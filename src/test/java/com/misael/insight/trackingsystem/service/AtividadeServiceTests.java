package com.misael.insight.trackingsystem.service;


import com.misael.insight.trackingsystem.TrackingsystemApplication;
import com.misael.insight.trackingsystem.model.Atividade;
import com.misael.insight.trackingsystem.model.Instituicao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.misael.insight.trackingsystem.model.Usuario;
import org.hibernate.TransientObjectException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrackingsystemApplication.class)
public class AtividadeServiceTests {

    @Autowired
    AtividadeService atividadeService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    InstituicaoService instituicaoService;

    @BeforeAll
    public void contextLoads() {
        assertThat(atividadeService).isNotNull();
        assertThat(usuarioService).isNotNull();
        assertThat(instituicaoService).isNotNull();
    }

    @Test
    public void testInsertAtividade() throws Exception {
        Atividade atividade = Atividade
                .builder()
                .horas(64)
                .nomeAtividade("Curso A")
                .descricao("Descricao")
                .build();
        Atividade saved = atividadeService.save(atividade);
        Instituicao savedInstituicao = instituicaoService
                .save(Instituicao.builder()
                        .NomeInstituicao("Instituicao2")
                        .CNPJ("32345678")
                        .build());

        Atividade atividade2 = Atividade.builder()
                .instituicao(savedInstituicao)
                .horas(64)
                .nomeAtividade("Curso A")
                .descricao("Descricao")
                .build();
        atividadeService.save(atividade2);

    }


    @Test
    public void testGetUsuarioAtividade() throws Exception {
        Usuario usuario = Usuario.builder()
                .email("usuario@usuarios.com")
                .nascimento(new Date())
                .nome("usuario")
                .telefonePcontato("+55 85 988888888").build();
        Usuario saved = usuarioService.save(usuario);
        assertThat(saved).isNotNull();
        assertThat(saved).isEqualTo(usuario);


        Atividade atividade = Atividade
                .builder()
                .horas(64)
                .nomeAtividade("Curso A")
                .descricao("Descricao")
                .build();
        Atividade savedAtividade = atividadeService.save(atividade);


        assertTrue(usuarioService.addAtividadeById(saved.getId(), savedAtividade.getId()));
    }

    @Test
    public void testInsertUserWithoutExist() {
        assertThrows(org.springframework.dao.InvalidDataAccessApiUsageException.class, () -> {
            Set<Usuario> usuariosSet = new HashSet<>();
            usuariosSet.add(Usuario.builder().nome("usuario").email("email@email").nascimento(new Date()).build());
            Atividade atividade3 = Atividade.builder()
                    .usuarios(usuariosSet)
                    .horas(64)
                    .nomeAtividade("Curso A")
                    .descricao("Descricao")
                    .build();
            atividadeService.save(atividade3);
        });
    }

}
