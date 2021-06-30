package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户表
 */
public class SxCustomer {
    private int autoid;                     //ID
    private String ccus_code;               //客户对应用友编码，新建时为空，审核时填写
    private String ccus_name;               //客户名称
    private String cpassword;               //密码，微信端无实际意义，将来商城用于PC端登陆
    private String ccus_create_by;          //建档人，中文
    private String ccus_create_source;      //建档来源，1业务员，2导入，9其他
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dcus_create_time;          //建档日期
    private String ccus_update_by;          //最后修改人
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dcus_update_time;          //最后修改日期
    private String ccus_status;             //客户状态，0待审核，1审核通过无交易，2审核通过活跃，3审核通过留存，9其他，10审核不通过,11 关闭
    private String ccus_statusname;         //客户状态名称（视图中的列）
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dfrist_login_time;         //首次登陆日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dlast_login_time;          //最后登陆日期
    private String ccompany_id;             //对应公司ID
    private String cdepartment_id;          //对应部门ID
    private String cperson_id;              //对应业务员ID
    private String ccus_account;            //登录手机号
    private String ccus_level;              //客户级别
    private String ccus_type;               //客户类型
    private BigDecimal ccus_xpoint;         //经度
    private BigDecimal ccus_ypoint;         //纬度
    private String ccus_address;            //客户地址，门店地址，拜访地址
    private String ccus_oaddress;           //送货地址
    private String ccus_person;             //客户联系人
    private String ccus_phone;              //客户联系方式
    private String ccus_email;              //客户邮箱
    private String ccus_paytype;            //客户付款方式，1现结，2月结，3送二结一，9其他
    private String ccus_faren_name;         //法人姓名
    private String ccus_faren_phone;        //法人电话
    private String ccus_bank_name;          //开户行网点名
    private String ccus_bank_account;       //开户行账号
    private String ccus_bank_dwname;        //开户人单位名称
    private String ccus_credit_type;        //客户信用方式，1账期，2额度，3账期+额度，9其他
    private int icus_credit_days;           //账期天数
    private int icus_credit_line;           //信用额度
    private String ccus_visit_type;         //客户拜访类型，1每周，2单周，3双周，4每月
    private int icus_visit_time;            //每周单周双周1-7，每月1-31
    private int ccus_visit_state;           //拜访状态，1正常拜访，2暂停拜访
    private String clicense_id;             //营业执照号
    private String clicense_name;           //营业执照店名
    private String clicense_img1;           //营业执照照片
    private String clicense_img2;           //客户身份证照片
    private String clicense_img3;           //门店照片
    private String ccus_close_by;           //客户关闭人
    private String ccus_close_time;         //客户关闭日期
    /** 字符型自定义项（预留字段）*/
    private String cdefine1;
    private String cdefine2;
    private String cdefine3;
    private String cdefine4;
    private String cdefine5;
    /** 日期自定义项（预留字段） */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ddefine1;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ddafine2;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ddefine3;
    /** 浮点型自定义项（预留字段） */
    private float idefine1;
    private float idefine2;
    private float idefine3;
    private String ccomname;            //公司名称（视图中的列）
    private String cperson_name;        //业务员名字（视图中的列）
    private String cdepname;            //部门名称（视图中的列）

    public SxCustomer() {
    }

    public SxCustomer(String ccus_name, String cpassword, String ccus_create_by, String ccus_create_source, String ccus_update_by, String ccus_status, String cperson_id, String ccus_account, String ccus_level, String ccus_type, BigDecimal ccus_xpoint, BigDecimal ccus_ypoint, String ccus_address, String ccus_oaddress, String ccus_person, String ccus_phone, String ccus_email, String ccus_paytype, String ccus_faren_name, String ccus_faren_phone, String ccus_bank_name, String ccus_bank_account, String ccus_bank_dwname, String ccus_credit_type, int icus_credit_days, int icus_credit_line, String ccus_visit_type, int icus_visit_time, int ccus_visit_state, String clicense_id, String clicense_name, String clicense_img1, String clicense_img2) {
        this.ccus_name = ccus_name;
        this.cpassword = cpassword;
        this.ccus_create_by = ccus_create_by;
        this.ccus_create_source = ccus_create_source;
        this.ccus_update_by = ccus_update_by;
        this.ccus_status = ccus_status;
        this.cperson_id = cperson_id;
        this.ccus_account = ccus_account;
        this.ccus_level = ccus_level;
        this.ccus_type = ccus_type;
        this.ccus_xpoint = ccus_xpoint;
        this.ccus_ypoint = ccus_ypoint;
        this.ccus_address = ccus_address;
        this.ccus_oaddress = ccus_oaddress;
        this.ccus_person = ccus_person;
        this.ccus_phone = ccus_phone;
        this.ccus_email = ccus_email;
        this.ccus_paytype = ccus_paytype;
        this.ccus_faren_name = ccus_faren_name;
        this.ccus_faren_phone = ccus_faren_phone;
        this.ccus_bank_name = ccus_bank_name;
        this.ccus_bank_account = ccus_bank_account;
        this.ccus_bank_dwname = ccus_bank_dwname;
        this.ccus_credit_type = ccus_credit_type;
        this.icus_credit_days = icus_credit_days;
        this.icus_credit_line = icus_credit_line;
        this.ccus_visit_type = ccus_visit_type;
        this.icus_visit_time = icus_visit_time;
        this.ccus_visit_state = ccus_visit_state;
        this.clicense_id = clicense_id;
        this.clicense_name = clicense_name;
        this.clicense_img1 = clicense_img1;
        this.clicense_img2 = clicense_img2;
    }

