package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
	
	User findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.role <> 'ADMIN'")
    List<User> findAllExceptAdmin();
	

}
