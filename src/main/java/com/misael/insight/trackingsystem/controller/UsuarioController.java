package com.misael.insight.trackingsystem.controller;


import com.misael.insight.trackingsystem.model.Usuario;
import com.misael.insight.trackingsystem.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("usuarios")
@CrossOrigin("*")
public class UsuarioController {

    UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping()
    List<Usuario> all() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Usuario> getUsuario(@PathVariable Long id) {
        if (usuarioService.findById(id).isPresent())
            return new ResponseEntity<Usuario>(usuarioService.findById(id).get(), HttpStatus.OK);
        return new ResponseEntity<Usuario>(new Usuario(), HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario user) {
        return new ResponseEntity<Usuario>(usuarioService.save(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteUsuario(@PathVariable Long id) {
        usuarioService.delete(id);
    }

    @PostMapping(value = "add-atividade-usuario")
    ResponseEntity<Object> addAtividadeToUsuario(@RequestBody Map<String,Long> data) {
        Long idUser=data.get("idUser");
        Long idAtividade=data.get("idAtividade");
        System.out.println(idUser);
        System.out.println(idAtividade);
        return usuarioService.addAtividadeById(idUser, idAtividade) ? new ResponseEntity<Object>(null, HttpStatus.OK) : new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
    }


}
