package com.shunxin.shunxin_salesman_visit.entity.promotentity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ZpcinvCode {

    private String sacxid;
    private String zpcinvcode;
    private int zpiquan;
    private String cinvcode;
    private String scInvName;
    private String sacxtext;
    private int izpquan;
    private int zpizpquan;
    private String cinvname;
    private String cinvstd;
    private BigDecimal ichangrate;
    private int izpquan_X;
    private int izpquan_P;
    private String sacxname;

    @Override
    public String toString() {
        return "ZpcinvCode{" +
                "sacxid='" + sacxid + '\'' +
                ", zpcinvcode='" + zpcinvcode + '\'' +
                ", zpiquan=" + zpiquan +
                ", cinvcode='" + cinvcode + '\'' +
                ", scInvName='" + scInvName + '\'' +
                ", sacxtext='" + sacxtext + '\'' +
                ", izpquan=" + izpquan +
                ", zpizpquan=" + zpizpquan +
                ", cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", ichangrate=" + ichangrate +
                ", izpquan_X=" + izpquan_X +
                ", izpquan_P=" + izpquan_P +
                ", sacxname='" + sacxname + '\'' +
                '}';
    }
}
