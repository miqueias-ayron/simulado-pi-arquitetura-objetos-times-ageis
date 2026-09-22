package com.simulado.pi.equipamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Equipamento {
    @NotBlank
    private String nome;
    @NotBlank
    private String categoria;
    @Positive
    private double valorDiaria;
    @NotBlank
    private String codigoPatrimonio;
    private boolean disponivel = true;
    private boolean deleted = false;

    public Equipamento(){
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCategoria(){
        return this.categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public double getValorDiaria(){
        return this.valorDiaria;
    }
    public void setValorDiaria(double valorDiaria){
        this.valorDiaria = valorDiaria;
    }

    public String getCodigoPatrimonio(){
        return this.codigoPatrimonio;
    }
    public void setCodigoPatrimonio(String codigoPatrimonio){
        this.codigoPatrimonio = codigoPatrimonio;
    }

    public boolean getDeleted(){
        return this.deleted;
    }
    public void setDeleted(){
        this.deleted = true;
    }

    public Boolean getDisponivel(){
        return this.disponivel;
    }
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
}
