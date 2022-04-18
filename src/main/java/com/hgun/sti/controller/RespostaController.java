package com.hgun.sti.controller;

import com.hgun.sti.models.Resposta;
import com.hgun.sti.repository.QuestionamentoRepository;
import com.hgun.sti.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
@RequestMapping("/administrador")
public class RespostaController {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private QuestionamentoRepository questionamentoRepository;

    @GetMapping("/novas")
    public String ocorrenciaslistpagenovas(Model model){

        model.addAttribute("questionamentos", questionamentoRepository.getAllNaoVisualizadas());
        model.addAttribute("titlePage", "Novas Solicitações");
        model.addAttribute("menuValor", 1);


        return "resposta/list-resposta.html";
    }

    @GetMapping("/finalizadas")
    public String ocorrenciaslistpagefinalizadas(Model model){

        model.addAttribute("questionamentos", questionamentoRepository.getAllVisualizadas());
        model.addAttribute("titlePage", "Solicitações Finalizadas");
        model.addAttribute("menuValor", 2);

        return "resposta/list-resposta.html";
    }

    @GetMapping("/view/{id}")
    public String viewQuestionamentoEResposta(@PathVariable("id") Long id, Model model){

        var questionamento = questionamentoRepository.findById(id).get();
        var resposta = new Resposta();
        resposta.setData(new Date());
        resposta.setQuestionamento(questionamento);

        model.addAttribute("resposta", resposta);

        return "resposta/form-resposta.html";
    }

    @PostMapping()
    public String saveResposta(@ModelAttribute Resposta resposta){

        resposta.setAtivo(true);
        respostaRepository.save(resposta);

        return "redirect:/administrador/novas";
    }

}
