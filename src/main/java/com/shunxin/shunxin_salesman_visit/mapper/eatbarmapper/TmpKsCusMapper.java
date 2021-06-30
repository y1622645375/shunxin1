package com.shunxin.shunxin_salesman_visit.mapper.eatbarmapper;

import com.shunxin.shunxin_salesman_visit.dto.eatbardto.StatKsCusDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.TmpKsCusDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TmpKsCusMapper {

    //查询 ks_cus 表数据
    List<TmpKsCusDto> selectTmpKsCus();


    //查询Ks_cus的统计数据
    List<StatKsCusDto> selectStatKsCus();


    //根据设备编码查询需要跳转的页面
    String getPageUrl(@Param("device_id") String device_id);


    //根据unionid查询是否绑定
    int getUnionidExist(@Param("unionid") String unionid);

}
