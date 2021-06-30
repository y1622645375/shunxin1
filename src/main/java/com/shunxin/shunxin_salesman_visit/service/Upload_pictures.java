package com.shunxin.shunxin_salesman_visit.service;

import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Base64.Decoder;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class Upload_pictures {
    public String[] upload(String[] imgStr){
        String path[] = new String[imgStr.length];
        for (int i = 0;i<imgStr.length;i++){
            imgStr[i] = imgStr[i].replaceAll("data:image/jpeg;base64,", "");
            Decoder decoder = Base64.getDecoder();
            //BASE64Decoder decoder = new BASE64Decoder();
            try
            {
                //Base64解码
                byte[] b = decoder.decode(imgStr[i]);
                for(int j = 0;j<b.length;++j)
                {
                    if(b[j]<0)
                    {//调整异常数据
                        b[j]+=256;
                    }
                }

                //生成文件名
                String files = new SimpleDateFormat("yyyyMMddHHmm")
                        .format(new Date())
                        + (new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000)
                        + ".jpg";

                //生成路径
                String filename = "D:\\tupian\\"+files;//新生成的图片

                // 生成文件
                File imageFile = new File(filename);
                if (!imageFile.getParentFile().exists()) {
                    imageFile.getParentFile().mkdirs();
                }

                OutputStream out = new FileOutputStream(imageFile);
                path[i] = filename;
                out.write(b);
                out.flush();
                out.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return path;
    }


    public String upload(String imgStr,String fileUrl){
             String path = null;
            imgStr = imgStr.replaceAll("data:image/jpeg;base64,", "");
            Decoder decoder1 = Base64.getDecoder();
            try
            {
                //Base64解码
                byte[] b = decoder1.decode(imgStr);
                for(int j = 0;j<b.length;++j)
                {
                    if(b[j]<0)
                    {//调整异常数据
                        b[j]+=256;
                    }
                }

                //生成文件名
                String files = new SimpleDateFormat("yyyyMMddHHmm")
                        .format(new Date())
                        + (new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000)
                        + ".jpg";

                //生成路径
                String filename = fileUrl+"\\"+files;//新生成的图片

                // 生成文件
                File imageFile = new File(filename);
                if (!imageFile.getParentFile().exists()) {
                    imageFile.getParentFile().mkdirs();
                }

                OutputStream out = new FileOutputStream(imageFile);
                path = filename;
                out.write(b);
                out.flush();
                out.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        return path;
    }


    public String upload3(String imgStr,String fileUrl,String img_name){
        String path = null;
        imgStr = imgStr.replaceAll("data:image/jpeg;base64,", "");
        Decoder decoder1 = Base64.getDecoder();
        try
        {
            //Base64解码
            byte[] b = decoder1.decode(imgStr);
            for(int j = 0;j<b.length;++j)
            {
                if(b[j]<0)
                {//调整异常数据
                    b[j]+=256;
                }
            }

            //生成文件名
            String files = img_name;

            //生成路径
            String filename = fileUrl+"\\"+files;//新生成的图片

            // 生成文件
            File imageFile = new File(filename);
            if (!imageFile.getParentFile().exists()) {
                imageFile.getParentFile().mkdirs();
            }

            OutputStream out = new FileOutputStream(imageFile);
            path = filename.substring(filename.indexOf("sxemall")+8,filename.length()).replace("\\","/");
            out.write(b);
            out.flush();
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return path;
    }


    public String upload2(String imgStr,String fileUrl,String imgName){
        String path = null;
        imgStr = imgStr.replaceAll("data:image/jpeg;base64,", "");
        //BASE64Decoder decoder = new BASE64Decoder();
        Decoder decoder1 = Base64.getDecoder();
        try
        {
            //Base64解码
            byte[] b = decoder1.decode(imgStr);
            for(int j = 0;j<b.length;++j)
            {
                if(b[j]<0)
                {//调整异常数据
                    b[j]+=256;
                }
            }

            //生成文件名
            /*String files = new SimpleDateFormat("yyyyMMddHHmm")
                    .format(new Date())
                    + (new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000)
                    + ".jpg";*/
            String files = imgName+".jpg";


            //生成路径
            String filename = fileUrl+"\\"+files;//新生成的图片

            // 生成文件
            File imageFile = new File(filename);
            if (!imageFile.getParentFile().exists()) {
                imageFile.getParentFile().mkdirs();
            }

            OutputStream out = new FileOutputStream(imageFile);
            path = filename;
            out.write(b);
            out.flush();
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return path;
    }



    public String copyByStream(File fromFile, File toFile,String path)
    {
        //源文件存在才复制
        if (fromFile.exists())
        {
            // 如果找不到目标文件
            if (!toFile.exists())
            {
                //这说明目标文件的上级目录不存在，先新建所有的上级目录
                toFile.getParentFile().mkdirs();
            }
            FileInputStream ins = null;
            FileOutputStream out = null;
            try
            {
                ins = new FileInputStream(fromFile);
                /*
                 * 使用FileOutputStream写文件
                 * 如果目标文件不存在，则FileOutputStream会创建目标文件(前提是父路径文件对象必须存在)。
                 */
                out = new FileOutputStream(toFile);
                byte[] buf = new byte[1024];
                int size = 0;
                // 每次读取1024个字节,然后写入1024字节
                while ((size = ins.read(buf)) != -1)
                {
                    out.write(buf, 0, size);
                }

            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return "读取文件错误";
            } finally
            {
                if (ins != null)
                {
                    try
                    {
                        ins.close();
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                        return "关闭ins错误";
                    }
                }
                if (out != null)
                {
                    try
                    {
                        out.close();
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                        return "关闭out错误";
                    }
                }

            }

        } else
        {
            return "源文件不存在";
        }
        return path;
    }
}
