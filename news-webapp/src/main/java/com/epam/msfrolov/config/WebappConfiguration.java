package com.epam.msfrolov.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;

/**
 * Web module Spring JavaConfig
 */
@Configuration
@Import(ServiceConfiguration.class)
@ComponentScan(basePackages = {"com.epam.msfrolov"})
public class WebappConfiguration extends WebMvcConfigurerAdapter {

    private static final String I18N_BUNDLE = "/i18n/messages";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final int COOKIE_MAX_AGE = 4800;
    private static final String PACKAGE_RESOURCES = "/resources/";
    private static final String PACKAGE_RESOURCES_HIERARCHY = "/resources/**";
    private static final String VIEW_PACKAGE = "/WEB-INF/view/";
    private static final String VIEW_EXTENSION = ".jsp";
    private static final String URL_PATH = "/";
    private static final String WELCOME_PAGE_NAME = "index";
    private static final String LOCALE_COOKIE_NAME = "NewsLocaleCookie";
    private static final String LOCAL_PARAM_NAME = "news-local";

    /**
     * Setup "welcome page"
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(URL_PATH).setViewName(WELCOME_PAGE_NAME);
    }

    /**
     * set default resources package
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(PACKAGE_RESOURCES_HIERARCHY).addResourceLocations(PACKAGE_RESOURCES);
    }

    /**
     * Setting the path to the jsp page
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(VIEW_PACKAGE);
        resolver.setSuffix(VIEW_EXTENSION);
        return resolver;
    }

    /**
     * Setting the default encoding and path to bundle properties
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(I18N_BUNDLE);
        messageSource.setDefaultEncoding(DEFAULT_ENCODING);
        return messageSource;
    }

    /**
     * This is method which uses cookie that is sent back on the browser
     * for custom settings to handle locale used in i18n and l10n.
     */
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(Locale.US);
        resolver.setCookieName(LOCALE_COOKIE_NAME);
        resolver.setCookieMaxAge(COOKIE_MAX_AGE);
        return resolver;
    }

    /**
     * Class which the responsible of changing the current locale if requested.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName(LOCAL_PARAM_NAME);
        registry.addInterceptor(interceptor);
    }
}
