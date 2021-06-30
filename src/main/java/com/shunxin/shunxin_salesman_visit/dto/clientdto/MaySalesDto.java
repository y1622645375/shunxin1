package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MaySalesDto {
    private String ccomcode;
    private BigDecimal lat;
    private BigDecimal lng;
    private String cinvname;
    private int icount;
    private String ccus_name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ddate;
    private String cperson_name;
    private String ccus_id;
    private String cperson_id;

    @Override
    public String toString() {
        return "MaySalesDto{" +
                "ccomcode='" + ccomcode + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", cinvname='" + cinvname + '\'' +
                ", icount=" + icount +
                ", ccus_name='" + ccus_name + '\'' +
                ", ddate=" + ddate +
                ", cperson_name='" + cperson_name + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                '}';
    }
}
