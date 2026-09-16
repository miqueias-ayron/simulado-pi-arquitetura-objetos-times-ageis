package com.simulado.pi.equipamento;

public class Equipamento {
    private String nome;
    private String categoria;
    private double valorDiaria;
    private String codigoPatrimonio;
    private boolean disponivel;
    private boolean deleted;

    public Equipamento(String nome, String categoria, double valorDiaria, String codigoPatrimonio){
        this.nome = nome;
        this.categoria = categoria;
        this.valorDiaria = valorDiaria;
        this.codigoPatrimonio = codigoPatrimonio;
        this.disponivel = true;
        this.deleted = false;
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

    public void setDeleted(){
        if (deleted == false){
            this.deleted = true;
        }
        else{
            this.deleted = false;
        }
    }
}
