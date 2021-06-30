package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;


@Data
public class PrintLogDto {
    private String ddate;       //日期
    private String ccomcode;    //公司编号
    private String ccomname;    //公司
    private String cperson_id;  //业务员ID
    private String cperson_name;    //业务员姓名
    private String csocode;     //订单编号
    private String ccus_id;     //店铺ID
    private String ccus_name;   //店铺名称
    private int iquan_sum;      //销量
    private String ddate1;      //下单时间
    private String ddate2;      //付款时间
    private String ddate3;      //打印时间
    private String paytype;
    private String printype;
    private int paycount;
    private int princount;


    @Override
    public String toString() {
        return "PrintLogDto{" +
                "ddate='" + ddate + '\'' +
                ", ccomcode='" + ccomcode + '\'' +
                ", ccomname='" + ccomname + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", cperson_name='" + cperson_name + '\'' +
                ", csocode='" + csocode + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", iquan_sum=" + iquan_sum +
                ", ddate1='" + ddate1 + '\'' +
                ", ddate2='" + ddate2 + '\'' +
                ", ddate3='" + ddate3 + '\'' +
                ", paytype='" + paytype + '\'' +
                ", printype='" + printype + '\'' +
                ", paycount=" + paycount +
                ", princount=" + princount +
                '}';
    }
}
