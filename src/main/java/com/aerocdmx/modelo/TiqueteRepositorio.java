package com.aerocdmx.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TiqueteRepositorio extends  JpaRepository<Tiquete, Long>  {

	
	 @Query("SELECT t FROM tiquete t WHERE t.itineraryID = ?1 ")	
	 Tiquete findByItineraryID(String itineraryID);



}
