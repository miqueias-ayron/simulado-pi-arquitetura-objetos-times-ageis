package com.simulado.pi.cliente;

public class Cliente {

    private String email;
    private String nome;
    private String cpf;
    private String telefone;
    private boolean deleted;

    public Cliente(String email, String nome, String cpf, String telefone){
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.deleted = false;
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

    public void setDeleted(){
        if (deleted == false){
            this.deleted = true;
        }
        else{
            this.deleted = false;
        }
    }
}