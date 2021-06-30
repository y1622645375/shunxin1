package com.shunxin.shunxin_salesman_visit.entity.checkentity;

import lombok.Data;

@Data
public class WorkCheckClass {

    private int autoid;
    private String cworkclasscode;
    private String cworkclassname;
    private String cwtimestart;
    private String cwtimeend;
    private String inoneedwtend;
    private String classname;

    @Override
    public String toString() {
        return "WorkCheckClass{" +
                "autoid=" + autoid +
                ", cworkclasscode='" + cworkclasscode + '\'' +
                ", cworkclassname='" + cworkclassname + '\'' +
                ", cwtimestart='" + cwtimestart + '\'' +
                ", cwtimeend='" + cwtimeend + '\'' +
                ", inoneedwtend='" + inoneedwtend + '\'' +
                ", classname='" + classname + '\'' +
                '}';
    }

}
