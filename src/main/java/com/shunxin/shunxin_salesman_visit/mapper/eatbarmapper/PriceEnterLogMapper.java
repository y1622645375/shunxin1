package com.shunxin.shunxin_salesman_visit.mapper.eatbarmapper;

import com.shunxin.shunxin_salesman_visit.dto.eatbardto.PriceAllDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.PriceEnterLog;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface PriceEnterLogMapper {



    //查询有权限的工号
    List<PriceAllDto> getCuserCode();


    //查询历史价格表
    List<PriceEnterLog> selectPriceEnterLog(@Param("cuser_id") String cuser_id ,@Param("ccomcode") String ccomcode, @Param("cinvcode") String cinvcode, @Param("ccus_level") String ccus_level,@Param("ddate") String ddate);


    //新增历史价格表
    int insertPriceEnter(@Param("ccomcode") String ccomcode,@Param("cuser_id") String cuser_id,@Param("cinvcode") String cinvcode,@Param("ccus_level") String ccus_level,
                         @Param("ccus_price") BigDecimal ccus_price,@Param("igoldrate") Float igoldrate,@Param("ddateb") Date ddateb,@Param("ddatee") Date ddatee,@Param("cmemo") String cmemo);


    //修改历史价格表
    int updatePriceEnter(@Param("ccomcode") String ccomcode,@Param("cuser_id") String cuser_id,@Param("cinvcode") String cinvcode,@Param("ccus_level") String ccus_level,
                         @Param("ccus_price") BigDecimal ccus_price,@Param("igoldrate") Float igoldrate,@Param("ddateb") Date ddateb,@Param("ddatee") Date ddatee,
                         @Param("cmemo") String cmemo,@Param("autoid") int autoid);


    //判断该数据是否已经审核
    String getChecktepy(@Param("autoid") int autoid);


    //停用，录入禁用人和禁用时间
    int forbiddenInventory(@Param("ccloser") String ccloser,@Param("cmemo") String cmemo,@Param("autoid") int autoid);


    //通过autoid查询Log表信息
    PriceEnterLog getExtLogs(@Param("autoid") int autoid);


    //再将正式表的bclose修改为1(0为有效，1为禁用)
    int updateBclose(@Param("iext_id") int iext_id);


    //填入审核人和审核时间
    int checkInventory(@Param("cchecker") String cchecker,@Param("autoid") int autoid);


    //判断公司、商品、客户级别、时间段是否重复
    int judgeRepeat(@Param("ccomcode") String ccomcode,@Param("ccus_level") String ccus_level,
                    @Param("cinvcode") String cinvcode,@Param("ddateb") Date ddateb,@Param("ddatee") Date ddatee);


    //判断该数据正式表中是否存在
    int judgeInventoryExt(@Param("ccomcode") String ccomcode,@Param("ccus_level") String ccus_level,
                          @Param("cinvcode") String cinvcode);


    //查询正式表的autoid
    int judgeInventoryExtAutoid(@Param("ccomcode") String ccomcode,@Param("ccus_level") String ccus_level,
                          @Param("cinvcode") String cinvcode);


    //最后将iext_id修改为正式表的autoid
    int updateIextId(@Param("iext_id") int iext_id,@Param("autoid") int autoid);


    //停用价格
    List<ResultDto> stopPriceEnter(@Param("jsonvist") String jsonvist);


    //新增价格记录
    List<ResultDto> addPriceEnter(@Param("jsonvist") String jsonvist);


    //修改价格
    List<ResultDto> modificatPriceEnter(@Param("jsonvist") String jsonvist);


    //审核价格
    List<ResultDto> auditPriceEnter(@Param("jsonvist") String jsonvist);


    //延长商品上架时间
    int updateInventoryExt(@Param("ddatee") String ddatee,@Param("autoid") int autoid);

    //回写log表
    int updateInventoryExtLog(@Param("ddatee") String ddatee,@Param("autoid") int autoid);

}
