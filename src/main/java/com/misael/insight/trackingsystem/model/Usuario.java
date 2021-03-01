package com.misael.insight.trackingsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
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
