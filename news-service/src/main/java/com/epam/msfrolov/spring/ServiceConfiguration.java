package com.epam.msfrolov.spring;

import com.epam.msfrolov.service.NewsService;
import com.epam.msfrolov.service.NewsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DbConfiguration.class)
public class ServiceConfiguration {

    @Bean(name = {"service", "newsService"})
    @Description("Service class for call DAO")
    NewsService service() {
        return new NewsServiceImpl();
    }
}
