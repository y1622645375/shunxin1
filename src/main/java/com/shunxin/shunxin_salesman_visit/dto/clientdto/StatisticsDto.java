package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;

@Data
public class StatisticsDto {

    private String ctype;
    private String userid;
    private String dateb;
    private String datee;
    private String cuserid;
    private String ckey;
    private int ilogin_type;

    @Override
    public String toString() {
        return "StatisticsDto{" +
                "ctype='" + ctype + '\'' +
                ", userid='" + userid + '\'' +
                ", dateb='" + dateb + '\'' +
                ", datee='" + datee + '\'' +
                ", cuserid='" + cuserid + '\'' +
                ", ckey='" + ckey + '\'' +
                ", ilogin_type=" + ilogin_type +
                '}';
    }
}
