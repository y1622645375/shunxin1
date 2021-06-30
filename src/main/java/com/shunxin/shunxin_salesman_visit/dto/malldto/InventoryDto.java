package com.shunxin.shunxin_salesman_visit.dto.malldto;

import lombok.Data;

@Data
public class InventoryDto {

    private String ccode;
    private String cclass;      //类型
    private String cname;       //商品名称
    private String imgurl;      //商品图片
    private String cinvstd;     //商品规格
    private String iinvquan;   //商品单价
    private String iinvprice;    //商品数量


    @Override
    public String toString() {
        return "InventoryDto{" +
                "ccode='" + ccode + '\'' +
                ", cclass='" + cclass + '\'' +
                ", cname='" + cname + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", iinvprice='" + iinvprice + '\'' +
                ", iinvquan='" + iinvquan + '\'' +
                '}';
    }
}
