package com.shunxin.shunxin_salesman_visit.dto.distributordto;

import lombok.Data;

@Data
public class commodityDto {

    private String cinvcode;   //商品编号
    private String cinvname;   //商品名称
    private String cinvstd;    //商品规格
    private String cinvimg;    //商品图片
    private String cinvimg64;   //商品图片https专用
    private String cinvimg500;   //商品图片https专用
    private float imoney; //订单价格
    private String iquantity;     //订单商品数量

    @Override
    public String toString() {
        return "commodityDto{" +
                "cinvcode='" + cinvcode + '\'' +
                ", cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", cinvimg='" + cinvimg + '\'' +
                ", cinvimg64='" + cinvimg64 + '\'' +
                ", cinvimg500='" + cinvimg500 + '\'' +
                ", imoney=" + imoney +
                ", iquantity='" + iquantity + '\'' +
                '}';
    }
}
