package com.epam.msfrolov.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public aspect LoggingAspect {

    private static final Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);

    @Before(value = "execution(* com.epam.msfrolov.service.NewsServiceImpl.findById(..))")
    public void logMethodExecution(JoinPoint point) {
        LOG.debug("!!!!! {}", point.toShortString());
        System.out.println("!!!!!!!!!!");
    }
}
