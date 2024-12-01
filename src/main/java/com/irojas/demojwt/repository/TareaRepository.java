package com.irojas.demojwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irojas.demojwt.entity.Proyecto;
import com.irojas.demojwt.entity.Tarea;
import java.util.List;


public interface TareaRepository extends JpaRepository<Tarea,Integer> {

		List<Tarea> findByProyecto(Proyecto proyecto);
}
