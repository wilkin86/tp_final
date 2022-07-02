package com.todocodeacademy.tp_final.service;

import com.todocodeacademy.tp_final.dto.ProductoVentaDTO;
import com.todocodeacademy.tp_final.model.Producto;
import com.todocodeacademy.tp_final.model.Venta;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    //Crear la venta
    void saveVenta (Venta venta);

    //Mostrar la venta
    List<Venta> getVenta();

    //Actualizar/editar la venta
    void editVenta (Long codigo_venta);

    //delete venta
    void deleteVenta (Long codigo_venta);

    //mostrar una venta en particular
    void getUnaVenta (Long codigo_venta);

    /*obtener el codigo_venta, el total, la cantidad de productos,
    el nombre del cliente y el apellido del cliente de la venta
    con el monto mas alto de todas*/
    ProductoVentaDTO getProductoVenta();

    float sumatorioVentasDia(LocalDate fecha);

}
