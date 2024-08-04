package com.metaphorce.cinemagic.jwt;

import com.metaphorce.cinemagic.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component                                   // Para crear filtros perzonalizados, y garantizar que se ejecute solo unav ez por solicitud http
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override      //metodo encargado de realizar todos los filtros relacionados al token
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String token = getTokenFromRequest(request);
        final String username;

        if(token==null){ //si el token es vacio le devolvemos a la cadena de filtros el control
            filterChain.doFilter(request,response);
            return;
        }


        //--------------------------- endpoint protegidos entran aqui
        username = jwtService.getUserNameFromToken(token); //obtener username del token
        if (username != null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if(jwtService.isTokenValid(token, userDetails)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken); //actualización contextholer
            }

        }
        filterChain.doFilter(request,response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader("Authorization"); //propiedad de autenticacio que viene en el encabezado
        if(authHeader != null && authHeader.startsWith("Bearer ")){ //verificamos que sea berear por que es autenticacion vazada en token
            return authHeader.substring(7); //retornamos el token sin incorporar la palabra bearer
        }
        return null;
    }
}

