package com.hgun.sti.models;

import com.hgun.sti.models.abstracts.AbstractEntidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="enderecos")
public class Endereco extends AbstractEntidade {
    private String cep;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
}
