package com.epam.msfrolov.configuration;

import com.epam.msfrolov.spring.WebappConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Class for Spring MVC configuration
 */


@Configuration
@ComponentScan
@EnableWebMvc
@EnableJpaRepositories
@Import({WebappConfiguration.class})
public class NewsConfiguration extends WebMvcConfigurerAdapter {

    private static final String VIEW_PACKAGE = "/WEB-INF/view/";
    private static final String VIEW_SUFFIX = ".jsp";
    private static final String URL_PATH = "/";
    private static final String WELCOME_PAGE_NAME = "index";

    /**
     * Setting the path to the jsp page
     *
     * @return
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
     *
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(URL_PATH).setViewName(WELCOME_PAGE_NAME);
    }
}
