package com.shunxin.shunxin_salesman_visit.mapper.eatbarmapper;

import com.shunxin.shunxin_salesman_visit.entity.cliententity.Inventory;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.Compay;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.PriceEnter;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface PriceEnterMapper {


    //查询商品价格录入表
    List<PriceEnter> selectPriceEnter(@Param("ccus_account") String ccus_account,@Param("ddate") String ddate,@Param("cuserid") String cuserid);


    //查询所有公司
    List<Compay> selectCompay(@Param("cusercode") String cusercode,@Param("ctype") String ctype);



    //查询基础档案（公司 company，部门 department）
    List<Compay> selectEnumdataLists(@Param("ctype") String ctype,@Param("cuser_id") String cuser_id);


    //新增价格表
    int addInventoryExt(@Param("ccomcode") String ccomcode,@Param("cinvcode") String cinvcode,@Param("ccus_level") String ccus_level,
                        @Param("ccus_price") BigDecimal ccus_price,@Param("igoldrate") Float igoldrate,@Param("ddateb") Date ddateb,
                        @Param("ddatee") Date ddatee,@Param("igrade") int igrade);


    //查询所有商品名称及编码
    List<Inventory> getInvents(@Param("cInvName") String cInvName);


    //修改价格表
    int updateInvents(@Param("ccomcode") String ccomcode,@Param("cinvcode") String cinvcode,@Param("ccus_level") String ccus_level,
                      @Param("ccus_price") BigDecimal ccus_price,@Param("igoldrate") Float igoldrate,@Param("ddateb") Date ddateb,
                      @Param("ddatee") Date ddatee,@Param("igrade") int igrade,@Param("autoid") int autoid);


}
