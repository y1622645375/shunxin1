package com.shunxin.shunxin_salesman_visit.dto.eatbardto;


import lombok.Data;

@Data
public class ResultOrderDto {

    private String result;
    private String msg;
    private String csocode;

    @Override
    public String toString() {
        return "ResultOrderDto{" +
                "result='" + result + '\'' +
                ", msg='" + msg + '\'' +
                ", csocode='" + csocode + '\'' +
                '}';
    }
}
