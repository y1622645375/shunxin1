package com.shunxin.shunxin_salesman_visit.mapper.clientmapper;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.SxOutRetained;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SxOutBoundMapper {



    /*int addOutBoundList(@Param("csocode") String csocode,@Param("cperson_id") String cperson_id,@Param("cstate") String cstate,
                        @Param("ccus_id") String ccus_id,@Param("csotype") String csotype,
                        @Param("cinvcode") String cinvcode,@Param("iquantity") String iquantity,@Param("iprice") String iprice,@Param("imoney") String imoney);*/

    //int addOutBoundList(@Param(value="boundDtos")List<SxOutBoundDto> boundDtos);


    //新增出库单
    List<ResultDto> addOutBoundLists(@Param("jsonvist") String jsonvist);


    //查询出库清单
    List<SxOutRetained> getOutBoundList(@Param("cperson_id") String cperson_id,@Param("ddate1") String ddate1,@Param("ddate2") String ddate2,
                                     @Param("cstate") String cstate,@Param("csotype") String csotype);


    //查询昨日留存
    List<SxOutRetained> getSxOutRetained(@Param("cperson_id") String cperson_id);


    //根据工号查询今日出库申请
    List<SxOutRetained> getSxSoorderList(@Param("cperson_id") String cperson_id);


    //业务员修改出库申请
    int updateSxSoorder(@Param("jsonvist") String jsonvist);


    //根据主管经理工号查询所管业务员的出库申请
    List<SxOutRetained> getStaffpsnHold(@Param("ccode") String ccode,@Param(value = "cperson_id") String cperson_id,
                                        @Param("ddate1") String ddate1,@Param("ddate2") String ddate2,@Param("cstate") String cstate);


    //PC端查询出库记录
    List<SxOutRetained> getStaffpsnList(@Param("cperson_id") String cperson_id,@Param("ccus_id") String ccus_id,@Param("ddate1") String ddate1,
                                        @Param("ddate2") String ddate2,@Param("cstate") String cstate);


    //根据客户编号查询出库申请单
    List<SxOutRetained> getSxSoorderPlace(@Param("cperson_id") String cperson_id,@Param("ccus_id") String ccus_id);


}
