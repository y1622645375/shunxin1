package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class FllowVisitListDto {

    private int autoid;    //ID
    private String ccus_address; //门店地址
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dfllow_start_time; //开始拜访时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dfllow_end_time;   //结束拜访时间
    private String ccus_name;       //店名
    private String dfllow_visit_time; //拜访日期
    private String ifllow_space; //拜访距离
    private int ifllow_bplan; //是否计划内拜访，0计划内1计划外
    private String cfllow_pid;  //业务员ID
    private BigDecimal cfllow_xpoint;   //拜访地址的纬度
    private BigDecimal cfllow_ypoint;   //拜访地址的经度
    private int sortid;     //序号
    private int icount_all;         //今天该拜访的全部数量
    private int icount_plan;        //今日计划内该拜访数量
    private int icount_unplan;      //今日计划外已拜访数量
    private int bfllow;


    @Override
    public String toString() {
        return "FllowVisitListDto{" +
                "autoid=" + autoid +
                ", ccus_address='" + ccus_address + '\'' +
                ", dfllow_start_time=" + dfllow_start_time +
                ", dfllow_end_time=" + dfllow_end_time +
                ", ccus_name='" + ccus_name + '\'' +
                ", dfllow_visit_time='" + dfllow_visit_time + '\'' +
                ", ifllow_space='" + ifllow_space + '\'' +
                ", ifllow_bplan=" + ifllow_bplan +
                ", cfllow_pid='" + cfllow_pid + '\'' +
                ", cfllow_xpoint=" + cfllow_xpoint +
                ", cfllow_ypoint=" + cfllow_ypoint +
                ", sortid=" + sortid +
                ", icount_all=" + icount_all +
                ", icount_plan=" + icount_plan +
                ", icount_unplan=" + icount_unplan +
                ", bfllow=" + bfllow +
                '}';
    }
}
