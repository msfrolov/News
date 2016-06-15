//package com.epam.msfrolov.spring;
//
//import com.epam.msfrolov.dao.JpaNewsDao;
//import com.epam.msfrolov.dao.NewsDao;
//import com.epam.msfrolov.model.News;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.repository.RepositoryDefinition;
//
//@Configuration
//@ComponentScan(basePackages = {"com.epam.msfrolov"})
//@EnableJpaRepositories("com.epam.msfrolov.repository")
//@RepositoryDefinition(domainClass = News.class, idClass = Integer.class)
//public class DbConfiguration {
//
//    @Bean
//    @Scope("prototype")
//    public News news() {
//        return new News();
//    }
//
//    @Bean
//    public NewsDao newsDao() {
//        return new JpaNewsDao();
//    }
//
//}
