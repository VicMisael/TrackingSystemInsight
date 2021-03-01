package com.misael.insight.trackingsystem.controller;

import com.misael.insight.trackingsystem.model.Atividade;
import com.misael.insight.trackingsystem.model.Usuario;
import com.misael.insight.trackingsystem.service.AtividadeService;
import com.misael.insight.trackingsystem.service.InstituicaoService;
import com.misael.insight.trackingsystem.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("atividades")

@CrossOrigin("*")
public class AtividadeController {

    AtividadeService atividadeService;
    UsuarioService usuarioService;
    InstituicaoService instituicaoService;

    public AtividadeController(UsuarioService usuarioService, AtividadeService atividadeService, InstituicaoService instituicaoService) {
        this.atividadeService = atividadeService;
        this.usuarioService = usuarioService;
        this.instituicaoService = instituicaoService;
    }

    @GetMapping()
    ResponseEntity<List<Atividade>> all() {
        return new ResponseEntity<List<Atividade>>(atividadeService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Atividade> save(@RequestBody Atividade atv) {
        if (atv == null) {
            return new ResponseEntity<Atividade>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Atividade>(atividadeService.save(atv), HttpStatus.OK);
    }

    @GetMapping(value = "usuarios/{id}")
    ResponseEntity<Set<Usuario>> getUsuariosByAtividade(@PathVariable Long id) {
        if (atividadeService.find(id).isPresent()) {
            return new ResponseEntity<Set<Usuario>>(atividadeService.find(id).get().getUsuarios(), HttpStatus.OK);
        }
        return new ResponseEntity<Set<Usuario>>(new HashSet<Usuario>(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "delete/{id}")
    ResponseEntity<Void> deleteAtividadeFromUsuario(@PathVariable Long id) {
        if (usuarioService.deleteAtividadesFromUsuarioById(id)) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }
}
