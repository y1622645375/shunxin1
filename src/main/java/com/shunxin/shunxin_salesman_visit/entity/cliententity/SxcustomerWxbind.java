package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SxcustomerWxbind {
    private int autoid;
    private String ckey;
    private int ccusid;             //客户ID
    private String copenid;         //openid
    private String cunitid;         //unitid
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dbindtime;         //
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dunbindtime;
    private String ccus_name;

    @Override
    public String toString() {
        return "SxcustomerWxbind{" +
                "autoid=" + autoid +
                ", ckey='" + ckey + '\'' +
                ", ccusid=" + ccusid +
                ", copenid='" + copenid + '\'' +
                ", cunitid='" + cunitid + '\'' +
                ", dbindtime=" + dbindtime +
                ", dunbindtime=" + dunbindtime +
                ", ccus_name='" + ccus_name + '\'' +
                '}';
    }
}
