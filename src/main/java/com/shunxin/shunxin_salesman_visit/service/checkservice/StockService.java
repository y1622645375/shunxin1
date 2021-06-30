package com.shunxin.shunxin_salesman_visit.service.checkservice;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.Group;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.InventoryStock;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.Stock;

import java.util.List;

public interface StockService {


    //查询商品分类
    List<InventoryStock> selectInventoryOne();


    //查询商品数据
    List<Stock> selectStockinfo(String cinvccode,String cinvcode);


    //录入库存商品
    List<ResultDto> enterStock(String jsonvist);


    //审核存货商品
    List<ResultDto> checkStock(String jsonvist);


    //禁用存货商品
    List<ResultDto> forbidStock(String jsonvist);


    //删除存货商品
    List<ResultDto> deleteStock(String jsonvist);


    //查询计量单位类别
    List<Group> selectGroupType();


    //根据存货编码删除图片
    int deleteInventotyImg(String cinvcode);


    //根据存货编码新增图片
    int insertInventotyImg(String cinvcode,String cinvimg1,String cinvimg);
}
