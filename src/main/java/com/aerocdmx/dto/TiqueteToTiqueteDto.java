package com.aerocdmx.dto;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.aerocdmx.modelo.Tiquete;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TiqueteToTiqueteDto {
	
	private final ModelMapper modelMapper;
	
	
	
	@PostConstruct
	public void init() {
		modelMapper.addMappings(new PropertyMap<Tiquete, TiqueteDto>() {

			@Override
			protected void configure() {
				map().setCiudadDestino(source.getCiudadDestino().getCiudad());
				map().setCiudadOrigen(source.getCiudadOrigen().getCiudad());
			}
		});
	}
	
	public TiqueteDto convertToDto(Tiquete tiquete) {
		return modelMapper.map(tiquete, TiqueteDto.class);
		
	}
	
	

}
