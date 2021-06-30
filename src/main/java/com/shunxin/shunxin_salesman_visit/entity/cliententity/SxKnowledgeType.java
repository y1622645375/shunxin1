package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import lombok.Data;

@Data
public class SxKnowledgeType {
    private String ktype_code;
    private String ktype_name;

    @Override
    public String toString() {
        return "SxKnowledgeType{" +
                "ktype_code='" + ktype_code + '\'' +
                ", ktype_name='" + ktype_name + '\'' +
                '}';
    }
}
