
package authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thiago-ribeiro
 */
@RestController
public class IndexController
{
    @GetMapping("/")
    public String index()
    {
        return "Hello from your rest api";
    }
}
