package com.shunxin.shunxin_salesman_visit.controller.clientcontroller;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.*;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.SxCustomer;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.SxOrderInfo;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.SxPersonarea;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.SxcustomerWxbind;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.Order;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxCustomerService;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxPersonareaService;
import com.shunxin.shunxin_salesman_visit.service.mallservice.SxOrderService;
import com.shunxin.shunxin_salesman_visit.util.*;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/sxPersonarea")
public class SxPersonareaController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SxPersonareaService sxPersonareaService;
    @Autowired
    private SxCustomerService sxCustomerService;
    @Autowired
    private UserInfoUtil userInfoUtil;
    @Autowired
    private BaseApiService baseApiService;
    @Autowired
    private SxOrderService orderService;


    /**
     * 获取企业微信打卡token
     * @return
     */
    @RequestMapping("/getQywxTokenDaka")
    public Object getQywxTokenDaka(){
        try {
            String tokenDaka = userInfoUtil.getQywxTokenDaka();
            return baseApiService.setResultResultSuccess(tokenDaka);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据业务员工号查询所属公司
     * @param sxPersonarea
     * @return
     */
    @RequestMapping("/selectCompand")
    public Object selectCompand(@RequestBody SxPersonarea sxPersonarea){
        String cuser_id =sxPersonarea.getCuser_id();
        try {
            String compand = sxPersonareaService.selectCompand(cuser_id);
            return baseApiService.setResultResultSuccess(compand);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询A 或B 表中某公司的所有业务员
     * @param response
     * @param sxPersonarea
     * @return
     */
    @RequestMapping("/selectCuserTemp")
    public Object selectCuserTemp(HttpServletResponse response, @RequestBody SxPersonarea sxPersonarea){
        String cuser_id =sxPersonarea.getCuser_id();
        String ctype = sxPersonarea.getCtype();
        try {
            if (ctype.equals("A")){
                List<ParameterDto> CuserTempList = sxPersonareaService.selectCuserTemp(cuser_id);
                for (ParameterDto dto : CuserTempList) {
                    String result = gonyon(dto.getCcode(),"A");
                    dto.setParam2(result);
                }
                logger.info("查询A 表中某公司已录点业务员,"+cuser_id);
                return baseApiService.setResultResultSuccess(CuserTempList);
            }else{
                List<ParameterDto> CuserTempList2 = sxPersonareaService.selectCuser(cuser_id);
                for (ParameterDto dto : CuserTempList2) {
                    String result = gonyon(dto.getCcode(),"B");
                    dto.setParam2(result);
                }
                logger.info("查询B 表中某公司已录点业务员,"+cuser_id);
                return baseApiService.setResultResultSuccess(CuserTempList2);
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }

    public String gonyon(String cuser_id,String ctype){
        List<SxPersonarea> sxPersonareaList = null;
        if (ctype.equals("A")){
             sxPersonareaList = sxPersonareaService.selectDistance(cuser_id);
        }else if (ctype.equals("B")){
            sxPersonareaList = sxPersonareaService.selectDistance2(cuser_id);
        }
        double x1 = 0.0; double y1 = 0.0; double x2 = 0.0;double y2 = 0.0;
        int cout = 0;
        for (SxPersonarea personarea : sxPersonareaList) {
            if (cout==0){
                x1 = personarea.getXpoint().doubleValue();
                y1 = personarea.getYpoint().doubleValue();
            }else {
                x2 = personarea.getXpoint().doubleValue();
                y2 = personarea.getYpoint().doubleValue();
            }
            cout++;
        }
        //BigDecimal 转换成 double数据类型
        double d = DistanceUtils.getDistance(y1, x1, y2, x2);
        String result = d*1000<200.00?"合格":"不合格，首尾点距离："+new DecimalFormat("#.00").format(d*1000)+"米";
        return result;
    }


    /**
     * 新增A表的点
     * @param response
     * @param sxPersonarea
     * @return
     */
    @RequestMapping("/insertPersonareaTemp")
    public Object insertPersonareaTemp(HttpServletResponse response, @RequestBody SxPersonarea sxPersonarea){
       String cuser_id = sxPersonarea.getCuser_id();
       BigDecimal xpoint = sxPersonarea.getXpoint();
       BigDecimal ypoint = sxPersonarea.getYpoint();
       String param1 = sxPersonarea.getParam1();
       try {
           String results = "";
           if (!cuser_id.equals("")){
               String ccompand_id = sxPersonareaService.selectCompand(cuser_id);
               int exists = sxPersonareaService.selectExistTemp(cuser_id,param1);
               if(exists>0){
                   results = "重复";
               }else {
                   int count = sxPersonareaService.insertPersonareaTemp(ccompand_id,cuser_id,xpoint,ypoint,param1);
                   logger.info("新增A 表的点"+ccompand_id+","+cuser_id+","+xpoint+","+ypoint);
                   results = count>0?"新增成功":"新增失败";
               }
         }
            return baseApiService.setResultResultSuccess(results);
       }catch (Exception e){
           e.printStackTrace();
           return baseApiService.setResultError(e.toString());
       }
    }


    /**
     * 删查A 表中某业务员的数据
     * @param response
     * @param sxPersonarea
     * @return
     */
    @RequestMapping("/delectPersonareaTemp")
    public Object delectPersonareaTemp(HttpServletResponse response, @RequestBody SxPersonarea sxPersonarea){
        String cuser_id = sxPersonarea.getCuser_id();
        String ctype = sxPersonarea.getCtype();
        try {
            String results = "";
            if (ctype.equals("A")){
                List<SxPersonarea> sxPersonareaList = sxPersonareaService.selectCusersTemp(cuser_id);
                if (sxPersonareaList.size()!=0){
                    int count = sxPersonareaService.delectPersonareaTemp(cuser_id);
                    logger.info("删查A 表中某业务员的数据,"+cuser_id);
                    results = count>0?"删除成功":"删除失败";
                }else {
                    results = "该业务员还未录点，无法删除";
                }
            }else if (ctype.equals("B")){
                List<SxPersonarea> sxPersonareaList = sxPersonareaService.selectCusers(cuser_id);
                if (sxPersonareaList.size()!=0){
                    int count = sxPersonareaService.delectPersonarea(cuser_id);
                    logger.info("删查B 表中某业务员的数据,"+cuser_id);
                    results = count>0?"删除成功":"删除失败";
                }else {
                    results = "该业务员还未录点，无法删除";
                }
            }
            return baseApiService.setResultResultSuccess(results);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 复制A表数据到B表
     * @param response
     * @param sxPersonarea
     * @return
     */
    @RequestMapping("/duplication")
    public Object duplication(HttpServletResponse response, @RequestBody SxPersonarea sxPersonarea){
        String cuser_id = sxPersonarea.getCuser_id();
        try{
            String results ="";
            int exists = sxPersonareaService.selectExist(cuser_id);
            if(exists>0){
                results = "重复";
            }else {
                int count = sxPersonareaService.duplication(cuser_id);
                logger.info("复制A表数据到B表==cuser_id："+cuser_id);
                results = count>0?"复制成功":"复制失败";
            }
            return baseApiService.setResultResultSuccess(results);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询A或B表中某业务员的所有点
     * @param response
     * @param sxPersonarea
     * @return
     */
    @RequestMapping("/selectCusers")
    public Object selectCusers(HttpServletResponse response, @RequestBody SxPersonarea sxPersonarea) {
        String cuser_id = sxPersonarea.getCuser_id();
        String ctype = sxPersonarea.getCtype();
        try {
            if (ctype.equals("A")) {
                List<SxPersonarea> sxPersonareaList = sxPersonareaService.selectCusersTemp(cuser_id);
                logger.info("查询A表中某业务员的所有点==cuser_id：" + cuser_id);
                return baseApiService.setResultResultSuccess(sxPersonareaList);
            } else {
                List<SxPersonarea> sxPersonareaList = sxPersonareaService.selectCusers(cuser_id);
                logger.info("查询B表中某业务员的所有点==cuser_id：" + cuser_id);
                return baseApiService.setResultResultSuccess(sxPersonareaList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询首尾点之间的距离
     * @param response
     * @param sxPersonarea
     * @return
     */
    @RequestMapping("/selectDistance")
    public Object selectDistance(HttpServletResponse response, @RequestBody SxPersonarea sxPersonarea){
        String cuser_id = sxPersonarea.getCuser_id();
        String param2 = sxPersonarea.getParam2();
        try {
            String result = gonyon(cuser_id,"A");
            sxPersonareaService.updateParam2(cuser_id,param2);
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询B表中所有业务员的点
     * @param response
     * @return
     */
    @RequestMapping("/selectAllCusers")
    public Object selectAllCusers(HttpServletResponse response,@RequestBody ParameterDto parameterDto) {
        String userid = parameterDto.getUserid();
        String ckey = parameterDto.getCkey();
        try {
            int count = sxPersonareaService.detectionKey(ckey,userid);
            if(count!=0){
                List<SxPersonarea> sxPersonareaList = sxPersonareaService.selectAllCusers();
                logger.info("查询B表中所有务员的点");
                return baseApiService.setResultResultSuccess(sxPersonareaList);
            }else {
                logger.info("key不合法");
                return baseApiService.setResultError("key不合法");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询业务员区域的中心点
     * @param response
     * @return
     */
    @RequestMapping("/selectCenterPoint")
    public Object selectCenterPoint(HttpServletResponse response,@RequestBody ParameterDto parameterDto) {
        String cuser_id = parameterDto.getCuser_id();
        String userid = parameterDto.getUserid();
        String ckey = parameterDto.getCkey();
        try {
            int count = sxPersonareaService.detectionKey(ckey,userid);
            if (count!=0){
                List<SxPersonarea> sxPersonareaList = sxPersonareaService.selectCenterPoint(cuser_id);
                logger.info("查询业务员区域的中心点");
                return baseApiService.setResultResultSuccess(sxPersonareaList);
            }else {
                logger.info("key不合法");
                return baseApiService.setResultError("key不合法");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询所有业务员
     * @param parameterDto
     * @return
     */
    @RequestMapping("/getPersonList")
    public Object getPersonList(@RequestBody ParameterDto parameterDto){
        String ccode = parameterDto.getCcode();
        String cname = parameterDto.getCname();
        String ccomcode = parameterDto.getCcomcode();
        String cdepcode = parameterDto.getCdepcode();
        try {
            List<ParameterDto> parameterDtoList = sxPersonareaService.getPersonList(ccomcode,cdepcode,ccode,cname);
            for (ParameterDto dto : parameterDtoList) {
                int count = sxPersonareaService.selectExist(dto.getCcode());
                String result = count>0?"已录点":"未录点";
                dto.setCkey(result);
            }
            return baseApiService.setResultResultSuccess(parameterDtoList);
        }catch (Exception e) {
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 判断该业务员是否已经录点
     * @param parameterDto
     * @return
     */
    @RequestMapping("/selectExist")
    public Object selectExist(@RequestBody ParameterDto parameterDto){
        String result = "";
        String cuser_id = parameterDto.getCuser_id();
        try {
            int count = sxPersonareaService.selectExist(cuser_id);
            result = count>0?"已录点":"未录点";
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e) {
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 新增业务员的范围点
     * @param
     * @return
     */
    @RequestMapping("/addPersonDot")
    public Object addPersonDot(HttpServletResponse response,@RequestBody ReqDto reqDto){
            response.setHeader("Access-Control-Allow-Origin", "*");
            String jsonvisit = reqDto.getJsonvisit().replace("'","\"");
           try {
               List<ResultDto> resultDtos = sxPersonareaService.addPersonDot(jsonvisit);
               logger.info("结果为："+resultDtos);
               return baseApiService.setResultResultSuccess(resultDtos);
           }catch (Exception e) {
               e.printStackTrace();
               return baseApiService.setResultError(e.toString());
           }
    }



    /**
     * 查询最近订单列表
     * @return
     */
    @RequestMapping("/getOrderList")
    public Object getOrderList(HttpServletResponse response,@RequestBody ParameterDto parameterDto){
        String userid = parameterDto.getUserid();
        String csocode = parameterDto.getCsocode();
        try {
            List<SxOrderInfo> sxOrderInfoList = sxPersonareaService.getOrderList(userid,csocode);
            logger.info("查询最近订单列表");
            return baseApiService.setResultResultSuccess(sxOrderInfoList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 获取userid
     * @param request
     * @param parameterDto
     * @return
     */
    @RequestMapping("/getWxAccessToken")
    public Object getWxAccessToken(HttpServletRequest request, @RequestBody ParameterDto parameterDto){
        String code = parameterDto.getCode();
        try{
            String access_token = userInfoUtil.getQywxToken();
            logger.info("access_token:"+access_token);
            String result =  CallUrl.sendGet("https://qyapi.weixin.qq.com/cgi-bin/miniprogram/jscode2session","access_token="+access_token+"&js_code="+code+"&grant_type=authorization_code");
            JSONObject jops = (JSONObject)(new JSONParser().parse(result));
            logger.info("jops:"+jops);
            return baseApiService.setResultResultSuccess(jops);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询单个订单详情
     * @param request
     * @param parameterDto
     * @return
     */
    @RequestMapping("/getOrderOne")
    public Object getOrderOne(HttpServletRequest request, @RequestBody ParameterDto parameterDto){
        String csocode = parameterDto.getCsocode();
        try {
            List<OrdervDto> ordervDtos = sxPersonareaService.getOrderOne(csocode);
            for (OrdervDto ordervDto : ordervDtos) {
                int autoid = ordervDto.getAutoid();
                List<SxOrderGift> sxOrderGiftList = sxPersonareaService.getSxOrderGift(autoid);
                ordervDto.setOrderGifts(sxOrderGiftList);
            }
            return baseApiService.setResultResultSuccess(ordervDtos);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    /**
     * 查询单个订单详情(用于客户查看公众号推送的订单)
     * @param parameterDto
     * @return
     */
    @RequestMapping("/getOrderOneWx")
    public Object getOrderOneWx( @RequestBody ParameterDto parameterDto){
        String csocode = parameterDto.getCsocode();
        String openid = parameterDto.getOpenid();
        try {
            String unionid = userInfoUtil.getInfoById(openid);
            List<OrdervDto> ordervDtos = sxPersonareaService.getOrderOne(csocode);
            if (!unionid.equals("未关注公众号")){
                String ccus_id = "";
                for (OrdervDto ordervDto : ordervDtos) {
                    ccus_id = ordervDto.getCcus_id();
                }
                int count = sxPersonareaService.getTomerWxbind(ccus_id,openid);  //判断查看人与被查看客户绑定一致
                int count2 = sxPersonareaService.getCcusidBind(ccus_id);
                if (count>0&&count2>0){
                    logger.info("查询单个信息:"+csocode);
                    for (OrdervDto dto : ordervDtos) {
                        dto.setCstate("00");
                    }
                    return baseApiService.setResultResultSuccess(ordervDtos);
                }else {
                    for (OrdervDto dto : ordervDtos) {
                        dto.setCstate("02");
                    }
                    return baseApiService.setResultResultSuccess(ordervDtos);
                }
            }else {
                for (OrdervDto dto : ordervDtos) {
                    dto.setCstate("01");
                }
                return baseApiService.setResultResultSuccess(ordervDtos);
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询订单列表，主要用于公众号中商家查询自己的订单
     * @param ordervDto
     * @return
     */
    @RequestMapping("/selectOrdervList")
    public Object selectOrdervList(@RequestBody OrdervDto ordervDto){
        String ccus_id = ordervDto.getCcus_id();
        String ddate2 = ordervDto.getDdate2();
        String csocode = ordervDto.getCsocode();
        String cso_state = ordervDto.getCso_state();
        try {
            List<OrdervDto> ordervDtoList = sxPersonareaService.selectOrdervList(ccus_id,ddate2,csocode,cso_state);
            return baseApiService.setResultResultSuccess(ordervDtoList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    /**
     * 增加打印的日志文件
     * @param request
     * @param parameterDto
     * @return
     */
    @RequestMapping("/increaseLog")
    public Object increaseLog(HttpServletRequest request, @RequestBody ParameterDto parameterDto){
        String userid = parameterDto.getUserid();
        String csocode = parameterDto.getCsocode();
        try {
            String results ="";
            int count = sxPersonareaService.increaseLog(userid,csocode);
            logger.info("增加打印的日志文件");
            results = count>0?"增加成功":"增加失败";
            return baseApiService.setResultResultSuccess(results);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 获取二维码的URL（临时的二维码）
     * @return
     */
    @RequestMapping("/GetqrCodes")
    public Object GetqrCodes(@RequestBody ParameterDto parameterDto){
        String scene_str = parameterDto.getScene_str();
        try {
            String access_token = userInfoUtil.getAccessToken();
            logger.info("access_token："+access_token);
            String jieguos = CallUrl.sendPost("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+access_token,
                    "{\"expire_seconds\": 604800,\"action_name\": \"QR_STR_SCENE\",\"action_info\": {\"scene\": {\"scene_str\":\""+scene_str+"\"}}}");
            JSONObject jsonObj2 = (JSONObject) (new JSONParser().parse(jieguos));
            String url = jsonObj2.get("url").toString();
            return baseApiService.setResultResultSuccess(url);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 发送模板消息
     * @param parameterDto
     * @return
     */
    @RequestMapping("/sendTemplates")
    public Object sendTemplates(@RequestBody ParameterDto parameterDto){
        String jsonvist = parameterDto.getJsonvist();
        try {
            JSONObject jsonObject = (JSONObject) (new JSONParser().parse(jsonvist));
            String ctype = jsonObject.get("ctype").toString();
            List<SxcustomerWxbind> sxcustomerWxbinds = new ArrayList<>();
            SxcustomerWxbind sxcustomerWxbind = new SxcustomerWxbind();
            sxcustomerWxbinds.add(sxcustomerWxbind);
            String openid = jsonObject.get("touser").toString();   //接收者（用户）的 openid
            if (openid!=null&&!openid.equals("")){
                for (SxcustomerWxbind wxbind : sxcustomerWxbinds) {
                    wxbind.setCopenid(openid);
                }
            }
            if (openid==null||openid.equals("")){
                String ccus_id = jsonObject.get("ccus_id").toString();
                sxcustomerWxbinds = sxPersonareaService.selectCopenid(ccus_id);
            }
            String url = jsonObject.get("tourl").toString();       //模板跳转链接
            String first = jsonObject.get("first").toString();
            String keyword1 = jsonObject.get("keyword1").toString();
            String keyword2 = jsonObject.get("keyword2").toString();
            String keyword3 = jsonObject.get("keyword3").toString();
            String keyword4 = "";
            if (jsonObject.get("keyword4")!=null){
                keyword4 = jsonObject.get("keyword4").toString();
            }
            String remark = jsonObject.get("remark").toString();
            String jieguo = "";
            //循环遍历openid，多个openid则发送多次消息
            for (SxcustomerWxbind wxbind : sxcustomerWxbinds) {
                if (wxbind.getCopenid()!=null&&!wxbind.getCopenid().equals("")){
                    if (ctype.equals("unpaidOrder")){   //待支付模板
                        logger.info("进入支付模板");
                        String template_id = "GN7nkSAbiWrsP7Hjm9WYBf_FCJX5CoM7dQPr3Revtmk";
                        String access_token= userInfoUtil.getAccessToken();
                        jieguo = CallUrl.sendPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token,
                                " {\"touser\":\""+wxbind.getCopenid()+"\",\"template_id\":\""+template_id+"\",\"url\":\""+url+"\",\"data\":" +
                                        "{\"first\": {\"value\":\""+first+"\", \"color\":\"#173177\"},\"keyword1\":{\"value\":\""+keyword1+"\",\"color\":\"#173177\"},\"keyword2\": {\"value\":\""+keyword2+"\",\"color\":\"#173177\"},\"keyword3\": {\"value\":\""+keyword3+"\",\"color\":\"#173177\"},\"remark\":{ \"value\":\""+remark+"\",\"color\":\"#173177\"}}}");
                        return baseApiService.setResultResultSuccess(jieguo);
                    }else if (ctype.equals("callback")){     //回访消息模板
                        logger.info("进入回访消息模板");
                        String template_id = "PnLBgt8jKqTBGl7TivCXGDos4JBZzYCABKVl33BaR7M";
                        String access_token= userInfoUtil.getAccessToken();
                        jieguo = CallUrl.sendPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token,
                                " {\"touser\":\""+wxbind.getCopenid()+"\",\"template_id\":\""+template_id+"\",\"url\":\""+url+"\",\"data\":" +
                                        "{\"first\": {\"value\":\""+first+"\", \"color\":\"#173177\"},\"keyword1\":{\"value\":\""+keyword1+"\",\"color\":\"#173177\"},\"keyword2\": {\"value\":\""+keyword2+"\",\"color\":\"#173177\"},\"keyword3\": {\"value\":\""+keyword3+"\",\"color\":\"#173177\"},\"remark\":{ \"value\":\""+remark+"\",\"color\":\"#173177\"}}}");
                        return baseApiService.setResultResultSuccess(jieguo);
                    }else if (ctype.equals("placeOrder")){  //分销商收到新订单模板
                        logger.info("进入分销商收到新订单模板");
                        String template_id = "a5sEeEhhasx-xVoexmQnzZcy2P5pBxwkZbw0YSmsA40";
                        String access_token= userInfoUtil.getAccessToken();
                        /*jieguo = CallUrl.sendPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token,
                                "{\"touser\":\""+wxbind.getCopenid()+"\",\"template_id\":\""+template_id+"\",\"url\":\"\",\"miniprogram\":\"{\"appid\":\"wxc42d00eb1ab95112\",\"pagepath\":\"pages/login/login\"}\",\"data\":" +
                                        "{\"first\": {\"value\":\""+first+"\", \"color\":\"#173177\"},\"keyword1\":{\"value\":\""+keyword1+"\",\"color\":\"#173177\"},\"keyword2\": {\"value\":\""+keyword2+"\",\"color\":\"#173177\"}," +
                                        "\"keyword3\": {\"value\":\""+keyword3+"\",\"color\":\"#173177\"},\"remark\":{ \"value\":\""+remark+"\",\"color\":\"#173177\"},\"keyword4\": {\"value\":\""+keyword4+"\",\"color\":\"#173177\"}}}");*/
                        jieguo = CallUrl.sendPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token,
                                "{ \"touser\":\""+wxbind.getCopenid()+"\",\"template_id\":\""+template_id+"\",\"url\":\"\",\"miniprogram\":{\"appid\":\"wxc42d00eb1ab95112\",\"pagepath\":\"pages/login/login\"}," +
                                        "\"data\":{\"first\": {\"value\":\""+first+"\",\"color\":\"#173177\" },\"keyword1\":{ \"value\":\""+keyword1+"\",\"color\":\"#173177\" },\"keyword2\": {\"value\":\""+keyword2+"\", \"color\":\"#173177\"}," +
                                        " \"keyword3\": {\"value\":\""+keyword3+"\",\"color\":\"#173177\"},\"keyword4\": {\"value\":\""+keyword4+"\",\"color\":\"#173177\"},\"remark\":{\"value\":\""+remark+"\",\"color\":\"#173177\"}}"
                        );
                    }else {
                        return baseApiService.setResultResultSuccess("系统错误，发送失败");
                    }
                }else {
                    return baseApiService.setResultResultSuccess("系统错误，发送失败");
                }
            }
            return baseApiService.setResultResultSuccess(jieguo);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    /**6
     * 从PHP 获取微信返回的数据包
     * @param reqDto
     * @return
     */
    @RequestMapping("/getWxXmlDatas")
    public Object getWxXmlDatas(HttpServletRequest request,@RequestBody ReqDto reqDto){
        String jsonvisit = reqDto.getJsonvisit();
        logger.info("获取到的json为："+jsonvisit);
        String jieguo = "";
        try {
            Document doc = null;
            doc = DocumentHelper.parseText(jsonvisit);
            Element xmls = doc.getRootElement();// 指向根节点  <xml>
            Element ToUserNames = xmls.element("ToUserName");
            Element FromUserNames = xmls.element("FromUserName");
            Element MsgTypes = xmls.element("MsgType");
            String ToUserName = ToUserNames.getTextTrim(); //开发者微信号
            String openid = FromUserNames.getTextTrim(); //发送方帐号（一个OpenID）
            String MsgType = MsgTypes.getTextTrim();    //消息类型，event
            Map<String, Object> hashmap = new HashMap<>();
            int wxshul = Integer.parseInt(sxPersonareaService.getInformCvalues("wxbindmax"));  //查询每个微信能绑定的客户数量
            if (MsgType.equals(WXConstants.MESSAGE_EVENT)) {
                Element eventTypes = xmls.element("Event");
                //从集合中，获取是哪一种事件传入
                String eventType = eventTypes.getTextTrim();
                if (eventType.equals(WXConstants.MESSAGE_TEMPLATESENDJOBFINISH)){
                    logger.info("模板推送成功！");
                }else {
                    Element eventKeys = xmls.element("EventKey");
                    //对获取到的参数进行处理
                    String eventKey = eventKeys.getTextTrim();
                    String order_code = "";
                    String[] params = eventKey.split("_");
                    if (params.length == 2) {
                        if (params[0].equalsIgnoreCase("qrscene")) {
                            order_code = params[1];
                        }
                    }else {
                        order_code = params[0];
                    }
                    order_code=order_code.replace(" ","");
                    List<SxcustomerWxbind> sxcustomerWxbinds = sxPersonareaService.selectWxbindOpenid2(openid);
                    if (order_code.contains("^")){  //包含特殊符号
                        logger.info("包含特殊符号");
                        String type = order_code.substring(order_code.indexOf("^"),order_code.lastIndexOf("~"));
                        logger.info("类型type："+type);
                        if (type.equals("^wxbind")){       //客户编码
                            logger.info("客户编码");
                            String ccus_id = order_code.substring(0,order_code.indexOf("^"));
                            String unionid = userInfoUtil.getInfoById(openid); //获取到unionid
                            int shun = sxPersonareaService.selectCcusid(ccus_id);
                            String cvalues = "";    //根据客户属于不同的公司、不同的客户级别查询不同的绑定数量
                            SxCustomer sxCustomer = sxPersonareaService.getCustomerPanyID(ccus_id);
                            if (sxCustomer.getCcus_level().equals("0202")){
                                if (sxCustomer.getCcompany_id().equals("20")){
                                    cvalues = sxPersonareaService.getInformCvalues("wxbindmax_0202_20");
                                }else {
                                    cvalues = sxPersonareaService.getInformCvalues("wxbindmax_0202_");
                                }
                            }else if (sxCustomer.getCcus_level().equals("0101")){
                                cvalues = sxPersonareaService.getInformCvalues("wxbindmax_0101_");
                            }else {
                                cvalues = sxPersonareaService.getInformCvalues("wxbindmax_0202_20");
                            }
                            int cvalus = Integer.parseInt(cvalues);
                            if(unionid!=null){
                                //获取一系列发送支付模板消息的参数
                                String template_id = "GN7nkSAbiWrsP7Hjm9WYBf_FCJX5CoM7dQPr3Revtmk";
                                String access_token= userInfoUtil.getAccessToken();
                                String order_id = order_code.substring(order_code.indexOf("~")+1,order_code.length());   //订单编号
                                String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxab0e17f759d71d17&redirect_uri=http%3A%2F%2Femall.hnsxtj.com%2Fgzh%2Fmyinfo/payment.html%3Forderid%3D\""+order_id+"\"&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";    //点击模板跳转的链接
                                String first = "尊敬的客户您好，你有一个订单未付款，请查看";
                                String keyword1 = order_id;     //订单编号
                                String keyword2 = "";           //订单金额
                                String keyword3 = "";           //订单创建时间
                                String remark = "如若已支付，请忽略本次消息";
                                if (!order_id.equals("")){
                                    List<Order> orderList = orderService.selectOrderInfo(order_id);
                                    for (Order order : orderList) {
                                        keyword2 = order.getImoney().toString();
                                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        keyword3 = formatter.format(order.getDdate());
                                    }
                                }
                                //未关注的扫码关注并绑定
                                if (eventType.equals(WXConstants.MESSAGE_SUBSCRIBE)) {
                                    if (shun>=cvalus){
                                        jieguo = "该客户绑定微信数量已达上限！";
                                    }else {
                                        if (sxcustomerWxbinds.size()<wxshul){    //该微信绑定的数量少于规定数量，则可继续进行绑定
                                            int shul = sxPersonareaService.getTomerWxbind(ccus_id,openid);
                                            if (shul<1){
                                                int count = sxPersonareaService.insertCustomerWx(ccus_id,openid,unionid);
                                                jieguo = count>0?"success":"系统错误，绑定失败！";
                                                //如果是通过订单支付进入的，则发送待支付的消息模板
                                                if (!order_id.equals("")){
                                                    logger.info("未关注的扫码关注并绑定，进入待支付消息模板");
                                                    CallUrl.sendPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token,
                                                            " {\"touser\":\""+openid+"\",\"template_id\":\""+template_id+"\",\"url\":\""+url+"\",\"data\":" +
                                                                    "{\"first\": {\"value\":\""+first+"\", \"color\":\"#173177\"},\"keyword1\":{\"value\":\""+keyword1+"\",\"color\":\"#173177\"},\"keyword2\": {\"value\":\""+keyword2+"\",\"color\":\"#173177\"},\"keyword3\": {\"value\":\""+keyword3+"\",\"color\":\"#173177\"},\"remark\":{ \"value\":\""+remark+"\",\"color\":\"#173177\"}}}");
                                                }
                                            }else {
                                                jieguo = "该客户已绑定，无法重复绑定";
                                            }
                                        }else {
                                            jieguo = "该微信号绑定客户已达上限，绑定失败！";
                                        }
                                    }
                                    hashmap.put("openid",openid);
                                    hashmap.put("cid",ccus_id);
                                    hashmap.put("result","wxbind");
                                    hashmap.put("msg",jieguo);
                                    hashmap.put("url","http://emall.hnsxtj.com/gzh/myinfo/personal_information.html?ccus_id="+ccus_id);
                                }
                                //已关注的扫码
                                else if (eventType.equals(WXConstants.MESSAGE_SCAN)) {
                                    if (shun>=cvalus){
                                        jieguo = "该客户绑定微信数量已达上限！";
                                    }else {
                                        if (sxcustomerWxbinds.size()<wxshul){    //该微信绑定客户未达上限，可继续绑定
                                            int shul = sxPersonareaService.getTomerWxbind(ccus_id,openid);
                                            if (shul<1){
                                                int count = sxPersonareaService.insertCustomerWx(ccus_id,openid,unionid);
                                                jieguo = count>0?"success":"系统错误，绑定失败！";
                                                //如果是通过订单支付进入的，则发送待支付的消息模板
                                                if (!order_id.equals("")){
                                                    logger.info("已关注的扫码，进入待支付消息模板");
                                                    CallUrl.sendPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token,
                                                   " {\"touser\":\""+openid+"\",\"template_id\":\""+template_id+"\",\"url\":\""+url+"\",\"data\":" +
                                                   "{\"first\": {\"value\":\""+first+"\", \"color\":\"#173177\"},\"keyword1\":{\"value\":\""+keyword1+"\",\"color\":\"#173177\"},\"keyword2\": {\"value\":\""+keyword2+"\",\"color\":\"#173177\"},\"keyword3\": {\"value\":\""+keyword3+"\",\"color\":\"#173177\"},\"remark\":{ \"value\":\""+remark+"\",\"color\":\"#173177\"}}}");
                                                }
                                            }else {
                                                jieguo = "该客户已绑定，无法重复绑定";
                                            }
                                        }else {
                                            jieguo = "该微信号绑定客户已达上限，绑定失败！";
                                        }
                                    }
                                    hashmap.put("openid",openid);
                                    hashmap.put("cid",ccus_id);
                                    hashmap.put("result","wxbind");
                                    hashmap.put("msg",jieguo);
                                    hashmap.put("url","http://emall.hnsxtj.com/gzh/myinfo/personal_information.html?ccus_id="+ccus_id);
                                }
                            }
                        }else if(type.equals("^scanorderqr")){      //订单编码
                            String scode = order_code.substring(0,order_code.indexOf("^"));
                            String strmd5 = openid+order_code;
                            String secret = MD5.MD5Encode(strmd5,"UTF-8"); //将openid和ccode进行md5加密
                            //扫描带参数的二维码，如果用户未关注则可关注公众号，事件类型为subscribe；用户已关注，则事件类型为SCAN
                            if (eventType.equals(WXConstants.MESSAGE_SUBSCRIBE)) {
                                if(!scode.equals("")){
                                    logger.info("用户未关注,点击了关注");
                                    if (sxcustomerWxbinds.size()<=wxshul){    //该微信绑定客户未达上限，可继续绑定
                                        sxPersonareaService.bindingOPenid(openid,scode,secret);
                                        jieguo = "success";
                                    }else {
                                        secret = secret +"1";
                                        jieguo = "success";
                                    }
                                    hashmap.put("openid",openid);
                                    hashmap.put("cid",scode);
                                    hashmap.put("result","scanorderqr");
                                    hashmap.put("msg",jieguo);
                                    hashmap.put("url","http://emall.hnsxtj.com/salebycar/scanning.php?orderid="+scode+"&id="+secret);
                                }
                            } else if (eventType.equals(WXConstants.MESSAGE_SCAN)) {
                                logger.info("用户已关注");
                                if (sxcustomerWxbinds.size()<=wxshul){    //该微信绑定客户未达上限，可继续绑定
                                    logger.info("该微信绑定客户未达上限，可继续绑定");
                                    sxPersonareaService.bindingOPenid(openid,scode,secret);
                                    jieguo = "success";
                                }else {
                                    secret = secret +"1";
                                    jieguo = "success";
                                }
                                hashmap.put("openid",openid);
                                hashmap.put("cid",scode);
                                hashmap.put("result","scanorderqr");
                                hashmap.put("msg",jieguo);
                                hashmap.put("url","http://emall.hnsxtj.com/salebycar/scanning.php?orderid="+scode+"&id="+secret);
                            }
                        }/*else if(type.equals("^apply")){        //报名码
                            String md5str = MD5.MD5Encode(openid,"UTF-8"); //将openid进行md5加密
                            String jieg = sxPersonareaService.judgeOpenid(md5str);
                            if(jieg==null){
                                sxPersonareaService.insertMd5OpenID(openid,md5str);
                            }
                            hashmap.put("openid",openid);
                            hashmap.put("cid","");
                            hashmap.put("result","apply");
                            hashmap.put("msg","http://emall.hnsxtj.com/Lottery/index.html?oid="+md5str);
                            hashmap.put("url","http://emall.hnsxtj.com/Lottery/index.html?oid="+md5str);
                        }*/
                    }
                }
            }
            return hashmap;
        } catch (Exception e) {
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询MD5是否存在
     * @param request
     * @param parameterDto
     * @return
     */
    @RequestMapping("/selectMD5str")
    public Object selectMD5str(HttpServletRequest request,@RequestBody ParameterDto parameterDto){
        String md5str = parameterDto.getMd5str();
        String restor = "不存在";
        try {
            List<WeixinDto> weixinDto = sxPersonareaService.selectOderOpen(md5str);
            if(weixinDto.size()!=0){
                restor = md5str;
            }
            logger.info(restor);
            return baseApiService.setResultResultSuccess(restor);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    /**
     * 微信绑定商户信息
     * @param parameterDto
     * @return
     */
    @RequestMapping("/bindingInfo")
    public Object bindingInfo(HttpServletRequest request,@RequestBody ParameterDto parameterDto){
        String md5str = parameterDto.getMd5str();
        String results = "";
        String openid ="";
        String ccus_id = "";
        String ccode = "";
        Map<String,String> map = new HashMap<String,String>();
        int wxshul = Integer.parseInt(sxPersonareaService.getInformCvalues("wxbindmax"));  //查询每个微信能绑定的客户数量
        try {
            List<WeixinDto> weixinDto = sxPersonareaService.selectOderOpen(md5str);
            if (weixinDto.size()!=0){
                for (WeixinDto dto : weixinDto) {
                    openid = dto.getOpenid();
                    ccode = dto.getCcode();
                }
                List<OrdervDto> ordervDtos = sxPersonareaService.getOrderOne(ccode);
                for (OrdervDto ordervDto : ordervDtos) {
                    ccus_id = ordervDto.getCcus_id();
                }
                String unionid = userInfoUtil.getInfoById(openid); //获取到unionid
                List<SxcustomerWxbind> sxcustomerWxbinds = sxPersonareaService.selectWxbindOpenid(openid);
                if(!unionid.equals("未关注公众号")){
                    String cvalues = "";    //根据客户属于不同的公司、不同的客户级别查询不同的绑定数量
                    int amount = sxPersonareaService.selectCcusid(ccus_id);
                    SxCustomer sxCustomer = sxPersonareaService.getCustomerPanyID(ccus_id);
                    if (sxCustomer.getCcus_level().equals("0202")){
                        if (sxCustomer.getCcompany_id().equals("20")){
                            cvalues = sxPersonareaService.getInformCvalues("wxbindmax_0202_20");
                        }else {
                            cvalues = sxPersonareaService.getInformCvalues("wxbindmax_0202_");
                        }
                    }else if (sxCustomer.getCcus_level().equals("0101")){
                        cvalues = sxPersonareaService.getInformCvalues("wxbindmax_0101_");
                    }
                    int cvalus = Integer.parseInt(cvalues);
                    if (amount>=cvalus){
                        results = "该客户绑定微信数量已达上限！";
                    }else {
                        if (sxcustomerWxbinds.size()<=wxshul){    //该微信绑定的客户数量少于规定数量则可以继续进行绑定
                            int count = sxPersonareaService.insertCustomerWx(ccus_id,openid,unionid);
                            results = count>0?"绑定成功！":"系统错误，绑定失败！";
                        }else {
                            results = "该微信号绑定客户已达上限，绑定失败！";
                        }
                    }
                }else {
                    results = "unionid为空，绑定失败！";
                }
            }else {
                results = "绑定失败";
                logger.info("参数不存在，绑定失败");
            }
            map.put("ccus_id",ccus_id);
            map.put("openid",openid);
            map.put("results",results);
            return baseApiService.setResultResultSuccess(map);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 通过获取客户编号ccus_id 和openid 进行客户绑定
     * @param parameterDto
     * @return
     */
    @RequestMapping("/bindingWxinfo")
    public Object bindingWxinfo(@RequestBody ParameterDto parameterDto){
        String ccus_id = parameterDto.getCcus_id();
        String openid = parameterDto.getOpenid();
        String results = "";
        String cvalues = "";
        try {
            if(!ccus_id.equals("")&&!openid.equals("")){
                int wxshul = Integer.parseInt(sxPersonareaService.getInformCvalues("wxbindmax"));  //查询每个微信能绑定的客户数量
                List<SxcustomerWxbind> sxcustomerWxbinds = sxPersonareaService.selectWxbindOpenid(openid);
                String unionid = userInfoUtil.getInfoById(openid); //获取到unionid
                if(!unionid.equals("")){
                    int quantity = sxPersonareaService.selectCcusid(ccus_id);
                    SxCustomer sxCustomer = sxPersonareaService.getCustomerPanyID(ccus_id);
                    if (sxCustomer.getCcus_level().equals("0202")){
                        if (sxCustomer.getCcompany_id().equals("20")){
                            cvalues = sxPersonareaService.getInformCvalues("wxbindmax_0202_20");
                        }else {
                            cvalues = sxPersonareaService.getInformCvalues("wxbindmax_0202_");
                        }
                    }else if (sxCustomer.getCcus_level().equals("0101")){
                        cvalues = sxPersonareaService.getInformCvalues("wxbindmax_0101_");
                    }
                    int cvalus = Integer.parseInt(cvalues);
                    if (quantity>=cvalus){
                        results = "该客户绑定微信数量已达上限！";
                    }else {
                        if (sxcustomerWxbinds.size()<=wxshul){    //该微信绑定的客户数量少于规定数量则可以继续进行绑定
                            int count = sxPersonareaService.insertCustomerWx(ccus_id,openid,unionid);
                            results = count>0?"绑定成功":"系统错误，绑定失败！";
                        }else {
                            results = "该微信号绑定客户已达上限，绑定失败！";
                        }
                    }
                }else {
                    results = "unionid为空，绑定失败！";
                }
            }else {
                results = "参数错误，绑定失败！";
            }
            return baseApiService.setResultResultSuccess(results);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询小程序登录信息并进行绑定
     * @param request
     * @param parameterDto
     * @return
     *
     * 1、业务员扫打印的二维码，将会获取到业务员微信的unionid和工号,然后进行一个绑定
     * 2、当业务员从微信下拉直接进入小程序时，如果业务员已经绑定过，则通过unionid直接获取到工号；
     *    如果未绑定进行绑定操作
     *
     */
    @RequestMapping("/getXcxcode")
    public Object getXcxcode(HttpServletRequest request, @RequestBody ParameterDto parameterDto){
        String code = parameterDto.getCode();
        String userid = parameterDto.getUserid();
        String ccode = "";
        String str = "";
        try {
            if(!code.equals("")){
                String unionid = userInfoUtil.getXcxunionid(code);
                logger.info("unionid="+unionid);
                if (!code.equals("") && !userid.equals("")){
                    //都不为空则进行查询，查询是未绑定的则进行绑定，查询是已绑定的则不做任何操作
                    str = "{\"ctype\":\"unionidlookup\",\"unionid\":\""+unionid+"\"}";
                    String reulst = CallUrl.post("http://emall.hnsxtj.com/leadtotal/leadtotal.php",str);
                    JSONObject jsonObj2 = (JSONObject)(new JSONParser().parse(reulst));
                    String msg = jsonObj2.get("msg").toString();
                    if (msg.equals("1")){  //已绑定
                        logger.info("已绑定");
                        String datas = jsonObj2.get("datas").toString();
                        String cc = datas.substring(datas.indexOf("[")+1, datas.lastIndexOf("]"));
                        JSONObject jsonObj3 = (JSONObject)(new JSONParser().parse(cc));
                        ccode = jsonObj3.get("ccode").toString();
                        if (unionid.equals("")){
                            ccode = "";
                        }
                    }else if (msg.equals("0")){  //未绑定
                        logger.info("未绑定");
                        String info = "{\"ctype\":\"wxunionid\",\"unionid\":\""+unionid+"\",\"userid\":\""+userid+"\"}";
                        String reslt = CallUrl.post("http://emall.hnsxtj.com/leadtotal/leadtotal.php",info);
                        JSONObject jsonObj3 = (JSONObject)(new JSONParser().parse(reslt));
                        String msg2 = jsonObj3.get("msg").toString();
                        if(msg2.equals("1")){
                            logger.info("绑定成功！");
                            ccode = userid;
                        }
                    }
                }
                if(userid.equals("") && !code.equals("")){
                    //如果userid为空code不为空，则用unionid去换取userid
                    str = "{\"ctype\":\"unionidlookup\",\"unionid\":\""+unionid+"\"}";
                    String reulst = CallUrl.post("http://emall.hnsxtj.com/leadtotal/leadtotal.php",str);
                    JSONObject jsonObj2 = (JSONObject)(new JSONParser().parse(reulst));
                    String msg = jsonObj2.get("msg").toString();
                    if(msg.equals("1")){
                        String datas = jsonObj2.get("datas").toString();
                        String cc = datas.substring(datas.indexOf("[")+1, datas.lastIndexOf("]"));
                        JSONObject jsonObj3 = (JSONObject)(new JSONParser().parse(cc));
                        ccode = jsonObj3.get("ccode").toString();
                        if (unionid.equals("")){
                            ccode = "";
                        }
                    }else {
                        ccode = "";
                    }
                }
            }
            return baseApiService.setResultResultSuccess(ccode);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询订单打印记录
     * @param printLogDto
     * @return
     */
    @RequestMapping("/selectPrintlog")
    public Object selectPrintlog(@RequestBody PrintLogDto printLogDto){
        String ddate = printLogDto.getDdate();
        String cperson_id = printLogDto.getCperson_id();
        String ccomcode = printLogDto.getCcomcode();
        int paycount= 0;
        int princount = 0;
        int count = 0;
        try {
            List<PrintLogDto> printLogDtos = sxPersonareaService.selectPrintlog(ddate,cperson_id,ccomcode);
            for (PrintLogDto logDto : printLogDtos) {
                count += 1;
                if (logDto.getPaytype().equals("1")){
                    paycount += 1;
                }if(logDto.getPrintype().equals("1")){
                    princount += 1;
                }
                if(count == printLogDtos.size()){
                    logDto.setPaycount(paycount);
                    logDto.setPrincount(princount);
                }
            }
            logger.info("查询订单打印记录："+ddate+"/"+cperson_id+"/"+ccomcode);
            return baseApiService.setResultResultSuccess(printLogDtos);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 获取公众号token
     * @return
     */
    @RequestMapping("/getGZAccessToken")
    public Object getGZAccessToken(@RequestBody ParameterDto parameterDto){
        String token = "";
        String ckey = parameterDto.getCkey();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        String today = "hnsxtj"+sdf.format(date);
        String md5key = MD5.MD5Encode(today,"UTF-8");
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.MINUTE, -1);// 1分钟之前的时间
        Date beforeD = beforeTime.getTime();
        String before1 = new SimpleDateFormat("yyyyMMddHHmm").format(beforeD);
        String today2 = "hnsxtj"+before1;
        String md5key2 = MD5.MD5Encode(today2,"UTF-8"); //前一分钟的key
        try {
            if(md5key.equals(ckey)){ //与当前分钟的key相同
                token = userInfoUtil.getAccessToken();
            }else {
                if (md5key2.equals(ckey)){  //与前一分钟的key相同
                    token = userInfoUtil.getAccessToken();
                }else {
                    token = "key不匹配！";
                }
            }
           return token;
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 通过code获取openid，再通过openid换取ccuserid和cunitid
     * @param parameterDto
     * @return
     */
    @RequestMapping("/getGzhOpneid")
    public Object getGzhOpneid(@RequestBody ParameterDto parameterDto){
        String code = parameterDto.getCode();
        String ctype = parameterDto.getCtype();  //define 默认， saleonline 在线销售
        try {
            if (ctype==null){  //ctype为空或者默认都设置为define
                ctype = "define";
            }
            String openid = userInfoUtil.getGzOpenid(code);
            List<SxcustomerWxbind> sxcustomerWxbind = sxPersonareaService.selectWxbindOpenid2(openid);
            if (sxcustomerWxbind.size()>0){   //微信已绑定店铺，则放回 店铺的所有信息和openid
                for (SxcustomerWxbind wxbind : sxcustomerWxbind) {   //给返回结果添加ckey
                    String ccusid = Integer.toString(wxbind.getCcusid());
                    String copenid = wxbind.getCopenid();
                    wxlogindataDto wxlogindataDto = sxPersonareaService.exchangeCkey(ccusid,copenid);
                    wxbind.setCkey(wxlogindataDto.getCkey());
                }
                return baseApiService.setResultResultSuccess(sxcustomerWxbind);
            }
            //如果该微信没有绑定店铺，根据ctype进行不同的赋值
            if (ctype.equals("saleonline")){    //在线销售，商城则赋值游客身份
                List<TouristDto> touristDtoList = sxPersonareaService.selectTouristInfo();
                for (TouristDto touristDto : touristDtoList) {
                     String ccusid = Integer.toString(touristDto.getCcus_id());
                     wxlogindataDto wxlogindataDto = sxPersonareaService.exchangeCkey(ccusid,openid);
                     touristDto.setCopenid(openid);
                     touristDto.setCkey(wxlogindataDto.getCkey());
                }
                return baseApiService.setResultResultSuccess(touristDtoList);
            }else{    //默认
                wxlogindataDto stringList = new wxlogindataDto();
                wxlogindataDto wxlogindataDto1 = sxPersonareaService.exchangeCkey("",openid);
                stringList.setCkey(wxlogindataDto1.getCkey());
                stringList.setCopenid(openid);
                return baseApiService.setResultResultSuccess(stringList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 通过openid换取绑定的客户编号和客户名称
     * @param parameterDto
     * @return
     */
    @RequestMapping("/selectCcusCode")
    public Object selectCcusCode(@RequestBody ParameterDto parameterDto){
        String openid = parameterDto.getOpenid();
        try {
            List<SxcustomerWxbind> sxcustomerWxbind = sxPersonareaService.selectWxbindOpenid2(openid);
            List<Object> sxCustomerList = new ArrayList<>();
            for (SxcustomerWxbind wxbind : sxcustomerWxbind) {
                int ccusid = wxbind.getCcusid();
                sxCustomerList.add(sxCustomerService.selectCustomer(ccusid).get(0));
            }
            return baseApiService.setResultResultSuccess(sxCustomerList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 设置默认店铺
     * @param parameterDto
     * @return
     */
    @RequestMapping("/updateDbefault")
    public Object updateDbefault(@RequestBody ParameterDto parameterDto){
        String openid = parameterDto.getOpenid();
        String ccus_id = parameterDto.getCcus_id();
        String result = "";
        try {
            int count = sxPersonareaService.updateDbefault(openid);
            if (count>0){
                int count2 = sxPersonareaService.updateDbefault2(openid,ccus_id);
                result = count2>0?"修改成功":"修改失败";
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    /**
     * 获取订单状态  1 已付款 0 未付款
     * @param sxOrderInfo
     * @return
     */
    @RequestMapping("/getOrderStatus")
    public Object getOrderStatus(@RequestBody SxOrderInfo sxOrderInfo){
        String csocode = sxOrderInfo.getCsocode();
        try {
             int ordercount = sxPersonareaService.getOrderStatus(csocode);
             return baseApiService.setResultResultSuccess(ordercount);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    @RequestMapping("/getQywxToken")
    public Object getQywxToken(){
        try {
            String qywxToken = userInfoUtil.getAccessToken();
            return qywxToken;
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }





}
