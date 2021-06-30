package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;


public class CustomerDto {
    private int status0;
    private int status1;
    private int status2;
    private int status3;
    private int status9;
    private int status10;
    private int statusall;

    private int autoid;
    private String ccus_code;
    private String ccus_name;
    private String cpassword;
    private String ccus_create_by;
    private String ccus_create_source;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dcus_create_time;
    private String ccus_update_by;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dcus_update_time;
    private String ccus_status;
    private String ccus_statusname;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dfrist_login_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dlast_login_time;
    private String ccompany_id;
    private String cdepartment_id;
    private String cperson_id;
    private String ccus_level;
    private String ccus_type;
    private BigDecimal ccus_xpoint;
    private BigDecimal ccus_ypoint;
    private String ccus_address;
    private String ccus_oaddress;
    private String ccus_person;
    private String ccus_phone;
    private String ccus_email;
    private String ccus_paytype;
    private String ccus_credit_type;
    private int icus_credit_days;
    private int icus_credit_line;
    private String ccus_visit_type;
    private String icus_visit_time;
    private int ccus_visit_state;
    private String clicense_id;
    private String clicense_name;
    private String clicense_img1;
    private String clicense_img2;
    private String ccus_close_by;
    private String ccus_close_time;
    private String ccomname;
    private String cdepname;
    private String cperson_name;
    private String ccus_faren_name;
    private String ccus_faren_phone;
    private String ccus_bank_name;
    private String ccus_bank_account;
    private String ccus_bank_dwname;
    private String ccus_account;
    private String clevelname;              //级别
    private String ctypename;               //类型
    private String ccus_credit_typename;    //客户信用方式，1账期，2额度，3账期+额度，9其他
    private String ccus_paytype_name;       //客户付款方式，1现结，2月结
    private String cdefine1;                //客服处理回复信息
    private String bwxbind;                 //是否绑定微信
    private String cuserid;
    private String ckey;
    private int ilogin_type;
    private String ccuspperson;



    public int getStatus0() {
        return status0;
    }

    public void setStatus0(int status0) {
        this.status0 = status0;
    }

    public int getStatus1() {
        return status1;
    }

    public void setStatus1(int status1) {
        this.status1 = status1;
    }

    public int getStatus2() {
        return status2;
    }

    public void setStatus2(int status2) {
        this.status2 = status2;
    }

    public int getStatus3() {
        return status3;
    }

    public void setStatus3(int status3) {
        this.status3 = status3;
    }

    public int getStatus9() {
        return status9;
    }

    public void setStatus9(int status9) {
        this.status9 = status9;
    }

    public int getStatus10() {
        return status10;
    }

    public void setStatus10(int status10) {
        this.status10 = status10;
    }

    public int getStatusall() {
        return statusall;
    }

    public void setStatusall(int statusall) {
        this.statusall = statusall;
    }

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getCcus_code() {
        return ccus_code;
    }

    public void setCcus_code(String ccus_code) {
        this.ccus_code = ccus_code;
    }

    public String getCcus_name() {
        return ccus_name;
    }

