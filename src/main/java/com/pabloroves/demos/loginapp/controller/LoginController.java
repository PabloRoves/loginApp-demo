package com.pabloroves.demos.loginapp.controller;

import com.pabloroves.demos.loginapp.model.Usuario;
import com.pabloroves.demos.loginapp.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Mostrar página de login
    @GetMapping("/")
    public String showLoginForm() {
        return "login";
    }

    // Procesar el formulario de login
    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        Optional<Usuario> userOpt = usuarioRepository.findByUsername(username);

        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
            model.addAttribute("usuario", userOpt.get());
            return "welcome";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }
}