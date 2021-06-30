package com.shunxin.shunxin_salesman_visit.controller.signcontroller;

import com.shunxin.shunxin_salesman_visit.dto.signdto.CallCenterDto;
import com.shunxin.shunxin_salesman_visit.entity.signentity.CallCenter;
import com.shunxin.shunxin_salesman_visit.entity.signentity.Information;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.signservice.CallCenterService;
import com.shunxin.shunxin_salesman_visit.service.signservice.SignCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 微信公众号客服系统
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/callCenter")
public class CallCenterController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CallCenterService callCenterService;
    @Autowired
    private SignCenterService signCenterService;
    @Autowired
    private BaseApiService baseApiService;


    /**
     * 根据 openid 获取近七天的聊天记录
     * @return
     */
    @RequestMapping("/selectCallService")
    public Object selectCallService(@RequestBody CallCenterDto callCenter){
        String copenid = callCenter.getCopenid();
        String ctype = callCenter.getCtype();
        String csource = callCenter.getCsource();
        List<CallCenter> callCenterList = new ArrayList<>();
        try {
            Information informationList = signCenterService.selectInformation("cusservice_msgtime");
            String cvalue = informationList.getCvalue();
            if (ctype.equals("all")){   //获取所有的聊天记录
                callCenterList = callCenterService.selectAllService(copenid);
                logger.info("根据 openid 获取所有的聊天记录");
            }else {   //获取近七天的聊天记录
                callCenterList = callCenterService.selectCallService(copenid);
                logger.info("根据 openid 获取近七天的聊天记录");
            }
            if (callCenterList.size()!=0&&csource.equals("company")){  //更新客服在线的最后时间
                callCenterService.updateCdefine5(copenid);
            }
            for (CallCenter center : callCenterList) {
                center.setCdefine1(cvalue);
            }
            return baseApiService.setResultResultSuccess(callCenterList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 发送消息
     * @return
     */
    @RequestMapping("/insertCallService")
    public Object insertCallService(@RequestBody CallCenterDto callCenter){
        String copenid = callCenter.getCopenid();
        String csource = callCenter.getCsource();
        String cmsgtext = callCenter.getCmsgtext();
        String result = "";
        try {
            Date date = callCenterService.selectMaxCdefine5(copenid);
            if (date==null){
                Date date2 = stepMonth(new Date(), -1);
                date = date2;
            }
            Information informationList2 = signCenterService.selectInformation("cusservice_msgtime");
            int cvalue2 = Integer.parseInt(informationList2.getCvalue());
            Date now = new Date();
            Date now_10 = new Date(now.getTime() - cvalue2*2*1000); //10秒前的时间
            int compareTo = now_10.compareTo(date);
            int count = callCenterService.insertCallService(copenid,csource,cmsgtext);
            result = count>0?"发送成功":"发送失败";
            if (compareTo==1){   //说明客服超过10秒未获取新的信息
                if (result.equals("发送成功")&&csource.equals("customer")){
                    Information informationList = signCenterService.selectInformation("cusservice_person");
                    String cvalue = informationList.getCvalue();
                    String str [] = cvalue.split(",");
                    for (String sname : str) {
                        callCenterService.sendMessages(sname,"收到客户的信息，请点击链接查看 http://emall.hnsxtj.com/gzh/myinfo/customeservice.html?openid="+copenid);
                    }
                }
                logger.info(copenid+"发送消息,"+result);
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }

    //两个时间对比大小
    public static Date stepMonth(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }




}
