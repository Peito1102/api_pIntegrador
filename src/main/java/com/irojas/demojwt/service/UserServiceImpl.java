package com.irojas.demojwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irojas.demojwt.entity.User;
import com.irojas.demojwt.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> listaTodos() {
		return userRepository.findAll();
	}

	@Override
	public String buscarPorUsername(String username) {
		
		String mensaje="no hay";
		
		Optional<User> user=userRepository.findByUsername(username);
		if (user.isPresent()) {
			mensaje = "Usuario ya registrado.";
            return mensaje;
        } 
		
		return mensaje;
	}

	@Override
	public String buscarPorDni(String dni) {
	
		String mensaje="";
		
		User user=userRepository.findByDni(dni);
		if (user != null) {
			mensaje = "DNI ya registrado.";
            return mensaje;
        } 
		
		return mensaje;
	}

	@Override
	public String buscarPorEmail(String email) {
		
		String mensaje="";
		
		User user=userRepository.findByEmail(email);
		if (user != null) {
			mensaje = "Email ya registrado.";
            return mensaje;
        } 
		
		return mensaje;
	}

	
}
