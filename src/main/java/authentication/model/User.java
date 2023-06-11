
package authentication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 *
 * @author thiago-ribeiro
 */
@Entity(name = "TB_USER")
@Data
public class User 
{
    @Id
    private String username;
    
    private String password;
    
    private String name;
}
