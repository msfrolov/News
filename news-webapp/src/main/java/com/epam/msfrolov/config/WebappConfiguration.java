package com.epam.msfrolov.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Web module Spring JavaConfig
 */
@Configuration
@Import(ServiceConfiguration.class)
@ComponentScan(basePackages = {"com.epam.msfrolov"})
public class WebappConfiguration {
}
