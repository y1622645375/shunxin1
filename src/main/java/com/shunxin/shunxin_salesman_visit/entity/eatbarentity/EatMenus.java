package com.shunxin.shunxin_salesman_visit.entity.eatbarentity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 菜单表
 */
@Data
public class EatMenus {
    private int me_id;
    private String me_name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date me_dtime;

    @Override
    public String toString() {
        return "EatMenus{" +
                "me_id=" + me_id +
                ", me_name='" + me_name + '\'' +
                ", me_dtime=" + me_dtime +
                '}';
    }
}
