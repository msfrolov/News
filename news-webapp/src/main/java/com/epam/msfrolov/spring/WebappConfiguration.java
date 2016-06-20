package com.epam.msfrolov.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ServiceConfiguration.class)
@ComponentScan(basePackages = {"com.epam.msfrolov"})
public class WebappConfiguration {
}
