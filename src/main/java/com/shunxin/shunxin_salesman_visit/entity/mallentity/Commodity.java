package com.shunxin.shunxin_salesman_visit.entity.mallentity;

import lombok.Data;

@Data
public class Commodity {

    private String cInvcode;     //商品编码
    private String cInvName;     //商品名
    private String cInvcname1;   //商品品牌
    private String cInvcname2;   //商品分类
    private Float ccus_price;    //价格
    private int isaquan;         //销量
    private int ifeelquan;       //累计评价数量
    private int istquan;         //库存
    private String cInvstd;      //规格型号
    private String cInvtext1;    //图文详情
    private String cinvimg;      //轮播主图
    private String cinvimg1;     //轮播图1
    private String cinvimg2;     //轮播图2
    private String cinvimg3;     //轮播图3
    private String cinvimg4;     //轮播图4
    private String cinvimg5;     //轮播图5
    private String cinvimg6;     //轮播图6
    private String cinvimg7;     //轮播图7
    private String cinvimg8;     //轮播图8
    private String cinvimg9;     //轮播图9


    @Override
    public String toString() {
        return "Commodity{" +
                "cInvcode='" + cInvcode + '\'' +
                ", cInvName='" + cInvName + '\'' +
                ", cInvcname1='" + cInvcname1 + '\'' +
                ", cInvcname2='" + cInvcname2 + '\'' +
                ", ccus_price=" + ccus_price +
                ", isaquan=" + isaquan +
                ", ifeelquan=" + ifeelquan +
                ", istquan=" + istquan +
                ", cInvstd='" + cInvstd + '\'' +
                ", cInvtext1='" + cInvtext1 + '\'' +
                ", cinvimg='" + cinvimg + '\'' +
                ", cinvimg1='" + cinvimg1 + '\'' +
                ", cinvimg2='" + cinvimg2 + '\'' +
                ", cinvimg3='" + cinvimg3 + '\'' +
                ", cinvimg4='" + cinvimg4 + '\'' +
                ", cinvimg5='" + cinvimg5 + '\'' +
                ", cinvimg6='" + cinvimg6 + '\'' +
                ", cinvimg7='" + cinvimg7 + '\'' +
                ", cinvimg8='" + cinvimg8 + '\'' +
                ", cinvimg9='" + cinvimg9 + '\'' +
                '}';
    }
}
