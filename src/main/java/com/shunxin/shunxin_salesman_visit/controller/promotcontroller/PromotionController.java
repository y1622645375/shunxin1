package com.shunxin.shunxin_salesman_visit.controller.promotcontroller;

import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.PromotionDto;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.Inventory2;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.Promotion;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.SacxHold;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.ZpcinvCode;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.Upload_pictures;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxPersonareaService;
import com.shunxin.shunxin_salesman_visit.service.promotservice.PromotionService;
import net.sf.json.JSONObject;
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
@RequestMapping("/api/promotion")
public class PromotionController {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private PromotionService promotionService;
    @Autowired
    private SxPersonareaService sxPersonareaService;
    @Autowired
    private CheckService checkService;
    @Autowired
    private BaseApiService baseApiService;


    /**
     * 查询促销商品列表
     * @return
     */
    @RequestMapping("/selectPromotion")
    public Object selectPromotion(@RequestBody PromotionDto promotionDto){
        String cusercode = promotionDto.getCusercode();
        String ddate = promotionDto.getDdate();
        String istate = promotionDto.getIstate();
        /*String cuserid = promotionDto.getCuserid();
        String ckey = promotionDto.getCkey();
        int ilogin_type = promotionDto.getIlogin_type();*/
        try {
            //String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            //if (results2.equals("1")){
                List<Promotion> promotionList = promotionService.selectPromotion(cusercode,ddate,istate);
                return baseApiService.setResultResultSuccess(promotionList);
            /*}else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }*/
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 新增促销活动
     * @param promotionDto
     * @return
     */
    @RequestMapping("/addPromotion")
    public Object addPromotion(@RequestBody PromotionDto promotionDto){
        String jsonvist = promotionDto.getJsonvist();
        String cuserid = promotionDto.getCuserid();
        String ckey = promotionDto.getCkey();
        int ilogin_type = promotionDto.getIlogin_type();
        JSONObject jsonObject =JSONObject.fromObject(jsonvist);
        String sacximg = jsonObject.get("sacximg").toString();  //获取到图片的base64编码
        Upload_pictures upload_pictures = new Upload_pictures();
        String fileUrl = "E:\\wwwroot\\pic\\sxemall\\public\\sacx";
        String path = upload_pictures.upload(sacximg,fileUrl);    //保存图片
        String imgurl = path.substring(path.lastIndexOf("\\")+1);
        if (jsonObject.get("sacximg") != null) {
            jsonObject.put("sacximg", imgurl);
        }
        logger.info("结果是："+jsonObject.toString());
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<ResultDto> resultDtos = promotionService.addPromotion(jsonObject.toString());
                logger.info("新增促销活动:"+resultDtos);
                return baseApiService.setResultResultSuccess(resultDtos);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 修改促销活动
     * @param promotionDto
     * @return
     */
    @RequestMapping("/updatePromotion")
    public Object updatePromotion(@RequestBody PromotionDto promotionDto){
        String jsonvist = promotionDto.getJsonvist();
        String cuserid = promotionDto.getCuserid();
        String ckey = promotionDto.getCkey();
        int ilogin_type = promotionDto.getIlogin_type();
        JSONObject jsonObject =JSONObject.fromObject(jsonvist);
        String sacximg = jsonObject.get("sacximg").toString();  //获取到图片的base64编码
        if (sacximg.contains("data:")){  //包含data则为64编码
            Upload_pictures upload_pictures = new Upload_pictures();
            String fileUrl = "E:\\wwwroot\\pic\\sxemall\\public\\sacx";
            String path = upload_pictures.upload(sacximg,fileUrl);    //保存图片
            String imgurl = path.substring(path.lastIndexOf("\\")+1);
            if (jsonObject.get("sacximg") != null) {
                jsonObject.put("sacximg", imgurl);
            }
        }
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<ResultDto> resultDtos = promotionService.updatePromotion(jsonObject.toString());
                logger.info("修改促销活动:"+resultDtos);
                return baseApiService.setResultResultSuccess(resultDtos);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 审核促销活动
     * @param promotionDto
     * @return
     */
    @RequestMapping("/checkPromotion")
    public Object checkPromotion(@RequestBody PromotionDto promotionDto){
        String jsonvist = promotionDto.getJsonvist();
        String cuserid = promotionDto.getCuserid();
        String ckey = promotionDto.getCkey();
        int ilogin_type = promotionDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<ResultDto> resultDtos = promotionService.checkPromotion(jsonvist);
                logger.info("审核促销活动:"+resultDtos);
                return baseApiService.setResultResultSuccess(resultDtos);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 作废该促销活动
     * @param promotionDto
     * @return
     */
    @RequestMapping("/invalidPromotion")
    public Object invalidPromotion(@RequestBody PromotionDto promotionDto){
        String jsonvist = promotionDto.getJsonvist();
        String cuserid = promotionDto.getCuserid();
        String ckey = promotionDto.getCkey();
        int ilogin_type = promotionDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<ResultDto> resultDtos = promotionService.invalidPromotion(jsonvist);
                logger.info("作废该促销活动:"+resultDtos);
                return baseApiService.setResultResultSuccess(resultDtos);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据id查询单条数据
     * @param promotion
     * @return
     */
    @RequestMapping("/selectPromoOne")
    public Object selectPromoOne(@RequestBody PromotionDto promotion){
        String sacxid = promotion.getSacxid();
        String cusercode = promotion.getCusercode();
        try {
            List<Promotion> promotionList = promotionService.selectPromoOne(cusercode,sacxid);
            List<SacxHold> promotionList2 = promotionService.selectSacxHold(sacxid);
            List<ZpcinvCode> promotionList3 = promotionService.selectZpCinvName("02",sacxid);
            for (Promotion promotion1 : promotionList) {
                promotion1.setSacxHolds(promotionList2);
                promotion1.setZpcinvCodes(promotionList3);
            }
            return baseApiService.setResultResultSuccess(promotionList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据活动编号查询客户类型详细
     * @param promotion
     * @return
     */
    @RequestMapping("/selectSacxHold")
    public Object selectSacxHold(@RequestBody Promotion promotion){
        String sacxid = promotion.getSacxid();
        try {
            List<SacxHold> promotionList = promotionService.selectSacxHold(sacxid);
            return baseApiService.setResultResultSuccess(promotionList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据活动编号查询赠品详细
     * @param promotion
     * @return
     */
    @RequestMapping("/selectZpCinvName")
    public Object selectZpCinvName(@RequestBody PromotionDto promotion){
        String ctype = "02";
        String sacxid = promotion.getSacxid();
        try {
            List<ZpcinvCode> promotionList = promotionService.selectZpCinvName(ctype,sacxid);
            logger.info("根据活动编号查询赠品详细:"+sacxid);
            return baseApiService.setResultResultSuccess(promotionList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 商家查询某商品的优惠
     * @param promotionDto
     * @return
     */
    @RequestMapping("/getZpSacxCount")
    public Object getZpSacxCount(@RequestBody PromotionDto promotionDto){
        String ctype = "01";
        //String cuser_id = promotionDto.getCuser_id();  //业务员ID
        String ccus_id = promotionDto.getCcus_id();    //商家ID
        String cinvcode = promotionDto.getCinvcode();
        int iquan = promotionDto.getIquan();
        try {
            String cuser_id = promotionService.getCpersonIds(ccus_id);  //根据商家ID查询业务员ID
            String ccomcode = sxPersonareaService.selectCompand(cuser_id);  //通过业务员编号查询所属公司
            List<ZpcinvCode> zpcinvCodeList = promotionService.getZpSacxCount(ctype,ccomcode,ccus_id,cinvcode,iquan);
            logger.info("商家查询某商品的优惠："+cuser_id+"=="+ccus_id+"=="+cinvcode+"=="+iquan);
            return baseApiService.setResultResultSuccess(zpcinvCodeList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询所有商品
     * @return
     */
    @RequestMapping("/selectInvent2")
    public Object  selectInvent2(@RequestBody PromotionDto promotionDto){
        String cinvname = promotionDto.getCinvname();
        String cuserid = promotionDto.getCuserid();
        String ckey = promotionDto.getCkey();
        int ilogin_type = promotionDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<Inventory2> inventoryList = promotionService.selectInvent2(cinvname);
                return baseApiService.setResultResultSuccess(inventoryList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



}
