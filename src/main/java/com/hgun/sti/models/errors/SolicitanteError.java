package com.hgun.sti.models.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SolicitanteError {

    private String funcao;
    private String tipoSetor;
    private String tipoEnvioResposta;
    private PessoaError pessoa;

    public boolean isEmpty(){
        if(funcao != null  && !funcao.isEmpty()){
            return false;
        }else if(tipoSetor != null && !tipoSetor.isEmpty()){
            return false;
        }else if(tipoEnvioResposta != null && !tipoEnvioResposta.isEmpty()){
            return false;
        }else if(pessoa != null && !pessoa.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
