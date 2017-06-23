package com.cycle.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cycle.springcloud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
