package com.irojas.demojwt.service;

import java.util.List;

import com.irojas.demojwt.entity.Tarea;

public interface TareaService {
	public List<Tarea> listaTodo();
	public String registroTarea(Tarea tarea);
	public String actualizarTarea(Tarea tarea);
	public void eliminarTarea(Integer id);

}
