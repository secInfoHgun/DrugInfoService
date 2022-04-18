package com.hgun.sti.models.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionamentoError {

    private String data;
    private String hora;
    private String resumo;
    private String perguntas;
    private SolicitanteError solicitante;
    private PacienteError paciente;

    public boolean isEmpty(){
        if(data != null  && !data.isEmpty()){
            return false;
        }else if(hora != null && !hora.isEmpty()){
            return false;
        }else if(resumo != null && !resumo.isEmpty()){
            return false;
        }else if(perguntas != null && !perguntas.isEmpty()){
            return false;
        }else if(solicitante != null && !solicitante.isEmpty()){
            return false;
        }else if(paciente != null && !paciente.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
