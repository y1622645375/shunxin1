package com.shunxin.shunxin_salesman_visit.dto.promotdto;

import lombok.Data;

@Data
public class CustomGoodDto {
    private String cinvcode;
    private String cinvname;
    private String ccus_id;
    private String ccus_name;
    private String ccus_code;
    private String cperson_id;
    private String cinvstd;
    private String bused;
    private String cuserid;
    private String ckey;
    private int ilogin_type;

    @Override
    public String toString() {
        return "CustomGoodDto{" +
                "cinvcode='" + cinvcode + '\'' +
                ", cinvname='" + cinvname + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", ccus_code='" + ccus_code + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", bused='" + bused + '\'' +
                ", cuserid='" + cuserid + '\'' +
                ", ckey='" + ckey + '\'' +
                ", ilogin_type=" + ilogin_type +
                '}';
    }
}
