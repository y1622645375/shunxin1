package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shunxin.shunxin_salesman_visit.dto.distributordto.commodityDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrdervDto {
     private int autoid;
     private String csocode;
     private String csocodes;
     private String csotype;
     private String csotypename;
     private String ccus_id;
     private String CCUS_NAME;
     private BigDecimal CCUS_XPOINT;
     private BigDecimal CCUS_YPOINT;
     private String CCUS_OADDRESS;
     private String CCUS_PHONE;
     private String CCUS_PERSON;
     private String CCUS_PAYTYPE_NAME;
     private String CCUS_LEVEL;
     private String cperson_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
     private Date ddate;
     private String cInvName;
     private String cInvStd;
     private String iquantity;
     private String iquan_sum;
     private float  imoney_sum;
     private String cmaker;
     private String cinvcode;
     private float iprice;
     private float imoney;
     private String cdefine28;
     private String cso_state;
     private String enumname;
     private String cinvimg;
     private String ccus_remaker;
     private String ccom_remaker;
     private int igold_sum;
     private int iusegold_sum;
     private int cpaytype;
     private String cpaytypename;
     private String icashmoney;
     private String iqrcodemoney;
     private String bclose;
     private int borderpay;
     private String ccomcode;
     private String CCOMNAME;
     private String ccus_distribution;  //配送商ID
     private int ordersid;
     private String cshiptype;
     private String cCus_Code;
     private String cperson_name;
     private float mdefine1;
     private String ddate1;
     private String ddate2;
     private String cso_statename;
    private String cuserid;
    private String ckey;
    private int ilogin_type;
    private String cstate;
    private String integral_result;
    private String cso_state_sub;
    private List<SxOrderGift> orderGifts;
    private List<commodityDto> commodityDtos;
    private String cdefine3;    //配送编码
    private String ipay_sum;
    private String jsonvist;
    private String ctype;

    @Override
    public String toString() {
        return "OrdervDto{" +
                "autoid=" + autoid +
                ", csocode='" + csocode + '\'' +
                ", csocodes='" + csocodes + '\'' +
                ", csotype='" + csotype + '\'' +
                ", csotypename='" + csotypename + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", CCUS_NAME='" + CCUS_NAME + '\'' +
                ", CCUS_XPOINT=" + CCUS_XPOINT +
                ", CCUS_YPOINT=" + CCUS_YPOINT +
                ", CCUS_OADDRESS='" + CCUS_OADDRESS + '\'' +
                ", CCUS_PHONE='" + CCUS_PHONE + '\'' +
                ", CCUS_PERSON='" + CCUS_PERSON + '\'' +
                ", CCUS_PAYTYPE_NAME='" + CCUS_PAYTYPE_NAME + '\'' +
                ", CCUS_LEVEL='" + CCUS_LEVEL + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", ddate=" + ddate +
                ", cInvName='" + cInvName + '\'' +
                ", cInvStd='" + cInvStd + '\'' +
                ", iquantity='" + iquantity + '\'' +
                ", iquan_sum='" + iquan_sum + '\'' +
                ", imoney_sum=" + imoney_sum +
                ", cmaker='" + cmaker + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", iprice=" + iprice +
                ", imoney=" + imoney +
                ", cdefine28='" + cdefine28 + '\'' +
                ", cso_state='" + cso_state + '\'' +
                ", enumname='" + enumname + '\'' +
                ", cinvimg='" + cinvimg + '\'' +
                ", ccus_remaker='" + ccus_remaker + '\'' +
                ", ccom_remaker='" + ccom_remaker + '\'' +
                ", igold_sum=" + igold_sum +
                ", iusegold_sum=" + iusegold_sum +
                ", cpaytype=" + cpaytype +
                ", cpaytypename='" + cpaytypename + '\'' +
                ", icashmoney='" + icashmoney + '\'' +
                ", iqrcodemoney='" + iqrcodemoney + '\'' +
                ", bclose='" + bclose + '\'' +
                ", borderpay=" + borderpay +
                ", ccomcode='" + ccomcode + '\'' +
                ", CCOMNAME='" + CCOMNAME + '\'' +
                ", ccus_distribution='" + ccus_distribution + '\'' +
                ", ordersid=" + ordersid +
                ", cshiptype='" + cshiptype + '\'' +
                ", cCus_Code='" + cCus_Code + '\'' +
                ", cperson_name='" + cperson_name + '\'' +
                ", mdefine1=" + mdefine1 +
                ", ddate1='" + ddate1 + '\'' +
                ", ddate2='" + ddate2 + '\'' +
                ", cso_statename='" + cso_statename + '\'' +
                ", cuserid='" + cuserid + '\'' +
                ", ckey='" + ckey + '\'' +
                ", ilogin_type=" + ilogin_type +
                ", cstate='" + cstate + '\'' +
                ", integral_result='" + integral_result + '\'' +
                ", cso_state_sub='" + cso_state_sub + '\'' +
                ", orderGifts=" + orderGifts +
                ", commodityDtos=" + commodityDtos +
                ", cdefine3='" + cdefine3 + '\'' +
                ", ipay_sum='" + ipay_sum + '\'' +
                ", jsonvist='" + jsonvist + '\'' +
                '}';
    }
}
