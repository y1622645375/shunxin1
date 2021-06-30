package com.shunxin.shunxin_salesman_visit.service.promotservice.Impl;

import com.shunxin.shunxin_salesman_visit.entity.promotentity.AppDinwei;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.Relation;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.ScanLog;
import com.shunxin.shunxin_salesman_visit.mapper.promotmapper.RelationMapper;
import com.shunxin.shunxin_salesman_visit.service.promotservice.RelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("RelationService")
public class RelationServiceImpl implements RelationService {

    @Resource
    private RelationMapper relationMapper;


    @Override
    public List<Relation> selectAreaSalesman(String jsonvist) {
        return relationMapper.selectAreaSalesman(jsonvist);
    }

    @Override
    public int addStaffOpenid(String ccode, String wxopenid, String cname) {
        return relationMapper.addStaffOpenid(ccode,wxopenid,cname);
    }

    @Override
    public int selectWxopenidso(String wxopenid) {
        return relationMapper.selectWxopenidso(wxopenid);
    }


    @Override
    public List<AppDinwei> selectSxDinweiLogs(String ddate1,String ddate2) {
        return relationMapper.selectSxDinweiLogs(ddate1,ddate2);
    }

    @Override
    public List<ScanLog> ScanRecordLog(String ddate1,String ddate2) {
        return relationMapper.ScanRecordLog(ddate1,ddate2);
    }

    @Override
    public String getStaffOpenid(String wxopenid) {
        return relationMapper.getStaffOpenid(wxopenid);
    }


}
