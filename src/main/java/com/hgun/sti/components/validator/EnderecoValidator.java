package com.hgun.sti.components.validator;

import com.hgun.sti.models.Endereco;
import com.hgun.sti.models.error.EnderecoError;

public class EnderecoValidator {
    public static EnderecoError validarEndereco(Endereco endereco){

        var enderecoError = new EnderecoError();

        if(endereco.getCep() == null || endereco.getCep().isEmpty()){
            enderecoError.setCep("O CEP não pode ser vazio!");
        }else if(!endereco.getCep().matches("[0-9]{5}-[0-9]{3}")){
            enderecoError.setCep("O CEP está inválido!");
        }

        if(endereco.getCidade() == null || endereco.getCidade().isEmpty()){
            enderecoError.setCidade("A cidade não pode ser vazia!");
        }else if(endereco.getCidade().length() < 4){
            enderecoError.setCidade("O nome da cidade está muito curto! (min: 4 caracteres)");
        }

        if(endereco.getBairro() == null || endereco.getBairro().isEmpty()){
            enderecoError.setBairro("O bairro não pode ser vazio!");
        }else if(endereco.getBairro().length() < 4){
            enderecoError.setBairro("O nome do bairro está muito curto! (min: 4 caracteres)");
        }

        if(endereco.getRua() == null || endereco.getRua().isEmpty()){
            enderecoError.setRua("A rua não pode ser vazia!");
        }else if(endereco.getRua().length() < 4){
            enderecoError.setRua("O nome da rua está muito curto! (min: 4 caracteres)");
        }

        return enderecoError;
    }
}
