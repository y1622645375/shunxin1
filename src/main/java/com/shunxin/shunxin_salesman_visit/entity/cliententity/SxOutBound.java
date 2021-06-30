package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SxOutBound {
    private String autoid;
    private String csocode;         //出库单号
    private String cperson_id;      //申请人编号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ddate;             //申请时间
    private String cstate;          //状态
    private String ccus_id;         //客户ID
    private String csotype;         //01 今日申请 02 昨日留存
    private String cinvcode;        //商品编号
    private float iquantity;        //数量
    private BigDecimal iprice;      //价格
    private BigDecimal imoney;      //金额


    @Override
    public String toString() {
        return "SxOutBound{" +
                "autoid='" + autoid + '\'' +
                ", csocode='" + csocode + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", ddate=" + ddate +
                ", cstate='" + cstate + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", csotype='" + csotype + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", iquantity=" + iquantity +
                ", iprice=" + iprice +
                ", imoney=" + imoney +
                '}';
    }
}
