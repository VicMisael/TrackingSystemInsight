package com.misael.insight.trackingsystem.service;


import com.misael.insight.trackingsystem.TrackingsystemApplication;
import com.misael.insight.trackingsystem.model.Atividade;
import com.misael.insight.trackingsystem.model.Usuario;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrackingsystemApplication.class)
public class UsuarioServiceTests {
    @Autowired
    UsuarioService service;

    @BeforeAll
    public void contextLoads() {
        assertThat(service).isNotNull();
    }

    @Test
    public void testInsertUsuario() {

        Usuario usuario = Usuario.builder()
                .email("usuario@usuarios.com")
                .nascimento(new Date())
                .nome("usuario")
                .telefonePcontato("+55 85 988888888").build();
        Usuario saved = service.save(usuario);
        assertThat(saved).isNotNull();
        assertThat(saved).isEqualTo(usuario);
    }

    @Test
    public void testGetAll() {
        List<Usuario> usuarios = service.findAll();
        //Should have at least one inserted above.
        assertTrue(!usuarios.isEmpty());

    }

    @Test
    public void testGetById() {
        Usuario usuario = Usuario.builder()
                .email("usuario2@usuarios.com")
                .nascimento(new Date())
                .nome("usuario2")
                .telefonePcontato("+55 85 988888888").build();
        Usuario saved = service.save(usuario);
        List<Usuario> usuarios = service.findAll();
        //Should have at least one inserted above.
        assertTrue(!usuarios.isEmpty());
        assertThat(service.findById(usuarios.get(0).getId())
                .isPresent())
                .isTrue();
    }

    @Test
    public void testDelete() {
        Usuario usuario = Usuario.builder()
                .email("usuario3@usuarios.com")
                .nascimento(new Date())
                .nome("usuario3")
                .telefonePcontato("+55 85 986888888").build();
        Usuario saved = service.save(usuario);
        List<Usuario> usuarios = service.findAll();
        //Should have at least one inserted above.
        assertTrue(!usuarios.isEmpty());
        Long selected = usuarios.get(0).getId();
        assertThat(service.findById(selected).isPresent()).isTrue();
        service.delete(selected);
        assertThat(service.findById(selected).isPresent()).isFalse();
    }

}
