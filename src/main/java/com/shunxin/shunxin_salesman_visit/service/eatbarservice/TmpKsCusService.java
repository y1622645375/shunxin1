package com.shunxin.shunxin_salesman_visit.service.eatbarservice;

import com.shunxin.shunxin_salesman_visit.dto.eatbardto.StatKsCusDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.TmpKsCusDto;

import java.util.List;

public interface TmpKsCusService {


    //查询 ks_cus 表数据
    List<TmpKsCusDto> selectTmpKsCus();


    //查询Ks_cus的统计数据
    List<StatKsCusDto> selectStatKsCus();


    //根据设备编码查询需要跳转的页面
    String getPageUrl(String device_id);


    //根据unionid查询是否绑定
    int getUnionidExist(String unionid);

}
