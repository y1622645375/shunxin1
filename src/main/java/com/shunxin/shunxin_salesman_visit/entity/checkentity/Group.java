package com.shunxin.shunxin_salesman_visit.entity.checkentity;

import lombok.Data;

@Data
public class Group {

    private String cgroupcode;
    private String cgroupname;
    private String igrouptype;
    private String unitcode1;
    private String unitname1;
    private String unitcode2;
    private String unitname2;
    private String ichangerate;
    private String grouptypename;

    @Override
    public String toString() {
        return "Group{" +
                "cgroupcode='" + cgroupcode + '\'' +
                ", cgroupname='" + cgroupname + '\'' +
                ", igrouptype='" + igrouptype + '\'' +
                ", unitcode1='" + unitcode1 + '\'' +
                ", unitname1='" + unitname1 + '\'' +
                ", unitcode2='" + unitcode2 + '\'' +
                ", unitname2='" + unitname2 + '\'' +
                ", ichangerate='" + ichangerate + '\'' +
                ", grouptypename='" + grouptypename + '\'' +
                '}';
    }
}
