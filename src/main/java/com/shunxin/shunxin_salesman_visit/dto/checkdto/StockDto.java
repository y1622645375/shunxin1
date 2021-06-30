package com.shunxin.shunxin_salesman_visit.dto.checkdto;

import lombok.Data;

@Data
public class StockDto {
    private String cinvccode;
    private String jsonvist;
    private String cinvcode;
    private String cinvimg;
    private String cuserid;
    private String ckey;
    private int ilogin_type;

    @Override
    public String toString() {
        return "StockDto{" +
                "cinvccode='" + cinvccode + '\'' +
                ", jsonvist='" + jsonvist + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", cinvimg='" + cinvimg + '\'' +
                ", cuserid='" + cuserid + '\'' +
                ", ckey='" + ckey + '\'' +
                ", ilogin_type=" + ilogin_type +
                '}';
    }

}
