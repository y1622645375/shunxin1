package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BusinessDto {
    private String ccompany_id;     //店铺id
    private String cperson_id;      //业务员工号
    private String ccus_name;       //店铺名称
    private String ccus_status;     //状态
    private String ddate;           //时间
    private BigDecimal ccus_xpoint; //经度
    private BigDecimal ccus_ypoint; //纬度

    @Override
    public String toString() {
        return "BusinessDto{" +
                "ccompany_id='" + ccompany_id + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", ccus_status='" + ccus_status + '\'' +
                ", ddate='" + ddate + '\'' +
                ", ccus_xpoint='" + ccus_xpoint + '\'' +
                ", ccus_ypoint='" + ccus_ypoint + '\'' +
                '}';
    }
}
