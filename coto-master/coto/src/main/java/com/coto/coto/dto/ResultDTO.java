package com.coto.coto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {
	Long idCentro;
	Long idModelo;
	Double porcentaje;
}
