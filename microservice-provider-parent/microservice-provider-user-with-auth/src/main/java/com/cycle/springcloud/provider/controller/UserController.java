package com.cycle.springcloud.provider.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cycle.springcloud.provider.entity.User;
import com.cycle.springcloud.provider.repository.UserRepository;

@RestController
public class UserController {
  
  private final Logger logger = LoggerFactory.getLogger(getClass());
	
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if (principal instanceof UserDetails) {
		UserDetails user = (UserDetails) principal;
		Collection<? extends GrantedAuthority> collection = user.getAuthorities();
		for (GrantedAuthority grantedAuthority : collection) {
			logger.info("当前用户:{},角色为:{}",user.getUsername(),grantedAuthority.getAuthority());
		}
	} else {
	}
	User findOne = this.userRepository.findOne(id);
	return findOne;
  }
}
