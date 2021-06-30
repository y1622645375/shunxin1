package com.shunxin.shunxin_salesman_visit.dto.checkdto;

import lombok.Data;

@Data
public class CheckDto {
    private String opencheckindatatype;
    private String starttime;
    private String endtime;
    private String useridlist;
    private String cuserid;
    private String ckey;
    private int ilogin_type;
    private String dchecktime;  //打卡日期
    private String cworktype;   //打卡类型
    private String cworkrule;   //打卡规则
    private String clocation_title; //打卡地点
    private String dstandtime;  //应打卡时间
    private String schedule_id; //打卡班次
    private String ddate1;
    private String ddate2;
    private String cpersoncode;
    private String dchecktype;
    private String ccomcode;
    private String jsonvist;
    private int page;
    private int limit;
    private String cname;
    private String cworkclasscode;


    @Override
    public String toString() {
        return "CheckDto{" +
                "opencheckindatatype='" + opencheckindatatype + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", useridlist='" + useridlist + '\'' +
                ", cuserid='" + cuserid + '\'' +
                ", ckey='" + ckey + '\'' +
                ", ilogin_type=" + ilogin_type +
                ", dchecktime='" + dchecktime + '\'' +
                ", cworktype='" + cworktype + '\'' +
                ", cworkrule='" + cworkrule + '\'' +
                ", clocation_title='" + clocation_title + '\'' +
                ", dstandtime='" + dstandtime + '\'' +
                ", schedule_id='" + schedule_id + '\'' +
                ", ddate1='" + ddate1 + '\'' +
                ", ddate2='" + ddate2 + '\'' +
                ", cpersoncode='" + cpersoncode + '\'' +
                ", dchecktype='" + dchecktype + '\'' +
                ", ccomcode='" + ccomcode + '\'' +
                ", jsonvist='" + jsonvist + '\'' +
                ", page=" + page +
                ", limit=" + limit +
                ", cname='" + cname + '\'' +
                ", cworkclasscode='" + cworkclasscode + '\'' +
                '}';
    }
}
