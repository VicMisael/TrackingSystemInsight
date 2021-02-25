package com.misael.insight.trackingsystem.service;

import com.misael.insight.trackingsystem.model.Atividade;
import com.misael.insight.trackingsystem.model.Usuario;
import com.misael.insight.trackingsystem.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Set<Atividade> findAtividadesByUsuario(Long id) {
        return usuarioRepository.findById(id).map(Usuario::getAtividades).get();
    }

    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Transactional
    public boolean deleteAtividadesFromUsuarioById(Long id) {
        if (usuarioRepository.findById(id).isPresent()) {
            usuarioRepository.deleteAtividadeById(id);
            return true;
        } else
            return false;
    }

}
