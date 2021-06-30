package com.shunxin.shunxin_salesman_visit.controller.promotcontroller;

import com.shunxin.shunxin_salesman_visit.dto.promotdto.PromotionDto;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.RelationDto;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.AppDinwei;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.Relation;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.ScanLog;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import com.shunxin.shunxin_salesman_visit.service.eatbarservice.EatBarService;
import com.shunxin.shunxin_salesman_visit.service.promotservice.RelationService;
import com.shunxin.shunxin_salesman_visit.util.CallUrl;
import com.shunxin.shunxin_salesman_visit.util.UserInfoUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
@RequestMapping("/api/relation")
public class RelationController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RelationService relationService;

    @Autowired
    private BaseApiService baseApiService;
    @Autowired
    private CheckService checkService;
    @Autowired
    private UserInfoUtil userInfoUtil;
    @Autowired
    private EatBarService eatBarService;


    /**
     * 根据当前位置查询业务员
     * @return
     */
    @RequestMapping("/selectAreaSalesman")
    public Object selectAreaSalesman(@RequestBody PromotionDto promotionDto){
        String jsonvist = promotionDto.getJsonvist();
        logger.info("根据当前位置查询业务员,参数："+jsonvist);
        try {
            List<Relation> relationList = relationService.selectAreaSalesman(jsonvist);
            String qywxToken = userInfoUtil.getQywxToken();
            for (Relation relation : relationList) {
                if (!relation.getCperson_id().equals("")){
                    String SalesmanInfo = CallUrl.sendGet("https://qyapi.weixin.qq.com/cgi-bin/user/get","access_token="+qywxToken+"&userid="+relation.getCperson_id());
                    JSONObject jsonObj2 = (JSONObject) (new JSONParser().parse(SalesmanInfo));
                    String headImg = "";
                    if (jsonObj2.get("thumb_avatar")!=null){
                        headImg = jsonObj2.get("thumb_avatar").toString();
                    }
                    relation.setHeadimg(headImg);
                }else {
                    relation.setHeadimg("http://emall.hnsxtj.com/gzh/myinfo/img/ywytubiao.png");
                }
            }
            return baseApiService.setResultResultSuccess(relationList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据工号绑定openid
     * @param relationDto
     * @return
     */
    @RequestMapping("/bandStaffOpenid")
    public Object bandStaffOpenid(@RequestBody RelationDto relationDto){
        String result = "";
        String copenid = relationDto.getCopenid();
        String ccode = relationDto.getCcode();
        try {
            int shuli = relationService.selectWxopenidso(copenid);
            if (shuli<1){
                String cname = eatBarService.getCname(ccode);
                int count = relationService.addStaffOpenid(ccode,copenid,cname);
                result = count >0?"绑定成功":"绑定失败";
            }else {
                result = "该微信已绑定";
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询扫码时的经纬度
     * @return
     */
    @RequestMapping("/selectSxDinweiLogs")
    public Object selectSxDinweiLogs(@RequestBody PromotionDto promotionDto){
        String ddate1 = promotionDto.getDdate1()+" 00:00:00";
        String ddate2 = promotionDto.getDdate2()+" 23:59:59";
        try {
            List<AppDinwei> appDinweiList = relationService.selectSxDinweiLogs(ddate1,ddate2);
            return baseApiService.setResultResultSuccess(appDinweiList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询客户扫码记录
     * @return
     */
    @RequestMapping("/ScanRecordLog")
    public Object ScanRecordLog(@RequestBody PromotionDto promotionDto){
        String ddate1 = promotionDto.getDdate1();
        String ddate2 = promotionDto.getDdate2();
        String cuserid = promotionDto.getCuserid();
        String ckey = promotionDto.getCkey();
        int ilogin_type = promotionDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<ScanLog> scanLogList = relationService.ScanRecordLog(ddate1,ddate2);
                return baseApiService.setResultResultSuccess(scanLogList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据openid查询工号
     * @return
     */
    @RequestMapping("/getStaffOpenid")
    public Object getStaffOpenid(@RequestBody RelationDto relationDto){
        String wxopenid = relationDto.getWxopenid();
        try {
            String ccode = relationService.getStaffOpenid(wxopenid);
            if (ccode==null){
                ccode = "";
            }
            return baseApiService.setResultResultSuccess(ccode);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


}
