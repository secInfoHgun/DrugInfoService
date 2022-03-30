package com.hgun.sti.models.errors;

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
    private PessoaError pessoa;
    private EnderecoError endereco;

    public boolean isEmpty(){
        if(endereco != null  && !endereco.isEmpty()){
            return false;
        }else if(pessoa != null && !pessoa.isEmpty()){
            return false;
        }else if(login != null && !login.isEmpty()){
            return false;
        }else if(senha != null && !senha.isEmpty()){
            return false;
        }else if(senhaConfirmada != null && !senhaConfirmada.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
