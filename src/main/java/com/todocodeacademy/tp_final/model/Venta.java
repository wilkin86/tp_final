package com.todocodeacademy.tp_final.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoVenta;
    private LocalDate fechaVenta;
    private Double total;

    @ManyToMany
    @JoinTable (name = "venta_producto",
            joinColumns = @JoinColumn (name = "codigo_venta", nullable = false),
            inverseJoinColumns = @JoinColumn (name = "codigo_producto", nullable = false))
    private List<Producto> lista_productos;

    @OneToOne
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigoVenta = codigo_venta;
        this.fechaVenta = fecha_venta;
        this.total = total;
        this.lista_productos = lista_productos;
        this.unCliente = unCliente;
    }
}
