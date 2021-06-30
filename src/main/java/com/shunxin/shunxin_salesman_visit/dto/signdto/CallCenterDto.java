package com.shunxin.shunxin_salesman_visit.dto.signdto;

import lombok.Data;

@Data
public class CallCenterDto {
    private int autoid;
    private String copenid;
    private String ddate;
    private String csource;
    private String cmsgtext;
    private String ctype;
    private String code;


    @Override
    public String toString() {
        return "CallCenterDto{" +
                "autoid=" + autoid +
                ", copenid='" + copenid + '\'' +
                ", ddate='" + ddate + '\'' +
                ", csource='" + csource + '\'' +
                ", cmsgtext='" + cmsgtext + '\'' +
                ", ctype='" + ctype + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}

