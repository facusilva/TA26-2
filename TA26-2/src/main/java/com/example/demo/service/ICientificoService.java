package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cientifico;

public interface ICientificoService {

	//Métodos del CRUD
	public List<Cientifico> listarCientificos(); //Listar All
	
	public Cientifico guardarCientifico(Cientifico Cientifico); //Guarda un Cientifico CREATE
	
	//public Cientifico CientificoXID(String id); //Leer datos de un Cientifico READ
	
	public Cientifico findByDni(String dni);//buscar cientifico por dni
	
	public Cientifico actualizarCientifico(Cientifico Cientifico); //Actualiza datos del Cientifico UPDATE
	
	public void deleteByDni(String dni);//Elimina el Cientifico DELETE
}
