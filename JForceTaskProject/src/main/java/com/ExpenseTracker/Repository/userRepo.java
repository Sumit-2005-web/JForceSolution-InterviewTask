package com.ExpenseTracker.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExpenseTracker.Entity.User;

@Repository
public interface userRepo extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
}
