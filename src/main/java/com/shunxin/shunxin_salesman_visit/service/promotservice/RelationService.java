package com.shunxin.shunxin_salesman_visit.service.promotservice;

import com.shunxin.shunxin_salesman_visit.entity.promotentity.AppDinwei;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.Relation;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.ScanLog;

import java.util.List;

public interface RelationService {

    //根据当前位置查询业务员
    List<Relation> selectAreaSalesman(String jsonvist);


    //根据工号绑定openid
    //int bandStaffOpenid(String cdefine26,String ccode);
    int addStaffOpenid(String ccode,String wxopenid,String cname);


    //判断该openid是否已经绑定
    int selectWxopenidso(String wxopenid);


    //查询扫码时的经纬度
    List<AppDinwei> selectSxDinweiLogs(String ddate1,String ddate2);


    //查询客户扫码记录
    List<ScanLog> ScanRecordLog(String ddate1,String ddate2);


    //根据openid查询工号
    String getStaffOpenid(String wxopenid);

}
