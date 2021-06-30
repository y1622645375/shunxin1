package com.shunxin.shunxin_salesman_visit.dto.malldto;

import lombok.Data;

@Data
public class ResultDto {

    private String result;
    private String msg;



    @Override
    public String toString() {
        return "ResultDto{" +
                "result='" + result + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
