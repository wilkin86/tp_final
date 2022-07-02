package com.todocodeacademy.tp_final.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_producto;

    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidadDisponible;

    @ManyToMany (mappedBy = "lista_productos")
    private List<Venta> lista_ventas;

    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidadDisponible = cantidad_disponible;
    }
}
