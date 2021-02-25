package com.misael.insight.trackingsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

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

    @ManyToMany(mappedBy = "atividades")
    private Set<Usuario> usuarios=new HashSet<>();

    @ManyToOne
    private Instituicao instituicao;


}
