package com.misael.insight.trackingsystem.controller;

import com.misael.insight.trackingsystem.model.Instituicao;
import com.misael.insight.trackingsystem.service.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("instituicoes")
@CrossOrigin("*")

public class InstituicaoController {

    InstituicaoService instituicaoService;

    @Autowired
    public InstituicaoController(InstituicaoService instituicaoService) {
        this.instituicaoService = instituicaoService;
    }

    @GetMapping
    ResponseEntity<List<Instituicao>> findAll() {
        List<Instituicao> institucoes=instituicaoService.findAll();
        return new ResponseEntity<List<Instituicao>>(institucoes,institucoes.isEmpty()?HttpStatus.NO_CONTENT:HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Instituicao> getById(@PathVariable Long id) {
        if (instituicaoService.findByid(id).isPresent()) {
            return new ResponseEntity<Instituicao>(instituicaoService.findByid(id).get(), HttpStatus.OK);
        }
            return new ResponseEntity<Instituicao>(new Instituicao(),HttpStatus.BAD_REQUEST);
    }

}
