
package authentication.service;

import authentication.model.User;
import authentication.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author thiago-ribeiro
 */
@Service
public class UserService implements UserDetailsService
{
    @Autowired 
    protected UserDAO userDAO;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return this.userDAO.findById(username).orElse(null);
    }
    
    public User save(User user)
    {
        return userDAO.save(user);
    }
    
    public User findByUsername(String username)
    {
        return this.userDAO.findById(username).orElse(null);
    }
}
