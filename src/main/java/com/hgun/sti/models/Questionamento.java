package com.hgun.sti.models;

import com.hgun.sti.models.abstracts.AbstractEntidade;
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
@Table(name="questionamento")
public class Questionamento extends AbstractEntidade {

    private String data;

    private String hora;

    @OneToOne
    private Solicitante solicitante;

    private String perguntas;

    @OneToOne
    private Paciente paciente;


}
