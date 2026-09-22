package com.simulado.pi.equipamento;

import com.simulado.pi.utils.RegistroDuplicadoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class EquipamentoService {

    private HashMap<String, Equipamento> equipamentos = new HashMap<>();

    public Equipamento create(Equipamento equipamento){
        if (equipamentos.containsKey(equipamento.getCodigoPatrimonio())){
            throw new RegistroDuplicadoException("Código de patrimônio já cadastrado");
        }
        equipamentos.put(equipamento.getCodigoPatrimonio(), equipamento);
        return equipamento;
    }

    public ArrayList<Equipamento> readAll(){
        ArrayList<Equipamento> resultado = new ArrayList<>();
        for (Equipamento equipamento : equipamentos.values()){
            if (!equipamento.getDeleted()){
                resultado.add(equipamento);
            }
        }
        return resultado;
    }

    public Equipamento readOne(String codigoPatrimonio){
        Equipamento equipamento = equipamentos.get(codigoPatrimonio);
        if (equipamento == null || equipamento.getDeleted()){
            throw new EquipamentoNaoEncontradoException("Equipamento não encontrado");
        }
        return equipamento;
    }

    public Equipamento put(String codigoPatrimonio, Equipamento equipamento) {
        Equipamento e = readOne(codigoPatrimonio);
        e.setNome(equipamento.getNome());
        e.setCategoria(equipamento.getCategoria());
        e.setValorDiaria(equipamento.getValorDiaria());

        return e;
    }

    public Equipamento delete(String codigoPatrimonio){
        Equipamento equipamento = readOne(codigoPatrimonio);
        equipamento.setDeleted();
        return equipamento;
    }
}
