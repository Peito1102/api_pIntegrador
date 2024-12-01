package com.irojas.demojwt.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaDTO {

	private Integer id;
	private String nombre;
	private String descripcion;
    private String prioridad;
	private String fechaVencimiento;
    private Integer idProyecto; 
    private Integer idUsuario;
}
