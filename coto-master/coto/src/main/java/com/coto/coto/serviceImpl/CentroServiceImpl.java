package com.coto.coto.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coto.coto.dto.ResultDTO;
import com.coto.coto.entity.CentroDeVenta;
import com.coto.coto.entity.Coche;
import com.coto.coto.repository.CentroRepository;
import com.coto.coto.repository.CocheRepository;
import com.coto.coto.repository.VentaRepository;
import com.coto.coto.service.CentroService;

@Service
public class CentroServiceImpl implements CentroService{

	@Autowired
	CentroRepository centroRepository;
	
	@Autowired
	VentaRepository ventaRepository;
	
	@Autowired
    private CocheRepository cocheRepository;
	
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
	
	@Override
	public List<ResultDTO> porcentajePorModelo() {
		Long totalSale = ventaRepository.count();
		List<Coche> coches = cocheRepository.findAll();
		List<CentroDeVenta> centros = centroRepository.findAll();
		List<ResultDTO> listResult = new ArrayList<ResultDTO>();
		//obtengo una lista de todos los centros para iterarla y por cada centro iterar todos los coches y llamar al metodo
		//countByIdCentroAndIdCoche para traerme la cantidad de ese coche particular vendido en ese centro y luego sacar el %
		for (Iterator<CentroDeVenta> iteratorCentro = centros.iterator(); iteratorCentro.hasNext();) {
			CentroDeVenta centroDeVenta = (CentroDeVenta) iteratorCentro.next();
			for (Iterator<Coche> iteratorCoche = coches.iterator(); iteratorCoche.hasNext();) {
				ResultDTO result = new ResultDTO();
				Coche coche = (Coche) iteratorCoche.next();
				double countByCenterAndIdCoche = 0.0;
				countByCenterAndIdCoche = ventaRepository.countByIdCentroAndIdCoche(centroDeVenta.getId(), coche.getId());
				double porcentaje = ((countByCenterAndIdCoche*100)/totalSale);
				result.setPorcentajeVentaPorCentro(porcentaje);
				result.setNombreCentro(centroDeVenta.getNombre());
				result.setNombreModelo(coche.getNombre());
				result.setIdCentro(centroDeVenta.getId());
				result.setIdModelo(coche.getId());
				result.setProvinciaCentro(centroDeVenta.getProvincia());
				result.setPrecio(coche.getPrecio());
				listResult.add(result);
			}
		}
		return listResult;
	}
	
	@Override
	public  Long countByIdCentroAndIdCoche(Long idCentro,Long idCoche) {
		Long countByCenterAndIdCoche = 0L;
		countByCenterAndIdCoche = ventaRepository.countByIdCentroAndIdCoche(idCentro, idCoche);
		return countByCenterAndIdCoche;
	}
}
