package com.aerocdmx.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity(name="tiquete")
public class Tiquete {
	
	@Column(name = "vuelo_id")
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long vueloId;
	@Column(name = "itinerary_id")
	private  String itineraryID;
	@Column(name="fecha_salida")
    private  Date fechaSalida;
	@Column(name="fecha_llegada")
	private  Date fechaLlegada;	
	
	private  String pasajeroNombre;
	
	
   @Column(name="pasajero_edad")
	private  int pasajeroEdad;
	@Column(name="equipaje_bodega")
	private  boolean equipajeBodega;
	@Column(name="precio")
	private  float precio;
	@Column(name="hora_salida")
	private  String horaSalida;
	@Column(name="hora_llegada")
	private  String horaLlegada;
	
	@ManyToOne
	@JoinColumn(name="id_origen")
	private  CatCiudad ciudadOrigen;
	
	@ManyToOne
	@JoinColumn(name="id_destino")
	private  CatCiudad ciudadDestino;
	
	

}
