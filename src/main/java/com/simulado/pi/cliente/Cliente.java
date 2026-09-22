package com.simulado.pi.cliente;
import com.simulado.pi.locacao.Locacao;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;

public class Cliente {

    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String telefone;
    private boolean deleted = false;

    private ArrayList<Locacao> locacoes = new ArrayList<>();

    public Cliente(){
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public boolean getDeleted(){
        return this.deleted;
    }
    public void setDeleted(){
        this.deleted = true;
    }

    public void addLocacao(Locacao locacao){
        locacoes.add(locacao);
        locacao.setCliente(this);
    }
}