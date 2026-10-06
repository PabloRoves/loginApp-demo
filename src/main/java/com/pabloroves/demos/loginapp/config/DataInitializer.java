package com.pabloroves.demos.loginapp.config;

import com.pabloroves.demos.loginapp.model.Usuario;
import com.pabloroves.demos.loginapp.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepository.count() == 0) {
            Usuario demoUser = new Usuario("pablo", passwordEncoder.encode("123456"), "Pablo Roves");
            usuarioRepository.save(demoUser);
            System.out.println(">>> Usuario de prueba creado: pablo / 123456");
        }
    }
}