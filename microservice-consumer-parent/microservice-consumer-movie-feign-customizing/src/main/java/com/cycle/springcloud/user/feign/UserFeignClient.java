package com.cycle.springcloud.user.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.cycle.springcloud.config.FeignConfiguration;
import com.cycle.springcloud.user.entity.User;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "microservice-provider-user",configuration = FeignConfiguration.class)
public interface UserFeignClient {
	
	/**
	 *  @Description	: 使用feign自带注解
	 *  @return         : User
	 *  @Creation Date  : 2017年6月24日 上午12:04:04 
	 *  @Author         : wangchao
	 */
	@RequestLine("GET /{id}")
	User findById(@Param("id") Long id);
}
