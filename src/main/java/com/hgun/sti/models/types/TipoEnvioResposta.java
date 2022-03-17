package com.hgun.sti.models.types;

import com.hgun.sti.models.abstracts.AbstractEntidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tipo_envio_resposta")
public class TipoEnvioResposta extends AbstractEntidade {
    private String nome;
    private String descricao;
}
