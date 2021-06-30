package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 *具体拜访详细表
 */
public class SxFllowVisit {
    private int autoid;             //ID
    private String cfllow_id;       //拜访ID
    private String cfllow_cid;      //拜访客户id
    private String cfllow_pid;      //拜访人id
    private String cfllow_comid;    //所属公司id
    private BigDecimal cfllow_xpoint;   //拜访时所处经度
    private BigDecimal cfllow_ypoint;   //拜访时所处纬度
    private BigDecimal cccus_xpoint;    //客户所属经度
    private BigDecimal cccus_ypoint;    //客户所属纬度
    private int ifllow_space;       //拜访距离
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dfllow_start_time; //开始拜访时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dfllow_end_time;   //拜访结束时间
    private int ifllow_bplan;       //是否计划内拜访，0计划内1计划外
    private String cfllow_memo;     //拜访小结
    private String cchecker1;       //预留字段
    private String cchecker2;
    private String ccheckmemo1;     //预留字段
    private String ccheckmemo2;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dchecktime1;       //预留字段
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dchecktime2;

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getCfllow_id() {
        return cfllow_id;
    }

    public void setCfllow_id(String cfllow_id) {
        this.cfllow_id = cfllow_id;
    }

    public String getCfllow_cid() {
        return cfllow_cid;
    }

    public void setCfllow_cid(String cfllow_cid) {
        this.cfllow_cid = cfllow_cid;
    }

    public String getCfllow_pid() {
        return cfllow_pid;
    }

    public void setCfllow_pid(String cfllow_pid) {
        this.cfllow_pid = cfllow_pid;
    }

    public String getCfllow_comid() {
        return cfllow_comid;
    }

    public void setCfllow_comid(String cfllow_comid) {
        this.cfllow_comid = cfllow_comid;
    }

    public BigDecimal getCfllow_xpoint() {
        return cfllow_xpoint;
    }

    public void setCfllow_xpoint(BigDecimal cfllow_xpoint) {
        this.cfllow_xpoint = cfllow_xpoint;
    }

    public BigDecimal getCfllow_ypoint() {
        return cfllow_ypoint;
    }

    public void setCfllow_ypoint(BigDecimal cfllow_ypoint) {
        this.cfllow_ypoint = cfllow_ypoint;
    }

    public BigDecimal getCccus_xpoint() {
        return cccus_xpoint;
    }

    public void setCccus_xpoint(BigDecimal cccus_xpoint) {
        this.cccus_xpoint = cccus_xpoint;
    }

    public BigDecimal getCccus_ypoint() {
        return cccus_ypoint;
    }

    public void setCccus_ypoint(BigDecimal cccus_ypoint) {
        this.cccus_ypoint = cccus_ypoint;
    }

    public int getIfllow_space() {
        return ifllow_space;
    }

    public void setIfllow_space(int ifllow_space) {
        this.ifllow_space = ifllow_space;
    }

    public Date getDfllow_start_time() {
        return dfllow_start_time;
    }

    public void setDfllow_start_time(Date dfllow_start_time) {
        this.dfllow_start_time = dfllow_start_time;
    }

    public Date getDfllow_end_time() {
        return dfllow_end_time;
    }

    public void setDfllow_end_time(Date dfllow_end_time) {
        this.dfllow_end_time = dfllow_end_time;
    }

    public int getIfllow_bplan() {
        return ifllow_bplan;
    }

    public void setIfllow_bplan(int ifllow_bplan) {
        this.ifllow_bplan = ifllow_bplan;
    }

    public String getCfllow_memo() {
        return cfllow_memo;
    }

    public void setCfllow_memo(String cfllow_memo) {
        this.cfllow_memo = cfllow_memo;
    }

    public String getCchecker1() {
        return cchecker1;
    }

    public void setCchecker1(String cchecker1) {
        this.cchecker1 = cchecker1;
    }

    public String getCchecker2() {
        return cchecker2;
    }

    public void setCchecker2(String cchecker2) {
        this.cchecker2 = cchecker2;
    }

    public String getCcheckmemo1() {
        return ccheckmemo1;
    }

    public void setCcheckmemo1(String ccheckmemo1) {
        this.ccheckmemo1 = ccheckmemo1;
    }

    public String getCcheckmemo2() {
        return ccheckmemo2;
    }

    public void setCcheckmemo2(String ccheckmemo2) {
        this.ccheckmemo2 = ccheckmemo2;
    }

    public Date getDchecktime1() {
        return dchecktime1;
    }

    public void setDchecktime1(Date dchecktime1) {
        this.dchecktime1 = dchecktime1;
    }

    public Date getDchecktime2() {
        return dchecktime2;
    }

    public void setDchecktime2(Date dchecktime2) {
        this.dchecktime2 = dchecktime2;
    }

    @Override
    public String toString() {
        return "SxFllowVisit{" +
                "autoid=" + autoid +
                ", cfllow_id='" + cfllow_id + '\'' +
                ", cfllow_cid='" + cfllow_cid + '\'' +
                ", cfllow_pid='" + cfllow_pid + '\'' +
                ", cfllow_comid='" + cfllow_comid + '\'' +
                ", cfllow_xpoint='" + cfllow_xpoint + '\'' +
                ", cfllow_ypoint='" + cfllow_ypoint + '\'' +
                ", cccus_xpoint='" + cccus_xpoint + '\'' +
                ", cccus_ypoint='" + cccus_ypoint + '\'' +
                ", ifllow_space=" + ifllow_space +
                ", dfllow_start_time=" + dfllow_start_time +
                ", dfllow_end_time=" + dfllow_end_time +
                ", ifllow_bplan=" + ifllow_bplan +
                ", cfllow_memo='" + cfllow_memo + '\'' +
                ", cchecker1='" + cchecker1 + '\'' +
                ", cchecker2='" + cchecker2 + '\'' +
                ", ccheckmemo1='" + ccheckmemo1 + '\'' +
                ", ccheckmemo2='" + ccheckmemo2 + '\'' +
                ", dchecktime1=" + dchecktime1 +
                ", dchecktime2=" + dchecktime2 +
                '}';
    }
}
