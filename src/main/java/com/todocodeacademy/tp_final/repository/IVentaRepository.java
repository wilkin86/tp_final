package com.todocodeacademy.tp_final.repository;

import com.todocodeacademy.tp_final.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IVentaRepository extends JpaRepository <Venta, Long> {

    Venta findByCodigoVenta(Long codigoVenta);

    List<Venta> findByFechaVenta(LocalDate fecha);

    Venta findFirstByOrderByTotalDesc();
}
