package com.hgun.sti.models.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RespostaError {

    private String referencias;
    private String resposta;
    private QuestionamentoError questionamento;

    public boolean isEmpty(){
        if(referencias != null  && !referencias.isEmpty()){
            return false;
        }else if(resposta != null && !resposta.isEmpty()){
            return false;
        }else if(questionamento != null && !questionamento.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
