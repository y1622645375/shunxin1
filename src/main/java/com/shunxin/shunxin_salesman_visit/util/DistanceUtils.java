package com.shunxin.shunxin_salesman_visit.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DistanceUtils {

        /**
         * 地球半径,单位 km
         */
        private static final double EARTH_RADIUS = 6378.137;

        /**
         * 根据经纬度，计算两点间的距离
         *
         * @param longitude1 第一个点的经度
         * @param latitude1  第一个点的纬度
         * @param longitude2 第二个点的经度
         * @param latitude2  第二个点的纬度
         * @return 返回距离 单位千米
         */
        public static double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
            // 纬度
            double lat1 = Math.toRadians(latitude1);
            double lat2 = Math.toRadians(latitude2);
            // 经度
            double lng1 = Math.toRadians(longitude1);
            double lng2 = Math.toRadians(longitude2);
            // 纬度之差
            double a = lat1 - lat2;
            // 经度之差
            double b = lng1 - lng2;
            // 计算两点距离的公式
            double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                    Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(b / 2), 2)));
            // 弧长乘地球半径, 返回单位: 千米
            s =  s * EARTH_RADIUS;
            return s;
        }

        /*public static void main(String[] args) {
            double d = getDistance(112.996992, 28.184154, 112.997759, 28.184395);
            System.out.println(d*1000+"米");
        }*/



    public static void zoomImage(String srcFileName,String tagFileName,int width,int height){
        try {
            BufferedImage bi = ImageIO.read(new File(srcFileName));
            BufferedImage tag=new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(bi, 0, 0, width, height, null);
            ImageIO.write(tag, "jpg", new File(tagFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //比较两个日期的大小
    public static String comparetoTime(String beginTime,String endTime) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date bt=sdf.parse(beginTime);
        Date et=sdf.parse(endTime);
        if (bt.before(et)){
            //表示bt小于et
            return "true";
        }else{
            //--反之
            if(beginTime.equals(endTime)){
                return "true";
            }else{
                return "false";
            }
        }
    }



}
