package com.irojas.demojwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irojas.demojwt.entity.Proyecto;
import com.irojas.demojwt.entity.Tarea;
import com.irojas.demojwt.repository.TareaRepository;

@Service
public class TareaServiceImpl implements TareaService {
	@Autowired
	private TareaRepository tareaRepository;

	@Override
	public List<Tarea> listaTodo() {
		return tareaRepository.findAll();
	}

	@Override
	public String registroTarea(Tarea tarea) {
		tareaRepository.save(tarea);
		return "Tarea Registrada";
	}

	@Override
	public String actualizarTarea(Tarea tarea) {
		Optional<Tarea> existingTarea = tareaRepository.findById(tarea.getId());
	    if (existingTarea.isPresent()) {
	        Tarea tareaExistente = existingTarea.get();
	        
	        tareaExistente.setNombre(tarea.getNombre());
	        tareaExistente.setDescripcion(tarea.getDescripcion());
	        tareaExistente.setPrioridad(tarea.getPrioridad());
	        tareaExistente.setFechaVencimiento(tarea.getFechaVencimiento());
	        tareaRepository.save(tareaExistente);
	        return "tarea actualizada";
	    }
	    return ""; 
	}

	@Override
	public void eliminarTarea(Integer id) {
		Tarea tarea = tareaRepository.findById(id).get();
		tareaRepository.delete(tarea);
	}
	

}
