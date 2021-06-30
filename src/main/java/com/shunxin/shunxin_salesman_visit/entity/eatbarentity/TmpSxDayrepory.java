package com.shunxin.shunxin_salesman_visit.entity.eatbarentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 日常工作汇报表
 */
@Data
public class TmpSxDayrepory {
    private int autoid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ddate;         //日期
    private String cpcode;       //工号
    private String cpname;       //姓名
    private String ctoday;      //今日工作内容
    private String ctomrrow;    //明天工作计划
    private String creport;     //今日工作进度
    private String creporter1;  //汇报给1
    private String creporter2;  //汇报给2

    @Override
    public String toString() {
        return "TmpSxDayrepory{" +
                "autoid=" + autoid +
                ", ddate=" + ddate +
                ", cpcode='" + cpcode + '\'' +
                ", cpname='" + cpname + '\'' +
                ", ctoday='" + ctoday + '\'' +
                ", ctomrrow='" + ctomrrow + '\'' +
                ", creport='" + creport + '\'' +
                ", creporter1='" + creporter1 + '\'' +
                ", creporter2='" + creporter2 + '\'' +
                '}';
    }
}
