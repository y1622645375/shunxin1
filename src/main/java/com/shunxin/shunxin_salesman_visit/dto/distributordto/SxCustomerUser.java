package com.shunxin.shunxin_salesman_visit.dto.distributordto;

import lombok.Data;

/**
 * @author yinyang
 * @version V1.0
 * @ClassName :
 * @Description :
 * @date 2021/4/20
 */
@Data
public class SxCustomerUser {
    private String cuser_type;
    private String ccus_id;
    private String ccus_user_name;
    private String ccus_user_tel;
    private String ccus_user_openid_gzh;
    private String ccus_user_openid_unitid;
    private String ccus_user_openid_xcx;
    private String ctype;
    private String session_key;
    private String encrypdata;
    private String ivdata;  //向量

    @Override
    public String toString() {
        return "SxCustomerUser{" +
                "cuser_type='" + cuser_type + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", ccus_user_name='" + ccus_user_name + '\'' +
                ", ccus_user_tel='" + ccus_user_tel + '\'' +
                ", ccus_user_openid_gzh='" + ccus_user_openid_gzh + '\'' +
                ", ccus_user_openid_unitid='" + ccus_user_openid_unitid + '\'' +
                ", ccus_user_openid_xcx='" + ccus_user_openid_xcx + '\'' +
                ", ctype='" + ctype + '\'' +
                ", session_key='" + session_key + '\'' +
                ", encrypdata='" + encrypdata + '\'' +
                ", ivdata='" + ivdata + '\'' +
                '}';
    }
}
