package com.coto.coto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.coto.coto.entity.CentroDeVenta;
import com.coto.coto.entity.Coche;
import com.coto.coto.entity.Venta;
import com.coto.coto.repository.CentroRepository;
import com.coto.coto.repository.CocheRepository;
import com.coto.coto.repository.VentaRepository;

@SpringBootApplication
public class CotoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CotoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(VentaRepository repository, CocheRepository cr, CentroRepository centroRepo) {
	    return (args) -> {
	        repository.save(new Venta(null,1L,1L));
	        repository.save(new Venta(null,1L,2L));
	        repository.save(new Venta(null,1L,1L));
	        repository.save(new Venta(null,1L,2L));
	        repository.save(new Venta(null,1L,3L));
	        repository.save(new Venta(null,1L,4L));
	        repository.save(new Venta(null,2L,1L));
	        repository.save(new Venta(null,2L,1L));
	        repository.save(new Venta(null,2L,2L));
	        repository.save(new Venta(null,2L,3L));
	        repository.save(new Venta(null,2L,4L));
	        repository.save(new Venta(null,3L,1L));
	        repository.save(new Venta(null,3L,2L));
	        repository.save(new Venta(null,3L,3L));
	        repository.save(new Venta(null,3L,4L));
	        repository.save(new Venta(null,3L,2L));
	        repository.save(new Venta(null,3L,2L));
	        repository.save(new Venta(null,3L,2L));
	        centroRepo.save(new CentroDeVenta(null,"Centro1","Bs As"));
	        centroRepo.save(new CentroDeVenta(null,"Centro2","Misiones"));
	        centroRepo.save(new CentroDeVenta(null,"Centro3","La Pampa"));
	        centroRepo.save(new CentroDeVenta(null,"Centro4","San Juan"));
	        cr.save(new Coche(null,"Sedan", "8000"));
	        cr.save(new Coche(null,"suv", "9500"));
	        cr.save(new Coche(null,"offroad", "12500"));
	        cr.save(new Coche(null,"sport", "18200"));
	    };
	}

}
