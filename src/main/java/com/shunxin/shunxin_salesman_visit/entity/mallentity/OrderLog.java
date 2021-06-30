package com.shunxin.shunxin_salesman_visit.entity.mallentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class OrderLog {

    private int autoid;
    private int order_id;    //订单编号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ddate_log;     //操作时间
    private String ctype_log;   //操作类型
    private String msg_log;     //操作内容
    private String enumcode;    //订单状态编号
    private String enumname;    //订单状态名称


    @Override
    public String toString() {
        return "OrderLog{" +
                "autoid=" + autoid +
                ", order_id='" + order_id + '\'' +
                ", ddate_log=" + ddate_log +
                ", ctype_log='" + ctype_log + '\'' +
                ", msg_log='" + msg_log + '\'' +
                ", enumcode='" + enumcode + '\'' +
                ", enumname='" + enumname + '\'' +
                '}';
    }
}
