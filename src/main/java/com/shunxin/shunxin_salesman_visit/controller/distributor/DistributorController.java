package com.shunxin.shunxin_salesman_visit.controller.distributor;


import com.shunxin.shunxin_salesman_visit.dto.clientdto.OrdervDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.distributordto.*;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.CustomGoodDto;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import com.shunxin.shunxin_salesman_visit.service.distributor.Distr_OrderService;
import com.shunxin.shunxin_salesman_visit.util.DateUtils;
import com.shunxin.shunxin_salesman_visit.util.UserInfoUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 经销商订单操作
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/distributor")
public class DistributorController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Distr_OrderService orderService;
    @Autowired
    private BaseApiService baseApiService;
    @Autowired
    private CheckService checkService;
    @Autowired
    private UserInfoUtil userInfoUtil;


    /**
     * 查询公司分配给他的订单(经销商部分)
     * @return
     */
    @RequestMapping("/getDistrOrderList2")
    public Object getDistrOrderList2(@RequestBody Distr_orderDto orderDto) throws IOException {
        String ddate = orderDto.getDdate();     //时间条件
        String content = orderDto.getContent(); //订单号
        String cso_state_sub = orderDto.getCso_state_sub(); //订单状态
        String cdefine3 = orderDto.getCdefine3();   //以前是随机码，现已用配送员手机号代替
        String ccus_distribution = orderDto.getCcus_id();   //分销商ID
        String ccuss_id = orderDto.getCcuss_id();  //客户ID
        String ddate1 = "";
        String ddate2 = "";
        try {
            if (ccus_distribution!=null||cdefine3!=null||ccuss_id!=null){
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                ddate2 = sdf.format(date);  //ddate2 永远是最新的时间
                if (ddate!=null){
                    if (ddate.equals("近一月")){
                        //本月开始时间
                        ddate1 =  DateUtils.getMonthStart();
                    }else if (ddate.equals("近三月")){
                        //近三月开始时间
                        ddate1 =  DateUtils.getMonthStart3();
                    }
                    else if (ddate.equals("近一年")){
                        //本年开始时间
                        ddate1 = DateUtils.getYearStart();
                    }else if (ddate.equals("近三年")){
                        //近三年开始时间
                        ddate1 = DateUtils.getYearStart3();
                    }
                }
                logger.info("查询订单列表(分销商部分) 低版本");
                List<OrdervDto> orderList = orderService.getDistrOrderList(ddate1,ddate2,content,cso_state_sub,cdefine3,ccuss_id,ccus_distribution);
                List<OrdervDto> orderList1 = new ArrayList<>();
                String ImgUrl = "https://www.hnsxtj.com/public/";
                int i = 1;
                for (OrdervDto sxOrder : orderList) {
                    if (i==1){  //表示第一次进来
                        orderList1.add(sxOrder);
                        List<commodityDto> commodityDtoList = new ArrayList<>();
                        commodityDto cdto = new commodityDto();
                        commodityDtoList.add(cdto);
                        for (commodityDto commodityDto : commodityDtoList) {   //将商品信息赋值给新的集合
                            commodityDto.setCinvcode(sxOrder.getCsocode());
                            commodityDto.setCinvname(sxOrder.getCInvName());
                            commodityDto.setCinvimg(sxOrder.getCinvimg());
                            commodityDto.setCinvimg64(ImgUrl+sxOrder.getCinvimg()+"_64.jpg");
                            commodityDto.setCinvimg500(ImgUrl+sxOrder.getCinvimg()+"_500.jpg");
                            commodityDto.setCinvstd(sxOrder.getCInvStd());
                            commodityDto.setImoney(sxOrder.getImoney());
                            commodityDto.setIquantity(sxOrder.getIquantity());
                        }
                        for (OrdervDto ordervDto : orderList1) {
                            ordervDto.setCommodityDtos(commodityDtoList);
                        }
                    }else {
                        for (OrdervDto order : orderList1) {
                            if(orderList1.size() - 1 == orderList1.indexOf(order)){   //如果等式成立就说明遍历到的order就是list的最后一个元素
                                if (sxOrder.getCsocode().equals(order.getCsocode())){   //判断下一行的订单号是否与上一次的相同
                                    List<commodityDto> commodityDtoList = new ArrayList<>();
                                    List<OrdervDto> ordervDtos = orderService.getDistrOrderOne(sxOrder.getCsocode());
                                    for (OrdervDto ordervDto : ordervDtos) {
                                        commodityDto commodityDto = new commodityDto();
                                        commodityDto.setCinvcode(ordervDto.getCsocode());
                                        commodityDto.setCinvname(ordervDto.getCInvName());
                                        commodityDto.setCinvimg(ordervDto.getCinvimg());
                                        commodityDto.setCinvimg64(ImgUrl+sxOrder.getCinvimg()+"_64.jpg");
                                        commodityDto.setCinvimg500(ImgUrl+sxOrder.getCinvimg()+"_500.jpg");
                                        commodityDto.setCinvstd(ordervDto.getCInvStd());
                                        commodityDto.setImoney(ordervDto.getImoney());
                                        commodityDto.setIquantity(ordervDto.getIquantity());
                                        commodityDtoList.add(commodityDto);
                                    }
                                    order.setCommodityDtos(commodityDtoList);
                                }else {
                                    orderList1.add(sxOrder);  //如果订单号不同则加入集合中
                                    List<commodityDto> commodityDtoList2 = new ArrayList<>();
                                    commodityDto cdto2 = new commodityDto();
                                    commodityDtoList2.add(cdto2);
                                    for (commodityDto commodityDto : commodityDtoList2) {
                                        commodityDto.setCinvcode(sxOrder.getCsocode());
                                        commodityDto.setCinvname(sxOrder.getCInvName());
                                        commodityDto.setCinvimg(sxOrder.getCinvimg());
                                        commodityDto.setCinvimg64(ImgUrl+sxOrder.getCinvimg()+"_64.jpg");
                                        commodityDto.setCinvimg500(ImgUrl+sxOrder.getCinvimg()+"_500.jpg");
                                        commodityDto.setCinvstd(sxOrder.getCInvStd());
                                        commodityDto.setImoney(sxOrder.getImoney());
                                        commodityDto.setIquantity(sxOrder.getIquantity());
                                    }
                                    for (OrdervDto ordervDto : orderList1) {
                                        if(orderList1.size() - 1 == orderList1.indexOf(ordervDto)){
                                            ordervDto.setCommodityDtos(commodityDtoList2);
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }
                    i++;
                }
                return baseApiService.setResultResultSuccess(orderList1);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 经销商点击接单、拒单、订单配送完成
     * @return
     */
    @RequestMapping("/receivingOrder")
    public Object receivingOrder(@RequestBody Distr_orderDto orderDto){
        String jsonvit = orderDto.getJsonvit();
        String ckey = orderDto.getCkey();
        String cuserid = orderDto.getCuserid();
        String ctype = orderDto.getCtype();   //01 数组，02 json
        int ilogin_type = 6;
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (1==1){
                List<ResultDto> resultDtoList = new ArrayList<>();
                if (ctype.equals("01")){  //多个订单的操作
                    String substring = jsonvit.substring(1,jsonvit.length()-1);
                    String [] stl= substring.split("},");
                    for (int i = 0; i < stl.length; i++) {
                        if (i!=stl.length-1){
                            stl[i] = stl[i]+"}";
                        }
                        resultDtoList = orderService.receivingOrder(stl[i]);
                    }
                }else if (ctype.equals("02")){ //单个订单的操作
                    resultDtoList = orderService.receivingOrder(jsonvit);
                }
                ResultDto resultDtos = new ResultDto();
                for (ResultDto resultDto : resultDtoList) {
                    resultDtos.setMsg(resultDto.getMsg());
                    resultDtos.setResult(resultDto.getResult());
                }
                return baseApiService.setResultResultSuccess(resultDtos);
            }else{
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 经销商查询合计
     * @param orderDto
     * @return
     */
    @RequestMapping("/getDistributionTotal")
    public Object getDistributionTotal(@RequestBody Distr_orderDto orderDto){
        String jsonvit = orderDto.getJsonvit();
        try {
            List<OrderListDto> orderListDtoList = orderService.getOrderCinvname();
            int s = 0;
            String [] strings = new String[5];
            for (OrderListDto listDto : orderListDtoList) {
                strings[s] = listDto.getCinvcode();
                s ++;
            }
            JSONObject object = JSONObject.fromObject(jsonvit);
            for (int i = 0; i < strings.length; i++) {
                object.put("cinvcode"+(i+1),strings[i]);
            }
            List<DistributionDto> distributionDtos = orderService.getDistributionTotal(object.toString());
            List<Distribution2Dto> distribution2Dtos = new ArrayList<>();
            for (DistributionDto dto : distributionDtos) {
                List<String> strings1 = new ArrayList<>();
                Distribution2Dto distribution2Dto = new Distribution2Dto();
                strings1.add(Float.toString(dto.getCinvcode1()));
                strings1.add(Float.toString(dto.getCinvcode2()));
                strings1.add(Float.toString(dto.getCinvcode3()));
                strings1.add(Float.toString(dto.getCinvcode4()));
                strings1.add(Float.toString(dto.getCinvcode5()));
                distribution2Dto.setCinvcode(strings1);
                distribution2Dto.setCtype(dto.getCtype());
                distribution2Dto.setImoney_sum(dto.getImoney_sum());
                distribution2Dtos.add(distribution2Dto);
            }
            if (distribution2Dtos.size()==1){  //说明只有53或者55中的一个
                Distribution2Dto distribution2Dto = new Distribution2Dto();
                for (Distribution2Dto dto : distribution2Dtos) {
                    String ctype = dto.getCtype();
                    if (ctype.equals("53")){  //说明有的那个是53，则补齐55
                        System.out.println("53");
                        List<String> strings1 = new ArrayList<>();
                        strings1.add(Float.toString(0));
                        strings1.add(Float.toString(0));
                        strings1.add(Float.toString(0));
                        strings1.add(Float.toString(0));
                        strings1.add(Float.toString(0));
                        distribution2Dto.setCinvcode(strings1);
                        distribution2Dto.setCtype("55");
                        distribution2Dto.setImoney_sum(0);
                    }else{   //说明有的那个是55，则补齐53
                        List<String> strings1 = new ArrayList<>();
                        strings1.add(Float.toString(0));
                        strings1.add(Float.toString(0));
                        strings1.add(Float.toString(0));
                        strings1.add(Float.toString(0));
                        strings1.add(Float.toString(0));
                        distribution2Dto.setCinvcode(strings1);
                        distribution2Dto.setCtype("53");
                        distribution2Dto.setImoney_sum(0);
                    }
                }
                distribution2Dtos.add(distribution2Dto);
            }
            List<Object> objectList = new ArrayList<>();
            JSONObject jsonObject = JSONObject.fromObject(jsonvit);
            String ccus_distribution = jsonObject.get("ccus_distribution").toString();
            String cname = "";
            int j = 1;
            for (OrderListDto orderListDto : orderListDtoList) {
                if (j==1){
                    cname = cname + orderListDto.getCinvcode();
                }else {
                    cname = cname + ","+orderListDto.getCinvcode();
                }
                j++;
            }
            List<OrdervDto> ordervDtos = orderService.getCommIquanSum(ccus_distribution,cname);
            float imoney_sum = 0;
            Distribution2Dto dto1 = new Distribution2Dto();
            List<String> strList = new ArrayList<>();
            for (OrdervDto dto : ordervDtos) {
                imoney_sum = imoney_sum + Float.valueOf(dto.getIquan_sum()).floatValue();
                dto1.setCtype("已配送");
                strList.add(dto.getIquan_sum());
                dto1.setCinvcode(strList);
                dto1.setImoney_sum(imoney_sum);
            }
            List<String> stringList = new ArrayList<>();
            for (OrderListDto listDto : orderListDtoList) {
                stringList.add(listDto.getCinvname());
            }
            distribution2Dtos.add(dto1);
            objectList.add(distribution2Dtos);
            objectList.add(stringList);
            return baseApiService.setResultResultSuccess(objectList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 主管人员查询合计
     */
    @RequestMapping("/getManageTotal")
    public Object getManageTotal(@RequestBody CustomGoodDto customGoodDto){
        String ckey = customGoodDto.getCkey();
        String cuserid = customGoodDto.getCuserid();
        int ilogin_type = customGoodDto.getIlogin_type();
        try {
            String results = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (1==1){
                List<OrderListDto> orderListDtoList = orderService.getOrderCinvname();
                int i = 0;
                String [] strings = new String[5];
                for (OrderListDto listDto : orderListDtoList) {
                    strings[i] = listDto.getCinvcode();
                    i ++;
                }
                List<ManageTotalDto> manageTotalDtoList = orderService.getManageTotal(strings[0],strings[1],strings[2],strings[3],strings[4],cuserid);
                List<ManageTotal2Dto> manageTotal2Dtos = new ArrayList<>();
                float yps_sum = 0;
                float wsk_sum = 0;
                float ysk_sum = 0;
                int ty1_sum = 0;
                int ty2_sum = 0;
                int ty3_sum = 0;
                int ty4_sum = 0;
                int ty5_sum = 0;
                List<String> string2 = new ArrayList<>();
                ManageTotal2Dto manageTotal2Dto1 = new ManageTotal2Dto();
                for (ManageTotalDto totalDto : manageTotalDtoList) {
                    List<String> strings1 = new ArrayList<>();
                    ManageTotal2Dto manageTotal2Dto = new ManageTotal2Dto();
                    strings1.add(Integer.toString(totalDto.getCtype1()));
                    strings1.add(Integer.toString(totalDto.getCtype2()));
                    strings1.add(Integer.toString(totalDto.getCtype3()));
                    strings1.add(Integer.toString(totalDto.getCtype4()));
                    strings1.add(Integer.toString(totalDto.getCtype5()));
                    totalDto.setCtype(strings1);
                    //写入新的集合，为了去掉ctype1至5
                    manageTotal2Dto.setCtype(totalDto.getCtype());
                    manageTotal2Dto.setYps(totalDto.getYps());
                    manageTotal2Dto.setYsk(totalDto.getYsk());
                    manageTotal2Dto.setWsk(totalDto.getWsk());
                    manageTotal2Dto.setCcus_name(totalDto.getCcus_name());
                    manageTotal2Dtos.add(manageTotal2Dto);
                    //计算合计
                    ysk_sum = ysk_sum + totalDto.getYsk();
                    yps_sum = yps_sum + totalDto.getYps();
                    wsk_sum = wsk_sum + totalDto.getWsk();
                    ty1_sum = ty1_sum + totalDto.getCtype1();
                    ty2_sum = ty2_sum + totalDto.getCtype2();
                    ty3_sum = ty3_sum + totalDto.getCtype3();
                    ty4_sum = ty4_sum + totalDto.getCtype4();
                    ty5_sum = ty5_sum + totalDto.getCtype5();
                }
                //合计复制Begin
                string2.add(Integer.toString(ty1_sum));
                string2.add(Integer.toString(ty2_sum));
                string2.add(Integer.toString(ty3_sum));
                string2.add(Integer.toString(ty4_sum));
                string2.add(Integer.toString(ty5_sum));
                manageTotal2Dto1.setCcus_name("合计");
                manageTotal2Dto1.setYps(yps_sum);
                manageTotal2Dto1.setYsk(ysk_sum);
                manageTotal2Dto1.setWsk(wsk_sum);
                manageTotal2Dto1.setCtype(string2);
                manageTotal2Dtos.add(manageTotal2Dto1);
                //end
                List<Object> objectList = new ArrayList<>();
                objectList.add(manageTotal2Dtos);
                //赋值当前的商品名称
                List<String> stringList = new ArrayList<>();
                for (OrderListDto dto : orderListDtoList) {
                    stringList.add(dto.getCinvname());
                }
                objectList.add(stringList);
                return baseApiService.setResultResultSuccess(objectList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    /**
     * 根据定位查询200米以内的订单
     * @param orderDto
     * @return
     */
    @RequestMapping("/getNearbyOrder")
    public Object getNearbyOrder(@RequestBody Distr_orderDto orderDto){
        String cdefine3 = orderDto.getCdefine3();  //以前是随机码，现已用配送员手机号代替
        String courier_xpoint = orderDto.getCourier_xpoint();
        String courier_ypoint = orderDto.getCourier_ypoint();
        try {
            List<OrdervDto> orderList = new ArrayList<>();
            List<OrdervDto> ordervDtoList = orderService.getNearbyOrder(cdefine3);
            for (OrdervDto dto : ordervDtoList) {
                //根据两个经纬度计算出距离
                Double distance = orderService.getCalculateDistance(dto.getCCUS_XPOINT().toString(),dto.getCCUS_YPOINT().toString(),courier_xpoint,courier_ypoint);
                if (distance<=200){
                    orderList.add(dto);
                }
            }
            List<OrdervDto> orderList1 = new ArrayList<>();
            int i = 1;
            String ImgUrl = "https://www.hnsxtj.com/public/";
            for (OrdervDto sxOrder : orderList) {
                if (i==1){  //表示第一次进来
                    orderList1.add(sxOrder);
                    List<commodityDto> commodityDtoList = new ArrayList<>();
                    commodityDto cdto = new commodityDto();
                    commodityDtoList.add(cdto);
                    for (commodityDto commodityDto : commodityDtoList) {   //将商品信息赋值给新的集合
                        commodityDto.setCinvcode(sxOrder.getCsocode());
                        commodityDto.setCinvname(sxOrder.getCInvName());
                        commodityDto.setCinvimg(sxOrder.getCinvimg());
                        commodityDto.setCinvimg64(ImgUrl+sxOrder.getCinvimg()+"_64.jpg");
                        commodityDto.setCinvimg500(ImgUrl+sxOrder.getCinvimg()+"_500.jpg");
                        commodityDto.setCinvstd(sxOrder.getCInvStd());
                        commodityDto.setImoney(sxOrder.getImoney());
                        commodityDto.setIquantity(sxOrder.getIquantity());
                    }
                    for (OrdervDto ordervDto : orderList1) {
                        ordervDto.setCommodityDtos(commodityDtoList);
                    }
                }else {
                    for (OrdervDto order : orderList1) {
                        if(orderList1.size() - 1 == orderList1.indexOf(order)){   //如果等式成立就说明遍历到的order就是list的最后一个元素
                            if (sxOrder.getCsocode().equals(order.getCsocode())){   //判断下一行的订单号是否与上一次的相同
                                List<commodityDto> commodityDtoList = new ArrayList<>();
                                List<OrdervDto> ordervDtos = orderService.getDistrOrderOne(sxOrder.getCsocode());
                                for (OrdervDto ordervDto : ordervDtos) {
                                    commodityDto commodityDto = new commodityDto();
                                    commodityDto.setCinvcode(ordervDto.getCsocode());
                                    commodityDto.setCinvname(ordervDto.getCInvName());
                                    commodityDto.setCinvimg(ordervDto.getCinvimg());
                                    commodityDto.setCinvimg64(ImgUrl+sxOrder.getCinvimg()+"_64.jpg");
                                    commodityDto.setCinvimg500(ImgUrl+sxOrder.getCinvimg()+"_500.jpg");
                                    commodityDto.setCinvstd(ordervDto.getCInvStd());
                                    commodityDto.setImoney(ordervDto.getImoney());
                                    commodityDto.setIquantity(ordervDto.getIquantity());
                                    commodityDtoList.add(commodityDto);
                                }
                                order.setCommodityDtos(commodityDtoList);
                            }else {
                                orderList1.add(sxOrder);  //如果订单号不同则加入集合中
                                List<commodityDto> commodityDtoList2 = new ArrayList<>();
                                commodityDto cdto2 = new commodityDto();
                                commodityDtoList2.add(cdto2);
                                for (commodityDto commodityDto : commodityDtoList2) {
                                    commodityDto.setCinvcode(sxOrder.getCsocode());
                                    commodityDto.setCinvname(sxOrder.getCInvName());
                                    commodityDto.setCinvimg(sxOrder.getCinvimg());
                                    commodityDto.setCinvimg64(ImgUrl+sxOrder.getCinvimg()+"_64.jpg");
                                    commodityDto.setCinvimg500(ImgUrl+sxOrder.getCinvimg()+"_500.jpg");
                                    commodityDto.setCinvstd(sxOrder.getCInvStd());
                                    commodityDto.setImoney(sxOrder.getImoney());
                                    commodityDto.setIquantity(sxOrder.getIquantity());
                                }
                                for (OrdervDto ordervDto : orderList1) {
                                    if(orderList1.size() - 1 == orderList1.indexOf(ordervDto)){
                                        ordervDto.setCommodityDtos(commodityDtoList2);
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
                i++;
            }
            return baseApiService.setResultResultSuccess(orderList1);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询经销商近7天支付次数大于等于5次的订单
     * @return
     */
    @RequestMapping("/getDistrPayCount")
    public Object getDistrPayCount(){
        try {
            List<PayCountDto> payCountDtos = orderService.getDistrPayCount();
            return baseApiService.setResultResultSuccess(payCountDtos);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 通过code获取配送商小程序的个人信息
     * @return
     */
    @RequestMapping("/getWxDealersXcx")
    public Object getWxDealersXcx(@RequestBody Distr_orderDto orderDto){
        String code = orderDto.getCode();
        try {
            String json = userInfoUtil.getWxXcxDealers(code);
            //String json = "{\"session_key\":\"crFMWzkFBP3wIXz1qV/PNw==\",\"openid\":\"oqQ6c5F1CqyCxJz8maX5ma_rcSIk\"}";
            JSONObject jsonObject = JSONObject.fromObject(json);
            /*if (jsonObject.get("errcode")==null){
                String openid = jsonObject.get("openid").toString();
                String session_key = jsonObject.get("session_key").toString();
                orderService.getSessionKey(session_key,openid); //每次换取小程序信息时绑定session_key
            }*/
            return baseApiService.setResultResultSuccess(json);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ctype = 01 : 先传入openid和手机号查询是否已经绑定过
     * ctype = 02 : 未绑定过的进行openid和手机号的绑定
     * @return
     */
    @RequestMapping("/getWxSmallBand")
    public Object getWxSmallBand(@RequestBody SxCustomerUser customerUser){
        String ctype = customerUser.getCtype();
        //String ccus_user_tel = customerUser.getCcus_user_tel(); //绑定的手机号
        String ivdata = customerUser.getIvdata();//向量
        String encrypdata = customerUser.getEncrypdata();
        String ccus_user_openid_xcx = customerUser.getCcus_user_openid_xcx(); //绑定的小程序openid
        String ccus_user_openid_unitid = customerUser.getCcus_user_openid_unitid(); //整个开发平台的unitid
        String session_key = customerUser.getSession_key();  //	会话密钥
        String result = "";
        int count = 0;
        try {
            if (ctype.equals("01")){
                count = orderService.getWxSmallBand(ccus_user_openid_xcx);
                result = count>0?"已绑定":"未绑定";
                if (result.equals("已绑定")){
                    //效验会话秘钥是否正确
                    /*List<SxCustomerUser> sxCustomerUser = orderService.getDistriList(ccus_user_openid_xcx,session_key);
                    if (sxCustomerUser.size()!=0){*/
                        //已绑定则返回绑定人的所有信息
                        List<SxCustomerUser> sxCustomerUsers = orderService.getDistriList(ccus_user_openid_xcx,"");
                        return baseApiService.setResultResultSuccess(sxCustomerUsers);
                    /*}else {
                        return baseApiService.setResultError("会话错误");
                    }*/
                }else {
                    //未绑定则返回空
                    return baseApiService.setResultResultSuccess("");
                }
            }else if (ctype.equals("02")){  //进行绑定
                //解析微信小程序获取的手机号
                String json = userInfoUtil.getPhoneNumber(encrypdata,session_key,ivdata).toString();
                JSONObject jsonObject = JSONObject.fromObject(json);
                String ccus_user_tel = jsonObject.get("phoneNumber").toString(); //用户绑定的手机号（国外手机号会有区号）
                //查询该手机号数据库是否已存在，不存在则无法进行绑定
                count = orderService.getWxSmallBand(ccus_user_tel);
                if (count>0){
                    count = orderService.addWxSmallBand(ccus_user_openid_xcx,ccus_user_openid_unitid,ccus_user_tel);
                    result = count>0?"绑定成功":"绑定失败";
                    if (result.equals("绑定成功")){
                        //效验会话秘钥是否正确
                        /*List<SxCustomerUser> sxCustomerUser = orderService.getDistriList(ccus_user_openid_xcx,session_key);
                        if (sxCustomerUser.size()!=0){*/
                            List<SxCustomerUser> sxCustomerUsers = orderService.getDistriList(ccus_user_openid_xcx,"");
                            return baseApiService.setResultResultSuccess(sxCustomerUsers);
                        /*}else {
                            return baseApiService.setResultError("会话错误");
                        }*/
                    }else {
                        return baseApiService.setResultResultSuccess("绑定失败");
                    }
                }else {
                    result = "信息不存在，无法绑定";
                }
            }else {
                return baseApiService.setResultError("服务器繁忙,,,");
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ctype: 01 查询配送员信息
     * ctype: 02 新增配送员信息
     * @return
     */
    @RequestMapping("/getDistribution")
    public Object getDistribution(@RequestBody SxCustomerUser customerUser){
        String ctype = customerUser.getCtype();
        String ccus_id = customerUser.getCcus_id(); //经销商id
        String cuser_type = customerUser.getCuser_type(); //1 为经销商自己，2 为配送员 ，空为全部
        String ccus_user_name = customerUser.getCcus_user_name();   //姓名
        String ccus_user_tel = customerUser.getCcus_user_tel();     //手机号
        String ccus_user_openid_unitid = "";
        String ccus_user_openid_xcx = "";
        try {
            if (ctype.equals("01")){
               List<SxCustomerUser> sxCustomerUsers = orderService.getDistribution(ccus_id,cuser_type);
               return baseApiService.setResultResultSuccess(sxCustomerUsers);
            }else if (ctype.equals("02")){
                int count = orderService.addDistribution(ccus_id,cuser_type,ccus_user_name,ccus_user_tel,ccus_user_openid_unitid,ccus_user_openid_xcx);
                String result = count>0?"新增成功":"新增失败";
                return baseApiService.setResultResultSuccess(result);
            }else {
                return baseApiService.setResultError("服务器繁忙,,,");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }




}
