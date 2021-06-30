package com.shunxin.shunxin_salesman_visit.service.mallservice;


import com.shunxin.shunxin_salesman_visit.dto.clientdto.OrdervDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.ResultOrderDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.OrderstyleDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.SxOrderDto;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.Order;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.OrderLog;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.SxOrder;

import java.util.List;

public interface SxOrderService {


     //查询订单
    List<OrdervDto> selectOrderList(String ccus_id, String ddate2, String csocode, String cso_state);


    //查询订单日志
    List<OrderLog> selectOrderLog(int order_id);


    //将商品存入临时订单表
    List<ResultDto> insertOrder(String items);


    //核对订单
    List<OrderstyleDto> selectOrderstyleList(String ccus_id);


    //生成订单
    ResultOrderDto addOrder(String items);


    //取消订单
    List<ResultDto> cancelOrder(String jsonvist);


    //查询订单详情
    List<Order> selectOrderInfo(String csocode);


    //根据客户编号查询所属分销商编号
    String getDistribution(String autoid);


    //查询支付二维码的收款状态
    int selectPayCodeType(String csocode);


    //新增日志
    int addErrlogs(String cuserid,String logs);


    //查询订单列表（非详情）
    List<SxOrder> queryOrderList(String cperson_id, String ddate1, String ddate2, String cso_state, String csocode);


    //根据订单号查询订单详情
    List<SxOrderDto> queryOrderInfo(String csocode);


    //查询订单列表（详情）
    List<OrdervDto> selectSxOrderList(String cperson_id, String ddate1, String ddate2, String cso_state, String csocode,String ccomcode,String cusercode);


    //让失效的订单重新生效
    int takeEffectOrder(String csocode);
}
