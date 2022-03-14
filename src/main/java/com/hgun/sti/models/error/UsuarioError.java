package com.hgun.sti.models.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioError {

    private String login;
    private String senha;
    private String senhaConfirmada;

    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    private EnderecoError endereco;

    public boolean isEmpty(){
        if(endereco != null && !endereco.isEmpty()){
            return false;
        }else if(login != null && !login.isEmpty()){
            return false;
        }else if(senha != null && !senha.isEmpty()){
            return false;
        }else if(senhaConfirmada != null && !senhaConfirmada.isEmpty()){
            return false;
        }else if(nome != null && !nome.isEmpty()){
            return false;
        }else if(cpf != null && !cpf.isEmpty()){
            return false;
        }else if(telefone != null && !telefone.isEmpty()){
            return false;
        }else if(email != null && !email.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
