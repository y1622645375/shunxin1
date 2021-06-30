package com.shunxin.shunxin_salesman_visit.service.eatbarservice;

import com.shunxin.shunxin_salesman_visit.dto.eatbardto.PriceAllDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.PriceEnterLog;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface PriceEnterLogService {


    //查询有权限的工号
    List<PriceAllDto> getCuserCode();


    //查询商品价格录入表
    List<PriceEnterLog> selectPriceEnterLog(String cuser_id,String ccomcode,String cinvcode,String ccus_level,String ddate);


    //新增历史价格表
    int insertPriceEnter(String ccomcode, String cuser_id, String cinvcode, String ccus_level,
                         BigDecimal ccus_price, Float igoldrate, Date ddateb, Date ddatee, String cmemo);


    //修改历史价格表
    int updatePriceEnter(String ccomcode,String cuser_id,String cinvcode,String ccus_level,BigDecimal ccus_price,
                         Float igoldrate,Date ddateb,Date ddatee,String cmemo,int autoid);


    //判断该数据是否已经审核
    String getChecktepy(int autoid);


    //停用，录入禁用人和禁用时间
    int forbiddenInventory(String ccloser,String cmemo,int autoid);

    //通过autoid查询Log表信息
    PriceEnterLog getExtLogs(int autoid);

    //再将正式表的bclose修改为1(0为有效，1为禁用)
    int updateBclose(int iext_id);


    //填入审核人和审核时间
    int checkInventory(String cchecker,int autoid);


    //判断公司、商品、客户级别、时间段是否重复
    int judgeRepeat(String ccomcode,String ccus_level,String cinvcode,Date ddateb,Date ddatee);


    //判断该数据正式表中是否存在
    int judgeInventoryExt(String ccomcode,String ccus_level,String cinvcode);


    //查询正式表的autoid
    int judgeInventoryExtAutoid(String ccomcode,String ccus_level,String cinvcode);


    //最后将iext_id修改为正式表的autoid
    int updateIextId(int iext_id,int autoid);


    //停用价格
    List<ResultDto> stopPriceEnter(String jsonvist);


    //新增价格记录
    List<ResultDto> addPriceEnter(String jsonvist);


    //修改价格
    List<ResultDto> modificatPriceEnter(String jsonvist);


    //审核价格
    List<ResultDto> auditPriceEnter(String jsonvist);


    //延长商品上架时间
    int updateInventoryExt(String ddatee,int autoid);

    //回写log表
    int updateInventoryExtLog(String ddatee,int autoid);
}
