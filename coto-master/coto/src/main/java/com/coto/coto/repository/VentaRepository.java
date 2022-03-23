package com.coto.coto.repository;

import org.springframework.data.repository.CrudRepository;

import com.coto.coto.entity.Venta;

public interface VentaRepository extends CrudRepository<Venta, Integer>{
	public Long countByIdCentro(Long id);
	public Long countByIdCentroAndIdCoche(Long idCentro,Long idCoche);
}
