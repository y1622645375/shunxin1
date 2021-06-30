package com.shunxin.shunxin_salesman_visit.entity.checkentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class WorkcheckLog {

    private int autoid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date altertime;
    private String ccode;
    private String cstate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date uploadtime;


    @Override
    public String toString() {
        return "WorkcheckLog{" +
                "autoid=" + autoid +
                ", altertime=" + altertime +
                ", ccode='" + ccode + '\'' +
                ", cstate='" + cstate + '\'' +
                ", uploadtime=" + uploadtime +
                '}';
    }
}
