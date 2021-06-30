package com.shunxin.shunxin_salesman_visit.service.clientservice;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.SxOutRetained;

import java.util.List;

public interface SxOutboundService {



    /*int addOutBoundList(String csocode,String cperson_id,String cstate,String ccus_id,String csotype,
                        String cinvcode,String iquantity,String iprice,String imoney);*/


    //int addOutBoundList(List<SxOutBoundDto> boundDtos);

    //新增出库单
    List<ResultDto> addOutBoundLists(String jsonvist);


    //查询出库清单
    List<SxOutRetained> getOutBoundList(String cperson_id, String ddate1, String ddate2,String cstate,String csotype);


    //查询昨日留存
    List<SxOutRetained> getSxOutRetained(String cperson_id);


    //根据工号查询今日出库申请
    List<SxOutRetained> getSxSoorderList(String cperson_id);


    //业务员修改出库申请
    int updateSxSoorder(String jsonvist);


    //根据主管经理工号查询所管业务员
    List<SxOutRetained> getStaffpsnHold(String ccode,String cperson_id,String ddate1,String ddate2,String cstate);


    //PC端查询出库记录
    List<SxOutRetained> getStaffpsnList(String cperson_id,String ccus_id,String ddate1,String ddate2,String cstate);


    //根据客户编号查询出库申请单
    List<SxOutRetained> getSxSoorderPlace(String cperson_id,String ccus_id);

}
