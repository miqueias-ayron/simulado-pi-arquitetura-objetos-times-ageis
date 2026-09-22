package com.simulado.pi.cliente;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criarClientes(@Valid @RequestBody Cliente cliente){
        return clienteService.create(cliente);
    }

    @GetMapping("/clientes")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<Cliente> listarClientes(){
        return clienteService.readAll();
    }

    @GetMapping("/clientes/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscaPorCpf(@PathVariable String cpf){
        return clienteService.readOne(cpf);
    }

    @PutMapping("/clientes/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente editarCliente(@PathVariable String cpf, @Valid @RequestBody Cliente cliente){
        return clienteService.put(cpf, cliente);
    }

    @DeleteMapping("/clientes/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente deletarCliente(@PathVariable String cpf){
        return clienteService.delete(cpf);
    }

}
