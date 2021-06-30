package com.shunxin.shunxin_salesman_visit.dto.eatbardto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yinyang
 * @version V1.0
 * @ClassName :
 * @Description :
 * @date 2021/3/23
 */
@Data
public class CustomerAddress {
    private String autoid;
    private String ccus_name;
    private String cperson_id;
    private String cperson_name;
    private BigDecimal ccus_xpoint;
    private BigDecimal ccus_ypoint;
    private String ccomname;

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "autoid='" + autoid + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", cperson_name='" + cperson_name + '\'' +
                ", ccus_xpoint=" + ccus_xpoint +
                ", ccus_ypoint=" + ccus_ypoint +
                ", ccomname='" + ccomname + '\'' +
                '}';
    }
}
