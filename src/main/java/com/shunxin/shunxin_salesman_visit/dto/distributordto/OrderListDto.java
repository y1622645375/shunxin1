package com.shunxin.shunxin_salesman_visit.dto.distributordto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderListDto {

    private int autoid;
    private String csocode;
    private String csotype;
    private String csotypename;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ddate;
    private String ccus_id;
    private String ccus_name;
    private String ccomcode;
    private String ccomname;
    private String cperson_id;
    private String cso_state;
    private int iquan_sum;
    private BigDecimal imoney_sum;
    private BigDecimal igold_sum;
    private BigDecimal iusegold_sum;
    private String cpaytype;
    private String cpaytypename;
    private BigDecimal icashmoney;
    private BigDecimal iqrcodemoney;
    private BigDecimal ipay_sum;
    private String bclose;
    private String cinvcode;
    private String cinvname;
    private String cinvstd;
    private String cinvcname1;
    private String cinvcname2;
    private String cinvimg;
    private int borderpay;
    private String ccus_code;
    private int bsnerp;
    private String cshiptype;
    private String ccus_level;
    private int iquantity;
    private String cso_state_sub;
    private BigDecimal imoney;
    private String cdefine3;
    private String ccus_oaddress;
    private String ccus_person;
    private String ccus_phone;
    private BigDecimal ccus_xpoint;
    private BigDecimal ccus_ypoint;

    @Override
    public String toString() {
        return "OrderListDto{" +
                "autoid=" + autoid +
                ", csocode='" + csocode + '\'' +
                ", csotype='" + csotype + '\'' +
                ", csotypename='" + csotypename + '\'' +
                ", ddate=" + ddate +
                ", ccus_id='" + ccus_id + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", ccomcode='" + ccomcode + '\'' +
                ", ccomname='" + ccomname + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", cso_state='" + cso_state + '\'' +
                ", iquan_sum=" + iquan_sum +
                ", imoney_sum=" + imoney_sum +
                ", igold_sum=" + igold_sum +
                ", iusegold_sum=" + iusegold_sum +
                ", cpaytype='" + cpaytype + '\'' +
                ", cpaytypename='" + cpaytypename + '\'' +
                ", icashmoney=" + icashmoney +
                ", iqrcodemoney=" + iqrcodemoney +
                ", ipay_sum=" + ipay_sum +
                ", bclose='" + bclose + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", cinvcname1='" + cinvcname1 + '\'' +
                ", cinvcname2='" + cinvcname2 + '\'' +
                ", cinvimg='" + cinvimg + '\'' +
                ", borderpay=" + borderpay +
                ", ccus_code='" + ccus_code + '\'' +
                ", bsnerp=" + bsnerp +
                ", cshiptype='" + cshiptype + '\'' +
                ", ccus_level='" + ccus_level + '\'' +
                ", iquantity=" + iquantity +
                ", cso_state_sub='" + cso_state_sub + '\'' +
                ", imoney=" + imoney +
                ", cdefine3='" + cdefine3 + '\'' +
                ", ccus_oaddress='" + ccus_oaddress + '\'' +
                ", ccus_person='" + ccus_person + '\'' +
                ", ccus_phone='" + ccus_phone + '\'' +
                ", ccus_xpoint=" + ccus_xpoint +
                ", ccus_ypoint=" + ccus_ypoint +
                '}';
    }
}
