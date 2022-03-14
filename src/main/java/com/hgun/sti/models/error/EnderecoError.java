package com.hgun.sti.models.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnderecoError {
    private String cep;
    private String cidade;
    private String bairro;
    private String rua;

    public boolean isEmpty(){
        if(cep != null && !cep.isEmpty()){
            return false;
        }else if(cidade != null && !cidade.isEmpty()){
            return false;
        } else if(bairro != null && !bairro.isEmpty()){
            return false;
        }else if(rua != null && !rua.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
