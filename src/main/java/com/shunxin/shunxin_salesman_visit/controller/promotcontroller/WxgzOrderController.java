package com.shunxin.shunxin_salesman_visit.controller.promotcontroller;


import com.shunxin.shunxin_salesman_visit.dto.clientdto.OrdervDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.ReqDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.SxOrderGift;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.*;
import com.shunxin.shunxin_salesman_visit.dto.signdto.CommonDto;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.SxcustomerWxbind;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.PriceEnter;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.WxgzFllowVist;
import com.shunxin.shunxin_salesman_visit.entity.signentity.Information;
import com.shunxin.shunxin_salesman_visit.entity.signentity.IntegralRecord;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxPersonareaService;
import com.shunxin.shunxin_salesman_visit.service.promotservice.WxgzOrderService;
import com.shunxin.shunxin_salesman_visit.service.signservice.SignCenterService;
import com.shunxin.shunxin_salesman_visit.util.DistanceUtils;
import com.shunxin.shunxin_salesman_visit.util.UserInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/wxgzOrder")
public class WxgzOrderController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WxgzOrderService wxgzOrderService;
    @Autowired
    private BaseApiService baseApiService;
    @Autowired
    private UserInfoUtil userInfoUtil;
    @Autowired
    private SignCenterService signCenterService;
    @Autowired
    private SxPersonareaService personareaService;
    @Autowired
    private CheckService checkService;

    /**
     * ?????????????????????????????????????????????
     * @param ordervDto
     * @return
     */
    @RequestMapping("/getOrderList")
    public Object getOrderList(@RequestBody OrdervDto ordervDto){
        String ccus_id = ordervDto.getCcus_id();       //????????????
        String ddate2 = ordervDto.getDdate2();         //???????????????????????????
        String csocode = ordervDto.getCsocode();       //????????????(???????????????)
        String cso_state = ordervDto.getCso_state();   //01 ????????? 02 ????????? 03 ?????????  99 ?????????  09 ?????????
        String ckey = ordervDto.getCkey();
        try {
            String result = checkService.charmKeyValidity("wxgzh",ckey,6);
            if (1 == 1){
                List<OrdervDto> ordervDtoList = wxgzOrderService.getOrderList(ccus_id,ddate2,csocode,cso_state);
                for (OrdervDto dto : ordervDtoList) {
                    int autoid = dto.getAutoid();
                    List<SxOrderGift> sxOrderGiftList = personareaService.getSxOrderGift(autoid);
                    dto.setOrderGifts(sxOrderGiftList);
                }
                Information information = signCenterService.selectInformation("order_integral_aging");
                int aging = Integer.parseInt(information.getCvalue());   //?????????????????????
                for (OrdervDto dto : ordervDtoList) {
                    if (dto.getCso_state().equals("99")){  //????????????????????????????????????
                        Date dt = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String endTime = sdf.format(dto.getDdate());    //??????????????????
                        Date date = new Date(sdf.parse(endTime).getTime()+aging*24*3600*1000);
                        String correct = DistanceUtils.comparetoTime(sdf.format(dt),sdf.format(date));  //??????????????????????????????????????????????????????????????????true,????????????false
                        IntegralRecord integralRecord = signCenterService.selectOrderIntegral(dto.getAutoid());
                        if (correct.equals("true")){
                            if (integralRecord==null) {
                                dto.setIntegral_result("?????????");
                            }
                        }
                    }
                }
                return baseApiService.setResultResultSuccess(ordervDtoList);
            }else {
                return baseApiService.setResultError("???????????????");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ???????????????????????????????????????
     * @return
     */
    @RequestMapping("/getFllowList")
    public Object getFllowList(@RequestBody CommonDto commonDto){
        String cfllow_cid = commonDto.getCfllow_cid();
        String ckey = commonDto.getCkey();
        try {
            String result = checkService.charmKeyValidity("wxgzh",ckey,6);
            if (result.equals("1")){
                List<WxgzFllowVist> wxgzFllowVists = wxgzOrderService.getFllowList(cfllow_cid);
                for (WxgzFllowVist fllowVist : wxgzFllowVists) {
                    int fllowid = fllowVist.getAutoid();
                    List<CImagePathDto> cImagePathDtoList = wxgzOrderService.getCimgPath(fllowid);
                    List<String> lists = new ArrayList<>();
                    for (CImagePathDto pathDto : cImagePathDtoList) {
                        String cimg_poth = "http://pic.hnsxtj.com/sxemall/"+pathDto.getCimg_path();
                        lists.add(cimg_poth);
                        fllowVist.setCimg_path(lists);
                    }
                    Date dt = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String endTime = sdf.format(fllowVist.getDfllow_end_time());     //?????????????????????
                    Date date = new Date(sdf.parse(endTime).getTime()+168*3600*1000);
                    String correct = DistanceUtils.comparetoTime(sdf.format(dt),sdf.format(date));  //??????????????????????????????????????????????????????????????????true,????????????false
                    IntegralRecord integralRecord = signCenterService.selectFllowIntegral(fllowid);
                    if (correct.equals("true")){
                        if (integralRecord==null) {
                            fllowVist.setIntegral_result("?????????");
                        }
                    }
                }
                return baseApiService.setResultResultSuccess(wxgzFllowVists);
            }else {
                return baseApiService.setResultError("???????????????");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ???????????????????????????????????????????????????????????????
     * @return
     */
    @RequestMapping("/getCommodityNewPrice")
    public Object getCommodityNewPrice(@RequestBody OrdervDto ordervDto){
        String ccus_id = ordervDto.getCcus_id();
        try {
            List<PriceEnter> priceEnters = wxgzOrderService.getCommodityNewPrice(ccus_id);
            return baseApiService.setResultResultSuccess(priceEnters);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ????????????????????????
     * @return
     */
    @RequestMapping("/getExaminingReport")
    public Object getExaminingReport(@RequestBody PromotionDto promotionDto){
        int autoid = promotionDto.getAutoid();
        String ctype = promotionDto.getCtype();
        try {
            List<ExaminingDto> examiningDtos = wxgzOrderService.getExaminingReport(autoid,ctype);
            if (ctype.equals("pay_anomaly")){
                int autoid2 = (autoid+2871)/6892;
                String dtime = wxgzOrderService.getTempdbDtime(autoid2);
                String ddate = dtime.substring(0,10);
                for (ExaminingDto examiningDto : examiningDtos) {
                    examiningDto.setDdate(ddate);
                }
            }else {
                for (ExaminingDto examiningDto : examiningDtos) {
                  String ddate = examiningDto.getDdate().substring(0,16);
                  examiningDto.setDdate(ddate);
                }
            }
            return baseApiService.setResultResultSuccess(examiningDtos);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * ???????????????openid???????????????????????????????????????
     * @return
     */
    @RequestMapping("/getInfoByIds")
    public Object getInfoByIds(@RequestBody ReqDto reqDto){
        String openid = reqDto.getOpenid();
        try {
            String utilid = userInfoUtil.getInfoById(openid);
            String result = utilid.equals("")?"?????????":"?????????";
            return baseApiService.setResultResultSuccess(result);
        }catch(Exception e){
            e.printStackTrace();
            return baseApiService.setResultResultSuccess(e.toString());
        }
    }


    /**
     * ?????????????????????
     * @param reqDto
     * @return
     */
    @RequestMapping("/selectUnpaidOrder")
    public Object selectUnpaidOrder(@RequestBody ReqDto reqDto){
        String cperson_id = reqDto.getCperson_id();
        try {
            List<UnpaidOrderDto> unpaidOrderDtoList = wxgzOrderService.selectUnpaidOrder(cperson_id);
            for (UnpaidOrderDto unpaidOrderDto : unpaidOrderDtoList) {
                String ccusid = unpaidOrderDto.getCcus_id();
                List<OrderWxbands> orderWxbands = wxgzOrderService.getOrderWxbind(ccusid);
                unpaidOrderDto.setCust(orderWxbands);
            }
            return baseApiService.setResultResultSuccess(unpaidOrderDtoList);
        }catch(Exception e){
            e.printStackTrace();
            return baseApiService.setResultResultSuccess(e.toString());
        }
    }


    /**
     * ????????????ID??????????????????????????????
     * @return
     */
    @RequestMapping("/getCcusidBind")
    public Object getCcusidBind(@RequestBody CommonDto commonDto){
        String ccusid = commonDto.getCcusid();
        String result = "";
        String copenid = "";
        try {
            int count = personareaService.getCcusidBind(ccusid);
            result = count>0?"?????????":"?????????";
            if (result.equals("?????????")){
                List<SxcustomerWxbind> sxcustomerWxbinds = personareaService.selectCopenid(ccusid);
                for (SxcustomerWxbind wxbind : sxcustomerWxbinds) {
                    copenid = wxbind.getCopenid();
                }
                String unionid = userInfoUtil.getInfoById(copenid);
                if (unionid.equals("??????????????????")){
                    result = "?????????";
                }else {
                    result = "?????????";
                }
            }
            return baseApiService.setResultResultSuccess(result);
        }catch(Exception e){
            e.printStackTrace();
            return baseApiService.setResultResultSuccess(e.toString());
        }
    }



}
