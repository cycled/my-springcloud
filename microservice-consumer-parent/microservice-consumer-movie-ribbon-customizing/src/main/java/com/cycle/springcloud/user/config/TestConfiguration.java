package com.cycle.springcloud.user.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

import com.cycle.springcloud.config.RibbonConfiguration;

@Configuration
@RibbonClient(name = "microservice-provider-user",
				configuration = RibbonConfiguration.class)
public class TestConfiguration {

}
