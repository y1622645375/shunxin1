package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Inventory {
    private String cinvccode;   //商品所属分类编号
    private String cinvcode;    //商品编号
    private String cinvname;    //商品名称
    private String cinvstd;     //商品规格
    private BigDecimal ccus_price;  //价格
    private String igoldrate;
    private String cinvimg64;   //64大小图片
    private String cinvimg500;  //500大小图片

    public Inventory(String cinvccode, String cinvcode, String cinvname, String cinvstd, BigDecimal ccus_price, String igoldrate, String cinvimg64, String cinvimg500) {
        this.cinvccode = cinvccode;
        this.cinvcode = cinvcode;
        this.cinvname = cinvname;
        this.cinvstd = cinvstd;
        this.ccus_price = ccus_price;
        this.igoldrate = igoldrate;
        this.cinvimg64 = cinvimg64;
        this.cinvimg500 = cinvimg500;
    }

    public Inventory() {
    }

    @Override
    public String toString() {
        return "Inventory2{" +
                "cinvccode='" + cinvccode + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", ccus_price='" + ccus_price + '\'' +
                ", igoldrate='" + igoldrate + '\'' +
                ", cinvimg64='" + cinvimg64 + '\'' +
                ", cinvimg500='" + cinvimg500 + '\'' +
                '}';
    }
}
