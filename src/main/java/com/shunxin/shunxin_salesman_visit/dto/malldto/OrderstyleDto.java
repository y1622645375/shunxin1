package com.shunxin.shunxin_salesman_visit.dto.malldto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderstyleDto {

    private int bsale;          //0为正常单  1为赠品单
    private String ccus_id;     //客户编号
    private String ccus_name;   //客户名称
    private String cinvcode;    //商品编号
    private String cinvname;    //商品名称
    private String cinvstd;     //规格型号
    private int iquantity;      //数量
    private BigDecimal iprice;  //单价
    private BigDecimal imoney;  //总价
    private String ccus_person; //收款人
    private String ccus_phone;  //联系电话
    private String ccus_oaddress; //收货地址
    private String ccus_paytype_name; //结账方式
    private String cinvimg;     //商品图片


    @Override
    public String toString() {
        return "OrderstyleDto{" +
                "bsale=" + bsale +
                ", ccus_id='" + ccus_id + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", iquantity=" + iquantity +
                ", iprice=" + iprice +
                ", imoney=" + imoney +
                ", ccus_person='" + ccus_person + '\'' +
                ", ccus_phone='" + ccus_phone + '\'' +
                ", ccus_oaddress='" + ccus_oaddress + '\'' +
                ", ccus_paytype_name='" + ccus_paytype_name + '\'' +
                '}';
    }
}
