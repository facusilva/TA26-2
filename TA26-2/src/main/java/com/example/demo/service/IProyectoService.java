package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proyecto;

public interface IProyectoService {

	//Métodos del CRUD
	public List<Proyecto> listarProyectos(); //Listar All
	
	public Proyecto guardarProyecto(Proyecto Proyecto); //Guarda un Proyecto CREATE
	
	//public Proyecto ProyectoXID(String id); //Leer datos de un Proyecto READ
	
	public Proyecto findById(String id);//buscar proveedor por id
	
	public Proyecto actualizarProyecto(Proyecto Proyecto); //Actualiza datos del Proyecto UPDATE
	
	public void eliminarProyecto(Long id);//Elimina el Proyecto DELETE
}
