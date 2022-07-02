package com.todocodeacademy.tp_final.controller;

import com.todocodeacademy.tp_final.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.todocodeacademy.tp_final.service.IClienteService;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService cliServ;

    @PostMapping("/clientes/crear")
    public String SaveCliente (Cliente cliente){
        cliServ.saveCliente(cliente);
        return "cliente creado";
    }
    @GetMapping("/clientes")
    public List<Cliente> getCliente (){
        return cliServ.getCliente();
    }
    @GetMapping("/clientes/{id_cliente}")
    public void getUnCliente (@PathVariable Long id_cliente){
        cliServ.getUnCliente(id_cliente);
    }
    @DeleteMapping("clientes/eliminar/{id_cliente}")
    public String deleteCliente (@PathVariable Long id_cliente){
        cliServ.deleteCliente(id_cliente);
        return "cliente eliminado";
    }
    @PutMapping("clientes/editar/{id_cliente}")
    public void editCliente (@PathVariable Long id_cliente){
        cliServ.editCliente(id_cliente);
    }
}
