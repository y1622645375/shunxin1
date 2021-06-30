package com.shunxin.shunxin_salesman_visit.dto.clientdto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class FllowVisitDetailDto {

    private int autoid;
    private String ccus_address;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dfllow_start_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dfllow_end_time;
    private String ccus_name;
    private BigDecimal cfllow_xpoint;
    private BigDecimal cfllow_ypoint;
    private BigDecimal cccus_xpoint;
    private BigDecimal cccus_ypoint;
    private String cfllow_memo;
    private String cimg_type;
    private String cimg_path;
    private String iimg_sort;
    private String cchecker1;
    private String cchecker2;
    private String ccheckmemo1;
    private String ccheckmemo2;
    private String dchecktime1;
    private String dchecktime2;
    private String cname;
    private String cname1;
    private String cname2;


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

    public String getDchecktime1() {
        return dchecktime1;
    }

    public void setDchecktime1(String dchecktime1) {
        this.dchecktime1 = dchecktime1;
    }

    public String getDchecktime2() {
        return dchecktime2;
    }

    public void setDchecktime2(String dchecktime2) {
        this.dchecktime2 = dchecktime2;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCname1() {
        return cname1;
    }

    public void setCname1(String cname1) {
        this.cname1 = cname1;
    }

    public String getCname2() {
        return cname2;
    }

    public void setCname2(String cname2) {
        this.cname2 = cname2;
    }

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getCcus_address() {
        return ccus_address;
    }

    public void setCcus_address(String ccus_address) {
        this.ccus_address = ccus_address;
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

    public String getCcus_name() {
        return ccus_name;
    }

    public void setCcus_name(String ccus_name) {
        this.ccus_name = ccus_name;
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

    public String getCfllow_memo() {
        return cfllow_memo;
    }

    public void setCfllow_memo(String cfllow_memo) {
        this.cfllow_memo = cfllow_memo;
    }

    public String getCimg_type() {
        return cimg_type;
    }

    public void setCimg_type(String cimg_type) {
        this.cimg_type = cimg_type;
    }

    public String getCimg_path() {
        return cimg_path;
    }

    public void setCimg_path(String cimg_path) {
        this.cimg_path = cimg_path;
    }

    public String getIimg_sort() {
        return iimg_sort;
    }

    public void setIimg_sort(String iimg_sort) {
        this.iimg_sort = iimg_sort;
    }

    @Override
    public String toString() {
        return "FllowVisitDetailDto{" +
                "autoid=" + autoid +
                ", ccus_address='" + ccus_address + '\'' +
                ", dfllow_start_time=" + dfllow_start_time +
                ", dfllow_end_time=" + dfllow_end_time +
                ", ccus_name='" + ccus_name + '\'' +
                ", cfllow_xpoint=" + cfllow_xpoint +
                ", cfllow_ypoint=" + cfllow_ypoint +
                ", cccus_xpoint=" + cccus_xpoint +
                ", cccus_ypoint=" + cccus_ypoint +
                ", cfllow_memo='" + cfllow_memo + '\'' +
                ", cimg_type='" + cimg_type + '\'' +
                ", cimg_path='" + cimg_path + '\'' +
                ", iimg_sort='" + iimg_sort + '\'' +
                ", cchecker1='" + cchecker1 + '\'' +
                ", cchecker2='" + cchecker2 + '\'' +
                ", ccheckmemo1='" + ccheckmemo1 + '\'' +
                ", ccheckmemo2='" + ccheckmemo2 + '\'' +
                ", dchecktime1='" + dchecktime1 + '\'' +
                ", dchecktime2='" + dchecktime2 + '\'' +
                ", cname='" + cname + '\'' +
                ", cname1='" + cname1 + '\'' +
                ", cname2='" + cname2 + '\'' +
                '}';
    }
}
