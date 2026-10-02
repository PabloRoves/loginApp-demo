package com.pabloroves.demos.loginapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pabloroves.demos.loginapp.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}