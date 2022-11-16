package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.AsignadoA;
import com.example.demo.service.AsignadoAServiceImpl;

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
public class AsignadoAController {

	@Autowired
	AsignadoAServiceImpl AsignadoAServiceImpl;
	
	//listar todos los AsignadoAs
	@GetMapping("/asignadoa")
	public List<AsignadoA> listarAsignadoAs(){
		return AsignadoAServiceImpl.listarAsignadoAs();
	}
	
	//guardar un AsignadoA
	@PostMapping("/asignadoa")
	public AsignadoA salvarAsignadoA(@RequestBody AsignadoA AsignadoA) {//los datos del AsignadoA llegan en formato JSON desde el Request Body
		return AsignadoAServiceImpl.guardarAsignadoA(AsignadoA);
	}
	
	//muestro un AsignadoA según el ID indicada
	@GetMapping("/asignadoa/{id}") 
	public AsignadoA AsignadoAXID(@PathVariable(name="id") Long id){ // el id del AsignadoA llega desde la variable del path
		AsignadoA AsignadoA_xid = new AsignadoA();//creo una instancia de la clase AsignadoA
		
		AsignadoA_xid=AsignadoAServiceImpl.AsignadoAXID(id);//busco el AsignadoA según el ID y le asigno los datos a la instancia de la clase AsignadoA
		
		System.out.println("AsignadoA XID: "+AsignadoA_xid);
		
		return AsignadoA_xid;//devuelvo el AsignadoA en formato JSON
	}
	
	//Actualizo los datos de un AsignadoA según el ID indicada
	@PutMapping("/asignadoa/{id}")
	public AsignadoA actualizarAsignadoA(@PathVariable(name="id")Long id,@RequestBody AsignadoA AsignadoA) {
		
		AsignadoA AsignadoA_seleccionado= new AsignadoA();
		AsignadoA AsignadoA_actualizado= new AsignadoA();
		
		AsignadoA_seleccionado= AsignadoAServiceImpl.AsignadoAXID(id);
		
		AsignadoA_seleccionado.setCientifico(AsignadoA.getCientifico());
		AsignadoA_seleccionado.setProyecto(AsignadoA.getProyecto());
		
		AsignadoA_actualizado = AsignadoAServiceImpl.actualizarAsignadoA(AsignadoA_seleccionado);
		
		System.out.println("El AsignadoA actualizado es: "+ AsignadoA_actualizado);
		
		return AsignadoA_actualizado;
	}
	
	//borro el AsignadoA indicado por el ID que llega en la variable del path
	@DeleteMapping("/asignadoa/{id}")
	public void eleiminarAsignadoA(@PathVariable(name="id")Long id) {
		AsignadoAServiceImpl.eliminarAsignadoA(id);
	}
}
