package com.shunxin.shunxin_salesman_visit.entity.checkentity;

import lombok.Data;

/**
 * @author yinyang
 * @version V1.0
 * @ClassName : 每月考勤统计
 * @Description :
 * @date 2021/3/16
 */
@Data
public class WorkcheckRecord {
    private String ccode;    //工号
    private String cname;    //姓名
    private int ydk_day;     //应打卡天数
    private int sdk_day;     //实打卡天数
    private int qk_day;      //缺勤天数
    private int cd_count;    //迟到次数
    private int zt_count;     //早退次数

    @Override
    public String toString() {
        return "WorkcheckRecord{" +
                "ccode='" + ccode + '\'' +
                ", cname='" + cname + '\'' +
                ", ydk_day=" + ydk_day +
                ", sdk_day=" + sdk_day +
                ", qk_day=" + qk_day +
                ", cd_count=" + cd_count +
                ", zt_count=" + zt_count +
                '}';
    }
}
