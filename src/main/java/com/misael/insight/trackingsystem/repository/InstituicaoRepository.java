package com.misael.insight.trackingsystem.repository;

import com.misael.insight.trackingsystem.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoRepository extends CrudRepository<Instituicao,Long> {
}
