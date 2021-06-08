package com.aerocdmx.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aerocdmx.dto.CrearTiqueteDto;
import com.aerocdmx.dto.TiqueteDto;
import com.aerocdmx.exception.TiqueteApiError;
import com.aerocdmx.exception.TiqueteNoFoundException;
import com.aerocdmx.modelo.service.TiqueteService;
import com.aerocdmx.modelo.service.TiqueteServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class TiqueteController {
	
    @Autowired
	TiqueteServiceImpl serviceTiquete;
	
    @ApiOperation(value="Consultar un tiquetede vuelo ", notes="Permite consultar un tiquete de vuelo por el identity id")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="OK", response=TiqueteDto.class),
			@ApiResponse(code=404, message="Not Found", response=TiqueteApiError.class),
			@ApiResponse(code=500, message="Internal Server Error", response=TiqueteApiError.class)
	})
	@GetMapping("/tiquete/{intenaryId}")
	public TiqueteDto obtenerTiquet(@PathVariable String intenaryId) {
		
	 return	serviceTiquete.consultarTiquete(intenaryId);
		
	 
	}
	
    @ApiOperation(value="Crear un nuevo tiquete", notes="Permite crear un tiquete de vuelo")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="OK", response=TiqueteDto.class),
			@ApiResponse(code=400, message="Bad Request", response=TiqueteApiError.class),
			@ApiResponse(code=500, message="Internal Server Error", response=TiqueteApiError.class)
	})	
	@PostMapping("/tiquete")
	public ResponseEntity<?> crearTiquete(@RequestBody CrearTiqueteDto tiqueteDto){
		
		return serviceTiquete.nuevoTiquete(tiqueteDto);
	}
}
