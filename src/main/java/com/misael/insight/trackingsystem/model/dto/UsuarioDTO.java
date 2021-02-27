package com.misael.insight.trackingsystem.model.dto;

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
