package com.hgun.sti.components;

import com.hgun.sti.models.Usuario;
import com.hgun.sti.repository.UsuarioRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class GetCookie {

    public Cookie getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals( cookieName ))
                    return cookie;
            }
        }
        return null;
    }

    public Usuario getCookieUsuario(UsuarioRepository usuarioRepository, HttpServletRequest request){
        var cookie = getCookie(request, "userId");
        var userId =  Long.parseLong(cookie.getValue());

        var usuario = usuarioRepository.findById(userId).get();

       return usuario;
    }
}
