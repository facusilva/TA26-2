package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cientificos")
public class Cientifico {

	//atributos de la entidad
	@Id
	private String dni;
	private String nomApels;
	
	@OneToMany
	@JoinColumn(name="cientifico")
	private List<AsignadoA> asignadoA;

	
	//constructores
	
	public Cientifico() {
		
	}
	
	public Cientifico(String dni, String nomApels, List<AsignadoA> asignadoA) {
		this.dni = dni;
		this.nomApels = nomApels;
		this.asignadoA = asignadoA;
	}
	
	//getters y setters
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cientifico")
	public List<AsignadoA> getAsignadoA() {
		return asignadoA;
	}

	public void setAsignadoA(List<AsignadoA> asignadoA) {
		this.asignadoA = asignadoA;
	}

	
	
	
	
	
}
