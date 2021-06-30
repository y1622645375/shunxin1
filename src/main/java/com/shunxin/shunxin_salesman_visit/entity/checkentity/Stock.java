package com.shunxin.shunxin_salesman_visit.entity.checkentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Stock {

    public String cinvcode;
    private String cinvaddcode;
    private String cinvname;
    private String cinvstd;
    private String cinvccode;
    private String cvencode;
    private float iinvsprice;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date dsdate;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date dedate;
    private String ccreateperson;
    private String cmodifyperson;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date dmodifydate;
    private String igrouptype;
    private String cgroupcode;
    private String ccomunitcode;
    private String csacomunitcode;
    private String cpucomunitcode;
    private String cstcomunitcode;
    private String ccacomunitcode;
    private String cinvcname;
    private String cgroupname;
    private String igrouptypename;
    private String caddress;
    private String ccomunitname;
    private float ichangrate;
    private String cinvimg;
    private String cinvdefine1;
    private String cinvstyle;

    @Override
    public String toString() {
        return "Stock{" +
                "cinvcode='" + cinvcode + '\'' +
                ", cinvaddcode='" + cinvaddcode + '\'' +
                ", cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", cinvccode='" + cinvccode + '\'' +
                ", cvencode='" + cvencode + '\'' +
                ", iinvsprice=" + iinvsprice +
                ", dsdate=" + dsdate +
                ", dedate=" + dedate +
                ", ccreateperson='" + ccreateperson + '\'' +
                ", cmodifyperson='" + cmodifyperson + '\'' +
                ", dmodifydate=" + dmodifydate +
                ", igrouptype='" + igrouptype + '\'' +
                ", cgroupcode='" + cgroupcode + '\'' +
                ", ccomunitcode='" + ccomunitcode + '\'' +
                ", csacomunitcode='" + csacomunitcode + '\'' +
                ", cpucomunitcode='" + cpucomunitcode + '\'' +
                ", cstcomunitcode='" + cstcomunitcode + '\'' +
                ", ccacomunitcode='" + ccacomunitcode + '\'' +
                ", cinvcname='" + cinvcname + '\'' +
                ", cgroupname='" + cgroupname + '\'' +
                ", igrouptypename='" + igrouptypename + '\'' +
                ", caddress='" + caddress + '\'' +
                ", ccomunitname='" + ccomunitname + '\'' +
                ", ichangrate=" + ichangrate +
                ", cinvimg='" + cinvimg + '\'' +
                ", cinvdefine1='" + cinvdefine1 + '\'' +
                ", cinvstyle='" + cinvstyle + '\'' +
                '}';
    }
}
