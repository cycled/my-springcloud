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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MovieController {
  
  private final Logger logger = LoggerFactory.getLogger(getClass());
	
  @Autowired
  private RestTemplate restTemplate;
  
  @Autowired
  private LoadBalancerClient loadBalancerClient;
  
  /**
   *  @Description	:   通过Hystrix使当前远程调用具有容错能力,远程请求失败时调用fallbackMethod指定的方法
   *  @return         : User
   *  @Creation Date  : 2017年6月24日 下午3:00:56 
   *  @Author         : wangchao
   */
  @HystrixCommand(fallbackMethod = "findByIdFallback")
  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
  }
  
  /**
   *  @Description	:   提供回退方法
   *  @return         : User
   *  @Creation Date  : 2017年6月24日 下午3:00:21 
   *  @Author         : wangchao
   */
  public User findByIdFallback(Long id) {
	  User user = new User();
	  user.setId(-1L);
	  user.setName("默认用户");
	  return user;
  }
  
  @GetMapping("/log-user-instance")
  public void logUserInstance() {
	  ServiceInstance  si = loadBalancerClient.choose("microservice-provider-user");
	  logger.info("{}:{}:{}",si.getServiceId(),si.getHost(),si.getPort());
  }
}
