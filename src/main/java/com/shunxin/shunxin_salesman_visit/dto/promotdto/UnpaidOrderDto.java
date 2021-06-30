package com.shunxin.shunxin_salesman_visit.dto.promotdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UnpaidOrderDto {
    private String csocode;
    private String ccus_name;
    private String ccus_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ddate;
    private float imoney_sum;
    private List<OrderWxbands> cust;

    @Override
    public String toString() {
        return "UnpaidOrderDto{" +
                "csocode='" + csocode + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", ddate=" + ddate +
                ", imoney_sum=" + imoney_sum +
                ", cust=" + cust +
                '}';
    }

}
