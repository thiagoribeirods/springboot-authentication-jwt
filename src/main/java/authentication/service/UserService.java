
package authentication.service;

import authentication.model.User;
import authentication.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thiago-ribeiro
 */
@Service
public class UserService 
{
    @Autowired 
    private UserDAO userDAO;
    
    public User save(User user)
    {
        return userDAO.save(user);
    }
}
