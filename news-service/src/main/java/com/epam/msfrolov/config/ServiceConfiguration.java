package com.epam.msfrolov.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;


/**
 * Service module Spring JavaConfig
 * connection parameters (URL, user, password)
 */
@Configuration
@Import(DbConfiguration.class)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = {"com.epam.msfrolov.aspect", "com.epam.msfrolov"})
public class ServiceConfiguration {
}
