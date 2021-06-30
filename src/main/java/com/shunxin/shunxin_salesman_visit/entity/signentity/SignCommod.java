package com.shunxin.shunxin_salesman_visit.entity.signentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 商品表
 */
@Data
public class SignCommod {
    private int autoid;
    private String cinvcode;        //商品ID(inventory表)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date datebegin;         //有效开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dateend;           //有效结束时间
    private String bopen;           //0为可兑换，1为不可兑换
    private int need_integral;      //所需积分
    private int iquan;              //可兑换总数量
    private int rquan;              //已兑换数量
    private int squan;              //总数量
    private String cinvname;
    private String cinvstd;
    private String cinvimg;

    @Override
    public String toString() {
        return "SignCommod{" +
                "autoid=" + autoid +
                ", cinvcode='" + cinvcode + '\'' +
                ", datebegin=" + datebegin +
                ", dateend=" + dateend +
                ", bopen='" + bopen + '\'' +
                ", need_integral=" + need_integral +
                ", iquan=" + iquan +
                ", rquan=" + rquan +
                ", squan=" + squan +
                ", cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", cinvimg='" + cinvimg + '\'' +
                '}';
    }
}
