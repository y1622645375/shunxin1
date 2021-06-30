package com.shunxin.shunxin_salesman_visit.controller.clientcontroller;


import com.shunxin.shunxin_salesman_visit.dto.clientdto.AutoCharDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.ReqDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.TouristDto;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.AutoChar;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.Inventory;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.InventoryClass;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxAInvService;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxPersonareaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/sxAInv")
public class SxAInvController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SxAInvService sxAInvService;
    @Autowired
    private SxPersonareaService sxPersonareaService;
    @Autowired
    private BaseApiService baseApiService;


    /**
     * 查询商品分类（顺兴商城和车销共用）
     * @return
     */
    @RequestMapping("/getInventClass")
    public Object getInventClass(){
        List<InventoryClass> inventoryClassList = new ArrayList<>();
        try {
            inventoryClassList = sxAInvService.getInventClass();
            return baseApiService.setResultResultSuccess(inventoryClassList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据商品分类查询商品（顺兴商城使用了）
     * @param
     * @return
     */
    @RequestMapping("/getInventory")
    public Object getInventory(@RequestBody ReqDto reqDto){
        String cinvccode = reqDto.getCinvccode();     //商品类别
        String cperson_id = reqDto.getCperson_id();   //业务员编号
        String ccus_id = reqDto.getCcus_id();         //客户编号
        String ctype = reqDto.getCtype();
        try {
            if (ctype.equals("wxopen")){
                String compand = "";
                String ccus_level = "";
                List<TouristDto> touristDtoList = sxAInvService.selectCcompanyId(ccus_id);
                for (TouristDto touristDto : touristDtoList) {
                    compand = touristDto.getCcompany_id();
                    ccus_level = touristDto.getCcus_level();
                }
                List<Inventory> inventoryList = sxAInvService.getInventory(compand,ccus_level,cinvccode);
                return baseApiService.setResultResultSuccess(inventoryList);
            }else {
                String compand = sxPersonareaService.selectCompand(cperson_id);
                List<Inventory> inventoryList = sxAInvService.getInventory(compand,"0202",cinvccode);
                return baseApiService.setResultResultSuccess(inventoryList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询各类排名
     * @return
     */
    @RequestMapping("/selectAutoChar")
    public Object selectAutoChar(@RequestBody AutoCharDto charDto){
        String ctype = charDto.getCtype();
        String userid = charDto.getUserid();
        String ddate1 = charDto.getDdate1();
        String ddate2 = charDto.getDdate2();
        try {
            List<AutoChar> autoChars = sxAInvService.selectAutoChar(ctype,userid,ddate1,ddate2);
            return baseApiService.setResultResultSuccess(autoChars);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    @RequestMapping("/getCcusAccount")
    public Object getCcusAccount(){
        try {
            String path = sxAInvService.getCcusAccount("13956");
            return baseApiService.setResultResultSuccess(path);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


}
