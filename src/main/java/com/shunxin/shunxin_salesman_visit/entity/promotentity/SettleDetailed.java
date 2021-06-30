package com.shunxin.shunxin_salesman_visit.entity.promotentity;

import lombok.Data;

@Data
public class SettleDetailed {

    private String csocode;
    private String ccus_id;
    private String cperson_id;
    private String cso_state;
    private int iquan_sum;
    private Double imoney_sum;   //总收款金额
    private Double icashmoney;   //现金收款金额
    private Double iqrcodemoney; //扫码收款金额

    @Override
    public String toString() {
        return "SettleDetailed{" +
                "csocode='" + csocode + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", cso_state='" + cso_state + '\'' +
                ", iquan_sum=" + iquan_sum +
                ", imoney_sum=" + imoney_sum +
                ", icashmoney=" + icashmoney +
                ", iqrcodemoney=" + iqrcodemoney +
                '}';
    }
}
