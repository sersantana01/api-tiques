package com.aerocdmx.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity(name = "cat_ciudad")
public class CatCiudad {

	@Id @GeneratedValue
	private long ciudadId;
	private String ciudad ;
	private String estado  ;
	private String pais    ;

	
}