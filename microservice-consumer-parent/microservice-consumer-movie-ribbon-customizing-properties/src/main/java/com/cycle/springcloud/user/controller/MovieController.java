package com.cycle.springcloud.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cycle.springcloud.user.entity.User;

@RestController
public class MovieController {
  
  private final Logger logger = LoggerFactory.getLogger(getClass());
	
  @Autowired
  private RestTemplate restTemplate;
  
  @Autowired
  private LoadBalancerClient loadBalancerClient;

  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
  }
  
  @GetMapping("/log-user-instance")
  public void logUserInstance() {
	  ServiceInstance  si = loadBalancerClient.choose("microservice-provider-user");
	  logger.info("{}:{}:{}",si.getServiceId(),si.getHost(),si.getPort());
  }
}