    public void setCcus_name(String ccus_name) {
        this.ccus_name = ccus_name;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getCcus_create_by() {
        return ccus_create_by;
    }

    public void setCcus_create_by(String ccus_create_by) {
        this.ccus_create_by = ccus_create_by;
    }

    public String getCcus_create_source() {
        return ccus_create_source;
    }

    public void setCcus_create_source(String ccus_create_source) {
        this.ccus_create_source = ccus_create_source;
    }

    public Date getDcus_create_time() {
        return dcus_create_time;
    }

    public void setDcus_create_time(Date dcus_create_time) {
        this.dcus_create_time = dcus_create_time;
    }

    public String getCcus_update_by() {
        return ccus_update_by;
    }

    public void setCcus_update_by(String ccus_update_by) {
        this.ccus_update_by = ccus_update_by;
    }

    public Date getDcus_update_time() {
        return dcus_update_time;
    }

    public void setDcus_update_time(Date dcus_update_time) {
        this.dcus_update_time = dcus_update_time;
    }

    public String getCcus_status() {
        return ccus_status;
    }

    public void setCcus_status(String ccus_status) {
        this.ccus_status = ccus_status;
    }

    public String getCcus_statusname() {
        return ccus_statusname;
    }

    public void setCcus_statusname(String ccus_statusname) {
        this.ccus_statusname = ccus_statusname;
    }

    public Date getDfrist_login_time() {
        return dfrist_login_time;
    }

    public void setDfrist_login_time(Date dfrist_login_time) {
        this.dfrist_login_time = dfrist_login_time;
    }

    public Date getDlast_login_time() {
        return dlast_login_time;
    }

    public void setDlast_login_time(Date dlast_login_time) {
        this.dlast_login_time = dlast_login_time;
    }

    public String getCcompany_id() {
        return ccompany_id;
    }

    public void setCcompany_id(String ccompany_id) {
        this.ccompany_id = ccompany_id;
    }

    public String getCdepartment_id() {
        return cdepartment_id;
    }

    public void setCdepartment_id(String cdepartment_id) {
        this.cdepartment_id = cdepartment_id;
    }

    public String getCperson_id() {
        return cperson_id;
    }

    public void setCperson_id(String cperson_id) {
        this.cperson_id = cperson_id;
    }

    public String getCcus_level() {
        return ccus_level;
    }

    public void setCcus_level(String ccus_level) {
        this.ccus_level = ccus_level;
    }

    public String getCcus_type() {
        return ccus_type;
    }

    public void setCcus_type(String ccus_type) {
        this.ccus_type = ccus_type;
    }

    public BigDecimal getCcus_xpoint() {
        return ccus_xpoint;
    }

    public void setCcus_xpoint(BigDecimal ccus_xpoint) {
        this.ccus_xpoint = ccus_xpoint;
    }

    public BigDecimal getCcus_ypoint() {
        return ccus_ypoint;
    }

    public void setCcus_ypoint(BigDecimal ccus_ypoint) {
        this.ccus_ypoint = ccus_ypoint;
    }

    public String getCcus_address() {
        return ccus_address;
    }

    public void setCcus_address(String ccus_address) {
        this.ccus_address = ccus_address;
    }

    public String getCcus_oaddress() {
        return ccus_oaddress;
    }

    public void setCcus_oaddress(String ccus_oaddress) {
        this.ccus_oaddress = ccus_oaddress;
    }

    public String getCcus_person() {
        return ccus_person;
    }

    public void setCcus_person(String ccus_person) {
        this.ccus_person = ccus_person;
    }

    public String getCcus_phone() {
        return ccus_phone;
    }

    public void setCcus_phone(String ccus_phone) {
        this.ccus_phone = ccus_phone;
    }

    public String getCcus_email() {
        return ccus_email;
    }

    public void setCcus_email(String ccus_email) {
        this.ccus_email = ccus_email;
    }

    public String getCcus_paytype() {
        return ccus_paytype;
    }

    public void setCcus_paytype(String ccus_paytype) {
        this.ccus_paytype = ccus_paytype;
    }

    public String getCcus_credit_type() {
        return ccus_credit_type;
    }

    public void setCcus_credit_type(String ccus_credit_type) {
        this.ccus_credit_type = ccus_credit_type;
    }

    public int getIcus_credit_days() {
        return icus_credit_days;
    }

    public void setIcus_credit_days(int icus_credit_days) {
        this.icus_credit_days = icus_credit_days;
    }

    public int getIcus_credit_line() {
        return icus_credit_line;
    }

    public void setIcus_credit_line(int icus_credit_line) {
        this.icus_credit_line = icus_credit_line;
    }

    public String getCcus_visit_type() {
        return ccus_visit_type;
    }

    public void setCcus_visit_type(String ccus_visit_type) {
        this.ccus_visit_type = ccus_visit_type;
    }

    public String getIcus_visit_time() {
        return icus_visit_time;
    }

    public void setIcus_visit_time(String icus_visit_time) {
        this.icus_visit_time = icus_visit_time;
    }

    public int getCcus_visit_state() {
        return ccus_visit_state;
    }

    public void setCcus_visit_state(int ccus_visit_state) {
        this.ccus_visit_state = ccus_visit_state;
    }

    public String getClicense_id() {
        return clicense_id;
    }

    public void setClicense_id(String clicense_id) {
        this.clicense_id = clicense_id;
    }

    public String getClicense_name() {
        return clicense_name;
    }

    public void setClicense_name(String clicense_name) {
        this.clicense_name = clicense_name;
    }

    public String getClicense_img1() {
        return clicense_img1;
    }

    public void setClicense_img1(String clicense_img1) {
        this.clicense_img1 = clicense_img1;
    }

    public String getClicense_img2() {
        return clicense_img2;
    }

    public void setClicense_img2(String clicense_img2) {
        this.clicense_img2 = clicense_img2;
    }

    public String getCcus_close_by() {
        return ccus_close_by;
    }

    public void setCcus_close_by(String ccus_close_by) {
        this.ccus_close_by = ccus_close_by;
    }

    public String getCcus_close_time() {
        return ccus_close_time;
    }

    public void setCcus_close_time(String ccus_close_time) {
        this.ccus_close_time = ccus_close_time;
    }

    public String getCcomname() {
        return ccomname;
    }

    public void setCcomname(String ccomname) {
        this.ccomname = ccomname;
    }

    public String getCdepname() {
        return cdepname;
    }

    public void setCdepname(String cdepname) {
        this.cdepname = cdepname;
    }

    public String getCperson_name() {
        return cperson_name;
    }

    public void setCperson_name(String cperson_name) {
        this.cperson_name = cperson_name;
    }

    public String getCcus_faren_name() {
        return ccus_faren_name;
    }

    public void setCcus_faren_name(String ccus_faren_name) {
        this.ccus_faren_name = ccus_faren_name;
    }

    public String getCcus_faren_phone() {
        return ccus_faren_phone;
    }

    public void setCcus_faren_phone(String ccus_faren_phone) {
        this.ccus_faren_phone = ccus_faren_phone;
    }

    public String getCcus_bank_name() {
        return ccus_bank_name;
    }

    public void setCcus_bank_name(String ccus_bank_name) {
        this.ccus_bank_name = ccus_bank_name;
    }

    public String getCcus_bank_account() {
        return ccus_bank_account;
    }

    public void setCcus_bank_account(String ccus_bank_account) {
        this.ccus_bank_account = ccus_bank_account;
    }

    public String getCcus_bank_dwname() {
        return ccus_bank_dwname;
    }

    public void setCcus_bank_dwname(String ccus_bank_dwname) {
        this.ccus_bank_dwname = ccus_bank_dwname;
    }

    public String getCcus_account() {
        return ccus_account;
    }

    public void setCcus_account(String ccus_account) {
        this.ccus_account = ccus_account;
    }

    public String getClevelname() {
        return clevelname;
    }

    public void setClevelname(String clevelname) {
        this.clevelname = clevelname;
    }

    public String getCtypename() {
        return ctypename;
    }

    public void setCtypename(String ctypename) {
        this.ctypename = ctypename;
    }

    public String getCcus_credit_typename() {
        return ccus_credit_typename;
    }

    public void setCcus_credit_typename(String ccus_credit_typename) {
        this.ccus_credit_typename = ccus_credit_typename;
    }

    public String getCcus_paytype_name() {
        return ccus_paytype_name;
    }

    public void setCcus_paytype_name(String ccus_paytype_name) {
        this.ccus_paytype_name = ccus_paytype_name;
    }

    public String getCdefine1() {
        return cdefine1;
    }

    public void setCdefine1(String cdefine1) {
        this.cdefine1 = cdefine1;
    }

    public String getBwxbind() {
        return bwxbind;
    }

    public void setBwxbind(String bwxbind) {
        this.bwxbind = bwxbind;
    }

    public String getCuserid() {
        return cuserid;
    }

    public void setCuserid(String cuserid) {
        this.cuserid = cuserid;
    }

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey;
    }

