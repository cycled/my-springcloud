package com.cycle.springcloud.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cycle.springcloud.user.entity.User;

@RestController
public class MovieController {
  
  final Logger logger = LoggerFactory.getLogger(getClass());
  
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
	User u = this.restTemplate.getForObject("http://localhost:8000/" + id, User.class);
    return u;
  }
}
