package com.hgun.sti.models.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PessoaError {

    private String  cpf;
    private String  nome;
    private String  idade;
    private String  peso;
    private String  telefone;
    private String  email;

    public boolean isEmpty(){
        if(cpf != null  && !cpf.isEmpty()){
            return false;
        }else if(nome != null && !nome.isEmpty()){
            return false;
        }else if(idade != null && !idade.isEmpty()){
            return false;
        }else if(peso != null && !peso.isEmpty()){
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
