package com.simulado.pi.locacao;

import com.simulado.pi.cliente.Cliente;
import com.simulado.pi.cliente.ClienteService;
import com.simulado.pi.equipamento.Equipamento;
import com.simulado.pi.equipamento.EquipamentoIndisponivelException;
import com.simulado.pi.equipamento.EquipamentoService;
import com.simulado.pi.utils.CampoInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class LocacaoService {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EquipamentoService equipamentoService;

    private HashMap<String, Locacao> locacoes = new HashMap<>();

    public Locacao create(Locacao locacao){
        if (locacao.getCliente() == null || locacao.getCliente().getCpf() == null || locacao.getCliente().getCpf().isBlank()){
            throw new CampoInvalidoException("Cliente é obrigatório");
        }

        Cliente cliente = clienteService.readOne(locacao.getCliente().getCpf());
        cliente.addLocacao(locacao);

        Equipamento disponivel = null;
        for (Equipamento equipamento : equipamentoService.readAll()){
            if (equipamento.getDisponivel()){
                disponivel = equipamento;
                break;
            }
        }
        if (disponivel == null){
            throw new EquipamentoIndisponivelException("Nenhum equipamento disponível");
        }
        disponivel.setDisponivel(false);
        locacao.setEquipamento(disponivel);
        locacao.setId(UUID.randomUUID().toString());

        locacoes.put(locacao.getId(), locacao);
        return locacao;
    }

    public ArrayList<Locacao> readAll(){
        ArrayList<Locacao> resultado = new ArrayList<>();
        for (Locacao locacao : locacoes.values()){
            if (!locacao.getDeleted()){
                resultado.add(locacao);
            }
        }
        return resultado;
    }

    public Locacao readOne(String id){
        Locacao locacao = locacoes.get(id);
        if (locacao == null || locacao.getDeleted()){
            throw new LocacaoNaoEncontradoException("Locação não encontrada");
        }
        return locacao;
    }

    public Locacao put(String id, Locacao locacao) {
        Locacao l = readOne(id);
        l.setDataInicio(locacao.getDataInicio());
        l.setDataFim(locacao.getDataFim());
        return l;
    }

    public Locacao delete(String id){
        Locacao locacao = readOne(id);
        locacao.setDeleted();
        return locacao;
    }
}
