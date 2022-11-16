package com.example.demo.dto;

import javax.persistence.*;

@Entity
@Table(name="asignado_a")
public class AsignadoA {

	//atributos de la entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="cientifico")
	private Cientifico cientifico;

	@ManyToOne
	@JoinColumn(name="proyecto")
	private Proyecto proyecto;
	
	//constructores

	public AsignadoA() {
	}
	
	public AsignadoA(Long id, Cientifico cientifico, Proyecto proyecto) {
		this.id = id;
		this.cientifico = cientifico;
		this.proyecto = proyecto;
	}


	//getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cientifico getCientifico() {
		return cientifico;
	}

	public void setCientifico(Cientifico cientifico) {
		this.cientifico = cientifico;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
}
