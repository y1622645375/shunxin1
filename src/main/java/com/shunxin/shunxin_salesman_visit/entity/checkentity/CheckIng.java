package com.shunxin.shunxin_salesman_visit.entity.checkentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CheckIng {

    private int autoid;
    private String cpersoncode;         //工号
    private String cname;               //姓名
    private String cworkrule;           //打卡规则
    private String irule;
    private String iclass;              //班次ID
    private String iwctype;
    private String cworktype;           //1上班 2下班 3外出
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dstandtime;            //标准时间(例如：上班时间9点，下班时间17点)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dchecktime;            //打卡时间
    private String clocation_title;     //打卡地点地名
    private String clocation_detail;    //打卡详细地址
    private String cworkdevice;         //打卡设备：手机、考勤机名称
    private String cnotes;              //打卡人打卡时的备注
    private BigDecimal lat;             //纬度
    private BigDecimal lng;             //经度
    private String ccheckimg;           //打卡照片
    private String dchecktype;
    private String cgroupcode;

    @Override
    public String toString() {
        return "CheckIng{" +
                "autoid=" + autoid +
                ", cpersoncode='" + cpersoncode + '\'' +
                ", cname='" + cname + '\'' +
                ", cworkrule='" + cworkrule + '\'' +
                ", irule='" + irule + '\'' +
                ", iclass='" + iclass + '\'' +
                ", iwctype='" + iwctype + '\'' +
                ", cworktype='" + cworktype + '\'' +
                ", dstandtime=" + dstandtime +
                ", dchecktime=" + dchecktime +
                ", clocation_title='" + clocation_title + '\'' +
                ", clocation_detail='" + clocation_detail + '\'' +
                ", cworkdevice='" + cworkdevice + '\'' +
                ", cnotes='" + cnotes + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", ccheckimg='" + ccheckimg + '\'' +
                ", dchecktype='" + dchecktype + '\'' +
                ", cgroupcode='" + cgroupcode + '\'' +
                '}';
    }
}
