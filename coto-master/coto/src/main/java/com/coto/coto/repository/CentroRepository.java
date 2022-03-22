package com.coto.coto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coto.coto.entity.CentroDeVenta;

public interface CentroRepository extends JpaRepository<CentroDeVenta, Long>{
	public abstract Optional<CentroDeVenta> findById(Long idCentro);
}
