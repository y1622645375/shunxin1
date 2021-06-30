package com.shunxin.shunxin_salesman_visit.entity.signentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 签到记录
 */
@Data
public class SignRecord {
    private int autoid;
    private String csign_cid;       //客户ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date sign_date;         //签到时间（或不签日期）
    private Date operate_date;      //操作时间
    private int sign_number;        //连续第几次签到
    private String openid;     //签到人openid
    private long timestamp;

    @Override
    public String toString() {
        return "SignRecord{" +
                "autoid=" + autoid +
                ", csign_cid='" + csign_cid + '\'' +
                ", sign_date=" + sign_date +
                ", operate_date=" + operate_date +
                ", sign_number=" + sign_number +
                ", openid='" + openid + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}
