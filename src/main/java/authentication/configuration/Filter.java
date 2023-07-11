
package authentication.configuration;

import authentication.service.TokenService;
import authentication.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author thiago-ribeiro
 */
@Component
public class Filter extends OncePerRequestFilter
{

    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private UserService userService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
            HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        
        String token;
        
        var authorization = request.getHeader("Authorization");
        
        if(authorization != null)
        {
            token = authorization.replace("Bearer", "");
            
            var subject = this.tokenService.getSubject(token);
            
            var user = this.userService.findByUsername(subject); //pegar o usuario
            
            var auth = new UsernamePasswordAuthenticationToken(
                    user,null,
                    user.getAuthorities()
            );
            
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        
        filterChain.doFilter(request, response);
    }
    
}
