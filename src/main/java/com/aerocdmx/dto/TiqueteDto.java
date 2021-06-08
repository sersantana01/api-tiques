package com.aerocdmx.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TiqueteDto {
	
	
	    private  Date fechaSalida;
		private  Date fechaLlegada;
		private  String itineraryID;
		private  String ciudadOrigen;
		private  String ciudadDestino;
		private  String pasajeroNombre;
		private  int pasajeroEdad;
		private  boolean equipajeBodega;
		private  float precio;
		private  String horaSalida;
		private  String horaLlegada;

}
