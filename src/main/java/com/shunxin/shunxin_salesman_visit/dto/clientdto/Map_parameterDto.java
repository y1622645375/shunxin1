package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Map_parameterDto {
    private String ctype;
    private String sales;
    private String userid;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date datea;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date datee;
    private String coloron;
    private String ckey;


    @Override
    public String toString() {
        return "Map_parameterDto{" +
                "ctype='" + ctype + '\'' +
                ", sales='" + sales + '\'' +
                ", userid='" + userid + '\'' +
                ", datea='" + datea + '\'' +
                ", dateb='" + datee + '\'' +
                ", coloron='" + coloron + '\'' +
                ", ckey='" + ckey + '\'' +
                '}';
    }
}
