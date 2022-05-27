package com.ibm.academia.apirest.ruleta.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "apuestas", schema = "juegos")
public class Apuesta implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "valorApuesta")
	private String valorApuesta;
	
	@Column(name = "cantidad")
	private Double cantidadApuesta;
	
	@Column(name = "cantidadGanada")
	private Double cantidadGanada;
	
	@Column(name = "fechaCreacion", nullable = false)
	private Date fechaCreacion;
	
	@ManyToOne(optional = true, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "ruleta_id", foreignKey = @ForeignKey(name = "FK_RULETA_ID"))
	private Ruleta ruleta;
	
	public Apuesta() 
	{
		super();
	}
	
	public Apuesta(String valorApuesta, Double cantidadApuesta, Double cantidadGanada, Ruleta ruleta) 
	{
		this.valorApuesta = valorApuesta;
		this.cantidadApuesta = cantidadApuesta;
		this.cantidadGanada = cantidadGanada;
		this.ruleta = ruleta;
	}
	
	public Apuesta(String valorApuesta, Long id, Double cantidadApuesta, Double cantidadGanada) 
	{
		this.valorApuesta = valorApuesta;
		this.id = id;
		this.cantidadApuesta = cantidadApuesta;
		this.cantidadGanada = cantidadGanada;
	}
	
	@PrePersist void antesPersistir()
	{
		this.fechaCreacion = new Date();
	}

	private static final long serialVersionUID = -3086878443327311264L;

}