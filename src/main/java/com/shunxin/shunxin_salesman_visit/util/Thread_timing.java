package com.shunxin.shunxin_salesman_visit.util;

import com.alibaba.fastjson.JSONObject;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import static org.springframework.util.StreamUtils.BUFFER_SIZE;


@Component
public class Thread_timing extends Thread{

    public final static long ONE_Minute =  3600 * 1000 * 8760;

    static Logger logger = Logger.getLogger(Thread_timing.class);
        // 构造函数为私有类型，只能在函数内部定义
        private Thread_timing() {
        }
        // 用单一模式，只能创建一个对象
        private static Thread_timing Thread_timing = new Thread_timing();
        // 定义一个静态对象，用来取类的唯一对象，
        public static Thread_timing getThread_timing() {
        // 获取线程的状态
            String state = Thread_timing.getState().toString();
            System.out.println("定时线程状态："+state);
            if (state.equals("NEW") || state.equals("TERMINATED")) {
                Thread_timing = new Thread_timing();
            }
            return Thread_timing;
        }

        /**
         * 每天7-8点定时下载车销对账信息
         */
        public void run(){
            System.out.println("定时线程已启动");
            while(true){
                Calendar date = Calendar.getInstance();
                int hour = date.get(Calendar.HOUR_OF_DAY);
                //当到达6点开始执行，8点结束
                while(hour >= 6 & hour < 8){
                    String url = "";
                    String filename = "";
                    String results = "";
                    String path = "E:\\"; //文件保存路径
                    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
                    Calendar calendar = new GregorianCalendar();
                    calendar.setTime(new Date());
                    calendar.add(calendar.DATE,-1); //获取昨天的日期
                    String ddate= df.format(calendar.getTime());
                    for (int i = 1; i < 6; i++) {
                        String code = "0"+i;
                        String jieguo = "{\"ctype\":\"orderaccount\",\"comcode\":\""+code+"\",\"ddate\":\""+ddate+"\"}";
                        System.out.println(jieguo);
                        try{
                             results = sendPost("http://www.hnsxtj.cn/sx_sxzx/salebycar/orderbycar.php",jieguo);
                        }catch (Exception e){
                           e.printStackTrace();
                        }
                        JSONObject jo = JSONObject.parseObject(results);  //将String转成JSON
                        for (Map.Entry<String, Object> entry: jo.entrySet()) {
                            Object o = entry.getValue();
                            if (o instanceof String) {
                                if (entry.getKey().toString() == "url") {
                                    url = entry.getValue().toString(); //获取到json的值
                                }
                                if (entry.getKey().toString() == "filename") {
                                    filename = entry.getValue().toString();
                                }
                            } else {
                                jsonLoop(o);
                            }
                        }
                        //如果下载链接和文件名都不为空，则进行下载操作
                        if(!url.equals("")){
                            if(!filename.equals("")){
                                try {
                                    String filepath = path +"\\"+filename;
                                    File files = new File(filepath);
                                    if(!files.exists()){
                                        //下载压缩包到指定路径
                                        downLoadFromUrl(url,filename+".zip",path);
                                        File file2 = new File(filepath+".zip");
                                        //解压并删除压缩包
                                        unZip(file2,path);
                                    }
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    try {
                        Thread.sleep(3000); //3秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                try {
                    //每隔一分钟检测一次，看看时间到了没
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    //@Scheduled(fixedDelay=ONE_Minute)
    public void mains(){
        Thread_timing thr=new Thread_timing();
        thr.start();
    }


    public  static String sendPost(String url, String data) {
        String response = null;
        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httppost = new HttpPost(url);
                StringEntity stringentity = new StringEntity(data,
                        ContentType.create("text/json", "UTF-8"));
                httppost.setEntity(stringentity);
                httpresponse = httpclient.execute(httppost);//关键一步
                response = EntityUtils
                        .toString(httpresponse.getEntity(),"utf-8");//加上utf-8参数防止中文乱码
                System.out.println(response);
            } finally {
                if (httpclient != null) {
                    httpclient.close();
                }
                if (httpresponse != null) {
                    httpresponse.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * String 转 JSON
     * @param object
     */
    public static void jsonLoop(Object object) {
        if(object instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) object;
            for (Map.Entry<String, Object> entry: jsonObject.entrySet()) {
                Object o = entry.getValue();
                if(o instanceof String) {
                    System.out.println("key:" + entry.getKey() + "，value:" + entry.getValue());
                } else {
                    jsonLoop(o);
                }
            }
        }
        if(object instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) object;
            for(int i = 0; i < jsonArray.size(); i ++) {
                jsonLoop(jsonArray.get(i));
            }
        }
    }


    /**
     * 下载 zip 压缩包
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);

        //文件保存位置
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        File file = new File(saveDir+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }
        System.out.println("info:"+url+" download success");

    }

    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }


    /**
     * zip解压
     * @param srcFile        zip源文件
     * @param destDirPath     解压后的目标文件夹
     * @throws RuntimeException 解压失败会抛出运行时异常
     */
    public static void unZip(File srcFile, String destDirPath) throws RuntimeException {
        long start = System.currentTimeMillis();
        // 判断源文件是否存在
        if (!srcFile.exists()) {
            throw new RuntimeException(srcFile.getPath() + "所指文件不存在");
        }
        // 开始解压
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(srcFile);
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                System.out.println("解压" + entry.getName());
                // 如果是文件夹，就创建个文件夹
                if (entry.isDirectory()) {
                    String dirPath = destDirPath + "/" + entry.getName();
                    File dir = new File(dirPath);
                    dir.mkdirs();
                } else {
                    // 如果是文件，就先创建一个文件，然后用io流把内容copy过去
                    File targetFile = new File(destDirPath + "/" + entry.getName());
                    // 保证这个文件的父文件夹必须要存在
                    if(!targetFile.getParentFile().exists()){
                        targetFile.getParentFile().mkdirs();
                    }
                    targetFile.createNewFile();
                    // 将压缩文件内容写入到这个文件中
                    InputStream is = zipFile.getInputStream(entry);
                    FileOutputStream fos = new FileOutputStream(targetFile);
                    int len;
                    byte[] buf = new byte[BUFFER_SIZE];
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    // 关流顺序，先打开的后关闭
                    fos.close();
                    is.close();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("解压完成，耗时：" + (end - start) +" ms");
            zipFile.close();
            srcFile.delete();
            System.out.println(srcFile);
        } catch (Exception e) {
            throw new RuntimeException("unzip error from ZipUtils", e);
        } finally {
            if(zipFile != null){
                try {
                    zipFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}



