package com.irojas.demojwt.service;

import java.util.List;

import com.irojas.demojwt.entity.Proyecto;

public interface ProyectoService {
	public List<Proyecto> listaTodo();
	public String registroProyecto(Proyecto proyecto);
	public String actualizarProyecto(Proyecto proyecto);
	public void eliminarProyecto(Integer id);
	
	
}
