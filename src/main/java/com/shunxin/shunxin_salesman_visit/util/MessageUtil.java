package com.shunxin.shunxin_salesman_visit.util;

import com.shunxin.shunxin_salesman_visit.entity.cliententity.TextMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MessageUtil {

    /**
     * 将接收到的XML格式，转化为Map对象
     * @param request 将request对象，通过参数传入
     * @return 返回转换后的Map对象
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        Map<String, String> map = new HashMap<String, String>();
        //从dom4j的jar包中，拿到SAXReader对象。
        SAXReader reader = new SAXReader();
        InputStream is = request.getInputStream();//从request中，获取输入流
        Document doc = (Document) reader.read(is);//从reader对象中,读取输入流
        Element root = doc.getRootElement();//获取XML文档的根元素
        List<Element> list = root.elements();//获得根元素下的所有子节点
        for (Element e : list) {
            map.put(e.getName(), e.getText());//遍历list对象，并将结果保存到集合中
        }
        is.close();
        return map;
    }


    /**
     * 初始化回复消息
     */
    public static String initNewsMessage(String toUSerName,String fromUserName){
        TextMessage text = new TextMessage();
        text.setFromUserName(toUSerName);//原来【接收消息用户】变为回复时【发送消息用户】
        text.setToUserName(fromUserName);
        text.setMsgType(WXConstants.MESSAGE_TEXT);
        text.setCreateTime(new Date().getTime());//创建当前时间为消息时间
        return MessageUtil.TextMessageToXml(text);
    }


    /**
     * 将文本消息对象转化成XML格式
     * @param message 文本消息对象
     * @return 返回转换后的XML格式
     */
    public static String TextMessageToXml(TextMessage message){
        XStream xs = new XStream();
        //由于转换后xml根节点默认为class类，需转化为<xml>
        xs.alias("xml", message.getClass());
        return xs.toXML(message);
    }



}
