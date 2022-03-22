package com.coto.coto.service;

import java.util.Map;
import java.util.Optional;

import com.coto.coto.entity.CentroDeVenta;

public interface CentroService {
	public Map<String,Long> totalByCenter();
	public  Optional<CentroDeVenta> findById(Long idCentro);
}
