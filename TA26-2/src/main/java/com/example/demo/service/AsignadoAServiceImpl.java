package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAsignadoADAO;
import com.example.demo.dto.AsignadoA;

@Service 
public class AsignadoAServiceImpl implements IAsignadoAService{

	@Autowired
	IAsignadoADAO iAsignadoADAO;
	
	@Override
	public List<AsignadoA> listarAsignadoAs() {
		// TODO Auto-generated method stub
		return iAsignadoADAO.findAll();
	}

	@Override
	public AsignadoA guardarAsignadoA(AsignadoA AsignadoA) {
		// TODO Auto-generated method stub
			return iAsignadoADAO.save(AsignadoA); //guardo el nuevo AsignadoA	
	}

	@Override
	public AsignadoA AsignadoAXID(Long id) {
		// TODO Auto-generated method stub
		return iAsignadoADAO.findById(id).get();
	}

	@Override
	public AsignadoA actualizarAsignadoA(AsignadoA AsignadoA) {
		// TODO Auto-generated method stub
		return iAsignadoADAO.save(AsignadoA);
	}

	@Override
	public void eliminarAsignadoA(Long id) {
		iAsignadoADAO.deleteById(id);
		
	}

}
