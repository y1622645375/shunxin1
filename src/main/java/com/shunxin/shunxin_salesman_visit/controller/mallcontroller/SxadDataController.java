package com.shunxin.shunxin_salesman_visit.controller.mallcontroller;


import com.shunxin.shunxin_salesman_visit.entity.mallentity.SxadData;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.mallservice.SxadDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 图片的接口为主
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/SxadData")
public class SxadDataController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BaseApiService baseApiService;
    @Autowired
    private SxadDataService sxadDataService;


    /**
     * 查询首页的所有图片（用于顺兴商城）
     *
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectSxadDataList")
    public Object selectSxadDataList(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            List<SxadData> sxadDataList = sxadDataService.selectSxadDataList();
            return baseApiService.setResultResultSuccess(sxadDataList);
        } catch (Exception e) {
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }





}
