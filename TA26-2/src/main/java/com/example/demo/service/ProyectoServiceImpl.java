package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProyectoDAO;
import com.example.demo.dto.Proyecto;

@Service 
public class ProyectoServiceImpl implements IProyectoService{

	@Autowired
	IProyectoDAO iProyectoDAO;
	
	@Override
	public List<Proyecto> listarProyectos() {
		// TODO Auto-generated method stub
		return iProyectoDAO.findAll();
	}

	@Override
	public Proyecto guardarProyecto(Proyecto Proyecto) {
		// TODO Auto-generated method stub
			return iProyectoDAO.save(Proyecto); //guardo el nuevo Proyecto	
	}

	public Proyecto findById(String id) {
		// TODO Auto-generated method stub
		return iProyectoDAO.findById(id);
	}

	@Override
	public Proyecto actualizarProyecto(Proyecto Proyecto) {
		// TODO Auto-generated method stub
		return iProyectoDAO.save(Proyecto);
	}

	@Override
	public void eliminarProyecto(Long id) {
		iProyectoDAO.deleteById(id);
		
	}

}
