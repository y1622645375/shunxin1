package com.shunxin.shunxin_salesman_visit.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 接口访问过滤器
 */
@WebFilter(filterName = "AccessFilter",urlPatterns = "/*")
public class AccessFilter extends HttpFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());


    //1.过滤器加载时初始化读取或相关处理
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //2.执行过滤器的相关处理
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //设置允许多个域名请求
        /*String[] allowDomains = {"http://www.hnsxtj.com","http://emall.hnsxtj.com","http://127.0.0.1:8020","https://www.hnsxtj.com","http://cx.hnsxtj.com"};
        Set allowOrigins = new HashSet(Arrays.asList(allowDomains));*/
        //获取当前WEB应用程序的路径
        //String currentWebURI=request.getContextPath();
        //logger.info("当前WeB："+currentWebURI);
        /* Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String times = dateFormat.format(date);
        //获取请求头：Referer
        String referer = request.getHeader("Referer");
        if(referer!=null&&!referer.equals("")){
        List<String> refererURI=Arrays.asList(referer.split("/"));
        String strUrl = refererURI.get(0)+"//"+refererURI.get(2);
        System.out.println("请求头："+strUrl);
            String str = new String(); //原有txt内容
            String s1 = new String(); //新增内容
            try {
                File f = new File("D:\\sx_visit\\refererLog.txt");
                if (f.exists()) {
                    System.out.print("文件存在");
                } else {
                    System.out.print("文件不存在");
                    f.createNewFile();// 不存在则创建
                }
                BufferedReader input = new BufferedReader(new FileReader(f));
                while ((str = input.readLine()) != null) {
                    s1 += str +"\r\n";
                }
                input.close();
                s1 += strUrl +"---"+dateFormat.format(date);
                BufferedWriter output = new BufferedWriter(new FileWriter(f));
                output.write(s1);
                output.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }*/
        chain.doFilter(request,response);
        /*if (referer==null){
            logger.info("从自己网站跳转，放行");
            chain.doFilter(request,response);
        }else {
            List<String> refererURI=Arrays.asList(referer.split("/"));
            String strUrl = refererURI.get(0)+"//"+refererURI.get(2);
            logger.info("请求头："+strUrl);
            if (allowOrigins.contains(strUrl)){
                logger.info("从自己网站跳转2，放行");
                //设置允许跨域的配置
                //这里填写你允许进行跨域的主机ip（正式上线时可以动态配置具体允许的域名和IP）
                //response.setHeader("Access-Control-Allow-Origin", strUrl);
                chain.doFilter(request,response);
            }else {
                logger.info("非法跳转！");
            }
        }*/
    }


    //3.过滤器销毁的相关处理
    @Override
    public void destroy() {

    }
}