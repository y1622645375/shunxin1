package com.shunxin.shunxin_salesman_visit.service.checkservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.Group;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.InventoryStock;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.Stock;
import com.shunxin.shunxin_salesman_visit.mapper.checkmapper.StockMapper;
import com.shunxin.shunxin_salesman_visit.service.checkservice.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("StockService")
public class StockServiceImpl implements StockService {


    @Resource
    private StockMapper stockMapper;


    @Override
    public List<InventoryStock> selectInventoryOne() {
        return stockMapper.selectInventoryOne();
    }

    @Override
    public List<Stock> selectStockinfo(String cinvccode,String cinvcode) {
        return stockMapper.selectStockinfo(cinvccode,cinvcode);
    }

    @Override
    public List<ResultDto> enterStock(String jsonvist) {
        return stockMapper.enterStock(jsonvist);
    }

    @Override
    public List<ResultDto> checkStock(String jsonvist) {
        return stockMapper.checkStock(jsonvist);
    }

    @Override
    public List<ResultDto> forbidStock(String jsonvist) {
        return stockMapper.forbidStock(jsonvist);
    }

    @Override
    public List<ResultDto> deleteStock(String jsonvist) {
        return stockMapper.deleteStock(jsonvist);
    }

    @Override
    public List<Group> selectGroupType() {
        return stockMapper.selectGroupType();
    }

    @Override
    public int deleteInventotyImg(String cinvcode) {
        return stockMapper.deleteInventotyImg(cinvcode);
    }

    @Override
    public int insertInventotyImg(String cinvcode, String cinvimg1, String cinvimg) {
        return stockMapper.insertInventotyImg(cinvcode,cinvimg1,cinvimg);
    }


}
