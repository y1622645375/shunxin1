package com.shunxin.shunxin_salesman_visit.dto.clientdto;

public class PlanaddDto {
    private String ccus_cid;
    private String ccus_comid;
    private String ccus_pid;
    private String ccus_code;
    private String ccus_visit_type;
    private String ccus_visit_time;
    private String ccus_visit_state;
    private String cuserid;
    private int ilogin_type;
    private String ckey;


    public String getCcus_cid() {
        return ccus_cid;
    }

    public void setCcus_cid(String ccus_cid) {
        this.ccus_cid = ccus_cid;
    }

    public String getCcus_comid() {
        return ccus_comid;
    }

    public void setCcus_comid(String ccus_comid) {
        this.ccus_comid = ccus_comid;
    }

    public String getCcus_pid() {
        return ccus_pid;
    }

    public void setCcus_pid(String ccus_pid) {
        this.ccus_pid = ccus_pid;
    }

    public String getCcus_code() {
        return ccus_code;
    }

    public void setCcus_code(String ccus_code) {
        this.ccus_code = ccus_code;
    }

    public String getCcus_visit_type() {
        return ccus_visit_type;
    }

    public void setCcus_visit_type(String ccus_visit_type) {
        this.ccus_visit_type = ccus_visit_type;
    }

    public String getCcus_visit_time() {
        return ccus_visit_time;
    }

    public void setCcus_visit_time(String ccus_visit_time) {
        this.ccus_visit_time = ccus_visit_time;
    }

    public String getCcus_visit_state() {
        return ccus_visit_state;
    }

    public void setCcus_visit_state(String ccus_visit_state) {
        this.ccus_visit_state = ccus_visit_state;
    }

    public String getCuserid() {
        return cuserid;
    }

    public void setCuserid(String cuserid) {
        this.cuserid = cuserid;
    }

    public int getIlogin_type() {
        return ilogin_type;
    }

    public void setIlogin_type(int ilogin_type) {
        this.ilogin_type = ilogin_type;
    }

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey;
    }

    @Override
    public String toString() {
        return "PlanaddDto{" +
                "ccus_cid='" + ccus_cid + '\'' +
                ", ccus_comid='" + ccus_comid + '\'' +
                ", ccus_pid='" + ccus_pid + '\'' +
                ", ccus_code='" + ccus_code + '\'' +
                ", ccus_visit_type='" + ccus_visit_type + '\'' +
                ", ccus_visit_time='" + ccus_visit_time + '\'' +
                ", ccus_visit_state='" + ccus_visit_state + '\'' +
                '}';
    }
}
