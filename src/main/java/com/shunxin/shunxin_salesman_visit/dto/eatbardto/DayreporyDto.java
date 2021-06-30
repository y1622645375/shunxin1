package com.shunxin.shunxin_salesman_visit.dto.eatbardto;

import lombok.Data;

@Data
public class DayreporyDto {
    private int autoid;
    private String ddate;       //日期
    private String cpcode;       //工号
    private String ctoday;      //今日工作内容
    private String ctomrrow;    //明天工作计划
    private String creport;     //今日工作进度
    private String creporter1;  //汇报给1
    private String creporter2;  //汇报给2
    private String ctype;

    @Override
    public String toString() {
        return "DayreporyDto{" +
                "autoid=" + autoid +
                ", ddate='" + ddate + '\'' +
                ", cpcode='" + cpcode + '\'' +
                ", ctoday='" + ctoday + '\'' +
                ", ctomrrow='" + ctomrrow + '\'' +
                ", creport='" + creport + '\'' +
                ", creporter1='" + creporter1 + '\'' +
                ", creporter2='" + creporter2 + '\'' +
                '}';
    }
}
