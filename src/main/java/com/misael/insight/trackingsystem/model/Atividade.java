package com.misael.insight.trackingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_ATIVIDADE")
    private Long id;

    @Column(name = "NM_ATIVIDADE")
    private String nomeAtividade;

    @Column(name = "NR_HORAS")
    private Integer horas;

    @Column(name="DS_ATIVIDADE")
    private String descricao;

    @ManyToMany
    @JsonIgnore
    private Set<Usuario> usuarios=new HashSet<>();

    @ManyToOne()
    @JoinColumn(name="instituicao_id")
    private Instituicao instituicao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade atividade = (Atividade) o;
        return Objects.equals(nomeAtividade, atividade.nomeAtividade) && Objects.equals(horas, atividade.horas) && Objects.equals(descricao, atividade.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeAtividade, horas, descricao);
    }
}
