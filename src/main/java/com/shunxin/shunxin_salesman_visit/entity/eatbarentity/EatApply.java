package com.shunxin.shunxin_salesman_visit.entity.eatbarentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 吃饭报名名单表
 */
@Data
public class EatApply {
    private int ap_id;
    private String ap_code;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ap_dtime;
    private String ap_type;

    @Override
    public String toString() {
        return "EatApply{" +
                "ap_id=" + ap_id +
                ", ap_code='" + ap_code + '\'' +
                ", ap_dtime=" + ap_dtime +
                ", ap_type='" + ap_type + '\'' +
                '}';
    }
}
