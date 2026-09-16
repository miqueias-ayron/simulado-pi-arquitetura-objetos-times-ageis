package com.simulado.pi.cliente;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ClienteService {

    private HashMap<String, Cliente> clientes = new HashMap<>();

    public Cliente create(Cliente clienteDTO){
        clientes.put(clienteDTO.getCpf(), clienteDTO);
        return clienteDTO;
    }

    public ArrayList<Cliente> readAll(){
        return new ArrayList<>(clientes.values());
    }

    public Cliente readForCpf(String cpf){
        Cliente cliente = clientes.get(cpf);
        if (cliente == null){
            return null;
        }
        return cliente;
    }

    public Cliente put(String cpf, Cliente cliente) {
        Cliente c = clientes.get(cpf);
        if (c == null) {
            return null;
        }
        c.setNome(cliente.getNome());
        c.setEmail(cliente.getEmail());
        c.setTelefone(cliente.getTelefone());
        return c;
    }

    public Cliente delete(String cpf){
        Cliente cliente = clientes.get(cpf);
        if (cliente != null){
            cliente.setDeleted();
        }
        return cliente;

    }

}
