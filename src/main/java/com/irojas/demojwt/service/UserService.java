package com.irojas.demojwt.service;

import java.util.List;

import com.irojas.demojwt.entity.User;



public interface UserService {
	
	public  List<User> listaTodos();
	 public  String buscarPorUsername(String username);
	 public  String buscarPorDni(String dni);
	 public  String buscarPorEmail(String email);
}
