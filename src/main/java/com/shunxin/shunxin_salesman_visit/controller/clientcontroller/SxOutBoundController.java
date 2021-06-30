package com.shunxin.shunxin_salesman_visit.controller.clientcontroller;


import com.shunxin.shunxin_salesman_visit.dto.clientdto.ParameterDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.SoorderDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.SxOutBoundDto;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.SxOutRetained;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxOutboundService;
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
@RequestMapping("/api/sxOutBound")
public class SxOutBoundController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SxOutboundService sxOutboundService;
    @Autowired
    private BaseApiService baseApiService;


    /**
     * 新增出库清单
     * @param
     * @return
     */
    @RequestMapping("/addOutBoundLists")
    public Object addOutBoundList(@RequestBody ParameterDto parameterDto){
        String jsonvist = parameterDto.getJsonvist();
        String result = "";
        try {
            List<ResultDto> resultDtos = sxOutboundService.addOutBoundLists(jsonvist);
            for (ResultDto dto : resultDtos) {
                result = dto.getMsg();
            }
            logger.info("新增出库清单");
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询出库清单
     * @param sxOutBound
     * @return
     */
    @RequestMapping("/getOutBoundList")
    public Object getOutBoundList(@RequestBody SxOutBoundDto sxOutBound){
        String cperson_id = sxOutBound.getCperson_id();
        String ddate1 = sxOutBound.getDdate1();
        String ddate2 = sxOutBound.getDdate2();
        String cstate = sxOutBound.getCstate();
        String csotype = sxOutBound.getCsotype();
        try {
            List<SxOutRetained> sxOutBounds = sxOutboundService.getOutBoundList(cperson_id,ddate1,ddate2,cstate,csotype);
            logger.info("查询出库清单");
            return baseApiService.setResultResultSuccess(sxOutBounds);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询昨日留存
     * @param sxOutBound
     * @return
     */
    @RequestMapping("/getSxOutRetained")
    public Object getSxOutRetained(@RequestBody SxOutBoundDto sxOutBound){
        String cperson_id = sxOutBound.getCperson_id();
        try {
            List<SxOutRetained> retaineds = sxOutboundService.getSxOutRetained(cperson_id);
            logger.info("查询昨日留存");
            return baseApiService.setResultResultSuccess(retaineds);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 业务员修改出库申请
     * @return
     */
    @RequestMapping("/updateSxSoorder")
    public Object updateSxSoorder(@RequestBody SoorderDto soorder){
        String ctype = soorder.getCtype();
        String cperson_id = soorder.getCperson_id();
        String jsonvist = soorder.getJsonvist();
        String result = "";
        try {
            if (ctype.equals("01")){ //先查询
                List<SxOutRetained> sxSoorderList = sxOutboundService.getSxSoorderList(cperson_id);
                return baseApiService.setResultResultSuccess(sxSoorderList);
            }else { //修改
                int count = sxOutboundService.updateSxSoorder(jsonvist);
                result = count>0?"修改成功":"修改失败";
                return baseApiService.setResultResultSuccess(result);
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }

    }


    /**
     * 根据主管经理工号查询所管业务员的出库申请
     * @return
     */
    @RequestMapping("/getStaffpsnHold")
    public Object getStaffpsnHold(@RequestBody SoorderDto soorder){
        String ccode = soorder.getCcode();
        String cperson_id = soorder.getCperson_id();
        String ddate1 = soorder.getDdate1();
        String ddate2 = soorder.getDdate2();
        String cstate = soorder.getCstate();
        try {
            List<SxOutRetained> sxOutRetainedList = sxOutboundService.getStaffpsnHold(ccode,cperson_id,ddate1,ddate2,cstate);
            return baseApiService.setResultResultSuccess(sxOutRetainedList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 审核出库申请
     * @return
     */
    @RequestMapping("/checkStaffpsnHold")
    public Object checkStaffpsnHold(@RequestBody SoorderDto soorder){
        String jsonvist = soorder.getJsonvist();
        try {
            List<ResultDto> resultDtos = sxOutboundService.addOutBoundLists(jsonvist);
            String result = "";
            for (ResultDto dto : resultDtos) {
                result = dto.getMsg();
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * @Title: PC 端查询出库记录
     * @Description:
     * @author : yyang
     * @date : 9:41 2021/2/24
     * @return
     */
    @RequestMapping("/getStaffpsnList")
    public Object getStaffpsnList(@RequestBody SoorderDto soorder){
        String cperson_id = soorder.getCperson_id();
        String ccus_id = soorder.getCcus_id();
        String ddate1 = soorder.getDdate1();
        String ddate2 = soorder.getDdate2();
        String cstate = soorder.getCstate();
        try {
            List<SxOutRetained> sxOutRetainedList = sxOutboundService.getStaffpsnList(cperson_id,ccus_id,ddate1,ddate2,cstate);
            logger.info("PC端查询出库记录");
            return baseApiService.setResultResultSuccess(sxOutRetainedList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据客户编号查询出库申请单
     * @return
     */
    @RequestMapping("/getSxSoorderPlace")
    public Object getSxSoorderPlace(@RequestBody SoorderDto soorder){
        String ccus_id = soorder.getCcus_id();
        String cperson_id = soorder.getCperson_id();
        try {
            List<SxOutRetained> sxSoorderPlace = sxOutboundService.getSxSoorderPlace(cperson_id,ccus_id);
            return baseApiService.setResultResultSuccess(sxSoorderPlace);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



     /*@RequestMapping("/addOutBoundList")
    public Object addOutBoundList(@RequestBody ParameterDto parameterDto){
        String jsonvist = parameterDto.getJsonvist();
        List<SxOutBoundDto> sxOutBounds = new ArrayList<>();
        String result = "";
        try {
            JSONArray jsonArray = JSONArray.fromObject(jsonvist);
            for (Object obj : jsonArray) {
                SxOutBoundDto sxOutBound = new SxOutBoundDto();
                JSONObject jo = JSONObject.fromObject(obj.toString());
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
                String csocode = "ck"+sdf.format(date)+(new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000); //当前日期拼接四位随机数
                String imoney = String.valueOf(Integer.parseInt(jo.get("iquantity").toString())*Double.parseDouble(jo.get("iprice").toString()));
                sxOutBound.setCsocode(csocode);
                sxOutBound.setCperson_id(jo.get("cperson_id").toString());
                sxOutBound.setCstate(jo.get("cstate").toString());
                sxOutBound.setCcus_id(jo.get("ccus_id").toString());
                sxOutBound.setCsotype(jo.get("csotype").toString());
                sxOutBound.setCinvcode(jo.get("cinvcode").toString());
                sxOutBound.setIquantity(jo.get("iquantity").toString());
                sxOutBound.setIprice(jo.get("iprice").toString());
                sxOutBound.setImoney(imoney);
                sxOutBounds.add(sxOutBound);
            }
            int count = sxOutboundService.addOutBoundList(sxOutBounds);
            resu                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         lt = count>0?"保存成功":"保存失败";
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }*/





}
