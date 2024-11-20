package com.irojas.demojwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irojas.demojwt.entity.User;


public interface UserRepository extends JpaRepository<User,Integer> {
	
	
	public User findByDni(String dni);
	public User findByEmail(String email);
    Optional<User> findByUsername(String username); 
}
