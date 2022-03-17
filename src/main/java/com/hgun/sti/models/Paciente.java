package com.hgun.sti.models;

import com.hgun.sti.models.abstracts.AbstractPessoa;
import com.hgun.sti.models.types.TipoCondicaoEspecial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="paciente")
public class Paciente extends AbstractPessoa {

    private String doencas;
    private String alergias;
    private String MedicamentosEmUso;
    private String UnidadeDeInternação;
    private String leito;
    private String admissao;

    @OneToOne
    private TipoCondicaoEspecial tipoCondicaoEspecial;
}
