package com.ibm.academia.apirest.ruleta.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.ibm.academia.apirest.ruleta.enums.ColorRuleta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ruletas", schema = "juegos")
public class Ruleta implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "estado")
	private Boolean estadoRuleta;
	
	@Column(name = "numeroApuesta")
	private Integer numeroApuesta;
	
	@Column(name = "color")
	private ColorRuleta colorRuleta;
	
	@Column(name = "cantidad")
	private Double cantidadApuesta;
	
	@Column(name = "fechaCreacion", nullable = false)
	private Date fechaCreacion;
	
	@OneToMany(mappedBy = "ruleta", fetch = FetchType.LAZY)
	private List<Apuesta> apuestas;
	
	public Ruleta(Integer id, Boolean estadoRuleta, Integer numeroApuesta, ColorRuleta colorRuleta, Double cantidadApuesta, List<Apuesta> apuestas) 
	{
		this.id = id;
		this.estadoRuleta = estadoRuleta;
		this.numeroApuesta = numeroApuesta;
		this.colorRuleta = colorRuleta;
		this.cantidadApuesta = cantidadApuesta;
		this.apuestas = apuestas;
	}

	@PrePersist void antesPersistir()
	{
		this.fechaCreacion = new Date();
	}
	
	private static final long serialVersionUID = -2846545211193071469L;

}