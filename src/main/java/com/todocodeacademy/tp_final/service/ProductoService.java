package com.todocodeacademy.tp_final.service;

import com.todocodeacademy.tp_final.model.Producto;
import com.todocodeacademy.tp_final.model.Venta;
import com.todocodeacademy.tp_final.repository.IProductoRepository;
import com.todocodeacademy.tp_final.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private IProductoRepository produRepo;
    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public void saveProducto(Producto producto) {
        produRepo.save(producto);
    }

    @Override
    public List<Producto> getProducto() {
        List<Producto>listaProductos = produRepo.findAll();
        return listaProductos;
    }

    @Override
    public void editProducto(Long codigo_producto) {
       this.getUnProducto(codigo_producto);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        produRepo.deleteById(codigo_producto);
    }

    @Override
    public void getUnProducto(Long codigo_producto) {
        produRepo.findById(codigo_producto);
    }

    @Override
    public List<Producto> getProductoCantidad() {
        return produRepo.findByCantidadDisponibleGreaterThanEqual(5);
    }

    @Override
    public List<Producto> getProductosVenta(Long codigo_venta) {
        Venta venta = ventaRepo.findByCodigoVenta(codigo_venta);

        if(venta != null) {
            return venta.getLista_productos();
        }

        return null;
    }

}
