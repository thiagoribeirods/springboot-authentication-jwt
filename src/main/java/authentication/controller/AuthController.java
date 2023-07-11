
package authentication.controller;

import authentication.dto.Login;
import authentication.model.User;
import authentication.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thiago-ribeiro
 */

@RestController
public class AuthController 
{
    @Autowired AuthenticationManager authenticationManager;
    
    @Autowired private TokenService tokenService;
    
    @PostMapping("/login")
    public String login(@RequestBody Login login)
    {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
                new UsernamePasswordAuthenticationToken(login.username(), login.password());
        
        Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        
        var user = (User) authentication.getPrincipal();
        
        return tokenService.generateToken(user);
    }
    
}
