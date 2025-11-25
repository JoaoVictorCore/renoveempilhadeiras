package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


//pacote dto
public class ContatoDTO {
    @NotBlank (message = "O nome é obrigatório")
    private String nome;

    @NotBlank (message = "O telefone é obrigatório")
    private String telefone;

    @NotBlank (message = "O e-mai é obrigatório")
    @Email (message = "Formato de e-mail inválido")
    private String email;

    @Size(min = 10, max = 500, message = "A mensagem deve ter entre 10 e 500 caracteres")
    private String mensagem;

    //getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
