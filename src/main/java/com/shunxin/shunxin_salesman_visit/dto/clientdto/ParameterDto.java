package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ParameterDto {

    private String ctype;
    private String stype;
    private String userid;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date1;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date2;
    private String ddate;
    private String param1;
    private String param2;
    private String cname;
    private String ccode;
    private String ckey;
    private String cuser_id;
    private String code;
    private String csocode;
    private String scene_str;
    private String md5str;
    private String ccus_id;
    private String openid;
    private String jsonvist;
    private String cuserid;
    private String ccomcode;
    private String cdepcode;
    private String cdepartment_id;
    private String ccus_comid;
    private int ilogin_type;
    private String cperson_id;
    private String ccus_xpoint;
    private String ccus_ypoint;
    private String ccus_address;
    private String autoid;

    @Override
    public String toString() {
        return "ParameterDto{" +
                "ctype='" + ctype + '\'' +
                ", stype='" + stype + '\'' +
                ", userid='" + userid + '\'' +
                ", date1=" + date1 +
                ", date2=" + date2 +
                ", ddate='" + ddate + '\'' +
                ", param1='" + param1 + '\'' +
                ", param2='" + param2 + '\'' +
                ", cname='" + cname + '\'' +
                ", ccode='" + ccode + '\'' +
                ", ckey='" + ckey + '\'' +
                ", cuser_id='" + cuser_id + '\'' +
                ", code='" + code + '\'' +
                ", csocode='" + csocode + '\'' +
                ", scene_str='" + scene_str + '\'' +
                ", md5str='" + md5str + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", openid='" + openid + '\'' +
                ", jsonvist='" + jsonvist + '\'' +
                ", cuserid='" + cuserid + '\'' +
                ", ccomcode='" + ccomcode + '\'' +
                ", cdepcode='" + cdepcode + '\'' +
                ", cdepartment_id='" + cdepartment_id + '\'' +
                ", ccus_comid='" + ccus_comid + '\'' +
                ", ilogin_type=" + ilogin_type +
                ", cperson_id='" + cperson_id + '\'' +
                ", ccus_xpoint='" + ccus_xpoint + '\'' +
                ", ccus_ypoint='" + ccus_ypoint + '\'' +
                ", ccus_address='" + ccus_address + '\'' +
                ", autoid='" + autoid + '\'' +
                '}';
    }
}
