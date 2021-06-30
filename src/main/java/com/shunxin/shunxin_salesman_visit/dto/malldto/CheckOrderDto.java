package com.shunxin.shunxin_salesman_visit.dto.malldto;

import lombok.Data;

@Data
public class CheckOrderDto {
    private String jsonvist;


    @Override
    public String toString() {
        return "CheckOrderDto{" +
                "jsonvist='" + jsonvist + '\'' +
                '}';
    }
}
