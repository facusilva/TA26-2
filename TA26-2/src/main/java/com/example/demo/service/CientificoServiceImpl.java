package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICientificoDAO;
import com.example.demo.dto.Cientifico;

@Service 
public class CientificoServiceImpl implements ICientificoService{

	@Autowired
	ICientificoDAO iCientificoDAO;
	
	@Override
	public List<Cientifico> listarCientificos() {
		// TODO Auto-generated method stub
		return iCientificoDAO.findAll();
	}

	@Override
	public Cientifico guardarCientifico(Cientifico Cientifico) {
		// TODO Auto-generated method stub
			return iCientificoDAO.save(Cientifico); //guardo el nuevo Cientifico	
	}

	public Cientifico findByDni(String dni) {
		// TODO Auto-generated method stub
		return iCientificoDAO.findByDni(dni);
	}

	@Override
	public Cientifico actualizarCientifico(Cientifico Cientifico) {
		// TODO Auto-generated method stub
		return iCientificoDAO.save(Cientifico);
	}

	@Override
	public void eliminarCientifico(String dni) {
		iCientificoDAO.deleteByDni(dni);
		
	}

}