    public String getClicense_img3() {
        return clicense_img3;
    }

    public void setClicense_img3(String clicense_img3) {
        this.clicense_img3 = clicense_img3;
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

    public int getIcus_visit_time() {
        return icus_visit_time;
    }

    public void setIcus_visit_time(int icus_visit_time) {
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

    public String getCdefine1() {
        return cdefine1;
    }

    public void setCdefine1(String cdefine1) {
        this.cdefine1 = cdefine1;
    }

    public String getCdefine2() {
        return cdefine2;
    }

    public void setCdefine2(String cdefine2) {
        this.cdefine2 = cdefine2;
    }

    public String getCdefine3() {
        return cdefine3;
    }

    public void setCdefine3(String cdefine3) {
        this.cdefine3 = cdefine3;
    }

    public String getCdefine4() {
        return cdefine4;
    }

    public void setCdefine4(String cdefine4) {
        this.cdefine4 = cdefine4;
    }

    public String getCdefine5() {
        return cdefine5;
    }

    public void setCdefine5(String cdefine5) {
        this.cdefine5 = cdefine5;
    }

    public Date getDdefine1() {
        return ddefine1;
    }

    public void setDdefine1(Date ddefine1) {
        this.ddefine1 = ddefine1;
    }

    public Date getDdafine2() {
        return ddafine2;
    }

    public void setDdafine2(Date ddafine2) {
        this.ddafine2 = ddafine2;
    }

    public Date getDdefine3() {
        return ddefine3;
    }

    public void setDdefine3(Date ddefine3) {
        this.ddefine3 = ddefine3;
    }

    public float getIdefine1() {
        return idefine1;
    }

    public void setIdefine1(float idefine1) {
        this.idefine1 = idefine1;
    }

    public float getIdefine2() {
        return idefine2;
    }

    public void setIdefine2(float idefine2) {
        this.idefine2 = idefine2;
    }

    public float getIdefine3() {
        return idefine3;
    }

    public void setIdefine3(float idefine3) {
        this.idefine3 = idefine3;
    }

    public String getCcomname() {
        return ccomname;
    }

    public void setCcomname(String ccomname) {
        this.ccomname = ccomname;
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

    public String getCcus_account() {
        return ccus_account;
    }

    public void setCcus_account(String ccus_account) {
        this.ccus_account = ccus_account;
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

    public String getCcus_statusname() {
        return ccus_statusname;
    }

    public void setCcus_statusname(String ccus_statusname) {
        this.ccus_statusname = ccus_statusname;
    }

    public String getCdepname() {
        return cdepname;
    }

    public void setCdepname(String cdepname) {
        this.cdepname = cdepname;
    }

    @Override
    public String toString() {
        return "SxCustomer{" +
                "autoid=" + autoid +
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
                ", ccus_account='" + ccus_account + '\'' +
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
                ", ccus_faren_name='" + ccus_faren_name + '\'' +
                ", ccus_faren_phone='" + ccus_faren_phone + '\'' +
                ", ccus_bank_name='" + ccus_bank_name + '\'' +
                ", ccus_bank_account='" + ccus_bank_account + '\'' +
                ", ccus_bank_dwname='" + ccus_bank_dwname + '\'' +
                ", ccus_credit_type='" + ccus_credit_type + '\'' +
                ", icus_credit_days=" + icus_credit_days +
                ", icus_credit_line=" + icus_credit_line +
                ", ccus_visit_type='" + ccus_visit_type + '\'' +
                ", icus_visit_time=" + icus_visit_time +
                ", ccus_visit_state=" + ccus_visit_state +
                ", clicense_id='" + clicense_id + '\'' +
                ", clicense_name='" + clicense_name + '\'' +
                ", clicense_img1='" + clicense_img1 + '\'' +
                ", clicense_img2='" + clicense_img2 + '\'' +
                ", clicense_img3='" + clicense_img3 + '\'' +
                ", ccus_close_by='" + ccus_close_by + '\'' +
                ", ccus_close_time='" + ccus_close_time + '\'' +
                ", cdefine1='" + cdefine1 + '\'' +
                ", cdefine2='" + cdefine2 + '\'' +
                ", cdefine3='" + cdefine3 + '\'' +
                ", cdefine4='" + cdefine4 + '\'' +
                ", cdefine5='" + cdefine5 + '\'' +
                ", ddefine1=" + ddefine1 +
                ", ddafine2=" + ddafine2 +
                ", ddefine3=" + ddefine3 +
                ", idefine1=" + idefine1 +
                ", idefine2=" + idefine2 +
                ", idefine3=" + idefine3 +
                ", ccomname='" + ccomname + '\'' +
                ", cperson_name='" + cperson_name + '\'' +
                ", cdepname='" + cdepname + '\'' +
                '}';
    }
}
