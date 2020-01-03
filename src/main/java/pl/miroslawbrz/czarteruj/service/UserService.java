package pl.miroslawbrz.czarteruj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.miroslawbrz.czarteruj.model.CharterPlace;
import pl.miroslawbrz.czarteruj.model.User;
import pl.miroslawbrz.czarteruj.model.UserRole;
import pl.miroslawbrz.czarteruj.repository.UserRepository;
import pl.miroslawbrz.czarteruj.repository.UserRoleRepository;
import pl.miroslawbrz.czarteruj.utils.UserUtilities;

@Service
public class UserService {


    private static final String DEFAULT_ROLE = "ROLE_USER";
    private UserRepository userRepository;
    private UserRoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User findUserByHash(int hash){
        return userRepository.findByHash(hash);
    }

    public void addWithDefaultRole(User user) {
        UserRole defaultRole = roleRepository.findByRole(DEFAULT_ROLE);
        user.getRoles().add(defaultRole);
        String passwordHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        userRepository.save(user);
    }
    public boolean isActivated(){
        User user = findUserByEmail(UserUtilities.getLoggedUser());
        return user.isActive();
    }




}

