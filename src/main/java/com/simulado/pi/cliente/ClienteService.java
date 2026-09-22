package com.simulado.pi.cliente;

import com.simulado.pi.utils.RegistroDuplicadoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ClienteService {

    private HashMap<String, Cliente> clientes = new HashMap<>();

    public Cliente create(Cliente cliente){
        if (clientes.containsKey(cliente.getCpf())){
            throw new RegistroDuplicadoException("CPF já cadastrado");
        }
        clientes.put(cliente.getCpf(), cliente);
        return cliente;
    }

    public ArrayList<Cliente> readAll(){
        ArrayList<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : clientes.values()){
            if (!cliente.getDeleted()){
                resultado.add(cliente);
            }
        }
        return resultado;
    }

    public Cliente readOne(String cpf){
        Cliente cliente = clientes.get(cpf);
        if (cliente == null || cliente.getDeleted()){
            throw new ClienteNaoEncontradoException("Cliente não encontrado");
        }
        return cliente;
    }

    public Cliente put(String cpf, Cliente cliente) {
        Cliente c = readOne(cpf);
        c.setNome(cliente.getNome());
        c.setEmail(cliente.getEmail());
        c.setTelefone(cliente.getTelefone());
        return c;
    }

    public Cliente delete(String cpf){
        Cliente cliente = readOne(cpf);
        cliente.setDeleted();
        return cliente;
    }

}
