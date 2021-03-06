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
     * ????????????????????????token
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
     * ???????????????????????????????????????
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
     * ??????A ???B ?????????????????????????????????
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
                logger.info("??????A ?????????????????????????????????,"+cuser_id);
                return baseApiService.setResultResultSuccess(CuserTempList);
            }else{
                List<ParameterDto> CuserTempList2 = sxPersonareaService.selectCuser(cuser_id);
                for (ParameterDto dto : CuserTempList2) {
                    String result = gonyon(dto.getCcode(),"B");
                    dto.setParam2(result);
                }
                logger.info("??????B ?????????????????????????????????,"+cuser_id);
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
        //BigDecimal ????????? double????????????
        double d = DistanceUtils.getDistance(y1, x1, y2, x2);
        String result = d*1000<200.00?"??????":"??????????????????????????????"+new DecimalFormat("#.00").format(d*1000)+"???";
        return result;
    }


    /**
     * ??????A?????????
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
                   results = "??????";
               }else {
                   int count = sxPersonareaService.insertPersonareaTemp(ccompand_id,cuser_id,xpoint,ypoint,param1);
                   logger.info("??????A ?????????"+ccompand_id+","+cuser_id+","+xpoint+","+ypoint);
                   results = count>0?"????????????":"????????????";
               }
         }
            return baseApiService.setResultResultSuccess(results);
       }catch (Exception e){
           e.printStackTrace();
           return baseApiService.setResultError(e.toString());
       }
    }


    /**
     * ??????A ???????????????????????????
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
                    logger.info("??????A ???????????????????????????,"+cuser_id);
                    results = count>0?"????????????":"????????????";
                }else {
                    results = "???????????????????????????????????????";
                }
            }else if (ctype.equals("B")){
                List<SxPersonarea> sxPersonareaList = sxPersonareaService.selectCusers(cuser_id);
                if (sxPersonareaList.size()!=0){
                    int count = sxPersonareaService.delectPersonarea(cuser_id);
                    logger.info("??????B ???????????????????????????,"+cuser_id);
                    results = count>0?"????????????":"????????????";
                }else {
                    results = "???????????????????????????????????????";
                }
            }
            return baseApiService.setResultResultSuccess(results);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ??????A????????????B???
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
                results = "??????";
            }else {
                int count = sxPersonareaService.duplication(cuser_id);
                logger.info("??????A????????????B???==cuser_id???"+cuser_id);
                results = count>0?"????????????":"????????????";
            }
            return baseApiService.setResultResultSuccess(results);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ??????A???B??????????????????????????????
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
                logger.info("??????A??????????????????????????????==cuser_id???" + cuser_id);
                return baseApiService.setResultResultSuccess(sxPersonareaList);
            } else {
                List<SxPersonarea> sxPersonareaList = sxPersonareaService.selectCusers(cuser_id);
                logger.info("??????B??????????????????????????????==cuser_id???" + cuser_id);
                return baseApiService.setResultResultSuccess(sxPersonareaList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ??????????????????????????????
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
     * ??????B???????????????????????????
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
                logger.info("??????B????????????????????????");
                return baseApiService.setResultResultSuccess(sxPersonareaList);
            }else {
                logger.info("key?????????");
                return baseApiService.setResultError("key?????????");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ?????????????????????????????????
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
                logger.info("?????????????????????????????????");
                return baseApiService.setResultResultSuccess(sxPersonareaList);
            }else {
                logger.info("key?????????");
                return baseApiService.setResultError("key?????????");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ?????????????????????
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
                String result = count>0?"?????????":"?????????";
                dto.setCkey(result);
            }
            return baseApiService.setResultResultSuccess(parameterDtoList);
        }catch (Exception e) {
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ????????????????????????????????????
     * @param parameterDto
     * @return
     */
    @RequestMapping("/selectExist")
    public Object selectExist(@RequestBody ParameterDto parameterDto){
        String result = "";
        String cuser_id = parameterDto.getCuser_id();
        try {
            int count = sxPersonareaService.selectExist(cuser_id);
            result = count>0?"?????????":"?????????";
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e) {
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ???????????????????????????
     * @param
     * @return
     */
    @RequestMapping("/addPersonDot")
    public Object addPersonDot(HttpServletResponse response,@RequestBody ReqDto reqDto){
            response.setHeader("Access-Control-Allow-Origin", "*");
            String jsonvisit = reqDto.getJsonvisit().replace("'","\"");
           try {
               List<ResultDto> resultDtos = sxPersonareaService.addPersonDot(jsonvisit);
               logger.info("????????????"+resultDtos);
               return baseApiService.setResultResultSuccess(resultDtos);
           }catch (Exception e) {
               e.printStackTrace();
               return baseApiService.setResultError(e.toString());
           }
    }



    /**
     * ????????????????????????
     * @return
     */
    @RequestMapping("/getOrderList")
    public Object getOrderList(HttpServletResponse response,@RequestBody ParameterDto parameterDto){
        String userid = parameterDto.getUserid();
        String csocode = parameterDto.getCsocode();
        try {
            List<SxOrderInfo> sxOrderInfoList = sxPersonareaService.getOrderList(userid,csocode);
            logger.info("????????????????????????");
            return baseApiService.setResultResultSuccess(sxOrderInfoList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ??????userid
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
     * ????????????????????????
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
     * ????????????????????????(??????????????????????????????????????????)
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
            if (!unionid.equals("??????????????????")){
                String ccus_id = "";
                for (OrdervDto ordervDto : ordervDtos) {
                    ccus_id = ordervDto.getCcus_id();
                }
                int count = sxPersonareaService.getTomerWxbind(ccus_id,openid);  //?????????????????????????????????????????????
                int count2 = sxPersonareaService.getCcusidBind(ccus_id);
                if (count>0&&count2>0){
                    logger.info("??????????????????:"+csocode);
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
     * ????????????????????????????????????????????????????????????????????????
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
     * ???????????????????????????
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
            logger.info("???????????????????????????");
            results = count>0?"????????????":"????????????";
            return baseApiService.setResultResultSuccess(results);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ??????????????????URL????????????????????????
     * @return
     */
    @RequestMapping("/GetqrCodes")
    public Object GetqrCodes(@RequestBody ParameterDto parameterDto){
        String scene_str = parameterDto.getScene_str();
        try {
            String access_token = userInfoUtil.getAccessToken();
            logger.info("access_token???"+access_token);
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
     * ??????????????????
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
            String openid = jsonObject.get("touser").toString();   //???????????????????????? openid
            if (openid!=null&&!openid.equals("")){
                for (SxcustomerWxbind wxbind : sxcustomerWxbinds) {
                    wxbind.setCopenid(openid);
                }
            }
            if (openid==null||openid.equals("")){
                String ccus_id = jsonObject.get("ccus_id").toString();
                sxcustomerWxbinds = sxPersonareaService.selectCopenid(ccus_id);
            }
            String url = jsonObject.get("tourl").toString();       //??????????????????
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
            //????????????openid?????????openid?????????????????????
            for (SxcustomerWxbind wxbind : sxcustomerWxbinds) {
                if (wxbind.getCopenid()!=null&&!wxbind.getCopenid().equals("")){
                    if (ctype.equals("unpaidOrder")){   //???????????????
                        logger.info("??????????????????");
                        String template_id = "GN7nkSAbiWrsP7Hjm9WYBf_FCJX5CoM7dQPr3Revtmk";
                        String access_token= userInfoUtil.getAccessToken();
                        jieguo = CallUrl.sendPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token,
                                " {\"touser\":\""+wxbind.getCopenid()+"\",\"template_id\":\""+template_id+"\",\"url\":\""+url+"\",\"data\":" +
                                        "{\"first\": {\"value\":\""+first+"\", \"color\":\"#173177\"},\"keyword1\":{\"value\":\""+keyword1+"\",\"color\":\"#173177\"},\"keyword2\": {\"value\":\""+keyword2+"\",\"color\":\"#173177\"},\"keyword3\": {\"value\":\""+keyword3+"\",\"color\":\"#173177\"},\"remark\":{ \"value\":\""+remark+"\",\"color\":\"#173177\"}}}");
                        return baseApiService.setResultResultSuccess(jieguo);
                    }else if (ctype.equals("callback")){     //??????????????????
                        logger.info("????????????????????????");
                        String template_id = "PnLBgt8jKqTBGl7TivCXGDos4JBZzYCABKVl33BaR7M";
                        String access_token= userInfoUtil.getAccessToken();
                        jieguo = CallUrl.sendPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token,
                                " {\"touser\":\""+wxbind.getCopenid()+"\",\"template_id\":\""+template_id+"\",\"url\":\""+url+"\",\"data\":" +
                                        "{\"first\": {\"value\":\""+first+"\", \"color\":\"#173177\"},\"keyword1\":{\"value\":\""+keyword1+"\",\"color\":\"#173177\"},\"keyword2\": {\"value\":\""+keyword2+"\",\"color\":\"#173177\"},\"keyword3\": {\"value\":\""+keyword3+"\",\"color\":\"#173177\"},\"remark\":{ \"value\":\""+remark+"\",\"color\":\"#173177\"}}}");
                        return baseApiService.setResultResultSuccess(jieguo);
                    }else if (ctype.equals("placeOrder")){  //??????????????????????????????
                        logger.info("????????????????????????????????????");
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
                        return baseApiService.setResultResultSuccess("???????????????????????????");
                    }
                }else {
                    return baseApiService.setResultResultSuccess("???????????????????????????");
                }
            }
            return baseApiService.setResultResultSuccess(jieguo);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    /**6
     * ???PHP ??????????????????????????????
     * @param reqDto
     * @return
     */
    @RequestMapping("/getWxXmlDatas")
    public Object getWxXmlDatas(HttpServletRequest request,@RequestBody ReqDto reqDto){
        String jsonvisit = reqDto.getJsonvisit();
        logger.info("????????????json??????"+jsonvisit);
        String jieguo = "";
        try {
            Document doc = null;
            doc = DocumentHelper.parseText(jsonvisit);
            Element xmls = doc.getRootElement();// ???????????????  <xml>
            Element ToUserNames = xmls.element("ToUserName");
            Element FromUserNames = xmls.element("FromUserName");
            Element MsgTypes = xmls.element("MsgType");
            String ToUserName = ToUserNames.getTextTrim(); //??????????????????
            String openid = FromUserNames.getTextTrim(); //????????????????????????OpenID???
            String MsgType = MsgTypes.getTextTrim();    //???????????????event
            Map<String, Object> hashmap = new HashMap<>();
            int wxshul = Integer.parseInt(sxPersonareaService.getInformCvalues("wxbindmax"));  //??????????????????????????????????????????
            if (MsgType.equals(WXConstants.MESSAGE_EVENT)) {
                Element eventTypes = xmls.element("Event");
                //?????????????????????????????????????????????
                String eventType = eventTypes.getTextTrim();
                if (eventType.equals(WXConstants.MESSAGE_TEMPLATESENDJOBFINISH)){
                    logger.info("?????????????????????");
                }else {
                    Element eventKeys = xmls.element("EventKey");
                    //?????????????????????????????????
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
                    if (order_code.contains("^")){  //??????????????????
                        logger.info("??????????????????");
                        String type = order_code.substring(order_code.indexOf("^"),order_code.lastIndexOf("~"));
                        logger.info("??????type???"+type);
                        if (type.equals("^wxbind")){       //????????????
                            logger.info("????????????");
                            String ccus_id = order_code.substring(0,order_code.indexOf("^"));
                            String unionid = userInfoUtil.getInfoById(openid); //?????????unionid
                            int shun = sxPersonareaService.selectCcusid(ccus_id);
                            String cvalues = "";    //????????????????????????????????????????????????????????????????????????????????????
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
                                //????????????????????????????????????????????????
                                String template_id = "GN7nkSAbiWrsP7Hjm9WYBf_FCJX5CoM7dQPr3Revtmk";
                                String access_token= userInfoUtil.getAccessToken();
                                String order_id = order_code.substring(order_code.indexOf("~")+1,order_code.length());   //????????????
                                String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxab0e17f759d71d17&redirect_uri=http%3A%2F%2Femall.hnsxtj.com%2Fgzh%2Fmyinfo/payment.html%3Forderid%3D\""+order_id+"\"&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";    //???????????????????????????
                                String first = "???????????????????????????????????????????????????????????????";
                                String keyword1 = order_id;     //????????????
                                String keyword2 = "";           //????????????
                                String keyword3 = "";           //??????????????????
                                String remark = "???????????????????????????????????????";
                                if (!order_id.equals("")){
                                    List<Order> orderList = orderService.selectOrderInfo(order_id);
                                    for (Order order : orderList) {
                                        keyword2 = order.getImoney().toString();
                                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        keyword3 = formatter.format(order.getDdate());
                                    }
                                }
                                //?????????????????????????????????
                                if (eventType.equals(WXConstants.MESSAGE_SUBSCRIBE)) {
                                    if (shun>=cvalus){
                                        jieguo = "??????????????????????????????????????????";
                                    }else {
                                        if (sxcustomerWxbinds.size()<wxshul){    //?????????????????????????????????????????????????????????????????????
                                            int shul = sxPersonareaService.getTomerWxbind(ccus_id,openid);
                                            if (shul<1){
                                                int count = sxPersonareaService.insertCustomerWx(ccus_id,openid,unionid);
                                                jieguo = count>0?"success":"??????????????????????????????";
                                                //????????????????????????????????????????????????????????????????????????
                                                if (!order_id.equals("")){
                                                    logger.info("???????????????????????????????????????????????????????????????");
                                                    CallUrl.sendPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token,
                                                            " {\"touser\":\""+openid+"\",\"template_id\":\""+template_id+"\",\"url\":\""+url+"\",\"data\":" +
                                                                    "{\"first\": {\"value\":\""+first+"\", \"color\":\"#173177\"},\"keyword1\":{\"value\":\""+keyword1+"\",\"color\":\"#173177\"},\"keyword2\": {\"value\":\""+keyword2+"\",\"color\":\"#173177\"},\"keyword3\": {\"value\":\""+keyword3+"\",\"color\":\"#173177\"},\"remark\":{ \"value\":\""+remark+"\",\"color\":\"#173177\"}}}");
                                                }
                                            }else {
                                                jieguo = "???????????????????????????????????????";
                                            }
                                        }else {
                                            jieguo = "??????????????????????????????????????????????????????";
                                        }
                                    }
                                    hashmap.put("openid",openid);
                                    hashmap.put("cid",ccus_id);
                                    hashmap.put("result","wxbind");
                                    hashmap.put("msg",jieguo);
                                    hashmap.put("url","http://emall.hnsxtj.com/gzh/myinfo/personal_information.html?ccus_id="+ccus_id);
                                }
                                //??????????????????
                                else if (eventType.equals(WXConstants.MESSAGE_SCAN)) {
                                    if (shun>=cvalus){
                                        jieguo = "??????????????????????????????????????????";
                                    }else {
                                        if (sxcustomerWxbinds.size()<wxshul){    //???????????????????????????????????????????????????
                                            int shul = sxPersonareaService.getTomerWxbind(ccus_id,openid);
                                            if (shul<1){
                                                int count = sxPersonareaService.insertCustomerWx(ccus_id,openid,unionid);
                                                jieguo = count>0?"success":"??????????????????????????????";
                                                //????????????????????????????????????????????????????????????????????????
                                                if (!order_id.equals("")){
                                                    logger.info("????????????????????????????????????????????????");
                                                    CallUrl.sendPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token,
                                                   " {\"touser\":\""+openid+"\",\"template_id\":\""+template_id+"\",\"url\":\""+url+"\",\"data\":" +
                                                   "{\"first\": {\"value\":\""+first+"\", \"color\":\"#173177\"},\"keyword1\":{\"value\":\""+keyword1+"\",\"color\":\"#173177\"},\"keyword2\": {\"value\":\""+keyword2+"\",\"color\":\"#173177\"},\"keyword3\": {\"value\":\""+keyword3+"\",\"color\":\"#173177\"},\"remark\":{ \"value\":\""+remark+"\",\"color\":\"#173177\"}}}");
                                                }
                                            }else {
                                                jieguo = "???????????????????????????????????????";
                                            }
                                        }else {
                                            jieguo = "??????????????????????????????????????????????????????";
                                        }
                                    }
                                    hashmap.put("openid",openid);
                                    hashmap.put("cid",ccus_id);
                                    hashmap.put("result","wxbind");
                                    hashmap.put("msg",jieguo);
                                    hashmap.put("url","http://emall.hnsxtj.com/gzh/myinfo/personal_information.html?ccus_id="+ccus_id);
                                }
                            }
                        }else if(type.equals("^scanorderqr")){      //????????????
                            String scode = order_code.substring(0,order_code.indexOf("^"));
                            String strmd5 = openid+order_code;
                            String secret = MD5.MD5Encode(strmd5,"UTF-8"); //???openid???ccode??????md5??????
                            //??????????????????????????????????????????????????????????????????????????????????????????subscribe???????????????????????????????????????SCAN
                            if (eventType.equals(WXConstants.MESSAGE_SUBSCRIBE)) {
                                if(!scode.equals("")){
                                    logger.info("???????????????,???????????????");
                                    if (sxcustomerWxbinds.size()<=wxshul){    //???????????????????????????????????????????????????
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
                                logger.info("???????????????");
                                if (sxcustomerWxbinds.size()<=wxshul){    //???????????????????????????????????????????????????
                                    logger.info("???????????????????????????????????????????????????");
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
                        }/*else if(type.equals("^apply")){        //?????????
                            String md5str = MD5.MD5Encode(openid,"UTF-8"); //???openid??????md5??????
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
     * ??????MD5????????????
     * @param request
     * @param parameterDto
     * @return
     */
    @RequestMapping("/selectMD5str")
    public Object selectMD5str(HttpServletRequest request,@RequestBody ParameterDto parameterDto){
        String md5str = parameterDto.getMd5str();
        String restor = "?????????";
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
     * ????????????????????????
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
        int wxshul = Integer.parseInt(sxPersonareaService.getInformCvalues("wxbindmax"));  //??????????????????????????????????????????
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
                String unionid = userInfoUtil.getInfoById(openid); //?????????unionid
                List<SxcustomerWxbind> sxcustomerWxbinds = sxPersonareaService.selectWxbindOpenid(openid);
                if(!unionid.equals("??????????????????")){
                    String cvalues = "";    //????????????????????????????????????????????????????????????????????????????????????
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
                        results = "??????????????????????????????????????????";
                    }else {
                        if (sxcustomerWxbinds.size()<=wxshul){    //???????????????????????????????????????????????????????????????????????????
                            int count = sxPersonareaService.insertCustomerWx(ccus_id,openid,unionid);
                            results = count>0?"???????????????":"??????????????????????????????";
                        }else {
                            results = "??????????????????????????????????????????????????????";
                        }
                    }
                }else {
                    results = "unionid????????????????????????";
                }
            }else {
                results = "????????????";
                logger.info("??????????????????????????????");
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
     * ????????????????????????ccus_id ???openid ??????????????????
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
                int wxshul = Integer.parseInt(sxPersonareaService.getInformCvalues("wxbindmax"));  //??????????????????????????????????????????
                List<SxcustomerWxbind> sxcustomerWxbinds = sxPersonareaService.selectWxbindOpenid(openid);
                String unionid = userInfoUtil.getInfoById(openid); //?????????unionid
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
                        results = "??????????????????????????????????????????";
                    }else {
                        if (sxcustomerWxbinds.size()<=wxshul){    //???????????????????????????????????????????????????????????????????????????
                            int count = sxPersonareaService.insertCustomerWx(ccus_id,openid,unionid);
                            results = count>0?"????????????":"??????????????????????????????";
                        }else {
                            results = "??????????????????????????????????????????????????????";
                        }
                    }
                }else {
                    results = "unionid????????????????????????";
                }
            }else {
                results = "??????????????????????????????";
            }
            return baseApiService.setResultResultSuccess(results);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ??????????????????????????????????????????
     * @param request
     * @param parameterDto
     * @return
     *
     * 1?????????????????????????????????????????????????????????????????????unionid?????????,????????????????????????
     * 2???????????????????????????????????????????????????????????????????????????????????????????????????unionid????????????????????????
     *    ?????????????????????????????????
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
                    //???????????????????????????????????????????????????????????????????????????????????????????????????????????????
                    str = "{\"ctype\":\"unionidlookup\",\"unionid\":\""+unionid+"\"}";
                    String reulst = CallUrl.post("http://emall.hnsxtj.com/leadtotal/leadtotal.php",str);
                    JSONObject jsonObj2 = (JSONObject)(new JSONParser().parse(reulst));
                    String msg = jsonObj2.get("msg").toString();
                    if (msg.equals("1")){  //?????????
                        logger.info("?????????");
                        String datas = jsonObj2.get("datas").toString();
                        String cc = datas.substring(datas.indexOf("[")+1, datas.lastIndexOf("]"));
                        JSONObject jsonObj3 = (JSONObject)(new JSONParser().parse(cc));
                        ccode = jsonObj3.get("ccode").toString();
                        if (unionid.equals("")){
                            ccode = "";
                        }
                    }else if (msg.equals("0")){  //?????????
                        logger.info("?????????");
                        String info = "{\"ctype\":\"wxunionid\",\"unionid\":\""+unionid+"\",\"userid\":\""+userid+"\"}";
                        String reslt = CallUrl.post("http://emall.hnsxtj.com/leadtotal/leadtotal.php",info);
                        JSONObject jsonObj3 = (JSONObject)(new JSONParser().parse(reslt));
                        String msg2 = jsonObj3.get("msg").toString();
                        if(msg2.equals("1")){
                            logger.info("???????????????");
                            ccode = userid;
                        }
                    }
                }
                if(userid.equals("") && !code.equals("")){
                    //??????userid??????code??????????????????unionid?????????userid
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
     * ????????????????????????
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
            logger.info("???????????????????????????"+ddate+"/"+cperson_id+"/"+ccomcode);
            return baseApiService.setResultResultSuccess(printLogDtos);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ???????????????token
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
        beforeTime.add(Calendar.MINUTE, -1);// 1?????????????????????
        Date beforeD = beforeTime.getTime();
        String before1 = new SimpleDateFormat("yyyyMMddHHmm").format(beforeD);
        String today2 = "hnsxtj"+before1;
        String md5key2 = MD5.MD5Encode(today2,"UTF-8"); //???????????????key
        try {
            if(md5key.equals(ckey)){ //??????????????????key??????
                token = userInfoUtil.getAccessToken();
            }else {
                if (md5key2.equals(ckey)){  //??????????????????key??????
                    token = userInfoUtil.getAccessToken();
                }else {
                    token = "key????????????";
                }
            }
           return token;
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ??????code??????openid????????????openid??????ccuserid???cunitid
     * @param parameterDto
     * @return
     */
    @RequestMapping("/getGzhOpneid")
    public Object getGzhOpneid(@RequestBody ParameterDto parameterDto){
        String code = parameterDto.getCode();
        String ctype = parameterDto.getCtype();  //define ????????? saleonline ????????????
        try {
            if (ctype==null){  //ctype??????????????????????????????define
                ctype = "define";
            }
            String openid = userInfoUtil.getGzOpenid(code);
            List<SxcustomerWxbind> sxcustomerWxbind = sxPersonareaService.selectWxbindOpenid2(openid);
            if (sxcustomerWxbind.size()>0){   //????????????????????????????????? ????????????????????????openid
                for (SxcustomerWxbind wxbind : sxcustomerWxbind) {   //?????????????????????ckey
                    String ccusid = Integer.toString(wxbind.getCcusid());
                    String copenid = wxbind.getCopenid();
                    wxlogindataDto wxlogindataDto = sxPersonareaService.exchangeCkey(ccusid,copenid);
                    wxbind.setCkey(wxlogindataDto.getCkey());
                }
                return baseApiService.setResultResultSuccess(sxcustomerWxbind);
            }
            //??????????????????????????????????????????ctype?????????????????????
            if (ctype.equals("saleonline")){    //??????????????????????????????????????????
                List<TouristDto> touristDtoList = sxPersonareaService.selectTouristInfo();
                for (TouristDto touristDto : touristDtoList) {
                     String ccusid = Integer.toString(touristDto.getCcus_id());
                     wxlogindataDto wxlogindataDto = sxPersonareaService.exchangeCkey(ccusid,openid);
                     touristDto.setCopenid(openid);
                     touristDto.setCkey(wxlogindataDto.getCkey());
                }
                return baseApiService.setResultResultSuccess(touristDtoList);
            }else{    //??????
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
     * ??????openid??????????????????????????????????????????
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
     * ??????????????????
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
                result = count2>0?"????????????":"????????????";
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    /**
     * ??????????????????  1 ????????? 0 ?????????
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
