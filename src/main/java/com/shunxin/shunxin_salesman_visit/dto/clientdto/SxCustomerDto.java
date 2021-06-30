package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import java.math.BigDecimal;

public class SxCustomerDto {
    private String ctype;                   // 01为增加  02为修改
    private int autoid;                     //ID
    private String ccus_name;               //店名
    private String cpassword;               //密码
    private String ccus_create_by;          //建档人，中文
    private String ccus_create_source;      //建档来源，1业务员，2导入，9其他
    private String ccus_update_by;          //最后修改人
    private String ccus_status;             //客户状态，0待审核，1审核通过无交易，2审核通过活跃，3审核通过留存，9其他，10审核不通过
    private String cperson_id;              //对应业务员ID
    private String ccus_account;            //登录手机号
    private String ccus_type;               //客户类型
    private String ccus_level;              //客户级别
    private BigDecimal ccus_xpoint;         //纬度
    private BigDecimal ccus_ypoint;         //经度
    private String ccus_address;            //客户地址，门店地址，拜访地址
    private String ccus_oaddress;           //送货地址
    private String ccus_person;             //客户联系人
    private String ccus_phone;              //客户联系方式
    private String ccus_email;              //客户邮箱
    private String ccus_paytype;            //客户付款方式，1现结，2月结，3送二结一，9其他
    private String ccus_faren_name;         //法人姓名
    private String ccus_faren_phone;        ///法人电话
    private String ccus_bank_account;       //开户行账号
    private String ccus_bank_name;          //开户行网点名
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
    private String ccus_code;               //客户编码
    private int icus_visit_time2;
    private int icus_visit_time3;
    private int icus_visit_time4;
    private int icus_visit_time5;
    private int icus_visit_time6;
    private int isxemallid;

    public int getIsxemallid() {
        return isxemallid;
    }

    public void setIsxemallid(int isxemallid) {
        this.isxemallid = isxemallid;
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

    public int getIcus_visit_time2() {
        return icus_visit_time2;
    }

    public void setIcus_visit_time2(int icus_visit_time2) {
        this.icus_visit_time2 = icus_visit_time2;
    }

    public int getIcus_visit_time3() {
        return icus_visit_time3;
    }

    public void setIcus_visit_time3(int icus_visit_time3) {
        this.icus_visit_time3 = icus_visit_time3;
    }

    public int getIcus_visit_time4() {
        return icus_visit_time4;
    }

    public void setIcus_visit_time4(int icus_visit_time4) {
        this.icus_visit_time4 = icus_visit_time4;
    }

    public int getIcus_visit_time5() {
        return icus_visit_time5;
    }

    public void setIcus_visit_time5(int icus_visit_time5) {
        this.icus_visit_time5 = icus_visit_time5;
    }

    public int getIcus_visit_time6() {
        return icus_visit_time6;
    }

    public void setIcus_visit_time6(int icus_visit_time6) {
        this.icus_visit_time6 = icus_visit_time6;
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

    public String getCcus_update_by() {
        return ccus_update_by;
    }

    public void setCcus_update_by(String ccus_update_by) {
        this.ccus_update_by = ccus_update_by;
    }

    public String getCcus_status() {
        return ccus_status;
    }

    public void setCcus_status(String ccus_status) {
        this.ccus_status = ccus_status;
    }

    public String getCperson_id() {
        return cperson_id;
    }

    public void setCperson_id(String cperson_id) {
        this.cperson_id = cperson_id;
    }

    public String getCcus_account() {
        return ccus_account;
    }

    public void setCcus_account(String ccus_account) {
        this.ccus_account = ccus_account;
    }

    public String getCcus_type() {
        return ccus_type;
    }

    public void setCcus_type(String ccus_type) {
        this.ccus_type = ccus_type;
    }

    public String getCcus_level() {
        return ccus_level;
    }

    public void setCcus_level(String ccus_level) {
        this.ccus_level = ccus_level;
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

    public String getCcus_bank_account() {
        return ccus_bank_account;
    }

    public void setCcus_bank_account(String ccus_bank_account) {
        this.ccus_bank_account = ccus_bank_account;
    }

    public String getCcus_bank_name() {
        return ccus_bank_name;
    }

    public void setCcus_bank_name(String ccus_bank_name) {
        this.ccus_bank_name = ccus_bank_name;
    }

    public String getCcus_bank_dwname() {
        return ccus_bank_dwname;
    }

    public void setCcus_bank_dwname(String ccus_bank_dwname) {
        this.ccus_bank_dwname = ccus_bank_dwname;
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

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    @Override
    public String toString() {
        return "SxCustomerDto{" +
                "ctype='" + ctype + '\'' +
                ", autoid=" + autoid +
                ", ccus_name='" + ccus_name + '\'' +
                ", cpassword='" + cpassword + '\'' +
                ", ccus_create_by='" + ccus_create_by + '\'' +
                ", ccus_create_source='" + ccus_create_source + '\'' +
                ", ccus_update_by='" + ccus_update_by + '\'' +
                ", ccus_status='" + ccus_status + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", ccus_account='" + ccus_account + '\'' +
                ", ccus_type='" + ccus_type + '\'' +
                ", ccus_level='" + ccus_level + '\'' +
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
                ", ccus_bank_account='" + ccus_bank_account + '\'' +
                ", ccus_bank_name='" + ccus_bank_name + '\'' +
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
                ", ccus_code='" + ccus_code + '\'' +
                ", icus_visit_time2=" + icus_visit_time2 +
                ", icus_visit_time3=" + icus_visit_time3 +
                ", icus_visit_time4=" + icus_visit_time4 +
                ", icus_visit_time5=" + icus_visit_time5 +
                ", icus_visit_time6=" + icus_visit_time6 +
                ", isxemallid=" + isxemallid +
                '}';
    }
}
