package com.epam.msfrolov.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


/**
 * Service module Spring JavaConfig
 * connection parameters (URL, user, password)
 */
@Configuration
@Import(DbConfiguration.class)
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.epam.msfrolov.aspect", "com.epam.msfrolov"})
public class ServiceConfiguration extends WebMvcConfigurerAdapter {

    /**
     * Setup "welcome page"
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    /**
     * set default resources package
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/**");
//        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }

    /**
     * Class which the responsible of changing the current locale if requested.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }
}