    public int getIlogin_type() {
        return ilogin_type;
    }

    public void setIlogin_type(int ilogin_type) {
        this.ilogin_type = ilogin_type;
    }

    public String getCcuspperson() {
        return ccuspperson;
    }

    public void setCcuspperson(String ccuspperson) {
        this.ccuspperson = ccuspperson;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "status0=" + status0 +
                ", status1=" + status1 +
                ", status2=" + status2 +
                ", status3=" + status3 +
                ", status9=" + status9 +
                ", status10=" + status10 +
                ", statusall=" + statusall +
                ", autoid=" + autoid +
                ", ccus_code='" + ccus_code + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", cpassword='" + cpassword + '\'' +
                ", ccus_create_by='" + ccus_create_by + '\'' +
                ", ccus_create_source='" + ccus_create_source + '\'' +
                ", dcus_create_time=" + dcus_create_time +
                ", ccus_update_by='" + ccus_update_by + '\'' +
                ", dcus_update_time=" + dcus_update_time +
                ", ccus_status='" + ccus_status + '\'' +
                ", ccus_statusname='" + ccus_statusname + '\'' +
                ", dfrist_login_time=" + dfrist_login_time +
                ", dlast_login_time=" + dlast_login_time +
                ", ccompany_id='" + ccompany_id + '\'' +
                ", cdepartment_id='" + cdepartment_id + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", ccus_level='" + ccus_level + '\'' +
                ", ccus_type='" + ccus_type + '\'' +
                ", ccus_xpoint=" + ccus_xpoint +
                ", ccus_ypoint=" + ccus_ypoint +
                ", ccus_address='" + ccus_address + '\'' +
                ", ccus_oaddress='" + ccus_oaddress + '\'' +
                ", ccus_person='" + ccus_person + '\'' +
                ", ccus_phone='" + ccus_phone + '\'' +
                ", ccus_email='" + ccus_email + '\'' +
                ", ccus_paytype='" + ccus_paytype + '\'' +
                ", ccus_credit_type='" + ccus_credit_type + '\'' +
                ", icus_credit_days=" + icus_credit_days +
                ", icus_credit_line=" + icus_credit_line +
                ", ccus_visit_type='" + ccus_visit_type + '\'' +
                ", icus_visit_time='" + icus_visit_time + '\'' +
                ", ccus_visit_state=" + ccus_visit_state +
                ", clicense_id='" + clicense_id + '\'' +
                ", clicense_name='" + clicense_name + '\'' +
                ", clicense_img1='" + clicense_img1 + '\'' +
                ", clicense_img2='" + clicense_img2 + '\'' +
                ", ccus_close_by='" + ccus_close_by + '\'' +
                ", ccus_close_time='" + ccus_close_time + '\'' +
                ", ccomname='" + ccomname + '\'' +
                ", cdepname='" + cdepname + '\'' +
                ", cperson_name='" + cperson_name + '\'' +
                ", ccus_faren_name='" + ccus_faren_name + '\'' +
                ", ccus_faren_phone='" + ccus_faren_phone + '\'' +
                ", ccus_bank_name='" + ccus_bank_name + '\'' +
                ", ccus_bank_account='" + ccus_bank_account + '\'' +
                ", ccus_bank_dwname='" + ccus_bank_dwname + '\'' +
                ", ccus_account='" + ccus_account + '\'' +
                ", clevelname='" + clevelname + '\'' +
                ", ctypename='" + ctypename + '\'' +
                ", ccus_credit_typename='" + ccus_credit_typename + '\'' +
                ", ccus_paytype_name='" + ccus_paytype_name + '\'' +
                ", cdefine1='" + cdefine1 + '\'' +
                ", bwxbind='" + bwxbind + '\'' +
                ", cuserid='" + cuserid + '\'' +
                ", ckey='" + ckey + '\'' +
                ", ilogin_type=" + ilogin_type +
                '}';
    }
}
