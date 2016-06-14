package com.epam.msfrolov.spring;

import com.epam.msfrolov.service.NewsService;
import com.epam.msfrolov.service.SpringDataNewsService;
import org.springframework.context.annotation.*;

@Configuration
@Import(DbConfiguration.class)
@ComponentScan(basePackages = {"com.epam.msfrolov"})
public class ServiceConfiguration {

    @Bean(name = {"service", "newsService"})
    @Description("Service class for call DAO")
    NewsService service() {
        return new SpringDataNewsService();
    }
}
