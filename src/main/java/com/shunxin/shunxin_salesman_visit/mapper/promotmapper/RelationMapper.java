package com.shunxin.shunxin_salesman_visit.mapper.promotmapper;

import com.shunxin.shunxin_salesman_visit.entity.promotentity.AppDinwei;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.Relation;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.ScanLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelationMapper {


    //根据当前位置查询业务员
    List<Relation> selectAreaSalesman(@Param("jsonvist") String jsonvist);


    //根据工号绑定openid
    //int bandStaffOpenid(@Param("cdefine26") String cdefine26,@Param("ccode") String ccode);
    int addStaffOpenid(@Param("ccode") String ccode,@Param("wxopenid") String wxopenid,@Param("cname") String cname);


    //判断该openid是否已经绑定
    int selectWxopenidso(@Param("wxopenid") String wxopenid);


    //查询扫码时的经纬度
    List<AppDinwei> selectSxDinweiLogs(@Param("ddate1") String ddate1,@Param("ddate2") String ddate2);


    //查询客户扫码记录
    List<ScanLog> ScanRecordLog(@Param("ddate1") String ddate1,@Param("ddate2") String ddate2);


    //根据openid查询工号
    String getStaffOpenid(@Param("wxopenid") String wxopenid);

}
