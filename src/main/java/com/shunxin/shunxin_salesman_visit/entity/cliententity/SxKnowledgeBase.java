package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SxKnowledgeBase {
    private int kbase_id;           //ID
    private String ktype;           //类型（例如：接口、常见错误）
    private String ktitle;          //标题
    private String kexplain;        //大概描述
    private String kcreator;        //创建人
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date kcreation_time;    //创建时间
    private String kmodifier;       //修改人
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date kmodify_time;      //修改时间

    @Override
    public String toString() {
        return "SxKnowledgeBase{" +
                "kbase_id=" + kbase_id +
                ", ktype='" + ktype + '\'' +
                ", ktitle='" + ktitle + '\'' +
                ", kexplain='" + kexplain + '\'' +
                ", kcreator='" + kcreator + '\'' +
                ", kcreation_time=" + kcreation_time +
                ", kmodifier='" + kmodifier + '\'' +
                ", kmodify_time=" + kmodify_time +
                '}';
    }
}
