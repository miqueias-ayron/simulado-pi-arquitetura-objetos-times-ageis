package com.simulado.pi.locacao;

import com.simulado.pi.equipamento.Equipamento;
import com.simulado.pi.equipamento.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class LocacaoService {
    @Autowired
    private EquipamentoService equipamentoService;

    ArrayList<Equipamento> equipamentos = equipamentoService.readAll();

    private HashMap<String, Locacao> locacoes = new HashMap<>();

    public Locacao create(Locacao locacao){
        for (Equipamento equipamento: equipamentos){
            if (equipamento.getDisponivel()==true){
                locacao.setEquipamento(equipamento);
                break;
            }
        }
        return locacao;
    }

    public ArrayList<Locacao> readAll(){
        return new ArrayList<>(locacoes.values());
    }

    public Locacao readOne(String id){
        Locacao locacao = locacoes.get(id);
        if (locacao == null){
            return null;
        }
        return locacao;
    }

    public Locacao put(String id, Locacao locacao) {
        Locacao l = locacoes.get(id);
        if (l == null) {
            return null;
        }
        l.setDataInicio(locacao.getDataInicio());
        l.setDataFim(locacao.getDataFim());
        l.setCliente(locacao.getCliente());
        l.setEquipamento(locacao.getEquipamento());

        return l;
    }

    public Locacao delete(String id){
        Locacao locacao = locacoes.get(id);
        if (locacao != null){
            locacao.setDeleted();
        }
        return locacao;

    }
}
