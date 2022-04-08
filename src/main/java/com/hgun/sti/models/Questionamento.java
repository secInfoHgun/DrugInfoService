package com.hgun.sti.models;

import com.hgun.sti.models.abstracts.AbstractEntidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="questionamento")
public class Questionamento extends AbstractEntidade {

    private Date data;

    @NotNull
    public Boolean visualizada;

    @OneToOne
    private Solicitante solicitante;

    private String perguntas;

    @OneToOne
    private Paciente paciente;


}
