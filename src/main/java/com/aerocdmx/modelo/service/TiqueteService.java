package com.aerocdmx.modelo.service;

import org.springframework.http.ResponseEntity;

import com.aerocdmx.dto.CrearTiqueteDto;
import com.aerocdmx.dto.TiqueteDto;

public interface TiqueteService {
	
	
	
	TiqueteDto consultarTiquete(String  itineraryID);
	 
	 
	ResponseEntity<?> nuevoTiquete(CrearTiqueteDto crearTiqueteDto);

}
