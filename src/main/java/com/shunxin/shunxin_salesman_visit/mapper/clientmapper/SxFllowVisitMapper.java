package com.shunxin.shunxin_salesman_visit.mapper.clientmapper;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.*;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.FllowVisitList;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.StaffCus;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


public interface SxFllowVisitMapper {


    //查询今天已拜访的客户列表
    List<FllowVisitListDto> selectSxFllowVisitList(@Param("jsonvist") String jsonvist);


    //查询单个具体的拜访记录
    List<FllowVisitDetailDto> selectFllowVisitDetail(int autoid);


    //查询客户的商品资料
    List<FllowVisitStortDto> selectStort(int autoid);



     //添加拜访记录
     List<ResultDto> insertFllowVisit(String jsonvisit);


     //查询5分钟内同一业务员是否有拜访记录
     int getFllowVistt(@Param("cfllow_pid") String cfllow_pid);


     //查询统计表
     List<StatisDto> selectStatistics(@Param("ctype") String ctype,@Param("userid") String userid, @Param("dateb") String dateb, @Param("datee") String datee);


     //查询单个区域的详情
     List<StatisalesmanDto> selectStatisalesman(@Param("ctype") String ctype,@Param("userid") String userid, @Param("dateb") String dateb, @Param("datee") String datee);



    //查询地图数据
    List<MapDto> selectMapinfo(@Param("ckey") String ckey, @Param("ctype") String ctype, @Param("sales") String sales, @Param("userid") String userid,
                               @Param("datea") Date datea, @Param("datee") Date datee, @Param("coloron") String coloron);


    //查询店铺的位置
    List<BusinessDto> selectBusiness(@Param("ckey") String ckey, @Param("ctype") String ctype, @Param("stype") String stype, @Param("userid") String userid,
                                     @Param("date1") Date date1, @Param("date2") Date date2, @Param("param1") String param1, @Param("param2") String param2);



    //查询某日拜访记录
    List<FllowVisitinfoDto> selectVisitInfos(@Param("jsonvist") String jsonvist);


    //查询5月销量（柱状图）
    //List<MaySalesDto> selectMaySales(@Param("begdate") Date begdate,@Param("dendate") Date dendate);


    //查询五六月份售点分布图
    List<BusinessDto> selectMaySellDot(@Param("ddate") String ddate,@Param("cperson_id") String cperson_id,@Param("cdepartment_id") String cdepartment_id,@Param("ccus_comid") String ccus_comid);


    //查询现存所有有过交易的售点
    List<BusinessDto> selectAllSellDot();


    //查询5月份有过拜访的售点
    List<BusinessDto> selectFllowDto(@Param("ddate") String ddate,@Param("cperson_id") String cperson_id,@Param("cdepartment_id") String cdepartment_id,@Param("ccus_comid") String ccus_comid);


    //根据工号查询客户
    List<StaffCus> getStaffCus(@Param("ccode") String ccode);


    //查询所有客户的坐标
    List<StaffCus> getCusAddress();


    //将腾讯坐标修改为百度坐标
    int updateCusAddress(@Param("ccus_address") String ccus_address,@Param("autoid") String autoid);


    //查询今日每个业务员的最新拜访位置
    List<FllowVisitList> getFllowVistList(@Param("ccomcode") String ccomcode, @Param("cfllow_pid") String cfllow_pid);

}
