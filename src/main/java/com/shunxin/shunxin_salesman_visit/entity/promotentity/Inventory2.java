package com.shunxin.shunxin_salesman_visit.entity.promotentity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Inventory2 {
    private String cinvccode;
    private String cinvcname;
    private String cinvcode;
    private String cinvname;
    private String cinvstd;
    private String ccomunitcode;
    private String ccomunitname;
    private BigDecimal iinvscost;


    @Override
    public String toString() {
        return "Inventory2{" +
                "cinvccode='" + cinvccode + '\'' +
                ", cinvcname='" + cinvcname + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", ccomunitcode='" + ccomunitcode + '\'' +
                ", ccomunitname='" + ccomunitname + '\'' +
                ", iinvscost='" + iinvscost + '\'' +
                '}';
    }
}
