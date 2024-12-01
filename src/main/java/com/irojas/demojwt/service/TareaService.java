package com.irojas.demojwt.service;

import java.util.List;


import com.irojas.demojwt.entity.Tarea;
import com.irojas.demojwt.entity.TareaDTO;

public interface TareaService {
	public List<Tarea> listaTodo();
	public String registroTarea(TareaDTO tareaDTO);
	public String actualizarTarea(Tarea tarea);
	public void eliminarTarea(Integer id);
	

	public List<Tarea> listaPorProyecto(Integer id);
	

}
