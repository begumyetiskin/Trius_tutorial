package trius.springframework.security;


import trius.springframework.domain.User;
import trius.springframework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Primary
@Service
public class ApplicationUserDetailsService extends User implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalApplicationUser = userRepository.findById(s);
        if(optionalApplicationUser.isPresent()) {
            return new ApplicationUser(optionalApplicationUser.get().getEmail(),optionalApplicationUser.get().getPassword());
        } else
            return null;
    }
}
