package com.todocodeacademy.tp_final.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductoVentaDTO {

    private Long codigo_venta;
    private Long total_venta;
    private Integer cantidad_producto_disponible;
    private String nombre_cliente;
    private String apellido_cliente;

    public ProductoVentaDTO() {
    }

    public ProductoVentaDTO(Long codigo_venta, Long total_venta, Integer cantidad_producto_disponible, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total_venta = total_venta;
        this.cantidad_producto_disponible = cantidad_producto_disponible;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }
}
