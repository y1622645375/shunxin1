package com.shunxin.shunxin_salesman_visit.dto.promotdto;

import lombok.Data;

@Data
public class PromotionDto {
    private int autoid;
    private String sacxid;
    private String cusercode;
    private String ddate;
    private String istate;
    private String jsonvist;
    private String cinvname;
    private String ddate1;
    private String ddate2;
    private String ctype;
    private String cuser_id;
    private String ccus_id;
    private String cinvcode;
    private int iquan;
    private String cuserid;
    private String ckey;
    private int ilogin_type;
    private String ccompany_id;
    private String cfllow_cid;
    private String cdefine1;
    private String cdefine2;
    private String cdefine3;
    private String cdefine4;

    @Override
    public String toString() {
        return "PromotionDto{" +
                "autoid=" + autoid +
                ", sacxid='" + sacxid + '\'' +
                ", cusercode='" + cusercode + '\'' +
                ", ddate='" + ddate + '\'' +
                ", istate='" + istate + '\'' +
                ", jsonvist='" + jsonvist + '\'' +
                ", cinvname='" + cinvname + '\'' +
                ", ddate1='" + ddate1 + '\'' +
                ", ddate2='" + ddate2 + '\'' +
                ", ctype='" + ctype + '\'' +
                ", cuser_id='" + cuser_id + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", iquan=" + iquan +
                ", cuserid='" + cuserid + '\'' +
                ", ckey='" + ckey + '\'' +
                ", ilogin_type=" + ilogin_type +
                ", ccompany_id='" + ccompany_id + '\'' +
                ", cfllow_cid='" + cfllow_cid + '\'' +
                ", cdefine1='" + cdefine1 + '\'' +
                ", cdefine2='" + cdefine2 + '\'' +
                ", cdefine3='" + cdefine3 + '\'' +
                ", cdefine4='" + cdefine4 + '\'' +
                '}';
    }
}
