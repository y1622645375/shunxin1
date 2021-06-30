package com.shunxin.shunxin_salesman_visit.dto.checkdto;

import lombok.Data;

@Data
public class WorkCheckDto {
    private String cname;
    private String ccomcode;
    private String cdepcode;
    private String ddate1;
    private String ddate2;
    private String cusercode;

    @Override
    public String toString() {
        return "WorkCheckDto{" +
                "cname='" + cname + '\'' +
                ", ccomcode='" + ccomcode + '\'' +
                ", cdepcode='" + cdepcode + '\'' +
                ", ddate1='" + ddate1 + '\'' +
                ", ddate2='" + ddate2 + '\'' +
                ", cusercode='" + cusercode + '\'' +
                '}';
    }
}
