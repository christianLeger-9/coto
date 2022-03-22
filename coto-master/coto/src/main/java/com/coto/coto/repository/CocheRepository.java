package com.coto.coto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.coto.coto.entity.Coche;

public interface CocheRepository extends JpaRepository<Coche, Long>{

}
