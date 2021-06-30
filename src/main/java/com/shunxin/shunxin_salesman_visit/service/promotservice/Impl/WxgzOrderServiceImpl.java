package com.shunxin.shunxin_salesman_visit.service.promotservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.OrdervDto;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.CImagePathDto;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.ExaminingDto;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.OrderWxbands;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.UnpaidOrderDto;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.PriceEnter;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.WxgzFllowVist;
import com.shunxin.shunxin_salesman_visit.mapper.promotmapper.WxgzOrderMapper;
import com.shunxin.shunxin_salesman_visit.service.promotservice.WxgzOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/WxgzOrderService")
public class WxgzOrderServiceImpl implements WxgzOrderService {

    @Resource
    private WxgzOrderMapper wxgzOrderMapper;


    @Override
    public List<OrdervDto> getOrderList(String ccus_id, String ddate2, String csocode, String cso_state) {
        return wxgzOrderMapper.getOrderList(ccus_id,ddate2,csocode,cso_state);
    }

    @Override
    public List<WxgzFllowVist> getFllowList(String cfllow_cid) {
        return wxgzOrderMapper.getFllowList(cfllow_cid);
    }

    @Override
    public List<CImagePathDto> getCimgPath(int fllowid) {
        return wxgzOrderMapper.getCimgPath(fllowid);
    }

    @Override
    public List<PriceEnter> getCommodityNewPrice(String ccus_cid) {
        return wxgzOrderMapper.getCommodityNewPrice(ccus_cid);
    }

    @Override
    public List<ExaminingDto> getExaminingReport(int userid,String ctype) {
        return wxgzOrderMapper.getExaminingReport(userid,ctype);
    }

    @Override
    public String getTempdbDtime(int autoid) {
        return wxgzOrderMapper.getTempdbDtime(autoid);
    }

    @Override
    public List<UnpaidOrderDto> selectUnpaidOrder(String cperson_id) {
        return wxgzOrderMapper.selectUnpaidOrder(cperson_id);
    }

    @Override
    public List<OrderWxbands> getOrderWxbind(String ccusid) {
        return wxgzOrderMapper.getOrderWxbind(ccusid);
    }


}
