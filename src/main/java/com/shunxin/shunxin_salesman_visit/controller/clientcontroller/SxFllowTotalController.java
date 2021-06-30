package com.shunxin.shunxin_salesman_visit.controller.clientcontroller;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.ExpirationTimeDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.FllowTotalDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.ReqDto;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxFllowTotalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/sxFllowTotal")
public class SxFllowTotalController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SxFllowTotalService sxFllowTotalService;
    @Autowired
    private BaseApiService baseApiService;

    /**
     * 查询今日该拜访客户数量和已拜访数量
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectFllowTotaCount")
    public Object selectFllowTotaCount(HttpServletResponse response,@RequestBody ReqDto reqDto){
        response.setHeader("Access-Control-Allow-Origin", "*");
        //接收前端的数据
        Date dplan_time = reqDto.getDplan_time();
        String ctotal_pid = reqDto.getUserid();
        try{
            List<FllowTotalDto> totalcount =  sxFllowTotalService.selectFllowTotaCount(ctotal_pid,dplan_time);
            logger.info("调用：查询今日该拜访客户数量和已拜访数量"+"工号："+ctotal_pid+"\t调用今日该拜访客户数量和已拜访数量接口\t参数："+ctotal_pid+","+dplan_time);
            return baseApiService.setResultResultSuccess(totalcount);
        }catch(Exception e){
            e.printStackTrace();
            logger.info("工号："+ctotal_pid+"\t调用今日该拜访客户数量和已拜访数量接口\t参数："+ctotal_pid+","+dplan_time+"\n返回异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 更新key的过期时间
     * @param
     * @return
     */
    @RequestMapping("/renewalExpirationTime")
    public Object renewalExpirationTime(@RequestBody ExpirationTimeDto timeDto){
        String cuser_id = timeDto.getCuser_id();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.MINUTE, -1);// 1分钟之前的时间
        Date beforeD = beforeTime.getTime();
        String today = sdf.format(beforeD);
        try {
            String result = "";
            int count = sxFllowTotalService.renewalExpirationTime(today,cuser_id);
            result = count>0?"更新成功":"更新失败";
            return baseApiService.setResultResultSuccess(result);
        }catch(Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }




}
