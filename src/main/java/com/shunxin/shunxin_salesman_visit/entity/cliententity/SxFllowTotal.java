package com.shunxin.shunxin_salesman_visit.entity.cliententity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 *汇总表
 */
public class SxFllowTotal {
    private int autoid;             //ID
    private String ctotal_comid;    //汇总公司ID
    private String ctotal_deptid;   //汇总部门ID
    private String ctotal_pid;      //汇总业务员ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dtotal_time;       //汇总表的日期
    private int itotal_plan;        //计划拜访数量
    private int itotal_onvisit;     //实际拜访数量，计划内
    private int itotal_unplan;      //实际拜访数量，计划外

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getCtotal_comid() {
        return ctotal_comid;
    }

    public void setCtotal_comid(String ctotal_comid) {
        this.ctotal_comid = ctotal_comid;
    }

    public String getCtotal_deptid() {
        return ctotal_deptid;
    }

    public void setCtotal_deptid(String ctotal_deptid) {
        this.ctotal_deptid = ctotal_deptid;
    }

    public String getCtotal_pid() {
        return ctotal_pid;
    }

    public void setCtotal_pid(String ctotal_pid) {
        this.ctotal_pid = ctotal_pid;
    }

    public Date getDtotal_time() {
        return dtotal_time;
    }

    public void setDtotal_time(Date dtotal_time) {
        this.dtotal_time = dtotal_time;
    }

    public int getItotal_plan() {
        return itotal_plan;
    }

    public void setItotal_plan(int itotal_plan) {
        this.itotal_plan = itotal_plan;
    }

    public int getItotal_onvisit() {
        return itotal_onvisit;
    }

    public void setItotal_onvisit(int itotal_onvisit) {
        this.itotal_onvisit = itotal_onvisit;
    }

    public int getItotal_unplan() {
        return itotal_unplan;
    }

    public void setItotal_unplan(int itotal_unplan) {
        this.itotal_unplan = itotal_unplan;
    }

    @Override
    public String toString() {
        return "SxFllowTotal{" +
                "autoid=" + autoid +
                ", ctotal_comid='" + ctotal_comid + '\'' +
                ", ctotal_deptid='" + ctotal_deptid + '\'' +
                ", ctotal_pid='" + ctotal_pid + '\'' +
                ", dtotal_time=" + dtotal_time +
                ", itotal_plan=" + itotal_plan +
                ", itotal_onvisit=" + itotal_onvisit +
                ", itotal_unplan=" + itotal_unplan +
                '}';
    }
}
