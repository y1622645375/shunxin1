package com.shunxin.shunxin_salesman_visit.entity.promotentity;

import lombok.Data;

@Data
public class Relation {

    private String ccompany_id;
    private String ccompany_name;
    private String cperson_id;
    private String cperson_name;
    private String msgtext;
    private String cmemo;
    private String headimg;

    @Override
    public String toString() {
        return "Relation{" +
                "ccompany_id='" + ccompany_id + '\'' +
                ", ccompany_name='" + ccompany_name + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", cperson_name='" + cperson_name + '\'' +
                ", msgtext='" + msgtext + '\'' +
                ", cmemo='" + cmemo + '\'' +
                ", headimg='" + headimg + '\'' +
                '}';
    }
}
