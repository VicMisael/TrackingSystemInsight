package com.misael.insight.trackingsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;


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

    @OneToMany
    @JoinColumn(name = "CD_ATIVIDADE")
    @JsonIgnore
    private List<Atividade> atividades;
}
