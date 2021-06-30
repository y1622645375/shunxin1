package com.shunxin.shunxin_salesman_visit.service.clientservice;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.TouristDto;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.AutoChar;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.Inventory;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.InventoryClass;

import java.util.List;

public interface SxAInvService {

    //查询商品分类
    List<InventoryClass> getInventClass();


    //根据商品分类查询商品
    List<Inventory> getInventory(String ccomcode,String ccus_level,String cInvCCode);


    //根据客户ID查询客户所属公司和客户级别
    List<TouristDto> selectCcompanyId(String autoid);


    //查询各类排名
    List<AutoChar> selectAutoChar(String ctype, String userid, String ddate1, String ddate2);


    //通过客户编号查询客户电话号码
    String getCcusAccount(String autoid);
}
