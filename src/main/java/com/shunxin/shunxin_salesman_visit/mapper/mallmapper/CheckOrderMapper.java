package com.shunxin.shunxin_salesman_visit.mapper.mallmapper;

import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckOrderMapper {


    //根据业务员ID查询其所管理客户的订单
    List<Order> selectManagesOrder(@Param("cuser_id") String cuser_id);


    //业务员审核客户所下的订单或取消的订单
    List<ResultDto> checkOrderList(@Param("jsonvist") String jsonvist);


}
