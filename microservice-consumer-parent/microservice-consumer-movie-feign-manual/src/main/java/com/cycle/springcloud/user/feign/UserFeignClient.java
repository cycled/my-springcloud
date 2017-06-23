package com.cycle.springcloud.user.feign;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cycle.springcloud.user.entity.User;

public interface UserFeignClient {
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	User findById(@PathVariable("id") Long id);
}
