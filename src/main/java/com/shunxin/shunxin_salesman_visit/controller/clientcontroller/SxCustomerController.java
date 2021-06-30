package com.shunxin.shunxin_salesman_visit.controller.clientcontroller;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.*;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.LinenameTotal;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.SxCustomer;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.Upload_pictures;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxCustomerService;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxPersonareaService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/sxCustomer")
public class SxCustomerController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SxCustomerService sxCustomerService;
    @Autowired
    private SxPersonareaService sxPersonareaService;
    @Autowired
    private BaseApiService baseApiService;
    @Autowired
    private CheckService checkService;

    /**
     * 根据业务员ID查询其负责商家的数量
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectCustomerCount")
    public Object selectCustomerCount(HttpServletResponse response,HttpServletRequest request,@RequestBody ReqDto reqDto){
        String userid = reqDto.getUserid();
        try {
            CustNumberDto listCustomer = sxCustomerService.selectCustomerCount(userid);
            logger.info("调用：根据业务员ID查询其负责商家的数量"+"工号："+reqDto.getUserid()+"\t调用查询负责商家数量接口\t参数："+reqDto.getUserid()+"\n返回结果："+listCustomer);
            return baseApiService.setResultResultSuccess(listCustomer);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("工号："+reqDto.getUserid()+"\t调用查询负责商家数量接口\t参数："+reqDto.getUserid()+",\n返回结果异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }



    /**
     * 根据客户类型、客户名称查询客户列表（包含模糊查询）
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/selectCustomerList",method = RequestMethod.POST)
    public Object selectCustomerList(HttpServletResponse response,@RequestBody ReqDto reqDto){
        String cuserid = reqDto.getCuserid();
        String ckey = reqDto.getCkey();
        int ilogin_type = reqDto.getIlogin_type();
        String userid = reqDto.getUserid();
        String ccus_status = reqDto.getCcus_status();
        String ccus_name = reqDto.getCcus_name();
        if(ccus_name==null||ccus_name.equals("")){
            ccus_name = "";
        }
        int autoid =StringUtils.isEmpty(reqDto.getAutoid())?0:Integer.parseInt(reqDto.getAutoid());
        try {
            String result = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (result.equals("1")){
                List<CustomerDto> sxCustomerList = sxCustomerService.selectCustomerListcharge(userid,ccus_status,ccus_name,autoid);
                logger.info("调用：根据客户类型、客户名称查询客户列表"+"工号："+reqDto.getUserid()+"\t参数："+userid+","+ccus_status+","+ccus_name+","+autoid);
                return baseApiService.setResultResultSuccess(sxCustomerList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("返回错误结果："+e.toString());
            return  baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 新增或修改客户信息
     * @param response
     * @param reqDto
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertCustomer")
    public Object insertCustomer(HttpServletResponse response ,@RequestBody ReqDto reqDto){
        String cuserid = reqDto.getCuserid();
        String ckey = reqDto.getCkey();
        int ilogin_type = reqDto.getIlogin_type();
        String json = reqDto.getJsonvisit();
        try {
            String results = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results.equals("1")){
                List<ResultDto> result = sxCustomerService.insertCustomer(json);
                logger.info("新增或修改客户信息\t参数："+json+"\n返回结果："+result);
                return baseApiService.setResultResultSuccess(result);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("新增客户\t参数："+json+"\n返回结果异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 新增或修改客户信息(小程序专用)
     * @param reqDto
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertCustomers")
    public Object insertCustomers(@RequestBody ReqDto reqDto) throws Exception{
        String json = reqDto.getJsonvisit();
        JSONObject jsonObject = JSONObject.fromObject(json);
        String clicense_img1 = jsonObject.get("clicense_img1").toString();  //获取到图片的base64编码
        String clicense_img2 = jsonObject.get("clicense_img2").toString();
        String clicense_img3 = jsonObject.get("clicense_img3").toString();
        Upload_pictures upload_pictures = new Upload_pictures();
        String fileUrl = "E:\\wwwroot\\pic\\sxemall\\public";
        String path1 = upload_pictures.upload(clicense_img1,fileUrl);    //保存图片
        String path2 = upload_pictures.upload(clicense_img2,fileUrl);
        String path3 = upload_pictures.upload(clicense_img3,fileUrl);
        String imgurl1 = path1.substring(path1.lastIndexOf("\\")+1);
        logger.info("图片名称1："+imgurl1);
        String imgurl2 = path2.substring(path2.lastIndexOf("\\")+1);
        logger.info("图片名称2："+imgurl2);
        String imgurl3 = path3.substring(path3.lastIndexOf("\\")+1);
        logger.info("图片名称3："+imgurl3);
        if (jsonObject.get("clicense_img1") != null) {
            jsonObject.put("clicense_img1", imgurl1);
        }
        if (jsonObject.get("clicense_img2") != null) {
            jsonObject.put("clicense_img2", imgurl2);
        }
        if (jsonObject.get("clicense_img3") != null) {
            jsonObject.put("clicense_img3", imgurl3);
        }
        try {
            List<ResultDto> result = sxCustomerService.insertCustomer(jsonObject.toString());
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("新增客户\t参数："+json+"\n返回结果异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }



    /**
     * 查询今日拜访客户列表
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectFllowCuslistList")
    public Object selectFllowCuslistList(HttpServletResponse response,@RequestBody ReqDto reqDto) throws Exception{
        String cuserid = reqDto.getCuserid();
        String ckey = reqDto.getCkey();
        int ilogin_type = reqDto.getIlogin_type();
        String userid = reqDto.getUserid();
        BigDecimal xpiont = reqDto.getXpiont();
        BigDecimal ypiont = reqDto.getYpiont();
        String ccus_name = reqDto.getCcus_name();
        int bplan = reqDto.getBplan();
        int distance = 200;  //默认拜访距离为200米，以防数据库出现错误
        try {
            String results = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results.equals("1")){
                distance = Integer.parseInt(sxPersonareaService.getInformCvalues("fllowlimit"));  //距离限制由数据库决定
                List<FllowCuslistDto> fllowCuslistList = sxCustomerService.selectFllowCuslistList(userid,xpiont,ypiont,distance,ccus_name,bplan);
                logger.info("调用：查询今日拜访客户列表"+"工号："+reqDto.getUserid()+"\t调用今日拜访客户列表接口\t参数："+userid+","+xpiont+","+ypiont+","+distance+","+ccus_name+","+bplan);
                return baseApiService.setResultResultSuccess(fllowCuslistList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("工号："+reqDto.getUserid()+"\t调用今日拜访客户列表接口\t参数："+userid+","+xpiont+","+ypiont+","+","+ccus_name+","+bplan+"\n返回结果异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据不同的条件查询客户级别/客户类型/商品
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectEnumdatasList")
    public Object selectEnumdatasList(HttpServletResponse response,@RequestBody ReqDto reqDto){
        String cuserid = reqDto.getCuserid();
        String ckey = reqDto.getCkey();
        int ilogin_type = reqDto.getIlogin_type();
        String ctype =  reqDto.getCtype(); //ccuslevel客户级别,ccustype客户类型,inventory商品
        try {
            String results = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results.equals("1")){
                List<EnumdataDto> enumdatalist = sxCustomerService.selectEnumdatasList(ctype);
                logger.info("调用：根据不同的条件查询客户级别/客户类型/商品"+"参数："+ reqDto.getCtype());
                return baseApiService.setResultResultSuccess(enumdatalist);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch(Exception e){
            e.printStackTrace();
            logger.info("商品结果返回异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询业务员列表
     * @param response
     * @param salesmanDto
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectSalesmanList")
    public Object selectSalesmanList(HttpServletResponse response,@RequestBody SalesmanDto salesmanDto) throws Exception{
        response.setHeader("Access-Control-Allow-Origin","*");
        String ccode = salesmanDto.getCcode();   //主管编码
        String cname = salesmanDto.getCname();   //员工姓名
        try{
            List<SalesmanDto> salesmanDtoList = sxCustomerService.selectSalesmanList(ccode,cname);
            logger.info("调用：查询业务员列表"+"参数："+ccode+",\t员工姓名："+cname);
            return baseApiService.setResultResultSuccess(salesmanDtoList);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("商品结果返回异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据客户类型、客户名称查询客户列表
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/selectCustomerListcharge",method = RequestMethod.POST)
    public Object selectCustomerListcharge(HttpServletResponse response,@RequestBody ReqDto reqDto){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String cuserid = reqDto.getCuserid();
        String ckey = reqDto.getCkey();
        int ilogin_type = reqDto.getIlogin_type();
        String userid = reqDto.getUserid();
        String ccus_status = reqDto.getCcus_status();
        String ccus_name = reqDto.getCcus_name();
        if(ccus_name==null||ccus_name.equals("")){
            ccus_name = "";
        }
        int autoid =StringUtils.isEmpty(reqDto.getAutoid())?0:Integer.parseInt(reqDto.getAutoid());
        try {
            String results = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results.equals("1")){
                List<CustomerDto> sxCustomerList = sxCustomerService.selectCustomerListcharge(userid,ccus_status,ccus_name,autoid);
                logger.info("工号："+reqDto.getUserid()+"\t调用查询客户列表接口\t参数："+userid+","+ccus_status+","+ccus_name+","+autoid);
                return baseApiService.setResultResultSuccess(sxCustomerList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("工号："+reqDto.getUserid()+"\t调用查询客户列表接口\t参数："+userid+","+ccus_status+","+ccus_name+","+autoid+"\t返回结果异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 业务员跟踪
     * @param response
     * @param personDto
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectPersonList")
    public Object selectPersonList(HttpServletRequest request, HttpServletResponse response, @RequestBody  PersonDto personDto)  {
        String cfllow_pid = personDto.getCfllow_pid();
        try{
            List<PersonDto> personDtoList = sxCustomerService.selectPersonList(cfllow_pid);
            logger.info("调用：业务员跟踪"+"参数："+cfllow_pid);
            return baseApiService.setResultResultSuccess(personDtoList);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("商品结果返回异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 添加评论
     * @param response
     * @param fllowCheckDto
     * @return
     *
     *
     * @throws Exception
     */
    @RequestMapping("/updateCuslist")
    public Object updateCuslist(HttpServletResponse response,@RequestBody FllowCheckDto fllowCheckDto) throws Exception{
        response.setHeader("Access-Control-Allow-Origin","*");
        int autoid = fllowCheckDto.getAutoid();
        String cuser_id = fllowCheckDto.getCuser_id();
        String cchecktext = fllowCheckDto.getCchecktext();
        try{
            List<ResultDto> result = sxCustomerService.updateCuslist(autoid,cuser_id,cchecktext);
            logger.info("调用：添加评论"+"参数："+autoid+"\t主管ID"+cuser_id+"\t评论内容:"+cchecktext+"\t返回结果："+result);
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("结果返回异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 修改拜访计划
     * @param response
     * @param planaddDto
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertPayvisit")
    public Object insertPayvisit(HttpServletResponse response,@RequestBody PlanaddDto planaddDto) throws Exception{
        response.setHeader("Access-Control-Allow-Origin","*");
        String cuserid = planaddDto.getCuserid();
        String ckey = planaddDto.getCkey();
        int ilogin_type = planaddDto.getIlogin_type();
        String ccus_cid = planaddDto.getCcus_cid();     //客户ID
        String ccus_pid = planaddDto.getCcus_pid();     //操作员ID
        String ccus_visit_type = planaddDto.getCcus_visit_type(); //拜访计划类型
        String ccus_visit_time = planaddDto.getCcus_visit_time(); //计划拜访时间
        String outcome = "";
        try{
            String results = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results.equals("1")){
                //先删除旧的拜访计划
                int resultDtos = sxCustomerService.deleteCustomer(ccus_cid,ccus_pid);
                if(resultDtos!=0){
                    int result = 0;
                    if(ccus_visit_type.equals("1")){   //类型为每周
                        String [] tsz =ccus_visit_time.split("");
                        for (String str: tsz) {
                            result =  sxCustomerService.insertPayvisit(ccus_cid,ccus_pid,ccus_visit_type,str);
                        }
                    }else {
                        result = sxCustomerService.insertPayvisit(ccus_cid,ccus_pid,ccus_visit_type,ccus_visit_time);
                    }
                    if(result!=0){
                        logger.info("调用：修改拜访计划"+"参数："+"\t客户ID:"+ccus_cid+"\t操作员ID:"+ccus_pid+"\t拜访计划类型："+ccus_visit_type+"\t计划拜访时间："+ccus_visit_time+"\t返回结果：修改成功");
                        outcome = "修改成功";
                    }else {
                        outcome = "修改失败";
                    }
                }else {
                    logger.info("调用：修改拜访计划"+"参数："+"\t客户ID:"+ccus_cid+"\t操作员ID:"+ccus_pid+"\t拜访计划类型："+ccus_visit_type+"\t计划拜访时间："+ccus_visit_time+"\t返回结果：删除旧拜访计划失败");
                    outcome = "删除旧拜访计划失败";
                }
                return baseApiService.setResultResultSuccess(outcome);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("结果返回异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询客户列表（PC 端）
     * @param response
     * @param customerDto
     * @return
     */
    @RequestMapping("/selectCustomerList2")
    public Object selectCustomerList2(HttpServletResponse response,@RequestBody CustomerDto customerDto){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String cuserid = customerDto.getCuserid();
        String ckey = customerDto.getCkey();
        int ilogin_type = customerDto.getIlogin_type();
        String cperson_id = customerDto.getCperson_id();
        String ccus_name = customerDto.getCcus_name();
        String ccus_account =customerDto.getCcus_account();
        String cperson_name = customerDto.getCperson_name();
        String ccus_type = customerDto.getCcus_type();
        String ccus_level = customerDto.getCcus_level();
        String ccus_visit_type = customerDto.getCcus_visit_type();
        String icus_visit_time = customerDto.getIcus_visit_time();
        String ccus_status = customerDto.getCcus_status();
        try {
            String results = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results.equals("1")){
                List<String> ccompanyidlist = sxCustomerService.selectCcompany(cperson_id);
                String[] ccompanyidstr = ccompanyidlist.toArray(new String[ccompanyidlist.size()]);
                StringBuffer sbuff = new StringBuffer();
                for(String s:ccompanyidstr){
                    sbuff.append("," +"\'"+s+"\'");
                }
                String ccompany = sbuff.substring(1);
                List<SxCustomer> sxCustomerList = sxCustomerService.selectCustomerList2("",ccus_name,ccus_account,cperson_name,ccus_type,ccus_level,ccus_visit_type,icus_visit_time,ccus_status,ccompany);
                logger.info("查询客户列表（PC 端）--"+"参数：--\tcperson_id"+cperson_id+"\tccus_name"+ccus_name+
                        "\tccus_account"+ccus_account+"\tcperson_name"+cperson_name+"\tccus_type"+ccus_type+"\tccus_level"+ccus_level
                        +"\tccus_visit_type"+ccus_visit_type+"\ticus_visit_time"+icus_visit_time);
                return baseApiService.setResultResultSuccess(sxCustomerList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("结果返回异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     *  客户禁用或启用
     * @param response
     * @param customerDto
     * @return
     */
    @RequestMapping("/updateccusStatus")
    public Object updateccusStatus (HttpServletResponse response,@RequestBody CustomerDto customerDto){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String cuserid = customerDto.getCuserid();
        String ckey = customerDto.getCkey();
        int ilogin_type = customerDto.getIlogin_type();
        int autoid = customerDto.getAutoid();
        String ccus_status = customerDto.getCcus_status();
        String cperson_id = customerDto.getCperson_id();
        String customerjson ="";
        String results = "";
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                if(ccus_status.equals("1")){ //启用
                    customerjson = " {\"ctype\":\"07\",\"isxemallid\":\""+autoid+"\",\"cperson_id\":\""+cperson_id+"\"}";
                }else if(ccus_status.equals("11")){ //禁用
                    customerjson = " {\"ctype\":\"06\",\"isxemallid\":\""+autoid+"\",\"cperson_id\":\""+cperson_id+"\"}";
                }
                List<ResultDto> resultDtoList = sxCustomerService.updateccusStatus(customerjson);
                for (ResultDto resultDto : resultDtoList) {
                    results = resultDto.getResult();
                }
                if(results.equals("0")){
                    results = "成功";
                }else {
                    results = "失败";
                }
                return baseApiService.setResultResultSuccess(results);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("结果返回异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 审核客户信息
     * @param response
     * @param customerDto
     * @return
     */
    @RequestMapping("/updateAudit")
    public Object updateAudit(HttpServletResponse response,@RequestBody CustomerDto customerDto){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String cuserid = customerDto.getCuserid();
        String ckey = customerDto.getCkey();
        int ilogin_type = customerDto.getIlogin_type();
        String ccus_status = customerDto.getCcus_status(); //状态
        String ccus_code = customerDto.getCcus_code();  //用友客户编码
        String cdefine1 = customerDto.getCdefine1();   //处理回复
        int autoid = customerDto.getAutoid();          //客户autoid
        String ccuspperson = customerDto.getCcuspperson();  //业务员ID
        //String results = "";
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                String customerjson = "{\"ctype\":\"05\",\"isxemallid\":\""+autoid+"\",\"ccus_code\":\""+ccus_code+"\",\"ccus_status\":\""+ccus_status+"\",\"ccuspperson\":\""+ccuspperson+"\"}";
                List<ResultDto> resultDtoList = sxCustomerService.updateAudit(customerjson);
                logger.info("审核客户信息\t参数：autoid:"+autoid+"\tccus_status："+ccus_status+"\tccus_code："+ccus_code+"\tcdefine1："+cdefine1);
                return baseApiService.setResultResultSuccess(resultDtoList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("结果返回异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询该人员所属公司的所有在职人员
     * @param response
     * @return
     */
    @RequestMapping("/selectPersonName")
    public Object selectPersonName(HttpServletResponse response,@RequestBody CustomerDto customerDto){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String cuserid = customerDto.getCuserid();
        String ckey = customerDto.getCkey();
        int ilogin_type = customerDto.getIlogin_type();
        String cperson_id = customerDto.getCperson_id();
        try {
            /*String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){*/
                List<ParameterDto> personNameDtoList = sxCustomerService.selectPersonName(cperson_id);
                logger.info("查询业务员姓名==cperson_id："+cperson_id);
                return baseApiService.setResultResultSuccess(personNameDtoList);
           /* }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }*/
        }catch (Exception e){
            e.printStackTrace();
            logger.info("结果返回异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 删除客户
     * @param response
     * @return
     */
    @RequestMapping("/delectCustomers")
    public Object delectCustomers(HttpServletResponse response,@RequestBody CustomerDto customerDto){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String cuserid = customerDto.getCuserid();
        String ckey = customerDto.getCkey();
        int ilogin_type = customerDto.getIlogin_type();
        int autoid = customerDto.getAutoid();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<ResultDto> resultDtos = sxCustomerService.delectCustomers(autoid);
                logger.info("删除客户");
                return baseApiService.setResultResultSuccess(resultDtos);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("结果返回异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 导出Excel文件
     * @param response
     * @return
     */
    @RequestMapping("/deriveExcel")
    public Object deriveExcel(HttpServletResponse response,@RequestBody ReqDto reqDto){
        String jsonvisit = reqDto.getJsonvisit();
        String tables_name = "客户管理表";
        JSONArray jsonArray = JSONArray.fromObject(jsonvisit);  // 首先把字符串转成 JSONArray  对象
        List<LinenameTotal> linenameTotalList = sxCustomerService.selectLinenameTotal(tables_name);
        HSSFWorkbook workbook = new HSSFWorkbook();   //创建工作簿对象
        String title = tables_name;
        try {
            String filename = "";
            for (int x = 1; x < 2; x++) {
                HSSFSheet sheet = workbook.createSheet(title+x);  //创建工作表
                List<HashMap<String,Object>> mapList = new ArrayList<HashMap<String,Object>>();
                if (jsonArray.size()>0){
                    int count = 0;
                    String[] rowsName = new String[linenameTotalList.size()];
                    String[] rowsValue = new String[linenameTotalList.size()];
                    for (LinenameTotal total : linenameTotalList) {
                        rowsName[count] = total.getColumn_name();
                        rowsValue[count] = total.getColumn_value();
                        count++;
                    }
                    for (int i = 0; i < jsonArray.size(); i++) {
                        if (i%10==0){
                            System.out.println("当前循环次数："+i);
                        }
                        JSONObject job = jsonArray.getJSONObject(i);// 遍历 jsonarray 数组，把每一个对象转成 json 对象
                        HashMap<String,Object> dataMap = new HashMap<String,Object>();
                        for (int j = 1; j < rowsValue.length; j++) {
                            String[] str1 = rowsValue[j].split(",");
                            String zhi = "";
                            for (int i1 = 0; i1 < str1.length; i1++) {
                                String [] str2 = str1[i1].split("：");
                                int sint = 1;
                                for (String s : str2) {
                                    if(sint % 2 != 1){
                                        zhi+=job.get(s)+"\n";
                                    }else{
                                        zhi+=s+":";
                                    }
                                    sint++;
                                }
                           }
                            dataMap.put(rowsName[j],zhi);
                        }
                        mapList.add(dataMap);
                    }
                    List<Object[]> dataList = new ArrayList<Object[]>();
                    Object[] objects = null;
                    for (int i = 0; i < mapList.size(); i++) {
                        HashMap<String,Object> data = mapList.get(i);
                        objects = new Object[rowsName.length];
                        for (int j = 0; j < count; j++) {
                            objects[j] = data.get(rowsName[j]);
                        }
                        dataList.add(objects);
                    }
                    /*ExportExcel ex = new ExportExcel(title, rowsName, dataList);
                    filename=  ex.export(workbook,sheet,x);*/
                }
            }
            return baseApiService.setResultResultSuccess(filename);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 批量修改商家所属业务员
     * @return
     */
    @RequestMapping("/batchUpdate")
    public Object batchUpdate(@RequestBody ReqDto reqDto){
        String cperson_id = reqDto.getCperson_id();
        String autoid = reqDto.getAutoid();
        String results = "";
        String customerinfo = "";
        try {
            List<ParameterDto> personNameDtoList = sxCustomerService.selectPersonName(cperson_id);
            if (personNameDtoList.size()!=0){  //判断输入的工号是否存在
                JSONArray jsonArray = JSONArray.fromObject(autoid);
                for (Object obj : jsonArray) {
                    JSONObject jsonObject = JSONObject.fromObject(obj);
                    String autoid1 = jsonObject.get("autoid").toString();
                    String cperson_old = jsonObject.get("cperson_old").toString();
                    customerinfo = "{\"ctype\":\"04\",\"cperson_id\":\""+cperson_id+ "\",\"isxemallid\":\""+autoid1+"\",\"cperson_old\":\""+cperson_old+"\"}";
                    List<ResultDto> resultDtos = sxCustomerService.batchUpdate(customerinfo);
                    for (ResultDto resultDto : resultDtos) {
                        String str = resultDto.getMsg();
                        results = str;
                    }
                }
                /*shuzu = autoid.split(",");
                for (int i = 0; i < shuzu.length; i++) {
                    customerinfo = "{\"ctype\":\"04\",\"cperson_id\":\""+cperson_id+ "\",\"isxemallid\":\""+shuzu[i]+"\"}";
                    resultDtos = sxCustomerService.batchUpdate(customerinfo);
                    for (ResultDto resultDto : resultDtos) {
                        String str = resultDto.getMsg();
                        results = str;
                    }
                }*/
            }else {
                results = "输入的工号不存在，请重新输入！";
            }
            return baseApiService.setResultResultSuccess(results);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询单个店铺信息
     * @param request
     * @param customer
     * @return
     */
    @RequestMapping("/selectCustomer")
    public Object selectCustomer(HttpServletRequest request, @RequestBody SxCustomer customer){
        int autoid = customer.getAutoid();
        try {
            List<CustomerDto> sxCustomerList = sxCustomerService.selectCustomer(autoid);
            logger.info("autoid："+autoid);
            return baseApiService.setResultResultSuccess(sxCustomerList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 餐饮业务员下单查询客户
     * @return
     */
    @RequestMapping("/getFllowCusList")
    public Object getFllowCusList(@RequestBody ReqDto reqDto){
        String cuserid = reqDto.getCuserid();
        String ckey = reqDto.getCkey();
        int ilogin_type = reqDto.getIlogin_type();
        BigDecimal xpiont = reqDto.getXpiont();
        BigDecimal ypiont = reqDto.getYpiont();
        String ccus_name = reqDto.getCcus_name();
        int bplan = reqDto.getBplan();
        String ctype = reqDto.getCtype();
        try {
            String results = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results.equals("1")){
                if (ctype.equals("01")){ //车销下单查询客户
                    int distance = Integer.parseInt(sxPersonareaService.getInformCvalues("orderlimit_carsales"));  //车销下单距离限制
                    List<FllowCuslistDto> fllowCusList = sxCustomerService.getFllowCusList(cuserid,xpiont,ypiont,distance,ccus_name,bplan);
                    return baseApiService.setResultResultSuccess(fllowCusList);
                }else {
                    int distance = Integer.parseInt(sxPersonareaService.getInformCvalues("orderlimit_beverage"));  //餐饮下单距离限制
                    List<FllowCuslistDto> fllowCusList = sxCustomerService.getFllowCusList(cuserid,xpiont,ypiont,distance,ccus_name,bplan);
                    return baseApiService.setResultResultSuccess(fllowCusList);
                }
            }else {
                return baseApiService.setResultError("服务器繁忙...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }




}
