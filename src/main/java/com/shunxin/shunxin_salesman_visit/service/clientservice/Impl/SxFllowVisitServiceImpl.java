package com.shunxin.shunxin_salesman_visit.service.clientservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.*;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.FllowVisitList;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.StaffCus;
import com.shunxin.shunxin_salesman_visit.mapper.clientmapper.SxFllowVisitMapper;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxFllowVisitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("SxFllowVisitService")
public class SxFllowVisitServiceImpl implements SxFllowVisitService {

    @Resource
    private SxFllowVisitMapper sxFllowVisitMapper;

    @Override
    public List<FllowVisitListDto> selectSxFllowVisitList(String jsonvist) {
        return sxFllowVisitMapper.selectSxFllowVisitList(jsonvist);
    }

    @Override
    public List<FllowVisitDetailDto> selectFllowVisitDetail(int autoid) {
        return sxFllowVisitMapper.selectFllowVisitDetail(autoid);
    }

    @Override
    public List<FllowVisitStortDto> selectStort(int autoid) {
        return sxFllowVisitMapper.selectStort(autoid);
    }


    @Override
    public List<ResultDto> insertFllowVisit(String jsonvisit) {
        return sxFllowVisitMapper.insertFllowVisit(jsonvisit);
    }

    @Override
    public int getFllowVistt(String cfllow_pid) {
        return sxFllowVisitMapper.getFllowVistt(cfllow_pid);
    }


    @Override
    public List<StatisDto>  selectStatistics(String ctype,String userid, String dateb, String datee) {
        return sxFllowVisitMapper.selectStatistics(ctype,userid,dateb,datee);
    }

    @Override
    public List<StatisalesmanDto> selectStatisalesman(String ctype, String userid, String dateb, String datee) {
        return sxFllowVisitMapper.selectStatisalesman(ctype,userid,dateb,datee);
    }

    @Override
    public List<MapDto> selectMapinfo(String ckey, String ctype, String sales, String userid, Date datea, Date datee, String coloron) {
        return sxFllowVisitMapper.selectMapinfo(ckey,ctype,sales,userid,datea,datee,coloron);
    }

    @Override
    public List<BusinessDto> selectBusiness(String ckey, String ctype, String stype, String userid, Date date1, Date date2, String param1, String param2) {
        return sxFllowVisitMapper.selectBusiness(ckey,ctype,stype,userid,date1,date2,param1,param2);
    }


    @Override
    public List<FllowVisitinfoDto> selectVisitInfos(String jsonvist) {
        return sxFllowVisitMapper.selectVisitInfos(jsonvist);
    }

    /*@Override
    public List<MaySalesDto> selectMaySales(Date begdate, Date dendate) {
        return sxFllowVisitMapper.selectMaySales(begdate,dendate);
    }*/

    @Override
    public List<BusinessDto> selectMaySellDot(String ddate,String cperson_id,String cdepartment_id,String ccus_comid) {
        return sxFllowVisitMapper.selectMaySellDot(ddate,cperson_id,cdepartment_id,ccus_comid);
    }

    @Override
    public List<BusinessDto> selectAllSellDot() {
        return sxFllowVisitMapper.selectAllSellDot();
    }

    @Override
    public List<BusinessDto> selectFllowDto(String ddate,String cperson_id,String cdepartment_id,String ccus_comid) {
        return sxFllowVisitMapper.selectFllowDto(ddate,cperson_id,cdepartment_id,ccus_comid);
    }

    @Override
    public List<StaffCus> getStaffCus(String ccode) {
        return sxFllowVisitMapper.getStaffCus(ccode);
    }

    @Override
    public List<StaffCus> getCusAddress() {
        return sxFllowVisitMapper.getCusAddress();
    }

    @Override
    public int updateCusAddress(String ccus_address, String autoid) {
        return sxFllowVisitMapper.updateCusAddress(ccus_address,autoid);
    }

    @Override
    public List<FllowVisitList> getFllowVistList(String ccomcode, String cfllow_pid) {
        return sxFllowVisitMapper.getFllowVistList(ccomcode,cfllow_pid);
    }

}
