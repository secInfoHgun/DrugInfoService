package com.hgun.sti.components;

import com.hgun.sti.models.Role;
import com.hgun.sti.models.Usuario;
import com.hgun.sti.repository.RoleRepository;
import com.hgun.sti.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        var roles = roleRepository.findAll();

        String[] roleLabes = { "ADMINISTRADOR" , "FUNCIONARIO" };

        if(roles.isEmpty()){

            for (String i: roleLabes) {
                var newRole =  new Role();

                newRole.setName(i);
                newRole.setAtivo(true);

                roleRepository.save(newRole);
            }

            System.out.println("cadastrei as roles");
        }

        var usuarioSuporte = usuarioRepository.getUsuarioByLogin("suporte");

        if(usuarioSuporte == null){
            var newUsuario = new Usuario();

            newUsuario.setLogin("suporte");
            newUsuario.setSenha("$2a$12$G.N9JLCHVwMWreV9sIPI.eH4yTQtHw7VjQKyvmgzzWOpoUegXwmfu");
            newUsuario.setAtivo(true);

            newUsuario.setRoles(
                    Set.copyOf(
                            Arrays.asList(
                                    roleRepository.findByName("ADMINISTRADOR")
                            )
                    )
            );

            usuarioRepository.save(newUsuario);

            System.out.println("cadastrei o usuario de suporte");
        }

        return;
    }

}