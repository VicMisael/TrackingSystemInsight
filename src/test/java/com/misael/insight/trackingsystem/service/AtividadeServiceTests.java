package com.misael.insight.trackingsystem.service;


import com.misael.insight.trackingsystem.TrackingsystemApplication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrackingsystemApplication.class)
public class AtividadeServiceTests {

    @Autowired
    AtividadeService service;

    @BeforeAll
    public void contextLoads() {
        assertThat(service).isNotNull();
    }


}
