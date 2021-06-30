package com.shunxin.shunxin_salesman_visit.service.promotservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.Inventory2;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.Promotion;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.SacxHold;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.ZpcinvCode;
import com.shunxin.shunxin_salesman_visit.mapper.promotmapper.PromotionMapper;
import com.shunxin.shunxin_salesman_visit.service.promotservice.PromotionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("PromotionService")
public class PromotionServiceImpl implements PromotionService {


    @Resource
    private PromotionMapper promotionMapper;

    @Override
    public List<Promotion> selectPromotion(String cusercode, String ddate, String istate) {
        return promotionMapper.selectPromotion(cusercode,ddate,istate);
    }

    @Override
    public List<ResultDto> addPromotion(String jsonvist) {
        return promotionMapper.addPromotion(jsonvist);
    }

    @Override
    public List<ResultDto> updatePromotion(String jsonvist) {
        return promotionMapper.updatePromotion(jsonvist);
    }

    @Override
    public List<ResultDto> checkPromotion(String jsonvist) {
        return promotionMapper.checkPromotion(jsonvist);
    }


    @Override
    public List<ResultDto> invalidPromotion(String jsonvist) {
        return promotionMapper.invalidPromotion(jsonvist);
    }

    @Override
    public List<Promotion> selectPromoOne(String cusercode,String sacxid) {
        return promotionMapper.selectPromoOne(cusercode,sacxid);
    }

    @Override
    public List<SacxHold> selectSacxHold(String sacxid) {
        return promotionMapper.selectSacxHold(sacxid);
    }

    @Override
    public List<ZpcinvCode> selectZpCinvName(String ctype,String sacxid) {
        return promotionMapper.selectZpCinvName(ctype,sacxid);
    }

    @Override
    public List<ZpcinvCode> getZpSacxCount(String ctype,String ccomcode,String ccus_id,String cinvcode,int iquan) {
        return promotionMapper.getZpSacxCount(ctype,ccomcode,ccus_id,cinvcode,iquan);
    }

    @Override
    public List<Inventory2> selectInvent2(String cinvname) {
        return promotionMapper.selectInvent2(cinvname);
    }

    @Override
    public String getCpersonIds(String autoid) {
        return promotionMapper.getCpersonIds(autoid);
    }
}
