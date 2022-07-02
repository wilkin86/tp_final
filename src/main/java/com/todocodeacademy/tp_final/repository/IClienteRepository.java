package com.todocodeacademy.tp_final.repository;

import com.todocodeacademy.tp_final.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository <Cliente, Long> {
}
