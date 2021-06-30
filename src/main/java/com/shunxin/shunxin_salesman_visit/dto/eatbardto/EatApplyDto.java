package com.shunxin.shunxin_salesman_visit.dto.eatbardto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class EatApplyDto {

    private int ap_id;
    private String ap_code;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ap_dtime;
    private String ap_type;
    private String st_name;

    @Override
    public String toString() {
        return "EatApplyDto{" +
                "ap_id=" + ap_id +
                ", ap_code='" + ap_code + '\'' +
                ", ap_dtime=" + ap_dtime +
                ", ap_type='" + ap_type + '\'' +
                ", st_name='" + st_name + '\'' +
                '}';
    }
}
