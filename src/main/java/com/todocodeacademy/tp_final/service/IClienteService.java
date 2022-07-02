package com.todocodeacademy.tp_final.service;

import com.todocodeacademy.tp_final.model.Cliente;

import java.util.List;

public interface IClienteService {

    //Crear el cliente
    void saveCliente (Cliente cliente);

    //Mostrar el cliente
    List<Cliente> getCliente();

    //Actualizar/editar el cliente
    void editCliente (Long id_cliente);

    //delete cliente
    void deleteCliente (Long id_cliente);

    //mostrar a un cliente en particular
    void getUnCliente (Long id_cliente);
}
