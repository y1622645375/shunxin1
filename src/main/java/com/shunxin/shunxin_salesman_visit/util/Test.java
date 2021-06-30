package com.shunxin.shunxin_salesman_visit.util;


import org.thymeleaf.util.StringUtils;

import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Test {

    private BufferedReader reader;
    private ServerSocket server;
    private Socket socket;


    public static void main(String[] args) {
        try {
           String a = "20210623";
           String b = a.substring(6,a.length());
            System.out.println(b);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Long getStartOfToday(String date) {
        if (StringUtils.isEmpty(date)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.format(date);
        }
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA);
        LocalDate parse = LocalDate.parse(date, ofPattern);
        return parse.atStartOfDay().toInstant(ZoneOffset.of("+8")).toEpochMilli()/1000;
    }


    public static String map_tx2bd(double lat, double lon){
        double bd_lat;
        double bd_lon;
        double x_pi=3.14159265358979324;
        double x = lon, y = lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        bd_lon = z * Math.cos(theta) + 0.0065;
        bd_lat = z * Math.sin(theta) + 0.006;

        System.out.println("bd_lat:"+bd_lat);
        System.out.println("bd_lon:"+bd_lon);
        return bd_lon+","+bd_lat;
    }


    public static void  swap(char[] array,int i,int j){
        array[i] =(char)(array[i]- array[j]);
        System.out.println(array[i]);
        array[j] =(char)(array[i]+array[j]);
        array[i] =(char)(array[i]-array[j]);
    }

            //int类型转换
            /*int aInt = 1023;
            String aStr = Convert.toStr(aInt);
            System.out.println(aStr);*/
            //数组进行转换
            /*int[] bArray = {1,2,3,4,5};
            String bStr = Convert.toStr(bArray);
            System.out.println(bStr);*/
            /*LocalDateTime beginTime = LocalDateTime.now();    //接口耗时计算
            Long timeConsuming = Duration.between(beginTime,LocalDateTime.now()).toMillis();
            System.out.println(timeConsuming);*/
            //CallUrl.sendGet("http://emall.hnsxtj.com/dolog.php","userid="+userid+"&msg="+     //写入PHP日志表
            //"处理之前的结果：{result："+resultDto.getResult()+"，msg："+resultDto.getMsg()+"，Csocode："+resultDto.getCsocode()+"}");
            /*String fullFilePath = "D:\\tupian\\666666_0_64.jpg";
            File deleteFile = new File(fullFilePath);
            if (deleteFile.exists() && deleteFile.isFile()) {
                deleteFile.delete();
            }*/
            /*String str = "D:\\tupian\\666666_0_64.jpg";
            String aa = str.substring(str.indexOf("tupian")+6,str.length());
            System.out.println(aa);*/

            //时间转时间戳
            /*long time = (new SimpleDateFormat("yyyy-MM-dd")).parse("2018-06-30", new ParsePosition(0)).getTime() / 1000;
            System.out.println(time);*/

            /*String stamp = DateUtils.stampToDate(1609725600);  //将时间戳转换为时间
            String s = stamp.substring(0,10)+" 00:00:00";
            String as = DateUtils.dateToStamp(s);
            System.out.println("结果："+as);*/


            /*String str = "10,12,15,18,20,23,25";
            String [] strings = str.split(",");
            int [] array = new int[7];
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(strings[i]);
                System.out.println(array[i]);
            }*/

            /*Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String a = sdf.format(date);
            String asd  = "2020-09-01 00:00:00";
            Date d = new Date(sdf.parse(asd).getTime()+168*3600*1000);
            System.out.println(d);
            String str = DistanceUtils.comparetoTime(sdf.format(d),a);*/

            /*Date now = new Date();
            Date now_10 = new Date(now.getTime() - 10000); //10秒前的时间*/

            /*String time = "2021-01-05 09:00:00.000";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String stamp = String.valueOf(sdf.parse(time).getTime()/1000);
            System.out.println("转换之后："+stamp);*/


            /*Calendar calendar2 = Calendar.getInstance();
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
                    calendar2.add(Calendar.DATE, 3);
            String three_days_after = sdf2.format(calendar2.getTime());
            String yeerMoth = three_days_after.substring(0,6);
            String days = three_days_after.substring(6,three_days_after.length());
            System.out.println(three_days_after);
            System.out.println("年月："+yeerMoth+"日："+days);*/

            /*Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
            String csocode = sdf.format(date)+(new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000);
            System.out.println(csocode);*/


    //在 E:\test\ 文件夹下创建 2.txt 文件
            /*File file1 = new File("E:\\test\\2.txt");
            Boolean flag = file1.createNewFile();
            System.out.println(flag);*/
    //在 E:\test\ 下创建 test1 文件夹，创建单极目录
            /*File file2 = new File("E:\\test\\test1");
            file2.mkdir();*/
    //在 E:\test\ 下创建 a\b\c 文件夹，创建多极目录
            /*File file3 = new File("E:\\test\\a\\b\\c");
            file3.mkdirs();*/

            /*File file4 = new File("E:\\test\\a\\b\\c");
            file4.mkdirs();
            System.out.println("测试file4是否是文件夹："+file4.isDirectory());
            System.out.println("测试file4是否是文件："+file4.isFile());
            System.out.println("测试file4是否存在"+file4.exists());*/

            /*File file5 = new File("g/1.txt");
            //获取绝对路径
            String path1 = file5.getAbsolutePath();
            System.out.println("绝对路径："+path1);
            //获取相对路径
            String path2 = file5.getPath();
            System.out.println("相对路径："+path2);
            String file5Name = file5.getName();
            System.out.println("文件名"+file5Name);

            File file6 = new File("E:\\test");
            String [] names = file6.list();
            for (String name : names) {
                System.out.println(name);
            }
            //获取lib文件夹下所有文件（夹）的：File对象数组 File[]
            File[] files = file6.listFiles();
            for (File file : files) {
                System.out.println(file);
            }*/

}


