package com.shunxin.shunxin_salesman_visit.service.eatbarservice;

import com.shunxin.shunxin_salesman_visit.entity.cliententity.Inventory;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.Compay;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.PriceEnter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface PriceEnterService {

    //查询商品价格录入表
    List<PriceEnter> selectPriceEnter(String ccus_account,String ddate,String cuserid);


    //查询所有公司
    List<Compay> selectCompay(String cusercode,String ctype);


    //查询基础档案（公司 company，部门 department）
    List<Compay> selectEnumdataLists(String ctype, String cuser_id);


    //新增价格表
    int addInventoryExt(String ccomcode, String cinvcode, String ccus_level, BigDecimal ccus_price, Float igoldrate, Date ddateb, Date ddatee, int igrade);


    //查询所有商品名称及编码
    List<Inventory> getInvents(String cInvName);


    //修改价格表
    int updateInvents(String ccomcode,String cinvcode,String ccus_level,BigDecimal ccus_price,Float igoldrate, Date ddateb,Date ddatee,int igrade,int autoid);




}
