package com.simulado.pi.equipamento;

import com.simulado.pi.cliente.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class EquipamentoService {

    private HashMap<String, Equipamento> equipamentos = new HashMap<>();

    public Equipamento create(Equipamento equipamento){
        equipamentos.put(equipamento.getCodigoPatrimonio(), equipamento);
        return equipamento;
    }

    public ArrayList<Equipamento> readAll(){
        return new ArrayList<>(equipamentos.values());
    }

    public Equipamento readOne(String codigoPatrimonio){
        Equipamento equipamento = equipamentos.get(codigoPatrimonio);
        if (equipamento == null){
            return null;
        }
        return equipamento;
    }

    public Equipamento put(String codigoPatrimonio, Equipamento equipamento) {
        Equipamento e = equipamentos.get(codigoPatrimonio);
        if (e == null) {
            return null;
        }
        e.setNome(equipamento.getNome());
        e.setCategoria(equipamento.getCategoria());
        e.setValorDiaria(equipamento.getValorDiaria());

        return e;
    }

    public Equipamento delete(String codigoPatrimonio){
        Equipamento equipamento = equipamentos.get(codigoPatrimonio);
        if (equipamento != null){
            equipamento.setDeleted();
        }
        return equipamento;

    }
}
