/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import luish.barber.dto.LoginDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author luis
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private JWTUtil jWTUtil;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jWTUtil) {
        this.authenticationManager = authenticationManager;
        this.jWTUtil = jWTUtil;
    }

    //tenta autenticar
    public Authentication attemptAuthentication(HttpServletRequest req,
            HttpServletResponse res) throws AuthenticationException {

        try {
            //pega a requisição e converte para CredenciaisDTO
            LoginDTO creds = new ObjectMapper()
                    .readValue(req.getInputStream(), LoginDTO.class);

            //Instancia UsernamePasswordAuthenticationToken token do Spring security 
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getSenha(), new ArrayList<>());

            //verifica se usuario e senha sao validos pelo framework
            Authentication auth = authenticationManager.authenticate(authToken);
            System.out.println("sjsjjs");
            return auth;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //se autenticacao sucesso gera o token e acrescentar na resposta da requisição
    protected void successfulAuthentication(HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain,
            Authentication auth) throws IOException, ServletException {

        //retorna o usuario do spring e faz casting para UsersSS
        String username = ((UserSS) auth.getPrincipal()).getUsername();
        //gera o token
        String token = jWTUtil.generateToken(username);
        //retorna o token no cabeçalho da requisição
        res.addHeader("Authorization", "Bearer " + token);
     

    }

}
