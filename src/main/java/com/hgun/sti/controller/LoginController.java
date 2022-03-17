package com.hgun.sti.controller;


import com.hgun.sti.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    public UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String login(HttpServletRequest request){

        if (request.getUserPrincipal() != null) {
            return "redirect:/dashboard";
        }

        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }
}
