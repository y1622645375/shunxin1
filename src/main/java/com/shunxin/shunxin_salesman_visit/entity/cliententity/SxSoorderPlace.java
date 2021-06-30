package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import lombok.Data;

/**
 * @author yinyang
 * @version V1.0
 * @ClassName :
 * @Description :
 * @date 2021/3/25
 */
@Data
public class SxSoorderPlace {

    private String cinvname;
    private String cinvstd;
    private String cinvcode;
    private int iquantity;
    private float iprice;
    private float imoney;
    private String cinvimg64;
    private String cinvimg500;

    @Override
    public String toString() {
        return "SxSoorderPlace{" +
                "cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", iquantity=" + iquantity +
                ", iprice=" + iprice +
                ", imoney=" + imoney +
                ", cinvimg64='" + cinvimg64 + '\'' +
                ", cinvimg500='" + cinvimg500 + '\'' +
                '}';
    }
}
