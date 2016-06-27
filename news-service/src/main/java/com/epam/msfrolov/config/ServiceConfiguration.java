package com.epam.msfrolov.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * Service module Spring JavaConfig
 * connection parameters (URL, user, password)
 */
@Configuration
@Import(DbConfiguration.class)
@ComponentScan(basePackages = {"com.epam.msfrolov"})
public class ServiceConfiguration {
}
