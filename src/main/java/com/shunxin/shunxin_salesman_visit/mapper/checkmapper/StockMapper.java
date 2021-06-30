package com.shunxin.shunxin_salesman_visit.mapper.checkmapper;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.Group;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.InventoryStock;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.Stock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockMapper {


    //查询商品分类
    List<InventoryStock> selectInventoryOne();


    //查询商品数据
    List<Stock> selectStockinfo(@Param("cinvccode") String cinvccode,@Param("cinvcode") String cinvcode);


    //录入库存商品
    List<ResultDto> enterStock(@Param("jsonvist") String jsonvist);


    //审核存货商品
    List<ResultDto> checkStock(@Param("jsonvist") String jsonvist);


    //禁用存货商品
    List<ResultDto> forbidStock(@Param("jsonvist") String jsonvist);


    //删除存货商品
    List<ResultDto> deleteStock(@Param("jsonvist") String jsonvist);


    //查询计量单位类别
    List<Group> selectGroupType();


    //根据存货编码删除图片
    int deleteInventotyImg(@Param("cinvcode") String cinvcode);


    //根据存货编码新增图片
    int insertInventotyImg(@Param("cinvcode") String cinvcode,@Param("cinvimg1") String cinvimg1,@Param("cinvimg") String cinvimg);


}
