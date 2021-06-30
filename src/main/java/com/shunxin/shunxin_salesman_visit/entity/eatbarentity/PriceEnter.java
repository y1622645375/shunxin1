package com.shunxin.shunxin_salesman_visit.entity.eatbarentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 正式价格表
 */
@Data
public class PriceEnter {

    private int autoid;
    private String ccomcode;
    private String cinvcode;
    private String cinvccode;
    private String ccus_level;
    private BigDecimal ccus_price;
    private Float igoldrate;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date ddateb;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ddatee;
    private int igrade;
    private int bclose;
    private String cinvname;
    private String cinvstd;
    private String clevelname;
    private String cinvimg64;
    private String cinvimg500;
    private String cuserid;
    private String ckey;
    private int ilogin_type;

    @Override
    public String toString() {
        return "PriceEnter{" +
                "autoid=" + autoid +
                ", ccomcode='" + ccomcode + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", cinvccode='" + cinvccode + '\'' +
                ", ccus_level='" + ccus_level + '\'' +
                ", ccus_price=" + ccus_price +
                ", igoldrate=" + igoldrate +
                ", ddateb=" + ddateb +
                ", ddatee=" + ddatee +
                ", igrade=" + igrade +
                ", bclose=" + bclose +
                ", cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", clevelname='" + clevelname + '\'' +
                ", cinvimg64='" + cinvimg64 + '\'' +
                ", cinvimg500='" + cinvimg500 + '\'' +
                '}';
    }
}
