package com.revature.swagshop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.swagshop.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> getByEmail(String email);
}
