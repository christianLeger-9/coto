package com.coto.coto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {
	Long idCentro;
	String nombreCentro;
	String provinciaCentro;
	Long idModelo;
	String nombreModelo;
	String precio;
	Double porcentajeVentaPorCentro;
	
}
