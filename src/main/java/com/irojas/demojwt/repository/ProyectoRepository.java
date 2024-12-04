package com.irojas.demojwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irojas.demojwt.entity.Proyecto;
import com.irojas.demojwt.entity.User;

public interface ProyectoRepository extends JpaRepository<Proyecto,Integer> {

	List<Proyecto> findByUsuario(User usuario);
	
}
