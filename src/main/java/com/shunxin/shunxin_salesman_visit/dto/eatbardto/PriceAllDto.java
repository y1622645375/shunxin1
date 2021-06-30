package com.shunxin.shunxin_salesman_visit.dto.eatbardto;

import lombok.Data;

@Data
public class PriceAllDto {
    private String ccus_cid;
    private String ccus_pid;
    private String ddates;
    private String ccus_account;
    private String cusercode;
    private String ctype;
    private String jsonvist;
    private String stype;
    private String cuser_id;
    private String cuserid;
    private String ckey;
    private int ilogin_type;
    private int autoid;
    private String ddatee;

    @Override
    public String toString() {
        return "PriceAllDto{" +
                "ccus_cid='" + ccus_cid + '\'' +
                ", ccus_pid='" + ccus_pid + '\'' +
                ", ddates='" + ddates + '\'' +
                ", ccus_account='" + ccus_account + '\'' +
                ", cusercode='" + cusercode + '\'' +
                ", ctype='" + ctype + '\'' +
                ", jsonvist='" + jsonvist + '\'' +
                ", stype='" + stype + '\'' +
                ", cuser_id='" + cuser_id + '\'' +
                ", cuserid='" + cuserid + '\'' +
                ", ckey='" + ckey + '\'' +
                ", ilogin_type=" + ilogin_type +
                ", autoid=" + autoid +
                ", ddatee='" + ddatee + '\'' +
                '}';
    }
}
