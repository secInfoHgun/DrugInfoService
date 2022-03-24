package com.hgun.sti.models;

import com.hgun.sti.models.abstracts.AbstractPessoa;
import com.hgun.sti.models.types.TipoEnvioResposta;
import com.hgun.sti.models.types.TipoSetor;
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
@Table(name="solicitante")
public class Solicitante  extends AbstractPessoa {
    private String funcao;

    @OneToOne
    private TipoSetor tipoSetor;

    @OneToOne
    private TipoEnvioResposta tipoEnvioResposta;
}
