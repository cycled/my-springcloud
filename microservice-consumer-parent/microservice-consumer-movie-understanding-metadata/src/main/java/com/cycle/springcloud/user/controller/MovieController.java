package com.cycle.springcloud.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cycle.springcloud.user.entity.User;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;
  
  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject("http://localhost:8000/" + id, User.class);
  }
  
  @GetMapping("/user-instance")
  public List<ServiceInstance> shouInfo() {
	  return discoveryClient.getInstances("microservice-provider-user");
  }
}
