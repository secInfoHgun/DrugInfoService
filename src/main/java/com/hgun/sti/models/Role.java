package com.hgun.sti.models;

import com.hgun.sti.models.abstracts.AbstractEntidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AbstractEntidade {
    private String name;
}
