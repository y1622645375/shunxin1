package com.shunxin.shunxin_salesman_visit.controller.signcontroller;


import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.signdto.CallCenterDto;
import com.shunxin.shunxin_salesman_visit.dto.signdto.CommonDto;
import com.shunxin.shunxin_salesman_visit.dto.signdto.PersonalCenter;
import com.shunxin.shunxin_salesman_visit.entity.signentity.IntegralRecord;
import com.shunxin.shunxin_salesman_visit.entity.signentity.SignCommod;
import com.shunxin.shunxin_salesman_visit.entity.signentity.SignRecord;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import com.shunxin.shunxin_salesman_visit.service.signservice.SignCenterService;
import com.shunxin.shunxin_salesman_visit.util.UserInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/signCenter")
public class SignCenterController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SignCenterService signCenterService;
    @Autowired
    private UserInfoUtil userInfoUtil;
    @Autowired
    private CheckService checkService;
    @Autowired
    private BaseApiService baseApiService;


    /**
     * 根据客户ID查询当前积分
     * @return
     */
    @RequestMapping("/selectSignIntegral")
    public Object selectSignIntegral(@RequestBody CommonDto commonDto){
        String integral_cid = commonDto.getIntegral_cid();
        String ckey = commonDto.getCkey();
        try {
            String result = checkService.charmKeyValidity("wxgzh",ckey,6);
            if (result.equals("1")){
                IntegralRecord integralRecord = signCenterService.selectSignIntegral(integral_cid);
                IntegralRecord record2 = signCenterService.getTodayIntegral(integral_cid);  //查询今日签到获得的积分
                if (integralRecord!=null){    //表示该客户有过积分记录，否则直接返回null
                    if (record2==null){
                        integralRecord.setIntegral_dr(0);
                    }else {
                        integralRecord.setIntegral_dr(record2.getIntegral_dr());
                    }
                }
                logger.info("根据客户ID查询当前积分");
                return baseApiService.setResultResultSuccess(integralRecord);
            }else {
                return baseApiService.setResultError("服务器繁忙");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据客户ID查询签到记录
     * @return
     */
    @RequestMapping("/selectSignRecord")
    public Object selectSignRecord(@RequestBody CommonDto commonDto){
        String csign_cid = commonDto.getCsign_cid();
        String ckey = commonDto.getCkey();
        try {
            String result = checkService.charmKeyValidity("wxgzh",ckey,6);
            if (result.equals("1")){
                List<SignRecord> signRecordList = signCenterService.selectSignRecord(csign_cid);
                if (signRecordList.size()>0){
                    for (SignRecord record : signRecordList) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String ddate = sdf.format(record.getSign_date());
                        long time = (new SimpleDateFormat("yyyy-MM-dd")).parse(ddate, new ParsePosition(0)).getTime() / 1000; //时间转时间戳
                        record.setTimestamp(time);
                    }
                }else {
                    signRecordList = null;
                }
                logger.info("根据客户ID查询签到记录");
                return baseApiService.setResultResultSuccess(signRecordList);
            }else {
                return baseApiService.setResultError("服务器繁忙");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询当前可兑换商品
     * @return
     */
    @RequestMapping("/selectCommodList")
    public Object selectCommodList(){
        try {
            List<SignCommod> signCommodList = signCenterService.selectCommodList();
            if (signCommodList.size()>0){
                for (SignCommod commod : signCommodList) {
                    commod.setCinvimg("http://pic.hnsxtj.com/sxemall/public/"+commod.getCinvimg()+"_500.jpg");
                }
            }else {
                signCommodList = null;
            }
            logger.info("查询当前可兑换商品");
            return baseApiService.setResultResultSuccess(signCommodList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 客户进行签到 （新接口）
     * @param commonDto
     * @return
     */
    @RequestMapping("/insertSignRecord")
    public Object insertSignRecord(@RequestBody CommonDto commonDto){
        String jsonvisit = commonDto.getJsonvisit();
        String ckey = commonDto.getCkey();
        try {
            String result = checkService.charmKeyValidity("wxgzh",ckey,6);
            if (result.equals("1")){
                ResultDto resultDtos = signCenterService.insertSignRecord(jsonvisit);
                return baseApiService.setResultResultSuccess(resultDtos);
            }else {
                return baseApiService.setResultError("服务器繁忙");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询签到或兑换积分记录
     * @return
     */
    @RequestMapping("/selectCreditsExchange")
    public Object selectCreditsExchange(@RequestBody CommonDto commonDto){
        String integral_type = commonDto.getIntegral_type();
        String integral_cid = commonDto.getIntegral_cid();
        String ckey = commonDto.getCkey();
        try {
            String result = checkService.charmKeyValidity("wxgzh",ckey,6);
            if (result.equals("1")){
                List<IntegralRecord> integralRecordList = new ArrayList<>();
                if (integral_type.equals("exchange")){   //兑换积分记录
                    integralRecordList = signCenterService.selectCommodExchange(integral_type,integral_cid);
                }else {   //兑换以外的积分记录
                    integralRecordList = signCenterService.selectCreditsExchange(integral_type,integral_cid);
                    for (IntegralRecord record : integralRecordList) {
                        if(record.getIntegral_type().equals("signday")){
                            record.setCcus_name("签到");
                        }else if (record.getIntegral_type().equals("fllow")){
                            record.setCcus_name("拜访");
                        }else if (record.getIntegral_type().equals("order")){
                            record.setCcus_name("订单");
                        }
                    }
                }
                logger.info("查询签到或兑换积分记录");
                return baseApiService.setResultResultSuccess(integralRecordList);
            }else {
                return baseApiService.setResultError("服务器繁忙");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    /**
     * 兑换商品（新接口）
     * @return
     *{"jsonvisit":"{\"busiid\":\"4\",\"openid\":\"o2-KHwNgniuKAtA7l1ADInc5Smhw\",\"ctype\":\"exchange\"}"}
     */
    @RequestMapping("/integralExchange")
    public Object integralExchange(@RequestBody CommonDto commonDto){
        String jsonvisit = commonDto.getJsonvisit();
        String ckey = commonDto.getCkey();
        try {
            String result = checkService.charmKeyValidity("wxgzh",ckey,6);
            if (result.equals("1")){
                ResultDto resultDtos = signCenterService.insertSignRecord(jsonvisit);
                return baseApiService.setResultResultSuccess(resultDtos);
            }else {
                return baseApiService.setResultError("服务器繁忙");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    /**
     * 兑换商品（老接口，已停用）
     * @return
     */
    @RequestMapping("/procommodExchange")
    public Object  procommodExchange(@RequestBody IntegralRecord integralRecord){
        int autoid = integralRecord.getAutoid();
        String integral_cid = integralRecord.getIntegral_cid();
        String result = "";
        try {
            if (integral_cid!=null&&!integral_cid.equals("")){
                IntegralRecord record = signCenterService.selectSignIntegral(integral_cid);  //查询当前积分
                SignCommod signCommod = signCenterService.getSignCommods(autoid);  //查询兑换商品
                int integral_ye = 0;
                if (record!=null){
                    integral_ye = record.getIntegral_ye();
                }
                if (integral_ye>=signCommod.getNeed_integral()){   //当前积分大于商品所需积分
                    if (signCommod.getIquan()>0){
                        int integral_cr = signCommod.getNeed_integral();
                        int quantity = signCenterService.updateCommodQuan(signCommod.getIquan()-1,signCommod.getRquan()+1,autoid);
                        if (quantity>0){
                            int count = signCenterService.addIntegralCommod(integral_cid,"exchange",0,integral_cr,integral_ye-integral_cr,autoid);
                            result = count>0?"兑换成功":"兑换失败";
                            return baseApiService.setResultResultSuccess(result);
                        }else {
                            return baseApiService.setResultResultSuccess("商品库存不足，兑换失败");
                        }
                    }else {
                        return baseApiService.setResultResultSuccess("商品库存不足，兑换失败");
                    }
                }else {
                    return baseApiService.setResultResultSuccess("积分不足，兑换失败");
                }
            }else {
                return baseApiService.setResultResultSuccess("未绑定商户，无法兑换");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 客户手动领取积分后，积分发生改变
     * @return
     */
    @RequestMapping("/updateIntegral")
    public Object updateIntegral(@RequestBody CommonDto commonDto){
        String jsonvisit = commonDto.getJsonvisit();
        //String ckey = commonDto.getCkey();
        try {
//            String result = checkService.charmKeyValidity("wxgzh",ckey,6);
//            if (result.equals("1")){
                ResultDto resultDtos = signCenterService.insertSignRecord(jsonvisit);
                return baseApiService.setResultResultSuccess(resultDtos);
//            }else {
//                return baseApiService.setResultError("服务器繁忙");
//            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 通过微信openid获取用户头像
     * @param centerDto
     * @return
     */
    @RequestMapping("/getHeadimgurl")
    public Object getHeadimgurl(@RequestBody CallCenterDto centerDto){
        String openid = centerDto.getCopenid();
        try {
            List<PersonalCenter> personalCenters = signCenterService.selectPersonal(openid);
            for (PersonalCenter center : personalCenters) {
                String headimgurl = userInfoUtil.getHeadimgurl(openid);
                center.setHeadimgurl(headimgurl);
            }
            return baseApiService.setResultResultSuccess(personalCenters);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }




}
