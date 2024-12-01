package com.irojas.demojwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irojas.demojwt.entity.Proyecto;
import com.irojas.demojwt.entity.Tarea;
import com.irojas.demojwt.service.ProyectoService;
import com.irojas.demojwt.service.TareaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/url/tarea")
@RequiredArgsConstructor
public class TareaController {
	@Autowired
    private TareaService tareaService;
	
	@GetMapping("/listar")
    public List<Tarea> listaTodo() {
        return tareaService.listaTodo();
    }
    
    @PostMapping("/insertar")
    public ResponseEntity<String> insertarTarea(@RequestBody Tarea tarea) {
        return ResponseEntity.ok(tareaService.registroTarea(tarea));
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarTarea(@RequestBody Tarea tarea) {
        return ResponseEntity.ok(tareaService.actualizarTarea(tarea));
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarTarea(@PathVariable Integer id) {
        tareaService.eliminarTarea(id);
    }

}
