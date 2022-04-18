package com.hgun.sti.controller;

import com.hgun.sti.models.Questionamento;
import com.hgun.sti.models.errors.QuestionamentoError;
import com.hgun.sti.repository.PacienteRepository;
import com.hgun.sti.repository.QuestionamentoRepository;
import com.hgun.sti.repository.SolicitanteRepository;
import com.hgun.sti.repository.types.TipoCondicaoEspecialRepository;
import com.hgun.sti.repository.types.TipoEnvioRespostaRepository;
import com.hgun.sti.repository.types.TipoSetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;


@Controller
@PreAuthorize("permitAll()")
@RequestMapping("/")
public class HomeController {

    @Autowired
    private TipoSetorRepository tipoSetorRepository;

    @Autowired
    private TipoCondicaoEspecialRepository tipoCondicaoEspecialRepository;

    @Autowired
    private TipoEnvioRespostaRepository tipoEnvioRespostaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @Autowired
    private QuestionamentoRepository questionamentoRepository;

    @GetMapping
    public String form(Model model){
        if(model.getAttribute("questionamento") == null){
            model.addAttribute("questionamento", new Questionamento());
            model.addAttribute("erros", new QuestionamentoError());
        }

        if(model.getAttribute("cadastrou") == null){
            model.addAttribute("cadastrou", false);
        }

        model.addAttribute("listaTipoSetor", tipoSetorRepository.findAll());
        model.addAttribute("listaTipoCondicaoEspecial", tipoCondicaoEspecialRepository.findAll());
        model.addAttribute("listaTipoEnvioResposta", tipoEnvioRespostaRepository.findAll());

        return "home.html";
    }

    @PostMapping
    public String cadastro(@ModelAttribute Questionamento questionamento, RedirectAttributes redirectAttributes){

        var paciente = pacienteRepository.save(questionamento.getPaciente());
        var solicitante = solicitanteRepository.save(questionamento.getSolicitante());

        questionamento.setPaciente(paciente);
        questionamento.setSolicitante(solicitante);
        questionamento.setData(new Date());
        questionamento.setVisualizada(false);
        questionamento.setAtivo(true);
        questionamentoRepository.save(questionamento);

        redirectAttributes.addFlashAttribute("cadastrou", true);

        return "redirect:/";
    }

}
