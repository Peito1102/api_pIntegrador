package com.irojas.demojwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irojas.demojwt.entity.Proyecto;
import com.irojas.demojwt.repository.ProyectoRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService {
	@Autowired
	private ProyectoRepository proyectoRepository;

	@Override
	public List<Proyecto> listaTodo() {
		return proyectoRepository.findAll();
	}

	@Override
	public String registroProyecto(Proyecto proyecto) {
		proyectoRepository.save(proyecto);
		return "Proyecto Registrado";
	}

	@Override
	public String actualizarProyecto(Proyecto proyecto) {
		Optional<Proyecto> existingProyecto = proyectoRepository.findById(proyecto.getId());
	    if (existingProyecto.isPresent()) {
	        Proyecto proyectoExistente = existingProyecto.get();
	        
	        proyectoExistente.setNombre(proyecto.getNombre()); 
	        proyectoRepository.save(proyectoExistente);
	        return "proyecto actualizado";
	    }
	    return ""; 
	}

	@Override
	public void eliminarProyecto(Integer id) {
		Proyecto proyecto = proyectoRepository.findById(id).get();
		proyectoRepository.delete(proyecto);
		
	}

}
