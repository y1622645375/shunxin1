package com.shunxin.shunxin_salesman_visit.dto.eatbardto;

import lombok.Data;

@Data
public class staffTmpDto {

    private int  autoid;
    private String cname;
    private String ccode;
    private String xpoint;
    private String ypoint;
    private String cadress;

    @Override
    public String toString() {
        return "staffTmpDto{" +
                "autoid=" + autoid +
                ", cname='" + cname + '\'' +
                ", ccode='" + ccode + '\'' +
                ", xpoint='" + xpoint + '\'' +
                ", ypoint='" + ypoint + '\'' +
                ", cadress='" + cadress + '\'' +
                '}';
    }
}
