package com.hgun.sti.components.validator;

import com.hgun.sti.models.Usuario;
import com.hgun.sti.models.errors.UsuarioError;

import java.util.List;

public class UsuarioValidator {
    public static UsuarioError validarUsuario(Usuario usuario, List<Usuario> usuariosAtivos) {

        var usuarioError = new UsuarioError();

        usuarioError.setEndereco(EnderecoValidator.validarEndereco(usuario.getEndereco()));

        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            usuarioError.setNome("O nome não pode ser vazio!");
        }else if(usuario.getNome().length() < 4){
            usuarioError.setNome("O nome do usuário está muito curto! (min: 4 caracteres)");
        }

        if (usuario.getCpf() == null || usuario.getCpf().isEmpty()) {
            usuarioError.setCpf("O CPF não pode ser vazio!");
        }else if(!usuario.getCpf().matches("(^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$)")){
            usuarioError.setCpf("O CPF está inválido!");
        }

        if (usuario.getTelefone() == null || usuario.getTelefone().isEmpty()) {
            usuarioError.setTelefone("O telefone não pode ser vazio!");
        }else if(!usuario.getTelefone().matches("^(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})$")){
            usuarioError.setTelefone("O telefone está inválido!");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            usuarioError.setEmail("O e-mail não pode ser vazio!");
        }else if(!usuario.getEmail().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")){
            usuarioError.setEmail("O e-mail está inválido!");
        }

        if (usuario.getLogin() == null || usuario.getLogin().isEmpty()) {
            usuarioError.setLogin("O login não pode ser vazio!");
        }else if(usuario.getLogin().length() < 4){
            usuarioError.setLogin("O login do usuário está muito curto! (min: 4 caracteres)");
        }else{
            for (Usuario bdUser : usuariosAtivos) {
                if(bdUser.getLogin().equals(usuario.getLogin())){
                    usuarioError.setLogin("O login já existente!");
                    break;
                }
            }
        }

        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            usuarioError.setSenha("A senha não pode ser vazia!");
        }

        if (usuario.getSenhaConfirmada() == null || usuario.getSenhaConfirmada().isEmpty()) {
            usuarioError.setSenhaConfirmada("A senha não pode ser vazia!");
        }else if(!usuario.getSenhaConfirmada().equals(usuario.getSenha())){
            usuarioError.setSenhaConfirmada("As senhas devem ser iguais!");
        }

        return usuarioError;
    }
}
