package com.epam.msfrolov.spring;

import com.epam.msfrolov.configuration.DbConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DbConfiguration.class)
@ComponentScan(basePackages = {"com.epam.msfrolov"})
public class ServiceConfiguration {

//    @Bean(name = {"service", "newsService"})
//    @Description("Service class for call DAO")
//    NewsService service() {
//        return new NewsServiceImpl();
//    }
}
