package com.simulado.pi.equipamento;

import com.simulado.pi.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EquipamentoController {
    @Autowired
    EquipamentoService equipamentoService;

    @PostMapping("/equipamentos")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipamento criarEquipamentos(@RequestBody Equipamento equipamento){
        return equipamentoService.create(equipamento);
    }

    @GetMapping("/equipamentos")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<Equipamento> listarEquipamentos(){
        return equipamentoService.readAll();
    }

    @GetMapping("/equipamentos/{codigoPatrimonio}")
    @ResponseStatus(HttpStatus.OK)
    public Equipamento buscaPorCodigoPatrimonio(@PathVariable String codigoPatrimonio){
        return equipamentoService.readOne(codigoPatrimonio);
    }

    @PutMapping("/equipamentos/{codigoPatrimonio}")
    @ResponseStatus(HttpStatus.OK)
    public Equipamento editarEquipamento(@PathVariable String codigoPatrimonio, @RequestBody Equipamento equipamento){
        return equipamentoService.put(codigoPatrimonio, equipamento);
    }

    @DeleteMapping("/equipamentos/{codigoPatrimonio}")
    @ResponseStatus(HttpStatus.OK)
    public Equipamento deletarEquipamento(@PathVariable String codigoPatrimonio){
        return equipamentoService.delete(codigoPatrimonio);
    }
}