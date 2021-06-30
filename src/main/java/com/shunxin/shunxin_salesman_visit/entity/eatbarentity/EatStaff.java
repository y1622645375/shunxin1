package com.shunxin.shunxin_salesman_visit.entity.eatbarentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 允许报餐人员表
 */
@Data
public class EatStaff {
    private int st_id;
    private String st_code;
    private String st_name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date st_dtime;
    private String st_remark;

    @Override
    public String toString() {
        return "EatStaff{" +
                "st_id=" + st_id +
                ", st_code='" + st_code + '\'' +
                ", st_name='" + st_name + '\'' +
                ", st_dtime=" + st_dtime +
                ", st_remark='" + st_remark + '\'' +
                '}';
    }
}
