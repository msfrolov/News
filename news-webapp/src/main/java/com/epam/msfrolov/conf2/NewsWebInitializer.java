//package com.epam.msfrolov.conf;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration.Dynamic;
//
//
//@EnableWebMvc
//public class NewsWebInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext container) throws ServletException {
//        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
//        appContext.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
//
//        Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(appContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//    }
//
//}
