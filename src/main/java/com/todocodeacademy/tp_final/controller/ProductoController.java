package com.todocodeacademy.tp_final.controller;

import com.todocodeacademy.tp_final.model.Producto;
import com.todocodeacademy.tp_final.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private IProductoService produServ;
    @Autowired
    private IProductoService prodServ;

    @PostMapping("/productos/crear")
    public String saveProducto (Producto producto){
        produServ.saveProducto(producto);
        return "el producto se ha creado correctamente";
    }
    @GetMapping("/productos")
    public List<Producto> getProductos (){
        List<Producto>listaProducto = produServ.getProducto();
        return listaProducto;
    }
    @GetMapping("/productos/{codigo_producto}")
    public void getUnProducto (@PathVariable Long codigo_producto){
        produServ.getUnProducto(codigo_producto);
    }
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto (@PathVariable Long codigo_producto){
        produServ.deleteProducto(codigo_producto);
        return "El producto se ha eliminado correctamente";
    }
    @PutMapping("/productos/editar/{codigo_producto}")
    public void editProducto (@PathVariable Long codigo_producto){
        produServ.editProducto(codigo_producto);
    }
    @GetMapping("/productos/falta_stock")
    public List<Producto> getProductoCantidad (){
        List<Producto>listaProducto = produServ.getProductoCantidad();
        return listaProducto;
    }
}
