package com.simulado.pi.locacao;

import com.simulado.pi.cliente.Cliente;
import com.simulado.pi.equipamento.Equipamento;

import java.time.LocalDate;
import java.util.UUID;

public class Locacao {
    private String id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Cliente cliente;
    private Equipamento equipamento;
    private boolean deleted;

    public Locacao(LocalDate dataInicio, LocalDate dataFim, Cliente cliente, Equipamento equipamento){
        this.id = UUID.randomUUID().toString();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.cliente = cliente;
        this.equipamento = equipamento;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio){
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim){
        this.dataFim = dataFim;
    }

    public Cliente getCliente(){
        return this.cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Equipamento getEquipamento(){
        return this.equipamento;
    }
    public void setEquipamento(Equipamento equipamento){
        this.equipamento = equipamento;
    }

    public void setDeleted(){
        if (deleted == false){
            this.deleted = true;
        }
        else{
            this.deleted = false;
        }
    }

}

