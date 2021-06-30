package com.shunxin.shunxin_salesman_visit.entity.eatbarentity;

import lombok.Data;

@Data
public class Compay {
    private String ccode;
    private String cname;
    private String cname2;
    private String cname3;
    private String cname4;
    private String cname5;
    private String cname6;

    @Override
    public String toString() {
        return "Compay{" +
                "ccode='" + ccode + '\'' +
                ", cname='" + cname + '\'' +
                ", cname2='" + cname2 + '\'' +
                ", cname3='" + cname3 + '\'' +
                ", cname4='" + cname4 + '\'' +
                ", cname5='" + cname5 + '\'' +
                ", cname6='" + cname6 + '\'' +
                '}';
    }
}
