package com.misael.insight.trackingsystem.repository;

import com.misael.insight.trackingsystem.model.Atividade;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AtividadeRepository extends CrudRepository<Atividade,Long> {


}
