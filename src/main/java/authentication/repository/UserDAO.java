
package authentication.repository;

import authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author thiago-ribeiro
 */
public interface UserDAO extends  JpaRepository<User, String>
{
    
}
