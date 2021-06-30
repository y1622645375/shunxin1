package com.shunxin.shunxin_salesman_visit.dto.eatbardto;

import lombok.Data;

@Data
public class BirthdayDto {
    private int autoid;
    private String greeting;
    private String cname;
    private String ccode;
    private String xpoint;
    private String ypoint;
    private String cadress;
    private String ctype;
    private String jsonvist;
    private String param1;

    @Override
    public String toString() {
        return "BirthdayDto{" +
                "autoid=" + autoid +
                ", greeting='" + greeting + '\'' +
                ", cname='" + cname + '\'' +
                ", ccode='" + ccode + '\'' +
                ", xpoint='" + xpoint + '\'' +
                ", ypoint='" + ypoint + '\'' +
                ", cadress='" + cadress + '\'' +
                ", ctype='" + ctype + '\'' +
                ", jsonvist='" + jsonvist + '\'' +
                ", param1='" + param1 + '\'' +
                '}';
    }
}
