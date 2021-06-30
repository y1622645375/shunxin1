package com.shunxin.shunxin_salesman_visit;


import org.apache.catalina.connector.Connector;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication  //是Spring Boot项目的核心注解，目的是开启自动配置
@EnableScheduling  //是通过@Import将Spring调度框架相关的bean定义都加载到IoC容器
@MapperScan("com.shunxin.shunxin_salesman_visit.mapper")
@ServletComponentScan(basePackages = "com.shunxin.shunxin_salesman_visit.filter")
public class ShunxinSalesmanVisitApplication {
    public static void main(String[] args) throws InterruptedException{
        SpringApplication.run(ShunxinSalesmanVisitApplication.class, args);
    }

    @Value("${http.port}")
    private Integer httpPort;

    /* SpringBoot 2.x版本(以及更高版本) 使用下面的代码 */
    @Bean
    public ServletWebServerFactory servletContainer() throws InterruptedException{
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createHTTPConnector());
        return tomcat;
    }

    private Connector createHTTPConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setSecure(false);
        connector.setPort(httpPort);
        return connector;
    }


    /**
     * http重定向到https
     * @return
     */
   /* @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
    }

    @Bean
    public Connector httpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        //Connector监听的http的端口号
        connector.setPort(9999);
        connector.setSecure(false);
        //监听到http的端口号后转向到的https的端口号
        connector.setRedirectPort(9443);
        return connector;
    }*/




}
