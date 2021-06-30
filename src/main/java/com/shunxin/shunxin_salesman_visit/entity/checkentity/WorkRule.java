package com.shunxin.shunxin_salesman_visit.entity.checkentity;

import lombok.Data;

@Data
public class WorkRule {
    private String autoid;
    private String cworkrulecode;
    private String cworkrulename;
    private String cworkclassid_1;
    private String cworkclassid_2;
    private String cworkclassid_3;
    private String cworkclassid_4;
    private String cworkclassid_5;
    private String cworkclassid_6;
    private String cworkclassid_7;

    @Override
    public String toString() {
        return "WorkRule{" +
                "autoid='" + autoid + '\'' +
                ", cworkrulecode='" + cworkrulecode + '\'' +
                ", cworkrulename='" + cworkrulename + '\'' +
                ", cworkclassid_1='" + cworkclassid_1 + '\'' +
                ", cworkclassid_2='" + cworkclassid_2 + '\'' +
                ", cworkclassid_3='" + cworkclassid_3 + '\'' +
                ", cworkclassid_4='" + cworkclassid_4 + '\'' +
                ", cworkclassid_5='" + cworkclassid_5 + '\'' +
                ", cworkclassid_6='" + cworkclassid_6 + '\'' +
                ", cworkclassid_7='" + cworkclassid_7 + '\'' +
                '}';
    }
}
