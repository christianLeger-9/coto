package com.coto.coto.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coto.coto.entity.Venta;
import com.coto.coto.repository.VentaRepository;
import com.coto.coto.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService{

	@Autowired
	VentaRepository ventaRepository;
	
	@Override
	public Venta newSale(Venta v){
		return ventaRepository.save(v);
	}
	
	@Override
	public Long totalSales(){
		return ventaRepository.count();
	}
	
	@Override
	public Long countByIdCentro(Long idCentro) {
		Long countByCenter = 0L;
		countByCenter = ventaRepository.countByIdCentro(idCentro);
		return countByCenter;
	}

	@Override
	public Long countByIdCentroAndIdCoche(Long idCentro, Long idCoche) {
		Long countByIdCentroAndIdCoche = 0L;
		countByIdCentroAndIdCoche = ventaRepository.countByIdCentroAndIdCoche(idCentro, idCoche);
		return countByIdCentroAndIdCoche;
	}
}
