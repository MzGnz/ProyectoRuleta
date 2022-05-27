package com.ibm.academia.apirest.ruleta.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.academia.apirest.ruleta.enums.ColorRuleta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ruletas", schema = "juegos")
public class Ruleta implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "estado")
	private Boolean estadoRuleta;
	
	@Column(name = "numeroApuesta")
	private Integer numeroApuesta;
	
	@Column(name = "color")
	@Enumerated(EnumType.STRING)
	private ColorRuleta colorRuleta;
	
	@Column(name = "fechaCreacion", nullable = false)
	private Date fechaCreacion;
	
	@OneToMany(mappedBy = "ruleta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"ruletas"})
	private Set<Apuesta> apuestas;
	
	public Ruleta(Long id, Boolean estadoRuleta) 
	{
		this.id = id;
		this.estadoRuleta = estadoRuleta;
	}
	
	@PrePersist void antesPersistir()
	{
		this.fechaCreacion = new Date();
	}
	
	
	public Boolean getEstadoRuleta() {
		return estadoRuleta;
	}

	public void setEstadoRuleta(Boolean estadoRuleta) {
		this.estadoRuleta = estadoRuleta;
	}

	public Integer getNumeroApuesta() {
		return numeroApuesta;
	}

	public void setNumeroApuesta(Integer numeroApuesta) {
		this.numeroApuesta = numeroApuesta;
	}

	public ColorRuleta getColorRuleta() {
		return colorRuleta;
	}

	public void setColorRuleta(ColorRuleta colorRuleta) {
		this.colorRuleta = colorRuleta;
	}

	public Set<Apuesta> getApuestas() {
		return apuestas;
	}

	public void setApuestas(Set<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	private static final long serialVersionUID = -2846545211193071469L;

}