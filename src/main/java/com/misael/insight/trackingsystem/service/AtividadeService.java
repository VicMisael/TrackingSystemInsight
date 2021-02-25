package com.misael.insight.trackingsystem.service;

import com.misael.insight.trackingsystem.model.Atividade;
import com.misael.insight.trackingsystem.model.Usuario;
import com.misael.insight.trackingsystem.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AtividadeService {

    private AtividadeRepository atividadeRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    public AtividadeService(AtividadeRepository atividadeRepository){
        this.atividadeRepository=atividadeRepository;
    }

    @Transactional
    public Atividade save(Atividade atividade){
        return atividadeRepository.save(atividade);
    }

    public Optional<Atividade> find(Long id){
       return atividadeRepository.findById(id);
    }

    public List<Atividade> findAll(){
        return (List<Atividade>)atividadeRepository.findAll();
    }

    public Set<Usuario> findAllUsuariosByAtividade(Long id){
        return atividadeRepository.findById(id).map(Atividade::getUsuarios).get();
    }



}
