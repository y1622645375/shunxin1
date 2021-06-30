package com.shunxin.shunxin_salesman_visit.dto.distributordto;

import lombok.Data;

@Data
public class DistributionDto {
    private String ctype;
    private float cinvcode1;
    private float cinvcode2;
    private float cinvcode3;
    private float cinvcode4;
    private float cinvcode5;
    private float imoney_sum;

    @Override
    public String toString() {
        return "DistributionDto{" +
                "ctype='" + ctype + '\'' +
                ", cinvcode1=" + cinvcode1 +
                ", cinvcode2=" + cinvcode2 +
                ", cinvcode3=" + cinvcode3 +
                ", cinvcode4=" + cinvcode4 +
                ", cinvcode5=" + cinvcode5 +
                ", imoney_sum=" + imoney_sum +
                '}';
    }
}
