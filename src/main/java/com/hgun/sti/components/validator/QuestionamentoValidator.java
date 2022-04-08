package com.hgun.sti.components.validator;

import com.hgun.sti.models.Questionamento;
import com.hgun.sti.models.errors.QuestionamentoError;

public class QuestionamentoValidator {
    public static QuestionamentoError validarQuestionamento(Questionamento questionamento){

        var questionamentoError = new QuestionamentoError();


        questionamentoError.setSolicitante(SolicitanteValidator.validarSolicitante(questionamento.getSolicitante()));

        if(questionamento.getPerguntas() == null || questionamento.getPerguntas().isEmpty()){
            questionamentoError.setPerguntas("As perguntas não podem ser vazias!");
        }else if(questionamento.getPerguntas().length() < 15){
            questionamentoError.setPerguntas("As perguntas não pode ser menos que 15 caracteres!");
        }

//        questionamentoError.setPaciente(PacienteValidator.validarPaciente(questionamento.getPaciente()));

        return questionamentoError;
    }
}
