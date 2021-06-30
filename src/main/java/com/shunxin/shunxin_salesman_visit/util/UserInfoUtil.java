package com.shunxin.shunxin_salesman_visit.util;

import com.shunxin.shunxin_salesman_visit.service.clientservice.SxPersonareaService;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;


/**
 *  获取用户基本信息的工具类
 * @author yinyang
 * @date 2019-10-08
 * */
@Component
public class UserInfoUtil {

    @Resource
    private  SxPersonareaService sxPersonareaService;

    private static final String GET_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info";
    private static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
    private static final String GET_XCXINFO_URL = "https://api.weixin.qq.com/sns/jscode2session";
    private static final String GET_QYTOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    //获取code后，请求该链接获取access_token
    private static final String GET_OAYTH_TOKEN_URl = "https://api.weixin.qq.com/sns/oauth2/access_token";
    private static final String GET_XCXDEALERS_URL = "https://api.weixin.qq.com/sns/jscode2session";

    /**
     * 根据openid直接获取用户的基本信息unionid
     * @param openId 用户的openid
     * @return unionid
     */
    public String getInfoById(String openId) {
        String unionid = "";
        try {
            String access_token = getAccessToken();
            String userinfo = CallUrl.sendGet(GET_INFO_URL,"access_token="+access_token+"&openid="+openId+"&lang=zh_CN");
            JSONObject jsonObject = (JSONObject) (new JSONParser().parse(userinfo));
            if (jsonObject.get("subscribe").toString().equals("1")){
                unionid = jsonObject.get("unionid").toString();
            }else {
                unionid = "未关注公众号";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unionid;
    }


    /**
     * 通过openid获取用户的微信头像
     * @param openId
     * @return
     */
    public String getHeadimgurl(String openId) {
        String headimgurl = "";
        try {
            String access_token = getAccessToken();
            String userinfo = CallUrl.sendGet(GET_INFO_URL,"access_token="+access_token+"&openid="+openId+"&lang=zh_CN");
            JSONObject jsonObject = (JSONObject) (new JSONParser().parse(userinfo));
            if (jsonObject.get("subscribe").toString().equals("1")){
                headimgurl = jsonObject.get("headimgurl").toString();
            }else {
                headimgurl = "未关注公众号";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return headimgurl;
    }



    /**
     * 获取公众号的access_token
     * @return access_token
     */
    public String getAccessToken(){
        String appid = "wxab0e17f759d71d17";
        String secret = "e232d9253eefb5abdf14a46f60a8a4e5";
        String access_token = "";
        try {
            String results = sxPersonareaService.selectGztoken();
            if (results==null){ //不存在token,则进行查询存储并返回
                String jsonvisit = CallUrl.sendGet(GET_TOKEN_URL, "grant_type=client_credential&" + "appid=" + appid + "&secret=" + secret);
                JSONObject jsonObj = (JSONObject) (new JSONParser().parse(jsonvisit));
                sxPersonareaService.insertGztoken(jsonObj.get("access_token").toString());
                access_token = jsonObj.get("access_token").toString();
            }else {  //存在token
                int count2 = sxPersonareaService.validationDEXTIME(); //校验token是否过期
                if(count2==0){ //已过期，重新获取存储并返回
                    String jsonvisit = CallUrl.sendGet(GET_TOKEN_URL, "grant_type=client_credential&" + "appid=" + appid + "&secret=" + secret);
                    JSONObject jsonObj = (JSONObject) (new JSONParser().parse(jsonvisit));
                    sxPersonareaService.updateGztoken(jsonObj.get("access_token").toString());
                    access_token = jsonObj.get("access_token").toString();
                }else { //未过期,直接返回token
                    access_token = results;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return access_token;
    }


    /**
     * 获取企业微信access_token(企业微信小程序)
     * @return
     */
    public String getQywxToken(){
        String corpid = "wx9710769b1535adb4";
        String corpsecret = "vX2Ofts-2emqwS7jahHj4Lc6QKDfaQH3AxOueTvPKoE";

        String access_token = "";
        String cuser_id = "qytoken";
        try {
            String result = sxPersonareaService.selectQytoken(cuser_id);
            if (result==null){ //不存在token,则进行查询存储并返回
                String jsonvisit =  CallUrl.sendGet(GET_QYTOKEN_URL,"corpid="+corpid+"&corpsecret="+corpsecret);
                JSONObject jsonObj = (JSONObject)(new JSONParser().parse(jsonvisit));
                sxPersonareaService.insertQytoken(cuser_id,jsonObj.get("access_token").toString());
                access_token = jsonObj.get("access_token").toString();
            }else {  //存在token
                int count = sxPersonareaService.validtionQytoken(cuser_id); //校验token是否过期
                if(count==0){ //已过期，重新获取存储并返回
                    String jsonvisit =  CallUrl.sendGet(GET_QYTOKEN_URL,"corpid="+corpid+"&corpsecret="+corpsecret);
                    System.out.println("获取到的结果为："+jsonvisit);
                    JSONObject jsonObj = (JSONObject)(new JSONParser().parse(jsonvisit));
                    sxPersonareaService.updateQytoken(jsonObj.get("access_token").toString(),cuser_id);
                    access_token = jsonObj.get("access_token").toString();
                }else { //未过期,直接返回token
                    access_token = result;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return access_token;
    }


    /**
     * 获取企业微信打卡access_token
     * @return
     */
    public String getQywxTokenDaka(){
        String corpid = "wx9710769b1535adb4";
        String corpsecret = "zz4u-cjPSRV3FMXuDsH4Rw3UIzLkOxi4Tchc_aroKWc";
        String access_token = "";
        String cuser_id = "qypunchtoken";
        try {
            String result = sxPersonareaService.selectQytoken(cuser_id);
            if (result==null){ //不存在token,则进行查询存储并返回
                String jsonvisit =  CallUrl.sendGet(GET_QYTOKEN_URL,"corpid="+corpid+"&corpsecret="+corpsecret);
                JSONObject jsonObj = (JSONObject)(new JSONParser().parse(jsonvisit));
                sxPersonareaService.insertQytoken(cuser_id,jsonObj.get("access_token").toString());
                access_token = jsonObj.get("access_token").toString();
            }else {  //存在token
                int count = sxPersonareaService.validtionQytoken(cuser_id); //校验token是否过期
                if(count==0){ //已过期，重新获取存储并返回
                    String jsonvisit =  CallUrl.sendGet(GET_QYTOKEN_URL,"corpid="+corpid+"&corpsecret="+corpsecret);
                    JSONObject jsonObj = (JSONObject)(new JSONParser().parse(jsonvisit));
                    sxPersonareaService.updateQytoken(jsonObj.get("access_token").toString(),cuser_id);
                    access_token = jsonObj.get("access_token").toString();
                }else { //未过期,直接返回token
                    access_token = result;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return access_token;
    }


    /**
     * 获取小程序的用户信息
     * @param code
     * @return unionid
     */
    public String getXcxunionid(String code){
        String appid = "wx342776e9d9dd8760";
        String secret = "56772fa619a07cf45c0c0d00efcd5ac3";
        String unionid = "";
        try {
            String json = CallUrl.sendGet(GET_XCXINFO_URL,"appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code");
            JSONObject jsonObj = (JSONObject)(new JSONParser().parse(json));
            unionid = jsonObj.get("unionid").toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return unionid;
    }


    /**
     * 通过code获取配送商小程序的个人信息
     * @param code
     * @return
     */
    public String getWxXcxDealers(String code){
        String appid = "wxc42d00eb1ab95112";
        String secret = "64a614fa91426e665f19f92c9735a1e5";
        String json = "";
        try {
            json =  CallUrl.sendPost(GET_XCXDEALERS_URL,"appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code");
        }catch (Exception e){
            e.printStackTrace();
        }
        return json;
    }


    /**
     * 解析微信小程序获取的手机号
     * @param session_key
     * @param encryptedData
     * @param iv
     * @return
     */
    public static Object getPhoneNumber(String encryptedData, String session_key, String iv) {
        // 被加密的数据
        byte[] dataByte = Base64.getDecoder().decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.getDecoder().decode(session_key);
        // 偏移量
        byte[] ivByte = Base64.getDecoder().decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return com.alibaba.fastjson.JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 通过code 获取公众号的Openid
     * @return
     */
    public String getGzOpenid(String code){
        String appid = "wxab0e17f759d71d17";
        String secret = "e232d9253eefb5abdf14a46f60a8a4e5";
        String openid = "";
        try {
            String json = CallUrl.sendGet(GET_OAYTH_TOKEN_URl,"appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code");
            JSONObject jsonObj = (JSONObject)(new JSONParser().parse(json));
            if (jsonObj.size()>2){
                openid = jsonObj.get("openid").toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return openid;
    }


    /**
     * 通过code 获取网页登录的Unionid
     * @return
     */
    public String getGzUnionid(String code){
        String appid = "wx720394fb8f94f436";
        String secret = "58b0a99e61097351c2a56219ec4fc6d2";
        String unionid = "";
        try {
            String json = CallUrl.sendGet(GET_OAYTH_TOKEN_URl,"appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code");
            JSONObject jsonObj = (JSONObject)(new JSONParser().parse(json));
            if (jsonObj.size()>2){
                unionid = jsonObj.get("unionid").toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return unionid;
    }



}
