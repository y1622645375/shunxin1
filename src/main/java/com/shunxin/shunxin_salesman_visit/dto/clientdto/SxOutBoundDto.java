package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;

@Data
public class SxOutBoundDto {

    private String csocode;         //出库单号
    private String cperson_id;      //申请人编号
    private String cstate;          //状态
    private String ccus_id;         //客户ID
    private String csotype;         //代表昨日留存 02 或今日申请 01
    private String cinvcode;        //商品编号
    private String iquantity;       //数量
    private String iprice;          //价格
    private String imoney;          //金额
    private String ddate1;
    private String ddate2;

    public SxOutBoundDto() {

    }

    public SxOutBoundDto(String csocode, String cperson_id, String cstate, String ccus_id, String csotype, String cinvcode, String iquantity, String iprice, String imoney) {
        this.csocode = csocode;
        this.cperson_id = cperson_id;
        this.cstate = cstate;
        this.ccus_id = ccus_id;
        this.csotype = csotype;
        this.cinvcode = cinvcode;
        this.iquantity = iquantity;
        this.iprice = iprice;
        this.imoney = imoney;
    }

    @Override
    public String toString() {
        return "SxOutBoundDto{" +
                ", csocode='" + csocode + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", cstate='" + cstate + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", csotype='" + csotype + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", iquantity='" + iquantity + '\'' +
                ", iprice='" + iprice + '\'' +
                ", imoney='" + imoney + '\'' +
                '}';
    }
}
