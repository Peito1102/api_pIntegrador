package com.irojas.demojwt.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irojas.demojwt.entity.Proyecto;
import com.irojas.demojwt.entity.Tarea;
import com.irojas.demojwt.entity.TareaDTO;
import com.irojas.demojwt.entity.User;
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
	public TareaDTO registroTarea(TareaDTO tareaDTO) {
		
		Date fecha = null;
		if (tareaDTO.getFechaVencimiento() != null) {
		String fechaString =tareaDTO.getFechaVencimiento(); 
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
		try {
			fecha = formato.parse(fechaString);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		} 
		
		
		User usuario= new User();
		usuario.setId(tareaDTO.getIdUsuario());
		
		Proyecto proyecto= new Proyecto();
		proyecto.setId(tareaDTO.getIdProyecto());
		
		Optional<Tarea> posibleProyecto = tareaRepository.findByProyecto(proyecto).stream().filter(t -> t.getNombre().trim().equals(tareaDTO.getNombre().trim())).findFirst();

		if(posibleProyecto.isPresent()) {
			tareaDTO.setNombre(null);
		} else {
			Tarea tarea= new Tarea();
			tarea.setDescripcion(tareaDTO.getDescripcion());
			tarea.setNombre(tareaDTO.getNombre().trim());
			tarea.setPrioridad(tareaDTO.getPrioridad());
			tarea.setFechaVencimiento(fecha);
			tarea.setProyecto(proyecto);
			tarea.setUsuario(usuario);
		
		
			tareaRepository.save(tarea);
		}
		
		
		return tareaDTO;
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

	@Override
	public List<Tarea> listaPorProyecto(Integer idProyecto) {
		Proyecto proyecto= new Proyecto();
		proyecto.setId(idProyecto);
		return tareaRepository.findByProyecto(proyecto);
	}
	

}
