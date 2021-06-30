package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SxOutRetained {
    private String csocode;
    private String cname;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ddate;
    private String cperson_id;
    private String ccus_id;
    private String ccus_name;
    private String cinvcode;
    private String cinvname;
    private String cinvstd;
    private int iquantity;
    private BigDecimal iprice;
    private BigDecimal imoney;
    private String cstate;

    @Override
    public String toString() {
        return "SxOutRetained{" +
                "csocode='" + csocode + '\'' +
                ", cname='" + cname + '\'' +
                ", ddate=" + ddate +
                ", cperson_id='" + cperson_id + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", iquantity=" + iquantity +
                ", iprice=" + iprice +
                ", imoney=" + imoney +
                ", cstate='" + cstate + '\'' +
                '}';
    }
}
