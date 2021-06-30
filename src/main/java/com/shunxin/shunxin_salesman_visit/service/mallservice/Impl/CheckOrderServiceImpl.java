package com.shunxin.shunxin_salesman_visit.service.mallservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.Order;
import com.shunxin.shunxin_salesman_visit.mapper.mallmapper.CheckOrderMapper;
import com.shunxin.shunxin_salesman_visit.service.mallservice.CheckOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CheckOrderService")
public class CheckOrderServiceImpl implements CheckOrderService {


    @Resource
    private CheckOrderMapper checkOrderMapper;

    @Override
    public List<Order> selectManagesOrder(String cuser_id) {
        return checkOrderMapper.selectManagesOrder(cuser_id);
    }

    @Override
    public List<ResultDto> checkOrderList(String jsonvist) {
        return checkOrderMapper.checkOrderList(jsonvist);
    }


}
