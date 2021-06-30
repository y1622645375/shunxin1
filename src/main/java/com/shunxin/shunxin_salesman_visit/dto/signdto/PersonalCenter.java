package com.shunxin.shunxin_salesman_visit.dto.signdto;

import lombok.Data;

@Data
public class PersonalCenter {

    private String ccus_name;       //客户名称
    private String ccus_phone;      //手机号
    private String ccus_address;    //客户地址
    private String headimgurl;      //用户头像

    @Override
    public String toString() {
        return "PersonalCenter{" +
                "ccus_name='" + ccus_name + '\'' +
                ", ccus_phone='" + ccus_phone + '\'' +
                ", ccus_address='" + ccus_address + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                '}';
    }
}
