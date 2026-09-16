package com.simulado.pi.locacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class LocacaoController {
    @Autowired
    LocacaoService locacaoService;

    @PostMapping("/locacoes")
    @ResponseStatus(HttpStatus.CREATED)
    public Locacao criarLocacao(@RequestBody Locacao locacao){
        return locacaoService.create(locacao);
    }

    @GetMapping("/locacoes")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<Locacao> listarLocacoes(){
        return locacaoService.readAll();
    }

    @GetMapping("/locacoes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Locacao buscaLocacao(@PathVariable String id){
        return locacaoService.readOne(id);
    }

    @PutMapping("/locacoes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Locacao editarLocacao(@PathVariable String id, @RequestBody Locacao locacao){
        return locacaoService.put(id, locacao);
    }

    @DeleteMapping("/locacoes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Locacao deletarLocacao(@PathVariable String id){
        return locacaoService.delete(id);
    }
}
