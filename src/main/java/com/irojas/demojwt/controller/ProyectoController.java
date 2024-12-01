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

import com.irojas.demojwt.Auth.AuthResponse;
import com.irojas.demojwt.entity.Proyecto;
import com.irojas.demojwt.entity.ProyectoDTO;
import com.irojas.demojwt.service.ProyectoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/url/proyecto")
@RequiredArgsConstructor
public class ProyectoController {
	@Autowired
    private ProyectoService proyectoService;

    @GetMapping("/listar")
    public List<Proyecto> listaTodo() {
        return proyectoService.listaTodo();
    }
    
    @PostMapping("/insertar")
    public ResponseEntity<String> insertarProyecto(@RequestBody ProyectoDTO proyectoDTO) {
        return ResponseEntity.ok(proyectoService.registroProyecto(proyectoDTO));
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarProyecto(@RequestBody Proyecto proyecto) {
        return ResponseEntity.ok(proyectoService.actualizarProyecto(proyecto));
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProyecto(@PathVariable Integer id) {
        proyectoService.eliminarProyecto(id);
    }
    
    @PostMapping("/buscarProyectosPorUsuario/{id}")
    public List<Proyecto> buscarProyectosPorUsuario(@PathVariable Integer id) {
        return proyectoService.listaPorUsuario(id);
    }

}
