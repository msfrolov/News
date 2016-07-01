package com.epam.msfrolov.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Main Spring JavaConfig
 * request parameters
 */
@Configuration
@EnableWebMvc
@Import({ServiceConfiguration.class})
@ComponentScan(basePackages = {"com.epam.msfrolov"})
public class RootConfiguration {

}
