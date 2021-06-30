package com.shunxin.shunxin_salesman_visit.dto.promotdto;

import lombok.Data;

@Data
public class OrderSubSum {
    private int iquans_sum;
    private Double imoneys_sum;

    @Override
    public String toString() {
        return "OrderSubSum{" +
                "iquans_sum=" + iquans_sum +
                ", imoneys_sum=" + imoneys_sum +
                '}';
    }
}
