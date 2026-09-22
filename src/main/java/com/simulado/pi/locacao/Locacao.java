package com.simulado.pi.locacao;

import com.simulado.pi.cliente.Cliente;
import com.simulado.pi.equipamento.Equipamento;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class Locacao {
    private String id;
    @NotNull
    private LocalDate dataInicio;
    @NotNull
    private LocalDate dataFim;
    @NotNull
    private Cliente cliente;
    private Equipamento equipamento;
    private boolean deleted = false;

    public Locacao(){
    }

    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
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

    public boolean getDeleted(){
        return this.deleted;
    }
    public void setDeleted(){
        this.deleted = true;
    }

}

