package com.shunxin.shunxin_salesman_visit.service.mallservice;



import com.shunxin.shunxin_salesman_visit.entity.mallentity.SxadData;

import java.util.List;

public interface SxadDataService {

    /**
     * 查询首页的所有图片
     *
     * @return
     */
    List<SxadData> selectSxadDataList();


}
