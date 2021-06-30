package com.shunxin.shunxin_salesman_visit.dto.malldto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author yinyang
 * @version V1.0
 * @ClassName :
 * @Description :
 * @date 2021/6/25
 */
@Data
public class XfgOrderDto {
    //csocode,csocodes,csotype,cshiptype,ddate,ccus_id,ccus_code,ccus_name,ccomcode,cperson_id,cso_state,cso_state_sub,ccus_remaker,ccom_remaker,iquan_sum,
    //ikpquan_sum,imoney_sum,ikpmoney_sum,cmaker,bsnerp,bgold,igold_sum,iusegold_sum,cpaytype,icashmoney,iqrcodemoney,inopaymoney,xpiont_order,ypiont_order,mdefine1,bsoorder

    private String ctype;           //01新增、02修改、03删除
    private String csocode;         //订单号
    private String csocodes;        //子订单号，暂设定为主订单号+01
    private String csotype;         //单据类型	01表示普通订单，04表示车销订单，54表示分销配送订单
    private String cshiptype;       //
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ddate;             //下单时间
    private String ccus_id;         //客户ID
    private String ccus_code;       //客户用友编号
    private String ccus_name;       //客户名称
    private String ccomcode;        //所属公司
    private String cperson_id;      //业务员ID
    private String cso_state;       //订单状态编码
    private String cso_state_sub;   //暂时不知道，数据库中多为空
    private String ccus_remaker;    //订单备注
    private String ccom_remaker;    //
    private Integer iquan_sum;      //数量合计
    private Integer ikpquan_sum;    //空瓶数量合计
    private BigDecimal imoney_sum;  //金额合计
    private BigDecimal ikpmoney_sum;   //空瓶金额合计
    private String cmaker;          //制单人
    private Integer bsnerp;         //是否已同步至用友,如果是分销配送不需要同步，默认置为1
    private Integer bgold;          //是否已计算积分，目前已基本不上使用了
    private Integer igold_sum;      //表头产生积分
    private Integer iusegold_sum;   //本次使用积分
    private String cpaytype;        //付款方式，1现金结算 2二维码结算 3现金+二维码结算,4货到付款,5陈列,0无
    private BigDecimal icashmoney;  //付现金额	仅车销
    private BigDecimal iqrcodemoney;//二维码付款金额	仅车销
    private BigDecimal inopaymoney; //无需付款金额	仅车销
    private BigDecimal xpiont_order;//纬度
    private BigDecimal ypiont_order;//经度
    private BigDecimal mdefine1;    //现结金额
    private String bsoorder;        //是否有出库申请  0无 1有
    private List<OrderstyleDto> orderList;  //订单具体信息

    @Override
    public String toString() {
        return "XfgOrderDto{" +
                "ctype='" + ctype + '\'' +
                ", csocode='" + csocode + '\'' +
                ", csocodes='" + csocodes + '\'' +
                ", csotype='" + csotype + '\'' +
                ", cshiptype='" + cshiptype + '\'' +
                ", ddate=" + ddate +
                ", ccus_id='" + ccus_id + '\'' +
                ", ccus_code='" + ccus_code + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", ccomcode='" + ccomcode + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", cso_state='" + cso_state + '\'' +
                ", cso_state_sub='" + cso_state_sub + '\'' +
                ", ccus_remaker='" + ccus_remaker + '\'' +
                ", ccom_remaker='" + ccom_remaker + '\'' +
                ", iquan_sum=" + iquan_sum +
                ", ikpquan_sum=" + ikpquan_sum +
                ", imoney_sum=" + imoney_sum +
                ", ikpmoney_sum=" + ikpmoney_sum +
                ", cmaker='" + cmaker + '\'' +
                ", bsnerp=" + bsnerp +
                ", bgold=" + bgold +
                ", igold_sum=" + igold_sum +
                ", iusegold_sum=" + iusegold_sum +
                ", cpaytype='" + cpaytype + '\'' +
                ", icashmoney=" + icashmoney +
                ", iqrcodemoney=" + iqrcodemoney +
                ", inopaymoney=" + inopaymoney +
                ", xpiont_order=" + xpiont_order +
                ", ypiont_order=" + ypiont_order +
                ", mdefine1=" + mdefine1 +
                ", bsoorder='" + bsoorder + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
