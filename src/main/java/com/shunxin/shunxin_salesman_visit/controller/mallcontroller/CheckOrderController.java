package com.shunxin.shunxin_salesman_visit.controller.mallcontroller;

import com.shunxin.shunxin_salesman_visit.dto.malldto.CheckOrderDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.InventoryPar;
import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.Order;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.mallservice.CheckOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/checkOrder")
public class CheckOrderController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CheckOrderService orderService;
    @Autowired
    private BaseApiService baseApiService;


    /**
     * 根据业务员ID查询其所管理客户的订单（用于顺兴商城）
     * @return
     */
    @RequestMapping("/selectManagesOrder")
    public Object selectManagesOrder(@RequestBody InventoryPar inventoryPar){
        String cuser_id = inventoryPar.getCuser_id();
        try {
            List<Order> orderList = orderService.selectManagesOrder(cuser_id);
            for (Order order : orderList) {
                order.setCinvimg("http://pic.hnsxtj.com/sxemall/public/"+order.getCinvimg()+"_64.jpg");
            }
            return baseApiService.setResultResultSuccess(orderList);
        }catch(Exception e){
            e.printStackTrace();
            logger.info("返回错误："+e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 业务员审核客户所下的订单或取消的订单（用于顺兴商城）
     * @return
     */
    @RequestMapping("/checkOrderList")
    public Object checkOrderList(@RequestBody CheckOrderDto checkOrderDto){
        String jsonvist = checkOrderDto.getJsonvist();
        try {
            List<ResultDto> resultDtos = orderService.checkOrderList(jsonvist);
            return baseApiService.setResultResultSuccess(resultDtos);
        }catch(Exception e){
            e.printStackTrace();
            logger.info("返回错误："+e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }




}
