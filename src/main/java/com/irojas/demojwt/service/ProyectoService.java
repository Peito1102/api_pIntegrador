package com.irojas.demojwt.service;

import java.util.List;

import com.irojas.demojwt.entity.Proyecto;
import com.irojas.demojwt.entity.ProyectoDTO;
import com.irojas.demojwt.entity.User;

public interface ProyectoService {
	public List<Proyecto> listaTodo();
	public ProyectoDTO registroProyecto(ProyectoDTO proyectoDTO);
	public String actualizarProyecto(Proyecto proyecto);
	public void eliminarProyecto(Integer id);
	
	public List<Proyecto> listaPorUsuario(Integer idUsuario);
	
	
}
