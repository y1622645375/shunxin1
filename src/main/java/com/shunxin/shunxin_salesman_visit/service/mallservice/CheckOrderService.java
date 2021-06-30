package com.shunxin.shunxin_salesman_visit.service.mallservice;

import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.Order;

import java.util.List;

public interface CheckOrderService {


    //根据业务员ID查询其所管理客户的订单
    List<Order> selectManagesOrder(String cuser_id);


    //业务员审核客户所下的订单或取消的订单
    List<ResultDto> checkOrderList(String jsonvist);



}
