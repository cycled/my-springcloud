package com.cycle.springcloud.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cycle.springcloud.user.entity.User;
import com.cycle.springcloud.user.feign.UserFeignClient;

@RestController
public class MovieController {
  
  @Autowired
  private UserFeignClient userFeignClient;
	
  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
    return userFeignClient.findById(id);
  }
}
