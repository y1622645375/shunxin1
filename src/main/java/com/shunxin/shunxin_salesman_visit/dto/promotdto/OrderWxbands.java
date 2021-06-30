package com.shunxin.shunxin_salesman_visit.dto.promotdto;

import lombok.Data;

@Data
public class OrderWxbands {
    private String copenid;
    private String cnickname;
    private String cmaskname;

    @Override
    public String toString() {
        return "OrderWxbands{" +
                "copenid='" + copenid + '\'' +
                ", cnickname='" + cnickname + '\'' +
                ", cmaskname='" + cmaskname + '\'' +
                '}';
    }
}
