package com.shunxin.shunxin_salesman_visit.service.clientservice;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.*;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.FllowVisitList;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.StaffCus;

import java.util.Date;
import java.util.List;

public interface SxFllowVisitService {

    //查询今天已拜访的客户列表
    List<FllowVisitListDto> selectSxFllowVisitList(String jsonvist);


    //查询单个具体的拜访记录
    List<FllowVisitDetailDto> selectFllowVisitDetail(int autoid);


    //查询客户的商品资料
    List<FllowVisitStortDto> selectStort(int autoid);


    //添加拜访记录
    List<ResultDto> insertFllowVisit(String jsonvisit);


    //查询5分钟内同一业务员是否有拜访记录
    int getFllowVistt(String cfllow_pid);

    //查询统计表
    List<StatisDto> selectStatistics(String ctype,String userid, String dateb, String datee);


    //查询单个区域的详情
    List<StatisalesmanDto> selectStatisalesman(String ctype,String userid, String dateb, String datee);


    //查询地图数据
    List<MapDto> selectMapinfo(String ckey, String ctype, String sales, String userid, Date datea, Date datee, String coloron);


    //查询店铺的位置
    List<BusinessDto> selectBusiness(String ckey, String ctype, String stype, String userid, Date date1, Date date2, String param1, String param2);



    //查询某日拜访记录
    List<FllowVisitinfoDto> selectVisitInfos(String jsonvist);



    //查询5月销量（柱状图）
    //List<MaySalesDto> selectMaySales(Date begdate,Date dendate);


    //查询五六月份售点分布图
    List<BusinessDto> selectMaySellDot(String ddate,String cperson_id,String cdepartment_id,String ccus_comid);


    //查询现存所有有过交易的售点
    List<BusinessDto> selectAllSellDot();


    //查询5月份有过拜访的售点
    List<BusinessDto> selectFllowDto(String ddate,String cperson_id,String cdepartment_id,String ccus_comid);


    //根据工号查询客户
    List<StaffCus> getStaffCus(String ccode);

    //查询所有客户的坐标
    List<StaffCus> getCusAddress();


    //将腾讯坐标修改为百度坐标
    int updateCusAddress(String ccus_address,String autoid);


    //查询今日每个业务员的最新拜访位置
    List<FllowVisitList> getFllowVistList(String ccomcode, String cfllow_pid);
}
