package br.com.fiap.assistentx.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TokenFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        HttpServletResponse res = (HttpServletResponse) response;

        String token = req.getHeader("Authorization");

        // liberar login sem token
        String path = req.getRequestURI();

        if (path.contains("/api/usuario/login")) {
            chain.doFilter(request, response);
            return;
        }

        // validação
        if (token == null ||
                !token.equals("abcdefghijklmnopqrstuvwxyz")) {

            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            res.getWriter().write("Token inválido");

            return;
        }

        // continua request
        chain.doFilter(request, response);
    }
}