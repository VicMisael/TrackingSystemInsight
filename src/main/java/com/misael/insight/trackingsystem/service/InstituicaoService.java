package com.misael.insight.trackingsystem.service;

import com.misael.insight.trackingsystem.model.Instituicao;
import com.misael.insight.trackingsystem.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class InstituicaoService {

    private InstituicaoRepository instituicaoRepository;

    @Autowired
    public InstituicaoService(InstituicaoRepository instituicaoRepository){
        this.instituicaoRepository=instituicaoRepository;
    }

    @Transactional
    public Instituicao save(Instituicao instituicao){
        return instituicaoRepository.save(instituicao);
    }

    public List<Instituicao> findAll(){
        return (List<Instituicao>)instituicaoRepository.findAll();
    }
    public Optional<Instituicao> findByid(Long id){
        return instituicaoRepository.findById(id);
    }

}
