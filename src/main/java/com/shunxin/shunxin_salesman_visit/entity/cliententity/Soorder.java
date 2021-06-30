package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Soorder {
    private int autoid;
    private String csocode;
    private String cperson_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ddate;
    private String cstate;
    private String ccus_id;
    private String csotype;
    private String cinvcode;
    private int iquantity;
    private BigDecimal iprice;
    private BigDecimal imoney;


    @Override
    public String toString() {
        return "Soorder{" +
                "autoid=" + autoid +
                ", csocode='" + csocode + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", ddate=" + ddate +
                ", cstate='" + cstate + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", csotype='" + csotype + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", iquantity=" + iquantity +
                ", iprice=" + iprice +
                ", imoney=" + imoney +
                '}';
    }
}
