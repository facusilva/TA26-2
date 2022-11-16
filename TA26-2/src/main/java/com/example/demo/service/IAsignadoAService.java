package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AsignadoA;

public interface IAsignadoAService {

	//Métodos del CRUD
	public List<AsignadoA> listarAsignadoAs(); //Listar All
	
	public AsignadoA guardarAsignadoA(AsignadoA AsignadoA); //Guarda un AsignadoA CREATE
	
	public AsignadoA AsignadoAXID(Long id); //Leer datos de un AsignadoA READ
	
	public AsignadoA actualizarAsignadoA(AsignadoA AsignadoA); //Actualiza datos del AsignadoA UPDATE
	
	public void eliminarAsignadoA(Long id);//Elimina el AsignadoA DELETE
}
