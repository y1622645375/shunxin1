package com.shunxin.shunxin_salesman_visit.controller.mallcontroller;


import com.shunxin.shunxin_salesman_visit.dto.clientdto.OrdervDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.PersonNameDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.ResultOrderDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.*;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.Order;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.OrderLog;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.SxOrder;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import com.shunxin.shunxin_salesman_visit.service.eatbarservice.EatBarService;
import com.shunxin.shunxin_salesman_visit.service.mallservice.SxOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单的接口为主
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/sxOrder")
public class SxOrderController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BaseApiService baseApiService;
    @Autowired
    private SxOrderService orderService;
    @Autowired
    private EatBarService eatBarService;
    @Autowired
    private CheckService checkService;


    /**
     * 同步先锋Go的订单至顺兴系统
     * @return
     */
    @PostMapping("/GetSynXfgOrder")
    public Object synXfgOrder(@RequestBody XfgOrderDto xfgOrderDto){
        String ctype = xfgOrderDto.getCtype();                //01新增、02修改、03删除
        String csocode = xfgOrderDto.getCsocode();            //订单号
        String csocodes = csocode+"01";                       //子订单号，暂设定为主订单号+01
        String csotype = xfgOrderDto.getCsotype();            //单据类型	01表示普通订单，04表示车销订单，54表示分销配送订单
        String cshiptype = xfgOrderDto.getCshiptype();        //
        Date date = xfgOrderDto.getDdate();                   //下单时间
        String ccus_id = xfgOrderDto.getCcus_id();            //客户ID
        String ccus_code = "";                                //用友编码
        String ccus_name = xfgOrderDto.getCcus_name();        //客户名称
        String ccomcode = xfgOrderDto.getCcomcode();          //所属公司
        String cperson_id = xfgOrderDto.getCperson_id();      //业务员ID
        String cso_state = xfgOrderDto.getCso_state();        //订单状态编码
        String cso_state_sub = "";                            //
        String ccus_remaker = xfgOrderDto.getCcus_remaker();  //订单备注
        String ccom_remaker = "";                             //
        Integer iquan_sum = xfgOrderDto.getIquan_sum();       //数量合计
        Integer ikpquan_su = xfgOrderDto.getIkpquan_sum();    //空瓶数量合计
        BigDecimal imoney_sum = xfgOrderDto.getImoney_sum();  //金额合计
        BigDecimal ikpmoney_sum = xfgOrderDto.getIkpmoney_sum(); //空瓶金额合计
        String cmaker = xfgOrderDto.getCmaker();              //制单人
        Integer bsnerp = xfgOrderDto.getBsnerp();             //
        String cpaytype = xfgOrderDto.getCpaytype();        //付款方式，1现金结算 2二维码结算 3现金+二维码结算,4货到付款,5陈列,0无
        List<OrderstyleDto> orderList = xfgOrderDto.getOrderList();
        try {
            if (ctype.equals("01")){


            }else if (ctype.equals("02")){


            }else if (ctype.equals("03")){

            }
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询我的订单
     * @param ordervDto
     * @return
     */
    @RequestMapping("/selectOrderList")
    public Object selectOrderList(@RequestBody OrdervDto ordervDto) {
        String ccus_id = ordervDto.getCcus_id();
        String ddate2 = ordervDto.getDdate2();
        String csocode = ordervDto.getCsocode();
        String cso_state = ordervDto.getCso_state();
        String cuserid = ordervDto.getCuserid();
        String ckey = ordervDto.getCkey();
        int ilogin_type = ordervDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<OrdervDto> ordervDtoList = orderService.selectOrderList(ccus_id,ddate2,csocode,cso_state);
                for (OrdervDto dto : ordervDtoList) {
                    dto.setCinvimg("http://pic.hnsxtj.com/sxemall/public/"+dto.getCinvimg()+"_64.jpg");
                }
                return baseApiService.setResultResultSuccess(ordervDtoList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询订单日志
     * @param orderLog
     * @return
     */
    @RequestMapping("/selectOrderLog")
    public Object selectOrderLog(@RequestBody OrderLog orderLog) {
        int order_id = orderLog.getOrder_id();
        try {
            List<OrderLog> orderLogList = orderService.selectOrderLog(order_id);
            logger.info("修改购物车--参数");
            return baseApiService.setResultResultSuccess(orderLogList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 将商品存入临时订单表
     * @param
     * @param commonDto
     * @return
     */
    @RequestMapping("/insertOrder")
    public Object insertOrder(@RequestBody CommonDto commonDto) {
        String items = commonDto.getItems();
        try {
            List<ResultDto> resultDtos = orderService.insertOrder(items);
            logger.info("将商品存入临时订单表");
            return baseApiService.setResultResultSuccess(resultDtos);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 核对订单
     * @param response
     * @param ordervDto
     * @return
     */
    @RequestMapping("/selectOrderstyleList")
    public Object selectOrderstyleList(HttpServletResponse response, @RequestBody OrdervDto ordervDto) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String ccus_id = ordervDto.getCcus_id();
        String cuserid = ordervDto.getCuserid();
        String ckey = ordervDto.getCkey();
        int ilogin_type = ordervDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<OrderstyleDto> orderstyleDtos = orderService.selectOrderstyleList(ccus_id);
                for (OrderstyleDto dto : orderstyleDtos) {
                    dto.setCinvimg("http://pic.hnsxtj.com/sxemall/public/"+dto.getCinvimg()+"_64.jpg");
                }
                logger.info("核对订单,业务员工号为："+ccus_id);
                return baseApiService.setResultResultSuccess(orderstyleDtos);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 生成订单(车销)
     * @param commonDto
     * @return
     */
    @RequestMapping("/addOrder")
    public Object addOrder(@RequestBody CommonDto commonDto) {
        String items = commonDto.getItems();
        String userid = commonDto.getUserid();
        String cuserid = commonDto.getCuserid();
        String ckey = commonDto.getCkey();
        int ilogin_type = commonDto.getIlogin_type();
        orderService.addErrlogs(userid,"接收到的参数为:"+items);
        logger.info("接收到的订单参数为："+items+"--订单生成者为："+userid);
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                ResultOrderDto results = orderService.addOrder(items);
                logger.info("生成订单处理后的结果："+results+"--订单生成者为："+userid);
                orderService.addErrlogs(userid,"处理之后的结果:{result："+results.getResult()+"，msg："+results.getMsg()+"，Csocode："+results.getCsocode()+"}");
                return baseApiService.setResultResultSuccess(results);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 新增餐饮订单
     * @return
     */
    @RequestMapping("/addCaterOrder")
    public Object addCaterOrder(@RequestBody CommonDto commonDto){
        String items = commonDto.getItems();
        try {
            ResultOrderDto results = orderService.addOrder(items);
            return baseApiService.setResultResultSuccess(results);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 订单作废
     * @param ordervDto
     * @return
     */
    @RequestMapping("/cancelOrder")
    public Object cancelOrder(@RequestBody OrdervDto ordervDto) {
        String jsonvist = ordervDto.getJsonvist();
        String cuserid = ordervDto.getCuserid();
        String ckey = ordervDto.getCkey();
        int ilogin_type = ordervDto.getIlogin_type();
        String result = "";
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (1 == 1){
                List<ResultDto> resultDtos = orderService.cancelOrder(jsonvist);
                for (ResultDto dto : resultDtos) {
                    result = dto.getMsg();
                }
                return baseApiService.setResultResultSuccess(result);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }



    /**
     * 订单详情
     * @param response
     * @param ordervDto
     * @return
     */
    @RequestMapping("/selectOrderInfo")
    public Object selectOrderInfo(HttpServletResponse response, @RequestBody OrdervDto ordervDto) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String csocode = ordervDto.getCsocode();
        String cuserid = ordervDto.getCuserid();
        String ckey = ordervDto.getCkey();
        int ilogin_type = ordervDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<Order> orderList = orderService.selectOrderInfo(csocode);
                for (Order order1 : orderList) {
                    order1.setCinvimg("http://pic.hnsxtj.com/sxemall/public/"+order1.getCinvimg()+"_64.jpg");
                    String distribution = orderService.getDistribution(order1.getCcus_id());
                    order1.setCcus_distribution(distribution);
                }
                logger.info("订单详情");
                return baseApiService.setResultResultSuccess(orderList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询支付二维码的收款状态
     * @return
     */
    @RequestMapping("/selectPayCodeType")
    public Object selectPayCodeType(@RequestBody Order order){
        String csocode = order.getCsocode();
        try {
            int result = orderService.selectPayCodeType(csocode);
            return baseApiService.setResultResultSuccess(result);
        }catch(Exception e){
            e.printStackTrace();
            logger.info("返回错误结果："+e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询订单列表（非详情）
     * @return
     */
    @RequestMapping("/queryOrderList")
    public Object queryOrderList(@RequestBody OrdervDto order){
        String cperson_id = order.getCperson_id();
        String ddate1 = order.getDdate1();
        String ddate2 = order.getDdate2();
        String csocode = order.getCsocode();
        String cso_state = order.getCso_state();
        String strResult = "";
        try {
            List<SxOrder> ordervDtos = orderService.queryOrderList(cperson_id,ddate1,ddate2,cso_state,csocode);
            for (SxOrder ordervDto : ordervDtos) {
                List<SxOrderDto> sxOrderDtoList = orderService.queryOrderInfo(ordervDto.getCsocode());
                for (SxOrderDto sxOrderDto : sxOrderDtoList) {
                    strResult = strResult + sxOrderDto.getCinvcode()+"_"+sxOrderDto.getCInvName()+"["+sxOrderDto.getCInvStd()+"]"+" 数量："+sxOrderDto.getIquantity()+" 单价："+sxOrderDto.getIprice()+" 金额："+sxOrderDto.getImoney()+"|";
                }
                ordervDto.setStrReslut(strResult);
                strResult = "";
            }
            return baseApiService.setResultResultSuccess(ordervDtos);
        }catch(Exception e){
            e.printStackTrace();
            logger.info("返回错误结果："+e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询订单列表（详情）
     * @return
     */
    @RequestMapping("/selectSxOrderList")
    public Object selectSxOrderList(@RequestBody OrdervDto order){
        String cperson_id = order.getCperson_id();
        String ddate1 = order.getDdate1();
        String ddate2 = order.getDdate2();
        String csocode = order.getCsocode();
        String cso_state = order.getCso_state();
        String ccomcode = order.getCcomcode();
        String cuserid = order.getCuserid();
        String ckey = order.getCkey();
        int ilogin_type = order.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                String cuser_id = "";
                if (cperson_id!=null&&!cperson_id.equals("")){
                    List<PersonNameDto> persons = eatBarService.getPersons(cperson_id);
                    for (PersonNameDto person : persons) {
                        cuser_id = person.getCcode();
                    }
                }
                List<OrdervDto> ordervDtoList = orderService.selectSxOrderList(cuser_id,ddate1,ddate2,cso_state,csocode,ccomcode,cuserid);
                return baseApiService.setResultResultSuccess(ordervDtoList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch(Exception e){
            e.printStackTrace();
            logger.info("返回错误结果："+e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 让失效的订单重新生效
     * @return
     */
    @RequestMapping("/takeEffectOrder")
    public Object takeEffectOrder(@RequestBody OrdervDto order){
        String csocode = order.getCsocode();
        try {
            int count = orderService.takeEffectOrder(csocode);
            String result = count>0?"操作成功":"操作失败";
            return baseApiService.setResultResultSuccess(result);
        }catch(Exception e){
            e.printStackTrace();
            logger.info("返回错误结果："+e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }



}
