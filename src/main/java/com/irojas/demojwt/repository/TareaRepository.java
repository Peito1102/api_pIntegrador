package com.irojas.demojwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irojas.demojwt.entity.Tarea;

public interface TareaRepository extends JpaRepository<Tarea,Integer> {

}
