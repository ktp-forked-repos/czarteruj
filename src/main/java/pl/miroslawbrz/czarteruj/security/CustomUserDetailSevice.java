package pl.miroslawbrz.czarteruj.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.miroslawbrz.czarteruj.model.User;
import pl.miroslawbrz.czarteruj.model.UserRole;
import pl.miroslawbrz.czarteruj.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomUserDetailSevice implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailSevice(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);
        if(user == null)
            throw new UsernameNotFoundException("User not found");
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                convertAuthorities(user.getRoles()));
    }

    private Set<GrantedAuthority> convertAuthorities(Set<UserRole> roles) {

        Set<GrantedAuthority> authorities = new HashSet<>();
        for(UserRole ur: roles){
            authorities.add(new SimpleGrantedAuthority(ur.getRole()));
        }

        return authorities;
    }
}
