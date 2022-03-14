package com.hgun.sti.controller;

import com.hgun.sti.models.Usuario;
import com.hgun.sti.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AllRestController {

    @Autowired
    public UsuarioRepository usuarioRepository;


    @RequestMapping(value = "/getExemplo", method = RequestMethod.GET)
    public List<Usuario> getExemplo() {
        var usuarios = usuarioRepository.findAllAtivo();
        return usuarios;
    }

}
