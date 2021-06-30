package com.shunxin.shunxin_salesman_visit.entity.checkentity;

import lombok.Data;

@Data
public class WorkCheckList {

    private String ccomcode;
    private String ccomname;
    private String cdepcode;
    private String cdepname;
    private String cpersoncode;
    private String cname;
    private String ddate;
    private String cwcplan;
    private String cwcheck;
    private String cwctype;

    @Override
    public String toString() {
        return "WorkCheckList{" +
                "ccomcode='" + ccomcode + '\'' +
                ", ccomname='" + ccomname + '\'' +
                ", cdepcode='" + cdepcode + '\'' +
                ", cdepname='" + cdepname + '\'' +
                ", cpersoncode='" + cpersoncode + '\'' +
                ", cname='" + cname + '\'' +
                ", ddate='" + ddate + '\'' +
                ", cwcplan='" + cwcplan + '\'' +
                ", cwcheck='" + cwcheck + '\'' +
                ", cwctype='" + cwctype + '\'' +
                '}';
    }
}
