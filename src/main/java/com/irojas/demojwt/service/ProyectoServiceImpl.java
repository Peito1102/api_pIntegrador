package com.irojas.demojwt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irojas.demojwt.entity.Proyecto;
import com.irojas.demojwt.entity.ProyectoDTO;
import com.irojas.demojwt.entity.User;
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
	public ProyectoDTO registroProyecto(ProyectoDTO proyectoDTO) {
		
		User usuario= new User();
		usuario.setId(proyectoDTO.getIdUsuario());
		
		Optional<Proyecto> posibleProyecto = proyectoRepository.findByUsuario(usuario).stream().filter(p -> p.getNombre().equals(proyectoDTO.getNombre())).findFirst();
		
		if(posibleProyecto.isPresent()) {
			proyectoDTO.setNombre(null);
		}
		else {
			Proyecto proyecto= new Proyecto();
			proyecto.setNombre(proyectoDTO.getNombre());
			proyecto.setUsuario(usuario);
		
		
			proyectoRepository.save(proyecto);
		}
		
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
	public List<Proyecto> listaPorUsuario(Integer idUsuario) {
		
		User usuario= new User();
		usuario.setId(idUsuario);
		return proyectoRepository.findByUsuario(usuario);
	}

	@Override
	public List<Proyecto> filtroProyecto(Integer usuarioId, String nombre) {
		User usuario= new User();
		usuario.setId(usuarioId);
		List<Proyecto> listaFiltrada = proyectoRepository.findByUsuario(usuario).stream().filter(p -> p.getNombre().contains(nombre)).collect(Collectors.toList());
		
		
		return listaFiltrada;
	}

}
