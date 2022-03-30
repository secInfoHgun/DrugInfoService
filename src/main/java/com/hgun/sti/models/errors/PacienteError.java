package com.hgun.sti.models.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PacienteError {

    private String doencas;
    private String alergias;
    private String MedicamentosEmUso;
    private String UnidadeDeInternação;
    private String leito;
    private String admissao;
    private String tipoCondicaoEspecial;
    private PessoaError pessoa;

    public boolean isEmpty(){
        if(doencas != null  && !doencas.isEmpty()){
            return false;
        }else if(alergias != null && !alergias.isEmpty()){
            return false;
        }else if(MedicamentosEmUso != null && !MedicamentosEmUso.isEmpty()){
            return false;
        }else if(UnidadeDeInternação != null && !UnidadeDeInternação.isEmpty()){
            return false;
        }else if(leito != null && !leito.isEmpty()){
            return false;
        }else if(admissao != null && !admissao.isEmpty()){
            return false;
        }else if(tipoCondicaoEspecial != null && !tipoCondicaoEspecial.isEmpty()){
            return false;
        }else if(pessoa != null && !pessoa.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
