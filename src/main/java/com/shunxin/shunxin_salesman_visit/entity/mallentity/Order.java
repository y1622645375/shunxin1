package com.shunxin.shunxin_salesman_visit.entity.mallentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {

    private String csocode;          //订单编号
    private String ccus_id;          //客户编号
    private String ccus_name;        //客户名称
    private BigDecimal ccus_xpoint;  //纬度
    private BigDecimal ccus_ypoint;  //经度
    private String ccus_oaddress;    //地址
    private String ccus_phone;       //手机号
    private String ccus_person;      //客户姓名
    private String ccus_paytype_name;//支付类型
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ddate;              //下单时间
    private String cinvname;         //商品名称
    private String cinvstd;          //规格型号
    private int iquantity;           //数量
    private int iquan_sum;           //核计数量
    private BigDecimal imoney_sum;   //核计金额
    private String cmaker;           //制单人
    private String cinvcode;         //商品编码
    private BigDecimal iprice;       //单价
    private Float imoney;            //金额
    private String cdefine28;        //渠道活动
    private String cso_state;        //订单状态编码
    private String enumname;         //订单状态名称
    private String cinvimg;          //商品图片
    private String csocodes;         //子订单号
    private int iusegold_sum;
    private BigDecimal mdefine1;
    private String cpaytypename;
    private String cpaytype;
    private String ccus_remaker;
    private String cso_statename;
    private String cperson_id;
    private BigDecimal inopaymoney;
    private BigDecimal icashmoney;
    private BigDecimal iqrcodemoney;
    private String ccus_distribution;
    private String cshiptype;


    public Order() {
    }

    public Order(String ccus_id, String cinvname, String cinvstd, int iquantity, int iquan_sum, BigDecimal imoney_sum, String cinvcode, BigDecimal iprice, String cinvimg) {
        this.ccus_id = ccus_id;
        this.cinvname = cinvname;
        this.cinvstd = cinvstd;
        this.iquantity = iquantity;
        this.iquan_sum = iquan_sum;
        this.imoney_sum = imoney_sum;
        this.cinvcode = cinvcode;
        this.iprice = iprice;
        this.cinvimg = cinvimg;
    }

    @Override
    public String toString() {
        return "Order{" +
                "csocode='" + csocode + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", ccus_xpoint=" + ccus_xpoint +
                ", ccus_ypoint=" + ccus_ypoint +
                ", ccus_oaddress='" + ccus_oaddress + '\'' +
                ", ccus_phone='" + ccus_phone + '\'' +
                ", ccus_person='" + ccus_person + '\'' +
                ", ccus_paytype_name='" + ccus_paytype_name + '\'' +
                ", ddate=" + ddate +
                ", cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", iquantity=" + iquantity +
                ", iquan_sum=" + iquan_sum +
                ", imoney_sum=" + imoney_sum +
                ", cmaker='" + cmaker + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", iprice=" + iprice +
                ", imoney=" + imoney +
                ", cdefine28='" + cdefine28 + '\'' +
                ", cso_state='" + cso_state + '\'' +
                ", enumname='" + enumname + '\'' +
                ", cinvimg='" + cinvimg + '\'' +
                ", csocodes='" + csocodes + '\'' +
                ", iusegold_sum=" + iusegold_sum +
                ", mdefine1=" + mdefine1 +
                ", cpaytypename='" + cpaytypename + '\'' +
                ", cpaytype='" + cpaytype + '\'' +
                ", ccus_remaker='" + ccus_remaker + '\'' +
                ", cso_statename='" + cso_statename + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", inopaymoney=" + inopaymoney +
                ", icashmoney=" + icashmoney +
                ", iqrcodemoney=" + iqrcodemoney +
                ", ccus_distribution='" + ccus_distribution + '\'' +
                ", cshiptype='" + cshiptype + '\'' +
                '}';
    }
}
