package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Proyecto;
import com.example.demo.service.ProyectoServiceImpl;

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
public class ProyectoController {

	@Autowired
	ProyectoServiceImpl ProyectoServiceImpl;
	
	//listar todos los Proyectos
	@GetMapping("/proyectos")
	public List<Proyecto> listarProyectos(){
		return ProyectoServiceImpl.listarProyectos();
	}
	
	//guardar un Proyecto
	@PostMapping("/proyectos")
	public Proyecto salvarProyecto(@RequestBody Proyecto Proyecto) {//los datos del Proyecto llegan en formato JSON desde el Request Body
		return ProyectoServiceImpl.guardarProyecto(Proyecto);
	}
	
	//muestro un Proyecto según el ID indicada
	@GetMapping("/proyectos/{id}") 
	public Proyecto ProyectoXID(@PathVariable(name="id") String id){ // el id del Proyecto llega desde la variable del path
		Proyecto Proyecto_xid = new Proyecto();//creo una instancia de la clase Proyecto
		
		Proyecto_xid=ProyectoServiceImpl.findById(id);//busco el Proyecto según el ID y le asigno los datos a la instancia de la clase Proyecto
		
		System.out.println("Proyecto XID: "+Proyecto_xid);
		
		return Proyecto_xid;//devuelvo el Proyecto en formato JSON
	}
	
	//Actualizo los datos de un Proyecto según el ID indicada
	@PutMapping("/proyectos/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name="id")String id,@RequestBody Proyecto Proyecto) {
		
		Proyecto Proyecto_seleccionado= new Proyecto();
		Proyecto Proyecto_actualizado= new Proyecto();
		
		Proyecto_seleccionado= ProyectoServiceImpl.findById(id);
		
		Proyecto_seleccionado.setNombre(Proyecto.getNombre());
		Proyecto_seleccionado.setHoras(Proyecto.getHoras());
		Proyecto_seleccionado.setAsignadoA(Proyecto.getAsignadoA());
		
		Proyecto_actualizado = ProyectoServiceImpl.actualizarProyecto(Proyecto_seleccionado);
		
		System.out.println("El Proyecto actualizado es: "+ Proyecto_actualizado);
		
		return Proyecto_actualizado;
	}
	
	//borro el Proyecto indicado por el ID que llega en la variable del path
	@DeleteMapping("/proyectos/{id}")
	public void eleiminarProyecto(@PathVariable(name="id")String id) {
		ProyectoServiceImpl.eliminarProyecto(id);
	}
}
