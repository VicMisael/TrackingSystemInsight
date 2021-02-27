package com.misael.insight.trackingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JsonBackReference
    private List<Atividade> atividades;
}
