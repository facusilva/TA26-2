package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Proyecto;

public interface IProyectoDAO extends JpaRepository<Proyecto, Long>{

	public Proyecto findById(String id);
	
	public Integer deleteById(String id);
	
}
