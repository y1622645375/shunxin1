package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yinyang
 * @version V1.0
 * @ClassName :
 * @Description :
 * @date 2021/3/29
 */
@Data
public class StaffCus {

    private String ccode;
    private String cname;
    private String autoid;
    private String ccus_name;
    private String ccus_statusname;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dcus_create_time;
    private BigDecimal ccus_xpoint;
    private BigDecimal ccus_ypoint;
    private String ccus_address;
    private String ccus_person;
    private String ccus_phone;
    private String cperson_name;
    private String ccus_account;
    private String ctypename;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date cffol_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date order_time;
    private int paycount;

    @Override
    public String toString() {
        return "StaffCus{" +
                "ccode='" + ccode + '\'' +
                ", cname='" + cname + '\'' +
                ", autoid='" + autoid + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", ccus_statusname='" + ccus_statusname + '\'' +
                ", dcus_create_time=" + dcus_create_time +
                ", ccus_xpoint=" + ccus_xpoint +
                ", ccus_ypoint=" + ccus_ypoint +
                ", ccus_address='" + ccus_address + '\'' +
                ", ccus_person='" + ccus_person + '\'' +
                ", ccus_phone='" + ccus_phone + '\'' +
                ", cperson_name='" + cperson_name + '\'' +
                ", ccus_account='" + ccus_account + '\'' +
                ", ctypename='" + ctypename + '\'' +
                ", cffol_time=" + cffol_time +
                ", order_time=" + order_time +
                ", paycount=" + paycount +
                '}';
    }
}
