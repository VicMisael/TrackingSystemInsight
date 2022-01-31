package com.misael.insight.trackingsystem.service;

import com.misael.insight.trackingsystem.TrackingsystemApplication;
import com.misael.insight.trackingsystem.model.Instituicao;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrackingsystemApplication.class)
public class InstituicaoServiceTests {
    @Autowired
    InstituicaoService service;

    @BeforeAll
    public void contextLoads() {
        assertThat(service).isNotNull();
    }

    @Test
    public void testInsertInstituicao(){
        Instituicao instituicao = Instituicao.builder()
                .NomeInstituicao("Instituicao")
                .CNPJ("12345678")
                .build();
        Instituicao saved = service.save(instituicao);
        assertThat(saved)
                .isNotNull()
                .isEqualTo(instituicao);
    }

    @Test
    public void testFindById(){
        Instituicao instituicao = Instituicao.builder()
                .NomeInstituicao("Instituicao2")
                .CNPJ("32345678")
                .build();
        Instituicao saved = service.save(instituicao);
        assertThat(service.findByid(saved.getId()))
                .isNotNull()
                .isEqualTo(instituicao);
    }
    @Test
    public void testFindAll(){
        Instituicao instituicao = Instituicao.builder()
                .NomeInstituicao("Instituicao2")
                .CNPJ("32345678")
                .build();
        service.save(instituicao);
        assertThat(service.findAll())
                .isNotNull()
                .containsAnyOf(instituicao);
    }

}
