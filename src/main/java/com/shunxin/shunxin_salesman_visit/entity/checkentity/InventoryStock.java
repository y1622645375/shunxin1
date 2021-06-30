package com.shunxin.shunxin_salesman_visit.entity.checkentity;

import lombok.Data;

/**
 * 商品分类表
 */
@Data
public class InventoryStock {
    private String cinvccode;  //商品分类编号
    private String cinvcname;  //商品分类名称
    private String iinvcgrade;  //级别
    private String binvcend;    //是否末级


    @Override
    public String toString() {
        return "InventoryStock{" +
                "cinvccode='" + cinvccode + '\'' +
                ", cinvcname='" + cinvcname + '\'' +
                ", iinvcgrade='" + iinvcgrade + '\'' +
                ", binvcend='" + binvcend + '\'' +
                '}';
    }
}
