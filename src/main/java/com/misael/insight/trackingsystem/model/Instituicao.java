package com.misael.insight.trackingsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Instituicao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_INSTITUICAO")
    private Long id;

    @Column(name = "NM_INSTITUICAO")
    private String NomeInstituicao;

    @Column(name = "NR_CNPJ")
    private String CNPJ;

    @OneToMany(targetEntity = Atividade.class,mappedBy = "instituicao",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Atividade> atividades;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instituicao that = (Instituicao) o;
        return NomeInstituicao.equals(that.NomeInstituicao) && CNPJ.equals(that.CNPJ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NomeInstituicao, CNPJ);
    }
}
