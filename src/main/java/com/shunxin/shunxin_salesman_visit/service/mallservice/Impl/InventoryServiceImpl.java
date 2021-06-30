package com.shunxin.shunxin_salesman_visit.service.mallservice.Impl;


import com.shunxin.shunxin_salesman_visit.dto.malldto.InventoryDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.Commodity;
import com.shunxin.shunxin_salesman_visit.mapper.mallmapper.InventoryMapper;
import com.shunxin.shunxin_salesman_visit.service.mallservice.InventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("InventoryService")
public class InventoryServiceImpl implements InventoryService {

    @Resource
    private InventoryMapper inventoryMapper;


    @Override
    public List<InventoryDto> selectInventory(String ctype, String cuser_id, String ctext) {
        return inventoryMapper.selectInventory(ctype, cuser_id, ctext);
    }

    @Override
    public List<InventoryDto> selectInvtype(String ctype) {
        return inventoryMapper.selectInvtype(ctype);
    }

    @Override
    public List<ResultDto> modifyShoppingTrolley(String ctype, String cuser_id, String cinvcode, int iquan) {
        return inventoryMapper.modifyShoppingTrolley(ctype, cuser_id, cinvcode, iquan);
    }


    @Override
    public List<ResultDto> removeShoppingTrolley(String ctype, String cuser_id, String cinvcode, int iquan) {
        return inventoryMapper.removeShoppingTrolley(ctype, cuser_id, cinvcode, iquan);
    }

    @Override
    public List<InventoryDto> selectShoppingTrolley(String ctype, String cuser_id, String ctext) {
        return inventoryMapper.selectShoppingTrolley(ctype, cuser_id, ctext);
    }

    @Override
    public List<Commodity> selectCommodity(String cInvCode, String ccus_level) {
        return inventoryMapper.selectCommodity(cInvCode, ccus_level);
    }

    @Override
    public String selectCcus_level(int autoid) {
        return inventoryMapper.selectCcus_level(autoid);
    }


}
