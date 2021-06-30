package com.shunxin.shunxin_salesman_visit.service.distributor;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.OrdervDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.distributordto.*;

import java.util.List;

public interface Distr_OrderService {

    //查询订单列表(分销商部分)
    List<OrdervDto> getDistrOrderList(String ddate1, String ddate2, String csocode, String cso_state_sub,String cdefine3,String ccus_id,String ccus_distribution);


    //根据订单号查询订单
    List<OrdervDto>  getDistrOrderOne(String csocode);


    //分销商点击接单、拒单、订单配送完成
    List<ResultDto> receivingOrder(String jsonvit);


    //每天00:30将未配送完成的订单重新划至新订单
    int clearUpOrder();


    //分销商查询合计
    List<DistributionDto> getDistributionTotal(String jsonvit);


    //根据分销商查询已配送商品数量
    List<OrdervDto> getCommIquanSum(String ccus_distribution,String cinvcode);


    //主管查询合计
    List<ManageTotalDto> getManageTotal( String cinvcode1,String cinvcode2, String cinvcode3, String cinvcode4, String cinvcode5,String cuserid);


    //根据工号判断客户是否为分销商
    String getDistributionSf(String cuserid);


    //业务员查询合计
    List<ManageTotalDto> getManageTotal_salesman(String cinvcode1,String cinvcode2, String cinvcode3, String cinvcode4, String cinvcode5,String cuserid);


    //根据两个经纬度计算出距离（米）
    Double getCalculateDistance(String ccus_xpoint, String ccus_ypoint,String courier_xpoint,String courier_ypoint);


    //根据定位查询200米以内的订单
    List<OrdervDto> getNearbyOrder(String cdefine3);


    //查询经销商近7天支付次数大于等于5次的订单
    List<PayCountDto> getDistrPayCount();


    //查询分销商出售的商品列表
    List<OrderListDto> getOrderCinvname();


    //先传入openid和手机号查询是否已经绑定过
    int getWxSmallBand(String ccus_user_openid_xcx);

    //未绑定过的进行openid和手机号的绑定
    int addWxSmallBand(String ccus_user_openid_xcx,String ccus_user_openid_unitid,String ccus_user_tel);

    //通过openid查询绑定信息
    List<SxCustomerUser> getDistriList(String ccus_user_openid_xcx,String session_key);

    //每次登录获取key以便进行效验
    int getSessionKey(String session_key,String ccus_user_openid_xcx);

    //查询配送员信息
    List<SxCustomerUser> getDistribution(String ccus_id, String cuser_type);

    //新增配送员
    int addDistribution(String ccus_id,String cuser_type,String ccus_user_name,String ccus_user_tel,String ccus_user_openid_unitid,String ccus_user_openid_xcx);

}
