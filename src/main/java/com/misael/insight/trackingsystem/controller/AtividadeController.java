package com.misael.insight.trackingsystem.controller;

import com.misael.insight.trackingsystem.model.Atividade;
import com.misael.insight.trackingsystem.service.AtividadeService;
import com.misael.insight.trackingsystem.service.InstituicaoService;
import com.misael.insight.trackingsystem.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("atividades")

@CrossOrigin("*")
public class AtividadeController {

    AtividadeService atividadeService;
    UsuarioService usuarioService;
    InstituicaoService instituicaoService;
    public AtividadeController(UsuarioService usuarioService, AtividadeService atividadeService, InstituicaoService instituicaoService){
        this.atividadeService=atividadeService;
        this.usuarioService=usuarioService;
        this.instituicaoService=instituicaoService;
    }

    @GetMapping()
    ResponseEntity<List<Atividade>> all(){
        return new ResponseEntity<List<Atividade>>(atividadeService.findAll(),HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Atividade> save(@RequestBody Atividade atv){
       if(instituicaoService.findByid(atv.getInstituicao().getId()).isPresent()){
            return new ResponseEntity<Atividade>(atividadeService.save(atv),HttpStatus.OK);
       }
        return new ResponseEntity<Atividade>(new Atividade(),HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping()
    void deleteAtividadeFromUsuario(@RequestParam Long id) {

        usuarioService.deleteAtividadesFromUsuarioById(id);
    }
}
