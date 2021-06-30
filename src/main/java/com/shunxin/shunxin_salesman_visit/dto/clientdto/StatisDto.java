package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;


@Data
public class StatisDto {
    private String 公司;
    private String 拜访;
    private String 平均;
    private String 数量;
    private Double 笔数;


    @Override
    public String toString() {
        return "StatisDto{" +
                "公司='" + 公司 + '\'' +
                ", 拜访='" + 拜访 + '\'' +
                ", 平均='" + 平均 + '\'' +
                ", 数量='" + 数量 + '\'' +
                ", 金额=" + 笔数 +
                '}';
    }
}
