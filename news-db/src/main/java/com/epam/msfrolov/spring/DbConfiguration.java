package com.epam.msfrolov.spring;

import com.epam.msfrolov.dao.Dao;
import com.epam.msfrolov.dao.JpaNewsDao;
import com.epam.msfrolov.model.News;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.epam.msfrolov.dao", "com.epam.msfrolov.model"})
public class DbConfiguration {

    @Bean
    @Scope("prototype")
    News news() {
        return new News();
    }

    @Bean
    Dao dao() {
        return new JpaNewsDao();
    }


}
