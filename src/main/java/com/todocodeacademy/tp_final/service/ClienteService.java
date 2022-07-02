package com.todocodeacademy.tp_final.service;

import com.todocodeacademy.tp_final.model.Cliente;
import com.todocodeacademy.tp_final.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public List<Cliente> getCliente() {
        List<Cliente>listaClientes = clienteRepo.findAll();
        return listaClientes;
    }

    @Override
    public void editCliente(Long id_cliente) {
        this.getUnCliente(id_cliente);
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        clienteRepo.deleteById(id_cliente);
    }

    @Override
    public void getUnCliente(Long id_cliente) {
        clienteRepo.findById(id_cliente);
    }
}
