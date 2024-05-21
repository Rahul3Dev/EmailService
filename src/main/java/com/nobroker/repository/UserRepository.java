package com.nobroker.repository;

import com.nobroker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  public User findByEmail(String email);
}
