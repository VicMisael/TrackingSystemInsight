package com.misael.insight.trackingsystem.model.dto;

import com.misael.insight.trackingsystem.model.Atividade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtividadeDTO {

    private Long id;


    private String nomeAtividade;


    private Integer horas;


    private String descricao;


    private InstituicaoDTO InstituicaoDTO;

    public AtividadeDTO ObjectToDTO(Atividade atividade){
        AtividadeDTO atividadeDto=new AtividadeDTO();
        atividadeDto.setId(atividade.getId());
        atividadeDto.setNomeAtividade(atividade.getNomeAtividade());
        atividadeDto.setHoras(atividade.getHoras());
        atividadeDto.setDescricao(atividade.getDescricao());
        atividadeDto.setInstituicaoDTO(new InstituicaoDTO(atividade.getInstituicao()));
        return atividadeDto;

    }
    public Atividade getAtividade(){
        return new Atividade();
    }
}
