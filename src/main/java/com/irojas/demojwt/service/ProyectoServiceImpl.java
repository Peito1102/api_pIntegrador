package com.irojas.demojwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irojas.demojwt.controller.UsuarioController;
import com.irojas.demojwt.entity.Proyecto;
import com.irojas.demojwt.entity.ProyectoDTO;
import com.irojas.demojwt.entity.User;
import com.irojas.demojwt.repository.ProyectoRepository;
import com.irojas.demojwt.repository.UserRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService {
	@Autowired
	private ProyectoRepository proyectoRepository;


	@Override
	public List<Proyecto> listaTodo() {
		return proyectoRepository.findAll();
	}

	@Override
	public ProyectoDTO registroProyecto(ProyectoDTO proyectoDTO) {
		
		User usuario= new User();
		usuario.setId(proyectoDTO.getIdUsuario());
		Proyecto proyecto= new Proyecto();
		proyecto.setNombre(proyectoDTO.getNombre());
		proyecto.setUsuario(usuario);
		
		
		proyectoRepository.save(proyecto);
		return proyectoDTO;
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

	@Override
	public List<Proyecto> listaPorUsuario(Integer id) {
		
		User usuario= new User();
		usuario.setId(id);
		return proyectoRepository.findByUsuario(usuario);
	}

}
