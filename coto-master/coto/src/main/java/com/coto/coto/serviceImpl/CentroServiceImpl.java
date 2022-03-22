package com.coto.coto.serviceImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coto.coto.entity.CentroDeVenta;
import com.coto.coto.repository.CentroRepository;
import com.coto.coto.repository.VentaRepository;
import com.coto.coto.service.CentroService;

@Service
public class CentroServiceImpl implements CentroService{

	@Autowired
	CentroRepository centroRepository;
	
	@Autowired
	VentaRepository ventaRepository;
	
	public Map<String,Long> totalByCenter(){
		Map<String,Long> result =  new HashMap<String,Long>();
		Iterable<CentroDeVenta> centros = centroRepository.findAll();
		for (Iterator<CentroDeVenta> iterator = centros.iterator(); iterator.hasNext();) {
			Long countByCenter = 0L;
			CentroDeVenta cv = (CentroDeVenta) iterator.next();
			countByCenter = ventaRepository.countByIdCentro(cv.getId());
			result.put(cv.getId()+"-"+ cv.getNombre(), countByCenter);
		}
		return result;
	}

	@Override
	public Optional<CentroDeVenta> findById(Long idCentro) {
		return centroRepository.findById(idCentro);
	}
}
