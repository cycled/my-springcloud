package com.cycle.springcloud.user.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cycle.springcloud.user.entity.User;

@FeignClient(name = "microservice-provider-user",fallback = FeignClientFallback.class)
public interface UserFeignClient {
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	User findById(@PathVariable("id") Long id);
}

@Component
class FeignClientFallback implements UserFeignClient {
	@Override
	public User findById(Long id) {
		User user = new User();
		user.setId(-1L);
		user.setUsername("默认用户");
		return user;
	}
}