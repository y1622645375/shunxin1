package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MapDto {
    private BigDecimal lat;      //经度
    private BigDecimal lng;      //纬度
    private Double count;        //销量
    private String ccus_name;    //店铺名
    private String ddate;        //最后交易时间
    private String cinvtext;     //商品详情

    @Override
    public String toString() {
        return "MapDto{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", count=" + count +
                ", ccus_name='" + ccus_name + '\'' +
                ", ddate='" + ddate + '\'' +
                ", cinvtext='" + cinvtext + '\'' +
                '}';
    }
}
