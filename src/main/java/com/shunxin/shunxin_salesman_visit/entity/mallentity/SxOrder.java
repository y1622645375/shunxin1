package com.shunxin.shunxin_salesman_visit.entity.mallentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shunxin.shunxin_salesman_visit.dto.distributordto.commodityDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class SxOrder {
    private int autoid;
    private String csocode;
    private String csotype;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ddate;              //下单时间
    private String ccus_id;          //客户编号
    private String ccus_code;        //用友编码
    private String ccus_name;        //客户名称
    private String ccomcode;         //公司编码
    private String cperson_id;       //业务员编号
    private String cso_state;        //订单状态
    private BigDecimal xpiont_order;  //纬度
    private BigDecimal ypiont_order;  //经度
    private int iquan_sum;
    private Float ikpquan_sum;
    private Float imoney_sum;
    private Float ikpmoney_sum;
    private Float igold_sum;
    private Float iusegold_sum;
    private String cpaytype;
    private Float icashmoney;
    private Float iqrcodemoney;
    private Float ipay_sum;
    private String cmaker;
    private String bclose;
    private String cclose_name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dclose_date;
    private String dclose_desc;
    private Float mdefine1;
    private String cperson_name;
    private String cpaytypename;
    private String cso_statename;
    private String ccomname;
    private String ccus_oaddress;
    private String strReslut;
    private List<commodityDto> commodityDtoList;

    @Override
    public String toString() {
        return "SxOrder{" +
                "autoid=" + autoid +
                ", csocode='" + csocode + '\'' +
                ", csotype='" + csotype + '\'' +
                ", ddate=" + ddate +
                ", ccus_id='" + ccus_id + '\'' +
                ", ccus_code='" + ccus_code + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", ccomcode='" + ccomcode + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", cso_state='" + cso_state + '\'' +
                ", xpiont_order=" + xpiont_order +
                ", ypiont_order=" + ypiont_order +
                ", iquan_sum=" + iquan_sum +
                ", ikpquan_sum=" + ikpquan_sum +
                ", imoney_sum=" + imoney_sum +
                ", ikpmoney_sum=" + ikpmoney_sum +
                ", igold_sum=" + igold_sum +
                ", iusegold_sum=" + iusegold_sum +
                ", cpaytype='" + cpaytype + '\'' +
                ", icashmoney=" + icashmoney +
                ", iqrcodemoney=" + iqrcodemoney +
                ", ipay_sum=" + ipay_sum +
                ", cmaker='" + cmaker + '\'' +
                ", bclose='" + bclose + '\'' +
                ", cclose_name='" + cclose_name + '\'' +
                ", dclose_date=" + dclose_date +
                ", dclose_desc='" + dclose_desc + '\'' +
                ", mdefine1=" + mdefine1 +
                ", cperson_name='" + cperson_name + '\'' +
                ", cpaytypename='" + cpaytypename + '\'' +
                ", cso_statename='" + cso_statename + '\'' +
                ", ccomname='" + ccomname + '\'' +
                ", ccus_oaddress='" + ccus_oaddress + '\'' +
                ", strReslut='" + strReslut + '\'' +
                ", commodityDtoList=" + commodityDtoList +
                '}';
    }
}
