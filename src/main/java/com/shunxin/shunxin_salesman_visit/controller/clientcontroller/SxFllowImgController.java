package com.shunxin.shunxin_salesman_visit.controller.clientcontroller;


import com.shunxin.shunxin_salesman_visit.dto.clientdto.ReqDto;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.Upload_pictures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/sxfllowImg")
public class SxFllowImgController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BaseApiService baseApiService;
        //单个图片上传
        @RequestMapping("/imageupload")
        public Object Imageupload (HttpServletResponse response, HttpServletRequest request){
            response.setHeader("Access-Control-Allow-Origin", "*");
            String fileUrl = "D:\\tupian";
            Upload_pictures upload_pictures = new Upload_pictures();
            String img = request.getParameter("img");
            String path = upload_pictures.upload(img,fileUrl);
            return baseApiService.setResultResultSuccess(path);
        }

        @RequestMapping("/imageupload2")
        public Object imageupload2 (@RequestBody ReqDto reqDto){
            String fileUrl = "D:\\tupian\\xintup.jpg";
            Upload_pictures upload_pictures = new Upload_pictures();
            String img = reqDto.getUserid();
            String path = upload_pictures.upload(img,fileUrl);
            return baseApiService.setResultResultSuccess(path);
        }


        //拷贝图片
        @RequestMapping("/copypictures")
        public Object Copypictures (HttpServletResponse response, HttpServletRequest request){
            response.setHeader("Access-Control-Allow-Origin", "*");
            String pathh = "";
            String img = request.getParameter("img");
            String cimg_type = request.getParameter("cimg_type");
            String userid = request.getParameter("userid");
            String customerid = request.getParameter("customerid");
            try{
                Upload_pictures upload_pictures = new Upload_pictures();
                String path = "";
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                String[] date = df.format(new Date()).split("-");// new Date()为获取当前系统时间
                String random = (new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000)+".jpg";
                if(Integer.valueOf(cimg_type) == 1){
                    pathh = date[0]+date[1]+"/doorfirst/"+userid+"_"+customerid+"_"+random;
                    path = "E:\\wwwroot\\pic\\sxemall\\"+date[0]+date[1]+"\\doorfirst\\"+userid+"_"+customerid+"_"+random;
                }else if(Integer.valueOf(cimg_type) == 2){
                    pathh = date[0]+date[1]+"/display/"+userid+"_"+customerid+"_"+random;
                    path = "E:\\wwwroot\\pic\\sxemall\\"+date[0]+date[1]+"\\display\\"+userid+"_"+customerid+"_"+random;
                }else if(Integer.valueOf(cimg_type) == 3){
                    pathh = date[0]+date[1]+"/freezer/"+userid+"_"+customerid+"_"+random;
                    path = "E:\\wwwroot\\pic\\sxemall\\"+date[0]+date[1]+"\\freezer\\"+userid+"_"+customerid+"_"+random;
                }else if(Integer.valueOf(cimg_type) == 4){
                    pathh = date[0]+date[1]+"/shelves/"+userid+"_"+customerid+"_"+random;
                    path = "E:\\wwwroot\\pic\\sxemall\\"+date[0]+date[1]+"\\shelves\\"+userid+"_"+customerid+"_"+random;
                }
                File fromFile = new File(img);
                File toFile = new File(path);
                String path2 = upload_pictures.copyByStream(fromFile,toFile,pathh);
                logger.info("工号："+userid+"\t调用上传图片接口\t参数："+img+","+userid+","+cimg_type+","+customerid);
                return baseApiService.setResultResultSuccess(path2);
            }catch (Exception e){
                e.printStackTrace();
                logger.info("工号："+userid+"\t调用上传图片接口\t参数："+img+","+userid+","+cimg_type+","+customerid+"\n返回异常："+e);
                return baseApiService.setResultError(e.toString());
            }
        }

        //拷贝图片
        @RequestMapping("/copypicturess")
        public Object Copypicturess (HttpServletResponse response, HttpServletRequest request){
            response.setHeader("Access-Control-Allow-Origin", "*");
            String pathh = "";
            String img = request.getParameter("img");
            String userid = request.getParameter("userid");
            String type = request.getParameter("type");
            try{
                Upload_pictures upload_pictures = new Upload_pictures();
                String path = "";
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                String[] date = df.format(new Date()).split("-");// new Date()为获取当前系统时间
                String random = "";
                if("tx".equals(type)){
                    random = ".jpg";
                }else{
                    random = "_"+date[1]+date[2]+"_"+(new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000)+".jpg";
                }
                pathh = "/salesman_other/"+userid+random;
                path = "E:\\wwwroot\\pic\\sxemall\\salesman_other\\"+userid+random;
                File fromFile = new File(img);
                File toFile = new File(path);
                String path2 = upload_pictures.copyByStream(fromFile,toFile,pathh);
                logger.info("工号："+userid+"\t调用上传图片接口\t参数："+img+","+userid);
                return baseApiService.setResultResultSuccess(path2);
            }catch (Exception e){
                e.printStackTrace();
                logger.info("工号："+userid+"\t调用上传图片接口\t参数："+img+","+userid+"\n返回结果异常："+e);
                return baseApiService.setResultError(e.toString());
            }
        }




}
