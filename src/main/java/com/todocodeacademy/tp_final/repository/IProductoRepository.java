package com.todocodeacademy.tp_final.repository;

import com.todocodeacademy.tp_final.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductoRepository extends JpaRepository <Producto, Long> {

    List<Producto> findByCantidadDisponibleGreaterThanEqual(int cantidad);

}
