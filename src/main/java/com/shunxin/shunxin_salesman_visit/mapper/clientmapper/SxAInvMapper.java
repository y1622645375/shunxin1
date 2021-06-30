package com.shunxin.shunxin_salesman_visit.mapper.clientmapper;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.TouristDto;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.AutoChar;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.Inventory;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.InventoryClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SxAInvMapper {

    //查询商品分类
    List<InventoryClass> getInventClass();


    //根据商品分类查询商品
    List<Inventory> getInventory(@Param("ccomcode") String ccomcode,@Param("ccus_level") String ccus_level,@Param("cInvCCode") String cInvCCode);


    //根据客户ID查询客户所属公司和客户级别
    List<TouristDto> selectCcompanyId(@Param("autoid") String autoid);


    //查询各类排名
    List<AutoChar> selectAutoChar(@Param("ctype") String ctype,@Param("userid") String userid,@Param("ddate1") String ddate1,@Param("ddate2") String ddate2);


    //通过客户编号查询客户电话号码
    String getCcusAccount(@Param("autoid") String autoid);


}
