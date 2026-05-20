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
        String path = req.getRequestURI();

        // libera login
        if (path.contains("/login")) {
            chain.doFilter(request, response);
            return;
        }

        // valida token
        if (token == null || !token.startsWith("Bearer usuario_")) {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Token inválido");
            return;
        }

        // pega ID do token
        String tokenLimpo = token.replace("Bearer ", "");

        String[] partes = tokenLimpo.split("_");

        Integer usuarioToken = Integer.parseInt(partes[1]);

        // verifica URL /usuario/{id}
        if (path.matches(".*/usuario/\\d+.*")) {
            String[] pathPartes = path.split("/");
            Integer usuarioUrl = Integer.parseInt(pathPartes[3]);

            // compara dono
            if (!usuarioToken.equals(usuarioUrl)) {
                res.setStatus(HttpServletResponse.SC_FORBIDDEN);
                res.getWriter().write("Acesso negado");
                return;
            }
        }

        chain.doFilter(request, response);
    }
}