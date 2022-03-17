package com.hgun.sti.models.abstracts;

import com.hgun.sti.models.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractPessoa extends AbstractEntidade {
    String cpf;
    String nome;
    Integer idade;
    Character sexo;
    Double peso;

    String telefone;
    String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    Endereco endereco;
}
