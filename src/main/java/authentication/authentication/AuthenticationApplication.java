package authentication.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScan(basePackages = {
    "authentication.configuration",
    "authentication.model",
    "authentication.repository",
    "authentication.service"
})

@EntityScan(basePackages = {"authentication.model"})
@EnableJpaRepositories(basePackages = {"authentication.repository"})
public class AuthenticationApplication 
{

    public static void main(String[] args) 
    {
        SpringApplication.run(AuthenticationApplication.class, args);
    }

}
