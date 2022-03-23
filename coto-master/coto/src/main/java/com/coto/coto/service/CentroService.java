package com.coto.coto.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.coto.coto.dto.ResultDTO;
import com.coto.coto.entity.CentroDeVenta;

public interface CentroService {
	public Map<String,Long> totalByCenter();
	public Optional<CentroDeVenta> findById(Long idCentro);
	public Long countByIdCentroAndIdCoche(Long idCentro,Long idCoche);
	public List<ResultDTO> porcentajePorModelo();
}
