package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Cientifico;
import com.example.demo.service.CientificoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CientificoController {

	@Autowired
	CientificoServiceImpl CientificoServiceImpl;
	
	//listar todos los Cientificos
	@GetMapping("/cientificos")
	public List<Cientifico> listarCientificos(){
		return CientificoServiceImpl.listarCientificos();
	}
	
	//guardar un Cientifico
	@PostMapping("/cientificos")
	public Cientifico salvarCientifico(@RequestBody Cientifico Cientifico) {//los datos del Cientifico llegan en formato JSON desde el Request Body
		return CientificoServiceImpl.guardarCientifico(Cientifico);
	}
	
	//muestro un Cientifico según el ID indicada
	@GetMapping("/cientificos/{dni}") 
	public Cientifico CientificoXID(@PathVariable(name="dni") String dni){ // el id del Cientifico llega desde la variable del path
		Cientifico Cientifico_xid = new Cientifico();//creo una instancia de la clase Cientifico
		
		Cientifico_xid=CientificoServiceImpl.findByDni(dni);//busco el Cientifico según el ID y le asigno los datos a la instancia de la clase Cientifico
		
		System.out.println("Cientifico XID: "+Cientifico_xid);
		
		return Cientifico_xid;//devuelvo el Cientifico en formato JSON
	}
	
	//Actualizo los datos de un Cientifico según el ID indicada
	@PutMapping("/cientificos/{id}")
	public Cientifico actualizarCientifico(@PathVariable(name="dni")String dni,@RequestBody Cientifico Cientifico) {
		
		Cientifico Cientifico_seleccionado= new Cientifico();
		Cientifico Cientifico_actualizado= new Cientifico();
		
		Cientifico_seleccionado= CientificoServiceImpl.findByDni(dni);
		
		Cientifico_seleccionado.setNomApels(Cientifico.getNomApels());
		Cientifico_seleccionado.setAsignadoA(Cientifico.getAsignadoA());
		
		Cientifico_actualizado = CientificoServiceImpl.actualizarCientifico(Cientifico_seleccionado);
		
		System.out.println("El Cientifico actualizado es: "+ Cientifico_actualizado);
		
		return Cientifico_actualizado;
	}
	
	//borro el Cientifico indicado por el ID que llega en la variable del path
	@DeleteMapping("/cientificos/{dni}")
	public void eleiminarCientifico(@PathVariable(name="dni")String dni) {
		CientificoServiceImpl.deleteByDni(dni);
	}
}
