package com.misael.insight.trackingsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CD_USUARIO")
    private Long id;

    @Column(name="NM_NOME")
    private String nome;

    @Column(name="NM_EMAIL")
    private String email;

    @Column(name="NR_TELEFONE")
    private String telefonePcontato;

    @Temporal(TemporalType.TIMESTAMP)
    private Date nascimento;

    @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="Usuario_atividade",joinColumns = @JoinColumn(name="usuario_id"),inverseJoinColumns = @JoinColumn(name="atividade_id"))
    private Set<Atividade> atividades=new HashSet<>();



}
