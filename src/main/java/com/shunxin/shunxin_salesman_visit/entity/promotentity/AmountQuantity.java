package com.shunxin.shunxin_salesman_visit.entity.promotentity;

import lombok.Data;

@Data
public class AmountQuantity {
    private int iquan_sum;
    private int ikpquan_sum;
    private Double imoney_sum;
    private Double icashmoney;
    private Double iqrcodemoney;
    private Double ipay_sum;


    @Override
    public String toString() {
        return "AmountQuantity{" +
                "iquan_sum=" + iquan_sum +
                ", ikpquan_sum=" + ikpquan_sum +
                ", imoney_sum=" + imoney_sum +
                ", icashmoney=" + icashmoney +
                ", iqrcodemoney=" + iqrcodemoney +
                ", ipay_sum=" + ipay_sum +
                '}';
    }
}
