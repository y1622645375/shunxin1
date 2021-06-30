package com.shunxin.shunxin_salesman_visit.service.promotservice;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.CustomerDto;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.CustomGoodDto;

import java.util.List;

public interface CustomgoodsService {


    //根据业务员工号查询所管客户
    List<CustomGoodDto> selectCustoms(String cperson_id,String ccus_name);


    //查询所有商品
    List<CustomGoodDto> selectCommodity(String cinvname);



    //给客户选择商品或给商品选择客户
    int addCommdityToCustoms(String ccomcode,String ccus_id,String cinvcode,String cperson_id);


    //根据客户编号删除其所有商品
    int deleteCommdityToCustoms(String ccus_id);


    //根据商品编号删除其所有客户
    int deleteCustomsToCommdity(String cinvcode);


    //根据业务员工号查询其所属公司
    String selectCompany(String cperson_id);


    //给商品选择客户
    //int updateCustomsToCommdity(String ccus_id,String cinvcode,String cperson_id);


    //根据客户查询已选择的商品
    List<CustomerDto> getCustomCommdity(String ccus_id);



    //根据商品查询已选择的客户
    List<CustomerDto> getCommdityCustom(String cinvcode,String cperson_id);


}
