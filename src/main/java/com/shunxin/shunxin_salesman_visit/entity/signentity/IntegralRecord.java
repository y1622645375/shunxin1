package com.shunxin.shunxin_salesman_visit.entity.signentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 积分记录
 */
@Data
public class IntegralRecord {
    private int autoid;
    private String integral_cid;      //客户ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date integral_date;    //积分获得的时间
    private String integral_type;  // 积分获得的途径（签到、拜访等等）
    private int integral_dr;       //增项
    private int integral_cr;       //减项
    private int integral_ye;       //余额
    private int sign_id;           //签到ID (签到表的autoid)
    private int commod_id;         //商品ID (商品表的autoid)
    private int fllow_id;          //拜访ID
    private int order_id;          //订单ID
    private String ccus_name;
    private String cinvname;       //兑换的商品名称
    private String cinvstd;        //兑换的商品规格

    @Override
    public String toString() {
        return "IntegralRecord{" +
                "autoid=" + autoid +
                ", integral_cid='" + integral_cid + '\'' +
                ", integral_date=" + integral_date +
                ", integral_type='" + integral_type + '\'' +
                ", integral_dr=" + integral_dr +
                ", integral_cr=" + integral_cr +
                ", integral_ye=" + integral_ye +
                ", sign_id=" + sign_id +
                ", commod_id=" + commod_id +
                ", fllow_id=" + fllow_id +
                ", order_id=" + order_id +
                ", ccus_name='" + ccus_name + '\'' +
                ", cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                '}';
    }
}
