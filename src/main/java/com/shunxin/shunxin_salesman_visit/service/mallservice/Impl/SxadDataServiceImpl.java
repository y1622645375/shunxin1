package com.shunxin.shunxin_salesman_visit.service.mallservice.Impl;


import com.shunxin.shunxin_salesman_visit.entity.mallentity.SxadData;
import com.shunxin.shunxin_salesman_visit.mapper.mallmapper.SxadDataMapper;
import com.shunxin.shunxin_salesman_visit.service.mallservice.SxadDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SxadDataService")
public class SxadDataServiceImpl implements SxadDataService {

    @Resource
    private SxadDataMapper sxadDataMapper;

    @Override
    public List<SxadData> selectSxadDataList() {
        return sxadDataMapper.selectSxadDataList();
    }
}
