package com.hgun.sti.models;

import com.hgun.sti.models.abstracts.AbstractEntidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="respostas")
public class Resposta extends AbstractEntidade {

    private Date data;

    private String referencias;

    private String resposta;

    @OneToOne
    private Questionamento questionamento;
}