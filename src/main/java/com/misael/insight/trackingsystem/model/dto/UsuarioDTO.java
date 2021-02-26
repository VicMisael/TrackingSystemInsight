package com.misael.insight.trackingsystem.model.dto;

import com.misael.insight.trackingsystem.model.Atividade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDTO {

    private Long id;

    private String nome;

    private String email;

    private String telefonePcontato;
    private Date nascimento;


    private Set<AtividadeDTO> atividades=new HashSet<>();
}
