package com.misael.insight.trackingsystem.repository;

import com.misael.insight.trackingsystem.model.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
    @Transactional
    @Modifying
    @Query(value = "Delete from usuario_atividade ua where ua.atividade_id = ?1",nativeQuery = true)
    void deleteAtividadeById(Long id);
    //@Query(value= "")


}
