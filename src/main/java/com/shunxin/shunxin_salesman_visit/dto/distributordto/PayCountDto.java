package com.shunxin.shunxin_salesman_visit.dto.distributordto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PayCountDto {
    private String csocode;
    private String ccus_name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ddate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dcreatedate;
    private float imoney_sum;
    private String payer_id;

    @Override
    public String toString() {
        return "PayCountDto{" +
                "csocode='" + csocode + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", ddate=" + ddate +
                ", dcreatedate=" + dcreatedate +
                ", imoney_sum=" + imoney_sum +
                ", payer_id='" + payer_id + '\'' +
                '}';
    }
}
