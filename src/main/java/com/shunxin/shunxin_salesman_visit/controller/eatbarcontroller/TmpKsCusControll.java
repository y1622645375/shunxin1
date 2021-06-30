package com.shunxin.shunxin_salesman_visit.controller.eatbarcontroller;


import com.shunxin.shunxin_salesman_visit.dto.clientdto.ParameterDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.StatKsCusDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.TmpKsCusDto;
import com.shunxin.shunxin_salesman_visit.dto.signdto.CommonDto;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.eatbarservice.TmpKsCusService;
import com.shunxin.shunxin_salesman_visit.util.UserInfoUtil;
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
@RequestMapping("/api/tmpKsCus")
public class TmpKsCusControll {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TmpKsCusService tmpKsCusService;
    @Autowired
    private UserInfoUtil userInfoUtil;
    @Autowired
    private BaseApiService baseApiService;


    /**
     * 查询 ks_cus 表数据
     * @return
     */
    @RequestMapping("/selectTmpKsCus")
    public Object selectTmpKsCus(@RequestBody CommonDto commonDto){
        String unionid = commonDto.getUnionid();
        try {
            int exist = tmpKsCusService.getUnionidExist(unionid);
            if (exist!=0){
                List<TmpKsCusDto> tmpKsCusDtoList = tmpKsCusService.selectTmpKsCus();
                logger.info("查询 ks_cus 表数据");
                return baseApiService.setResultResultSuccess(tmpKsCusDtoList);
            }else {
                return baseApiService.setResultError("系统错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询ks_cus表统计数据
     * @return
     */
    @RequestMapping("/selectStatKsCus")
    public Object selectStatKsCus(@RequestBody CommonDto commonDto){
        String unionid = commonDto.getUnionid();
        try {
            int exist = tmpKsCusService.getUnionidExist(unionid);
            if (exist!=0){
                List<StatKsCusDto> statKsCusDtoList = tmpKsCusService.selectStatKsCus();
                logger.info("查询ks_cus表统计数据");
                return baseApiService.setResultResultSuccess(statKsCusDtoList);
            }else {
                return baseApiService.setResultError("系统错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 通过code 获取网页登录的Unionid
     * @return
     */
    @RequestMapping("/getGzUnionid")
    public Object getGzUnionid(@RequestBody ParameterDto parameterDto){
        String code = parameterDto.getCode();
        try {
            String unionid = userInfoUtil.getGzUnionid(code);
            return baseApiService.setResultResultSuccess(unionid);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据设备编码查询需要跳转的页面
     * @return
     */
    @RequestMapping("/getPageUrl")
    public Object getPageUrl(@RequestBody CommonDto commonDto){
        String device_id = commonDto.getDevice_id();
        try {
            String pageUrl = tmpKsCusService.getPageUrl(device_id);
            logger.info("根据设备编码查询需要跳转的页面");
            return baseApiService.setResultResultSuccess(pageUrl);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


}
