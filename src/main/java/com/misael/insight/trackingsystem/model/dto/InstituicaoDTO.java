package com.misael.insight.trackingsystem.model.dto;

import com.misael.insight.trackingsystem.model.Atividade;
import com.misael.insight.trackingsystem.model.Instituicao;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class InstituicaoDTO {
    private Long id;

    private String nomeInstituicao;

    private String CNPJ;

    public InstituicaoDTO(Instituicao instituicao){
        this.id=instituicao.getId();
        this.nomeInstituicao=instituicao.getNomeInstituicao();
        this.CNPJ=instituicao.getCNPJ();
    }
//    public InstituicaoDTO ObjectToDto(Instituicao instituicao){
//        InstituicaoDTO instituicaoDTO=new InstituicaoDTO();
//        instituicaoDTO.setId(instituicaoDTO.getId());
//        instituicaoDTO.setNomeInstituicao(instituicao.getNomeInstituicao());
//        instituicaoDTO.setCNPJ(instituicao.getCNPJ());
//        return instituicaoDTO;
//
//    }
    public Instituicao getInstituicao(){
        return new Instituicao(id,nomeInstituicao,CNPJ,new ArrayList<Atividade>());
    }


}
