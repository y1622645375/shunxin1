package com.shunxin.shunxin_salesman_visit.service.distributor.Impl;


import com.shunxin.shunxin_salesman_visit.dto.clientdto.OrdervDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.distributordto.*;
import com.shunxin.shunxin_salesman_visit.mapper.distributor.Distr_OrderMapper;
import com.shunxin.shunxin_salesman_visit.service.distributor.Distr_OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/Distr_OrderService")
public class Distr_OrderServiceImpl implements Distr_OrderService {

    @Resource
    private Distr_OrderMapper orderMapper;


    @Override
    public List<OrdervDto> getDistrOrderList(String ddate1, String ddate2, String csocode, String cso_state_sub, String cdefine3, String ccus_id, String ccus_distribution) {
        return orderMapper.getDistrOrderList(ddate1,ddate2,csocode,cso_state_sub,cdefine3,ccus_id,ccus_distribution);
    }

    @Override
    public List<OrdervDto> getDistrOrderOne(String csocode) {
        return orderMapper.getDistrOrderOne(csocode);
    }

    @Override
    public List<ResultDto> receivingOrder(String jsonvit) {
        return orderMapper.receivingOrder(jsonvit);
    }


    @Override
    public int clearUpOrder() {
        return orderMapper.clearUpOrder();
    }

    @Override
    public List<DistributionDto> getDistributionTotal(String jsonvit) {
        return orderMapper.getDistributionTotal(jsonvit);
    }

    @Override
    public List<OrdervDto> getCommIquanSum(String ccus_distribution,String cinvcode) {
        return orderMapper.getCommIquanSum(ccus_distribution,cinvcode);
    }

    @Override
    public List<ManageTotalDto> getManageTotal( String cinvcode1, String cinvcode2,String cinvcode3, String cinvcode4, String cinvcode5,String cuserid) {
        return orderMapper.getManageTotal(cinvcode1,cinvcode2,cinvcode3,cinvcode4,cinvcode5,cuserid);
    }

    @Override
    public String getDistributionSf(String cuserid) {
        return orderMapper.getDistributionSf(cuserid);
    }

    @Override
    public List<ManageTotalDto> getManageTotal_salesman(String cinvcode1, String cinvcode2, String cinvcode3, String cinvcode4, String cinvcode5, String cuserid) {
        return orderMapper.getManageTotal_salesman(cinvcode1,cinvcode2,cinvcode3,cinvcode4,cinvcode5,cuserid);
    }

    @Override
    public Double getCalculateDistance(String ccus_xpoint, String ccus_ypoint, String courier_xpoint, String courier_ypoint) {
        return orderMapper.getCalculateDistance(ccus_xpoint,ccus_ypoint,courier_xpoint,courier_ypoint);
    }

    @Override
    public List<OrdervDto> getNearbyOrder(String cdefine3) {
        return orderMapper.getNearbyOrder(cdefine3);
    }

    @Override
    public List<PayCountDto> getDistrPayCount() {
        return orderMapper.getDistrPayCount();
    }

    @Override
    public List<OrderListDto> getOrderCinvname() {
        return orderMapper.getOrderCinvname();
    }

    @Override
    public int getWxSmallBand(String ccus_user_openid_xcx) {
        return orderMapper.getWxSmallBand(ccus_user_openid_xcx);
    }

    @Override
    public int addWxSmallBand(String ccus_user_openid_xcx,String ccus_user_openid_unitid,String ccus_user_tel) {
        return orderMapper.addWxSmallBand(ccus_user_openid_xcx,ccus_user_openid_unitid,ccus_user_tel);
    }

    @Override
    public List<SxCustomerUser> getDistriList(String ccus_user_openid_xcx,String session_key) {
        return orderMapper.getDistriList(ccus_user_openid_xcx,session_key);
    }

    @Override
    public int getSessionKey(String session_key, String ccus_user_openid_xcx) {
        return orderMapper.getSessionKey(session_key,ccus_user_openid_xcx);
    }

    @Override
    public List<SxCustomerUser> getDistribution(String ccus_id, String cuser_type) {
        return orderMapper.getDistribution(ccus_id,cuser_type);
    }

    @Override
    public int addDistribution(String ccus_id, String cuser_type, String ccus_user_name, String ccus_user_tel, String ccus_user_openid_unitid, String ccus_user_openid_xcx) {
        return orderMapper.addDistribution(ccus_id,cuser_type,ccus_user_name,ccus_user_tel,ccus_user_openid_unitid,ccus_user_openid_xcx);
    }


}
