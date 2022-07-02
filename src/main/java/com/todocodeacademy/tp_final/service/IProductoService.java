package com.todocodeacademy.tp_final.service;

import com.todocodeacademy.tp_final.model.Producto;

import java.util.List;

public interface IProductoService {

    //Crear el producto
    void saveProducto (Producto producto);

    //Mostrar el producto
    List<Producto> getProducto();

    //Actualizar/editar
    void editProducto (Long codigo_producto);

    //delete
    void deleteProducto (Long codigo_producto);

    //mostrar un producto en particular
    void getUnProducto (Long codigo_producto);

    /*Obtener todos los productos cuya cantidad disponible
    sea menor a 5*/
    List<Producto> getProductoCantidad();

    /*obtener la lista de productos de una
determinada venta*/
    List<Producto> getProductosVenta (Long codigo_venta);
}
