package com.cycle.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

/**
 * @Project       : microservice-consumer-movie-feign-customizing
 * @Program Name  : com.cycle.springcloud.user.FeignConfiguration.java
 * @Description   : Feign配置类;注意:当前类不能在主应用程序上下文的@ComponentScan中.
 * @Author        : wangchao
 * @Creation Date : 2017年6月24日 上午12:00:35 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * wangchao     2017年6月24日        create
 */
@Configuration
public class FeignConfiguration {
	
	/**
	 *  @Description	: 将契约改为Feign原生的默认契约,这样就可以使用feign自带注解了
	 *  @return         : Contract
	 *  @Creation Date  : 2017年6月24日 上午12:01:51 
	 *  @Author         : wangchao
	 */
	@Bean
	public Contract basicAuthRequestInterceptor() {
		return new feign.Contract.Default();
	}
}
