package com.coto.coto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coto.coto.dto.ResultDTO;
import com.coto.coto.entity.CentroDeVenta;
import com.coto.coto.entity.Venta;
import com.coto.coto.service.CentroService;
import com.coto.coto.service.VentaService;

@RestController
@RequestMapping("/fabrica")
public class FabricaController {

	@Autowired
    private CentroService centroService;
	
	@Autowired
    private VentaService ventaService;
 
	@RequestMapping(value="/{idCentro}", method=RequestMethod.GET)
	public ResponseEntity<?> totalByIdCenter(@PathVariable(required=true,value="idCentro")Long idCentro) {
		long inicio = System.currentTimeMillis();
		Long count = 0L;
		try {
			//busco primero que exista el id en BD
			Optional<CentroDeVenta> centro = centroService.findById(idCentro);
			if (centro.isPresent()) {
				count = ventaService.countByIdCentro(idCentro);
			} else {
				throw new Exception("El idCentro no existe en la Base de Datos.");
			}
		}
		catch( Exception e) { 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((e.getMessage()));
		 }
		long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
        System.out.println(tiempo +" segundos");
		return new ResponseEntity<>("Total de ventas para el id: "+count, HttpStatus.OK);
	}
	
	@RequestMapping(value="/porcentajePorModelo", method=RequestMethod.POST)
    public ResponseEntity<?> porcentajePorModelo() {
		long inicio = System.currentTimeMillis();
		List<ResultDTO> result = new ArrayList<ResultDTO>();
		try {
			result = centroService.porcentajePorModelo();
		} catch( Exception e) { 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((e.getMessage()));
		}
		long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
        System.out.println(tiempo +" segundos");
		return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value="/totalSales", method=RequestMethod.POST)
    public ResponseEntity<?> totalSales() {
		long inicio = System.currentTimeMillis();
		Long count = 0L;
		try {
			count = ventaService.totalSales();
		} catch( Exception e) { 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((e.getMessage()));
		}
		long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
        System.out.println(tiempo +" segundos");
		return new ResponseEntity<>(count, HttpStatus.OK);
    }
	
	@RequestMapping(value="/totalByCenter",method=RequestMethod.POST)
    public ResponseEntity<?> totalByCenter() {
		long inicio = System.currentTimeMillis();
		Map<String,Long> result = new HashMap<String,Long>();
		try {
			result = centroService.totalByCenter();
		} catch( Exception e) { 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((e.getMessage()));
		}
		long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
        System.out.println(tiempo +" segundos");
		return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping("/newSale")
    public ResponseEntity<?> newSale(@RequestBody Venta v) {
		long inicio = System.currentTimeMillis();
		Venta ve = new Venta();
		try {
			ve = ventaService.newSale(v);
		} catch( Exception e) { 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((e.getMessage()));
		}
		long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
        System.out.println(tiempo +" segundos");
		return new ResponseEntity<>(ve, HttpStatus.CREATED);
    }
}
