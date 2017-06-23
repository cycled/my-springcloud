package com.cycle.springcloud.user.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cycle.springcloud.user.entity.User;

@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	User findById(@PathVariable("id") Long id);
}
