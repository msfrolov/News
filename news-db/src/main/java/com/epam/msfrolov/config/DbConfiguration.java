package com.epam.msfrolov.config;

import com.epam.msfrolov.exception.DbModuleException;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.util.Properties;

/**
 * DB module Spring JavaConfig
 * connection parameters (URL, user, password)
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.epam.msfrolov.repository"})
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.epam.msfrolov"})
public class DbConfiguration {

    private static final String CONNECTION_PROPERTIES = "properties/connection.properties";
    private static final String SQL_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_ORACLE10G = "org.hibernate.dialect.Oracle10gDialect";
    private static final String PACKAGE_REPOSITORY = "com.epam.msfrolov.repository";
    private static final String PACKAGE_MODEL = "com.epam.msfrolov.model";

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        Properties properties = getConnectionProperties();
        dataSource.setDriverClassName(properties.getProperty("db.param.driver"));
        dataSource.setUrl(properties.getProperty("db.param.url"));
        dataSource.setUsername(properties.getProperty("db.param.user"));
        dataSource.setPassword(properties.getProperty("db.param.password"));
        return dataSource;
    }

    private Properties getConnectionProperties() {
        try {
            Properties properties = new Properties();
            properties.load(DbConfiguration.class.getClassLoader().getResourceAsStream(CONNECTION_PROPERTIES));
            return properties;
        } catch (IOException e) {
            throw new DbModuleException("IOException: failed to get property", e);
        }
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
        emFactory.setDataSource(dataSource());
        emFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        emFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties properties = new Properties();
        properties.setProperty(SQL_DIALECT, HIBERNATE_ORACLE10G);
        emFactory.setJpaProperties(properties);
        emFactory.setPackagesToScan(PACKAGE_REPOSITORY, PACKAGE_MODEL);
        return emFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
