package com.shunxin.shunxin_salesman_visit.dto.promotdto;

import lombok.Data;

@Data
public class ZpSacxCount {

    private String ccompany;
    private String ccus_code;
    private String ddate;
    private String cinvcode;
    private int zpcount;
    private String cuser_id;

    @Override
    public String toString() {
        return "ZpSacxCount{" +
                "ccompany='" + ccompany + '\'' +
                ", ccus_code='" + ccus_code + '\'' +
                ", ddate='" + ddate + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", zpcount=" + zpcount +
                ", cuser_id='" + cuser_id + '\'' +
                '}';
    }
}
