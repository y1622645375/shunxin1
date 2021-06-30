package com.shunxin.shunxin_salesman_visit.dto.distributordto;

import lombok.Data;

import java.util.List;

@Data
public class Distribution2Dto {
    private String ctype;
    private List<String> cinvcode;
    private float imoney_sum;

    @Override
    public String toString() {
        return "Distribution2Dto{" +
                "ctype='" + ctype + '\'' +
                ", cinvcode=" + cinvcode +
                ", imoney_sum=" + imoney_sum +
                '}';
    }
}
