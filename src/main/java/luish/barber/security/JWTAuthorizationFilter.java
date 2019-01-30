/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 *
 * @author luis
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private JWTUtil jwtUtil;
    private UserDetailsService userDetailService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserDetailsService userDetailService) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
        this.userDetailService = userDetailService;
    }

    //intercepta a requisição e ve se o usuario está autorizado
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        //pega cabeçalho Authorization e guarda na string
        String header = request.getHeader("Authorization");

        //se header enviado e valor do header comça com Bearer e contem o espaço
        if (header != null && header.startsWith("Bearer ")) {
            //vou mandar o token e retorno um objeto do spring se token valido
            UsernamePasswordAuthenticationToken auth = getAuthentication(header.substring(7));
            // se token diferente de null
            if (auth != null) {
                //função que libera ascesso no filtro, libera a autorização do usuario que tenta ascessar o endpoint
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        //filtro pode continuar a execução com a requisição
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        if (jwtUtil.tokenValido(token)) {
            //pegar o USERName dentro do token
            String username = jwtUtil.getUsername(token);
            //buscr usuario
            UserDetails user = userDetailService.loadUserByUsername(username);
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

        }
        return null;
    }

}
