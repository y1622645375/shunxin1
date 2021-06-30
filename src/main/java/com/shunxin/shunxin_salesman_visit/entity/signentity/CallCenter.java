package com.shunxin.shunxin_salesman_visit.entity.signentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CallCenter {
    private int autoid;
    private String copenid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ddate;
    private String csource;
    private String cmsgtext;
    private String cdefine1;
    private String cdefine2;
    private String cdefine3;
    private String cdefine4;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date cdefine5;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date cdefine6;
    private Float cdefine7;
    private Float cdefine8;
    private Float cdefine9;

    @Override
    public String toString() {
        return "CallCenter{" +
                "autoid=" + autoid +
                ", copenid='" + copenid + '\'' +
                ", ddate=" + ddate +
                ", csource='" + csource + '\'' +
                ", cmsgtext='" + cmsgtext + '\'' +
                ", cdefine1='" + cdefine1 + '\'' +
                ", cdefine2='" + cdefine2 + '\'' +
                ", cdefine3='" + cdefine3 + '\'' +
                ", cdefine4='" + cdefine4 + '\'' +
                ", cdefine5=" + cdefine5 +
                ", cdefine6=" + cdefine6 +
                ", cdefine7=" + cdefine7 +
                ", cdefine8=" + cdefine8 +
                ", cdefine9=" + cdefine9 +
                '}';
    }
}
