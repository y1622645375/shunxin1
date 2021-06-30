package com.shunxin.shunxin_salesman_visit.entity.signentity;

import lombok.Data;

@Data
public class Information {
    private int autoid;
    private String ccomcode;
    private String cid;
    private String cname;
    private String ccaption;
    private String ctype;
    private String cvalue;

    @Override
    public String toString() {
        return "Information{" +
                "autoid=" + autoid +
                ", ccomcode='" + ccomcode + '\'' +
                ", cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", ccaption='" + ccaption + '\'' +
                ", ctype='" + ctype + '\'' +
                ", cvalue='" + cvalue + '\'' +
                '}';
    }
}
