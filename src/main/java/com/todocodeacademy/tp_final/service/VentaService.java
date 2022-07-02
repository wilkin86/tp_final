package com.todocodeacademy.tp_final.service;

import com.todocodeacademy.tp_final.dto.ProductoVentaDTO;
import com.todocodeacademy.tp_final.model.Cliente;
import com.todocodeacademy.tp_final.model.Producto;
import com.todocodeacademy.tp_final.model.Venta;
import com.todocodeacademy.tp_final.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public List<Venta> getVenta() {
        List<Venta>listaVentas = ventaRepo.findAll();
        return listaVentas;
    }

    @Override
    public void editVenta(Long codigo_venta) {
        this.getUnaVenta(codigo_venta);
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepo.deleteById(codigo_venta);
    }

    @Override
    public void getUnaVenta(Long codigo_venta) {
        ventaRepo.findById(codigo_venta);
    }

    @Override
    public ProductoVentaDTO getProductoVenta() {
        Venta mayorVenta = ventaRepo.findFirstByOrderByTotalDesc();
        ProductoVentaDTO productoVentaDTO = new ProductoVentaDTO();
        productoVentaDTO.setCodigo_venta(mayorVenta.getCodigoVenta());
        productoVentaDTO.setTotal_venta(mayorVenta.getTotal().longValue());
        productoVentaDTO.setCantidad_producto_disponible(mayorVenta.getLista_productos().size());
        /*int totalProductos = 0;
        for(Producto p : mayorVenta.getLista_productos()) {
            totalProductos += p.getCantidad_disponible();
        }
        productoVentaDTO.setCantidad_producto_disponible(totalProductos);*/
        productoVentaDTO.setNombre_cliente(mayorVenta.getUnCliente().getNombre());
        productoVentaDTO.setApellido_cliente(mayorVenta.getUnCliente().getApellido());
        return productoVentaDTO;
    }

    @Override
    public float sumatorioVentasDia(LocalDate fecha) {
        List<Venta> ventas = ventaRepo.findByFechaVenta(fecha);
        float total = 0;

        for(Venta venta : ventas) {
            for(Producto producto : venta.getLista_productos()) {
                total += producto.getCosto();
            }
        }
        return total;
    }
}
