package com.aerocdmx;


import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.aerocdmx.dto.CrearTiqueteDto;
import com.aerocdmx.modelo.TiqueteRepositorio;
import com.aerocdmx.modelo.service.TiqueteServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApiTiquesApplicationTests {

	@Test
	void contextLoads() {
	}
	
	 @Autowired
	 private MockMvc mvc;
	 @Autowired
     TiqueteServiceImpl serviceTiquete;
	  
	 @Autowired
	 TiqueteRepositorio tiqueteRepositorio;
	  

	 @Test
	 public void insertar_unTiquet()
	   throws Exception {
		 
		 Date date = new Date();
	     long timeInMilliSeconds = date.getTime();
	     java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
		 
		 CrearTiqueteDto tiquet=new CrearTiqueteDto();
		 tiquet.setEquipajeBodega(false);
	
		 
	
		tiquet.setFechaLlegada(date1);
		tiquet.setFechaSalida(date1);
		tiquet.setEquipajeBodega(false);
		tiquet.setHoraLlegada("14:01:00");
		tiquet.setHoraSalida("10:00:01");
		tiquet.setIdOrigen(1);
		tiquet.setIdOrigen(3);
		tiquet.setPasajeroNombre("Pablo Romero");
		tiquet.setPasajeroEdad(55);
		tiquet.setPrecio(545465);
		 serviceTiquete.nuevoTiquete(tiquet);
		 
		 
		
	 }
}
