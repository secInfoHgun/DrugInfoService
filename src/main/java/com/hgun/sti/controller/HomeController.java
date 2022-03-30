package com.hgun.sti.controller;

import com.hgun.sti.models.Questionamento;
import com.hgun.sti.models.errors.QuestionamentoError;
import com.hgun.sti.repository.types.TipoCondicaoEspecialRepository;
import com.hgun.sti.repository.types.TipoEnvioRespostaRepository;
import com.hgun.sti.repository.types.TipoSetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private TipoSetorRepository tipoSetorRepository;

    @Autowired
    private TipoCondicaoEspecialRepository tipoCondicaoEspecialRepository;

    @Autowired
    private TipoEnvioRespostaRepository tipoEnvioRespostaRepository;

    @GetMapping
    public String form(Model model){
        if(model.getAttribute("questionamento") == null){
            model.addAttribute("questionamento", new Questionamento());
            model.addAttribute("erros", new QuestionamentoError());
        }

        model.addAttribute("listaTipoSetor", tipoSetorRepository.findAll());
        model.addAttribute("listaTipoCondicaoEspecial", tipoCondicaoEspecialRepository.findAll());
        model.addAttribute("listaTipoEnvioResposta", tipoEnvioRespostaRepository.findAll());

        return "home.html";
    }

}
