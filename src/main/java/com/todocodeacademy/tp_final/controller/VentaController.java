package com.todocodeacademy.tp_final.controller;

import com.todocodeacademy.tp_final.dto.ProductoVentaDTO;
import com.todocodeacademy.tp_final.model.Producto;
import com.todocodeacademy.tp_final.model.Venta;
import com.todocodeacademy.tp_final.service.IProductoService;
import com.todocodeacademy.tp_final.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {
    @Autowired
    private IVentaService ventaServ;
    @Autowired
    private IProductoService prodServ;

    @PostMapping("/ventas/crear")
    public String saveVenta (Venta venta){
        ventaServ.saveVenta(venta);
        return "Venta creada";
    }
    @GetMapping("/ventas")
    public List<Venta> getVentas (){
        List<Venta>listaVenta = ventaServ.getVenta();
        return listaVenta;
    }
    @DeleteMapping("/clientes/eliminar/{codigo_venta}")
    public String deleteClienteCodVenta (@PathVariable Long codigo_venta){
        ventaServ.deleteVenta(codigo_venta);
        return "eliminado";
    }
    @PutMapping("/clientes/editar/{codigo_venta}")
    public void editClientesVenta (@PathVariable Long codigo_venta){
        ventaServ.editVenta(codigo_venta);
    }
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getProductosVenta (@PathVariable Long codigo_venta){
        return prodServ.getProductosVenta(codigo_venta);
    }
    @GetMapping("/ventas/{fecha_venta}")
    public Float SumaTotalVentasDia (@PathVariable LocalDate fecha){
        return ventaServ.sumatorioVentasDia(fecha);
    }
    @GetMapping("/ventas/mayor_venta")
    public ProductoVentaDTO getProductoVenta(){
        return ventaServ.getProductoVenta();
    }
}
