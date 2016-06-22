package com.epam.msfrolov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Main Spring JavaConfig
 * request parameters
 */
@Configuration
@EnableWebMvc
@Import({WebappConfiguration.class})
@ComponentScan(basePackages = {"com.epam.msfrolov"})
public class RootConfiguration extends WebMvcConfigurerAdapter {

    private static final String PACKAGE_RESOURCES = "/resources/";
    private static final String PACKAGE_RESOURCES_HIERARCHY = "/resources/**";
    private static final String VIEW_PACKAGE = "/WEB-INF/view/";
    private static final String VIEW_SUFFIX = ".jsp";
    private static final String URL_PATH = "/";
    private static final String WELCOME_PAGE_NAME = "index";

    /**
     * Setting the path to the jsp page
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix(VIEW_PACKAGE);
        viewResolver.setSuffix(VIEW_SUFFIX);

        return viewResolver;
    }

    /**
     * Setup "welcome page"
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(URL_PATH).setViewName(WELCOME_PAGE_NAME);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(PACKAGE_RESOURCES_HIERARCHY).addResourceLocations(PACKAGE_RESOURCES);
    }
}
