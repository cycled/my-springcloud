package com.cycle.springcloud.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cycle.springcloud.provider.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
