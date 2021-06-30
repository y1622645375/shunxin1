package com.shunxin.shunxin_salesman_visit.entity.promotentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CustomGoods {

    private int autoid;
    private String ccomcode;        //公司编号
    private String ccus_id;         //客户编号
    private String cinvcode;        //商品编号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dmodifydate;       //操作时间
    private String cperson_id;      //操作人id
    private int benabled;           //是否生效


    @Override
    public String toString() {
        return "CustomGoods{" +
                "autoid=" + autoid +
                ", ccomcode='" + ccomcode + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", dmodifydate=" + dmodifydate +
                ", cperson_id='" + cperson_id + '\'' +
                ", benabled=" + benabled +
                '}';
    }
}
