package com.shunxin.shunxin_salesman_visit.mapper.distributor;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.OrdervDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.distributordto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Distr_OrderMapper {


    //查询订单列表(分销商部分)
    List<OrdervDto> getDistrOrderList(@Param("ddate1") String ddate1,@Param("ddate2") String ddate2, @Param("csocode") String csocode,
                                      @Param("cso_state_sub") String cso_state_sub,@Param("cdefine3") String cdefine3,@Param("ccus_id") String ccus_id,
                                      @Param("ccus_distribution") String ccus_distribution);


    //根据订单号查询订单
    List<OrdervDto>  getDistrOrderOne(@Param("csocode") String csocode);


    //分销商点击接单、拒单、订单配送完成
    List<ResultDto> receivingOrder(@Param("jsonvit") String jsonvit);


    //每天00:30将未配送完成的订单重新划至新订单
    int clearUpOrder();


    //分销商查询合计
    List<DistributionDto> getDistributionTotal(@Param("jsonvit") String jsonvit);


    //根据分销商查询已配送商品数量
    List<OrdervDto> getCommIquanSum(@Param("ccus_distribution") String ccus_distribution,@Param("cinvcode") String cinvcode);


    //主管查询合计
    List<ManageTotalDto> getManageTotal(@Param("cinvcode1") String cinvcode1,@Param("cinvcode2") String cinvcode2,@Param("cinvcode3") String cinvcode3,
                                        @Param("cinvcode4") String cinvcode4,@Param("cinvcode5") String cinvcode5,@Param("cuserid") String cuserid);


    //根据工号判断客户是否为分销商
    String getDistributionSf(@Param("cuserid") String cuserid);


    //业务员查询合计
    List<ManageTotalDto> getManageTotal_salesman(@Param("cinvcode1") String cinvcode1,@Param("cinvcode2") String cinvcode2,@Param("cinvcode3") String cinvcode3,
                                        @Param("cinvcode4") String cinvcode4,@Param("cinvcode5") String cinvcode5,@Param("cuserid") String cuserid);


    //根据两个经纬度计算出距离（米）
    Double getCalculateDistance(@Param("ccus_xpoint") String ccus_xpoint,@Param("ccus_ypoint") String ccus_ypoint,
                                @Param("courier_xpoint") String courier_xpoint,@Param("courier_ypoint") String courier_ypoint);


    //根据定位查询200米以内的订单
    List<OrdervDto> getNearbyOrder(@Param("cdefine3") String cdefine3);


    //查询经销商近7天支付次数大于等于5次的订单
    List<PayCountDto> getDistrPayCount();


    //查询分销商出售的商品列表
    List<OrderListDto> getOrderCinvname();


    //先传入openid和手机号查询是否已经绑定过
    int getWxSmallBand(@Param("ccus_user_openid_xcx") String ccus_user_openid_xcx);

    //未绑定过的进行openid和手机号的绑定
    int addWxSmallBand(@Param("ccus_user_openid_xcx") String ccus_user_openid_xcx,@Param("ccus_user_openid_unitid") String ccus_user_openid_unitid,@Param("ccus_user_tel") String ccus_user_tel);

    //通过openid查询绑定信息
    List<SxCustomerUser> getDistriList(@Param("ccus_user_openid_xcx") String ccus_user_openid_xcx,@Param("session_key") String session_key);

    //每次登录获取key以便进行效验
    int getSessionKey(@Param("session_key") String session_key,@Param("ccus_user_openid_xcx") String ccus_user_openid_xcx);

    //查询配送员信息
    List<SxCustomerUser> getDistribution(@Param("ccus_id") String ccus_id, @Param("cuser_type") String cuser_type);

    //新增配送员
    int addDistribution(@Param("ccus_id") String ccus_id,@Param("cuser_type") String cuser_type,@Param("ccus_user_name") String ccus_user_name,
                        @Param("ccus_user_tel") String ccus_user_tel,@Param("ccus_user_openid_unitid") String ccus_user_openid_unitid,@Param("ccus_user_openid_xcx") String ccus_user_openid_xcx);


}
