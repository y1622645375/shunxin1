package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class PersonDto {
    private String cfllow_pid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dfllow_start_time;
    private BigDecimal cfllow_xpoint;
    private BigDecimal cfllow_ypoint;
    private String cname1;
    private String zgcode;


    public String getCfllow_pid() {
        return cfllow_pid;
    }

    public void setCfllow_pid(String cfllow_pid) {
        this.cfllow_pid = cfllow_pid;
    }

    public Date getDfllow_start_time() {
        return dfllow_start_time;
    }

    public void setDfllow_start_time(Date dfllow_start_time) {
        this.dfllow_start_time = dfllow_start_time;
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

    public String getCname1() {
        return cname1;
    }

    public void setCname1(String cname1) {
        this.cname1 = cname1;
    }

    public String getZgcode() {
        return zgcode;
    }

    public void setZgcode(String zgcode) {
        this.zgcode = zgcode;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "cfllow_pid='" + cfllow_pid + '\'' +
                ", dfllow_start_time=" + dfllow_start_time +
                ", cfllow_xpoint=" + cfllow_xpoint +
                ", cfllow_ypoint=" + cfllow_ypoint +
                ", cname1='" + cname1 + '\'' +
                ", zgcode='" + zgcode + '\'' +
                '}';
    }
}
