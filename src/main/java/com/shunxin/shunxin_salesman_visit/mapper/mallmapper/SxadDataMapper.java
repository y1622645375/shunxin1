package com.shunxin.shunxin_salesman_visit.mapper.mallmapper;

import com.shunxin.shunxin_salesman_visit.entity.mallentity.SxadData;

import java.util.List;

public interface SxadDataMapper {


    /**
     * 查询首页的所有图片
     *
     * @return
     */
    List<SxadData> selectSxadDataList();


}
