package com.hgun.sti.components;

import com.hgun.sti.models.Role;
import com.hgun.sti.models.Usuario;
import com.hgun.sti.models.types.TipoCondicaoEspecial;
import com.hgun.sti.models.types.TipoEnvioResposta;
import com.hgun.sti.models.types.TipoSetor;
import com.hgun.sti.repository.RoleRepository;
import com.hgun.sti.repository.UsuarioRepository;
import com.hgun.sti.repository.types.TipoCondicaoEspecialRepository;
import com.hgun.sti.repository.types.TipoEnvioRespostaRepository;
import com.hgun.sti.repository.types.TipoSetorRepository;
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

    @Autowired
    private TipoSetorRepository tipoSetorRepository;

    @Autowired
    private TipoCondicaoEspecialRepository tipoCondicaoEspecialRepository;

    @Autowired
    private TipoEnvioRespostaRepository tipoEnvioRespostaRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        var usuarioSuporte = usuarioRepository.getUsuarioByLogin("sti");
        var roles = roleRepository.findAll();
        var listaTipoSetor = tipoSetorRepository.findAll();
        var listaTipoCondicaoEspecial = tipoCondicaoEspecialRepository.findAll();
        var listaTipoEnvioResposta = tipoEnvioRespostaRepository.findAll();

        if(roles.isEmpty()){

            String[] roleLabes = { "ADMINISTRADOR" , "FUNCIONARIO" };

            for (String i: roleLabes) {
                var newRole =  new Role();

                newRole.setName(i);
                newRole.setAtivo(true);

                roleRepository.save(newRole);
            }

            System.out.println("cadastrei as roles");
        }

        if(usuarioSuporte == null){
            var newUsuario = new Usuario();

            newUsuario.setLogin("sti");
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
        }else{
            usuarioSuporte.setAtivo(true);
            usuarioRepository.save(usuarioSuporte);
        }

        if(listaTipoSetor.isEmpty()){
            String[][] aux = {
                    {"1º ANDAR", ""},
                    {"2º ANDAR", ""},
                    {"2ª SEÇÃO", ""},
                    {"ALMOXARIFADO", ""},
                    {"AMBULATÓRIO", ""},
                    {"CENTRO CIRURGICO", ""},
                    {"CME", "CENTRO DE MATERIAL E ESTERILIZAÇÃO"},
                    {"CONTAS MÉDICAS", ""},
                    {"CONTIGENTE", ""},
                    {"CORPO DA GUARDA", ""},
                    {"BLOCO ADMINISTRATIVO", ""},
                    {"FARMÁCIA", ""},
                    {"FARNÁCIA", "CENTRO CIRURGICO"},
                    {"FARMÁCIA SATÉLITE", ""},
                    {"FISIOTERAPIA", ""},
                    {"FUSEX", ""},
                    {"GARAGEM", "SETOR DE NANUTENÇÃO E TRANSPORTE"},
                    {"LABORATÓRIO DE ANÁLISES CLÍNICAS", ""},
                    {"NUTRIÇÃO", ""},
                    {"ODONTOLOGIA", ""},
                    {"PAD", "PROGRAMA DE ACOMPANHAMENTO DOMICILIAR"},
                    {"PRONTO ATENDIMENTO MÉDICO", ""},
                    {"RADIOLOGIA", ""},
                    {"SEÇÃO DE AUDITORIA DE LISURA", ""},
                    {"SEÇÃO DE INFORMÁTICA", ""},
                    {"SEÇÃO DE PERÍCIAS MÉDICAS", ""},
                    {"SERVIÇO DE APROVISIONAMENTO", ""},
                    {"SETOR DE ENDOSCOPIA", ""},
                    {"UMITI", "UNIDADE MILITAR INTEGRADA DE TERAPIA INTENSIVA"},
                    {"UPRSS", "UNIDADE DE PROCESSAMENTO DE ROUPAS DE SERVIÇOS DE SAÚDE"},
            };

            for (String[] i: aux) {
                var tipoSetor =  new TipoSetor();
                tipoSetor.setNome(i[0]);
                tipoSetor.setDescricao(i[1]);
                tipoSetorRepository.save(tipoSetor);
            }

            System.out.println("cadastrei os tipos de setor");
        }

        if(listaTipoCondicaoEspecial.isEmpty()){

            String[][] aux = {
                    {"DESNUTRIÇÃO", ""},
                    {"ETILISTA", ""},
                    {"GRAVIDEZ", ""},
                    {"LACTAÇÃO", ""},
                    {"MENOPAUSA", ""},
            };

            for (String[] i: aux) {
                var tipoCondicaoEspecial =  new TipoCondicaoEspecial();
                tipoCondicaoEspecial.setNome(i[0]);
                tipoCondicaoEspecial.setDescricao(i[1]);
                tipoCondicaoEspecialRepository.save(tipoCondicaoEspecial);
            }

            System.out.println("cadastrei os tipos de condições especiais");
        }

        if(listaTipoEnvioResposta.isEmpty()){

            String[][] aux = {
                    {"E-MAIL", ""},
                    {"IMPRESSO", ""},
            };

            for (String[] i: aux) {
                var tipoEnvioResposta =  new TipoEnvioResposta();
                tipoEnvioResposta.setNome(i[0]);
                tipoEnvioResposta.setDescricao(i[1]);
                tipoEnvioRespostaRepository.save(tipoEnvioResposta);
            }

            System.out.println("cadastrei os tipos de envio de resposta");
        }


        return;
    }

}