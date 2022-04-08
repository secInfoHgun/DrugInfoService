package com.hgun.sti.components.validator;

import com.hgun.sti.models.errors.PessoaError;

public class PessoaValidator {

    public static PessoaError validarPessoa(
            String cpf, String nome, Integer idade, Double peso, String telefone, String email
    ){

        var pessoaError = new PessoaError();

        if (cpf == null || cpf.isEmpty()) {
            pessoaError.setCpf("O CPF não pode ser vazio!");
        }else if(!cpf.matches("(^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$)")){
            pessoaError.setCpf("O CPF está inválido!");
        }

        if (nome == null || nome.isEmpty()) {
            pessoaError.setNome("O nome não pode ser vazio!");
        }else if(nome.length() < 4){
            pessoaError.setNome("O nome está muito curto! (min: 4 caracteres)");
        }

        if(idade == null || idade < 1){
            pessoaError.setIdade("A idade não pode ser menor que um ano!");
        }

        if(peso == null || peso < 1){
            pessoaError.setPeso("o peso não pode ser menor que um ano!");
        }

        if (telefone == null || telefone.equals("") || telefone.isEmpty()) {
            pessoaError.setTelefone("O telefone não pode ser vazio!");
        }else if(!telefone.matches("^(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})$")){
            pessoaError.setTelefone("O telefone está inválido!");
        }

        if (email == null || email.equals("") || email.isEmpty()) {
            pessoaError.setEmail("O e-mail não pode ser vazio!");
        }else if(!email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")){
            pessoaError.setEmail("O e-mail está inválido!");
        }

        return pessoaError;
    }
}
