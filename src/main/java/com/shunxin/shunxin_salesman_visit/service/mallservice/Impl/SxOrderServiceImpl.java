package com.shunxin.shunxin_salesman_visit.service.mallservice.Impl;


import com.shunxin.shunxin_salesman_visit.dto.clientdto.OrdervDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.ResultOrderDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.OrderstyleDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.SxOrderDto;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.Order;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.OrderLog;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.SxOrder;
import com.shunxin.shunxin_salesman_visit.mapper.mallmapper.SxOrderMapper;
import com.shunxin.shunxin_salesman_visit.service.mallservice.SxOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("OrderService")
public class SxOrderServiceImpl implements SxOrderService {

    @Resource
    private SxOrderMapper orderMapper;

    @Override
    public List<OrdervDto> selectOrderList(String ccus_id, String ddate2, String csocode, String cso_state) {
        return orderMapper.selectOrderList(ccus_id,ddate2,csocode,cso_state);
    }

    @Override
    public List<OrderLog> selectOrderLog(int order_id) {
        return orderMapper.selectOrderLog(order_id);
    }

    @Override
    public List<ResultDto> insertOrder(String items) {
        return orderMapper.insertOrder(items);
    }

    @Override
    public List<OrderstyleDto> selectOrderstyleList(String ccus_id) {
        return orderMapper.selectOrderstyleList(ccus_id);
    }

    @Override
    public ResultOrderDto addOrder(String items) {
        return orderMapper.addOrder(items);
    }

    @Override
    public List<ResultDto> cancelOrder(String jsonvist) {
        return orderMapper.cancelOrder(jsonvist);
    }


    @Override
    public List<Order> selectOrderInfo(String csocode) {
        return orderMapper.selectOrderInfo(csocode);
    }

    @Override
    public String getDistribution(String autoid) {
        return orderMapper.getDistribution(autoid);
    }

    @Override
    public int selectPayCodeType(String csocode) {
        return orderMapper.selectPayCodeType(csocode);
    }

    @Override
    public int addErrlogs(String cuserid, String logs) {
        return orderMapper.addErrlogs(cuserid,logs);
    }

    @Override
    public List<SxOrder> queryOrderList(String cperson_id, String ddate1, String ddate2, String cso_state, String csocode) {
        return orderMapper.queryOrderList(cperson_id,ddate1,ddate2,cso_state,csocode);
    }

    @Override
    public List<SxOrderDto> queryOrderInfo(String csocode) {
        return orderMapper.queryOrderInfo(csocode);
    }


    @Override
    public List<OrdervDto> selectSxOrderList(String cperson_id, String ddate1, String ddate2, String cso_state, String csocode,String ccomcode,String cusercode) {
        return orderMapper.selectSxOrderList(cperson_id,ddate1,ddate2,cso_state,csocode,ccomcode,cusercode);
    }

    @Override
    public int takeEffectOrder(String csocode) {
        return orderMapper.takeEffectOrder(csocode);
    }


}
