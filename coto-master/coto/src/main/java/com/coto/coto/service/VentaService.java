package com.coto.coto.service;

import com.coto.coto.entity.Venta;

public interface VentaService {
	public Venta newSale(Venta venta);
	public Long totalSales();
	public Long countByIdCentro(Long idCentro);
}
