package com.aerocdmx.modelo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.aerocdmx.dto.CrearTiqueteDto;
import com.aerocdmx.dto.TiqueteDto;
import com.aerocdmx.dto.TiqueteToTiqueteDto;
import com.aerocdmx.exception.TiqueteNoFoundException;
import com.aerocdmx.modelo.CatCiudad;
import com.aerocdmx.modelo.CatCiudadRepositorio;
import com.aerocdmx.modelo.Tiquete;
import com.aerocdmx.modelo.TiqueteRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TiqueteServiceImpl  implements TiqueteService{
	
	
  	@Autowired
	TiqueteRepositorio tiqueteRepositorio ;
	@Autowired
	TiqueteToTiqueteDto tiqueteToTiqueteDto; 
	@Autowired
	CatCiudadRepositorio catCiudadRepositorio;
	
	
	@Override
	public TiqueteDto consultarTiquete(String itineraryID) {
		TiqueteDto tiqueteDto;
	 try {
	
	  
		Tiquete tiquete= tiqueteRepositorio.findByItineraryID(itineraryID);
		if(tiquete==null) {   	  
	        throw new TiqueteNoFoundException(itineraryID);
	      }  
		
		tiqueteDto=tiqueteToTiqueteDto.convertToDto(tiquete);
		
		
		
		}
		catch (TiqueteNoFoundException e) {
			  throw new  ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	  return tiqueteDto;
		
	}

	@Override
	public ResponseEntity<?> nuevoTiquete(CrearTiqueteDto crearTiqueteDto) {
		
		Tiquete tiquete=new Tiquete();
		tiquete.setEquipajeBodega(crearTiqueteDto.isEquipajeBodega());
		
		tiquete.setFechaLlegada(crearTiqueteDto.getFechaLlegada());
		tiquete.setFechaSalida(crearTiqueteDto.getFechaSalida());
		tiquete.setHoraLlegada(crearTiqueteDto.getHoraLlegada());
		tiquete.setHoraSalida(crearTiqueteDto.getHoraSalida());
		tiquete.setPasajeroEdad(crearTiqueteDto.getPasajeroEdad());
		tiquete.setPasajeroNombre(crearTiqueteDto.getPasajeroNombre());
		tiquete.setPrecio(crearTiqueteDto.getPrecio());
		tiquete.setItineraryID(generarItineraryId(tiquete));
		
		CatCiudad ciudadDestino = catCiudadRepositorio.findById(crearTiqueteDto.getIdDestino()).orElse(null);
		CatCiudad ciudadOrigen=catCiudadRepositorio.findById(crearTiqueteDto.getIdOrigen()).orElse(null);
		
		tiquete.setCiudadDestino(ciudadDestino);
		tiquete.setCiudadOrigen(ciudadOrigen);
		
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(tiqueteRepositorio.save(tiquete));
	}
	
	private String generarItineraryId( Tiquete tiquete) {
		
		
		String id=Math.random()*1000 +""+tiquete.getPasajeroNombre().toUpperCase().charAt(0)+tiquete.getFechaSalida();
		
		return id;
	}
	
	


}


