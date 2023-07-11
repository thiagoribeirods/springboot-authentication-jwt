
package authentication.service;

import authentication.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author thiago-ribeiro
 */
@Service
public class TokenService 
{
    
    @Value("${jwt.secret.key}")
    private String jwtSecret;
    
    public String generateToken(User user)
    {
        return JWT.create()
                .withIssuer("Authentication")
                .withSubject(user.getUsername())
                .withClaim("username", user.getUsername())
                .withExpiresAt(
                    LocalDateTime
                    .now()
                    .plusMinutes(10)
                    .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256(jwtSecret));   
    }
    
    public String getSubject(String token)
    {
        return JWT.require(Algorithm.HMAC256(jwtSecret))
                .withIssuer("Authentication")
                .build().verify(token).getSubject();
    }
    
}
