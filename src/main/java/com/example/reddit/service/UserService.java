package com.example.reddit.service;

import com.example.reddit.domain.MyUser;
import com.example.reddit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final RoleService roleService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserService(RoleService roleService, UserRepository userRepository) {
        this.roleService = roleService;
        this.userRepository = userRepository;
        encoder = new BCryptPasswordEncoder();
    }

    public MyUser register(MyUser user) {
        String secret = "{bcrypt}" + encoder.encode(user.getPassword());
        user.setEnabled(false);
        user.setPassword(secret);
        user.setConfirmPassword(secret);
        user.addRole(roleService.findByName("ROLE_USER"));
//        user.setActivationCode(UUID.randomUUID().toString());
        save(user);
        sendActivationEmail(user);
        return user;
    }
    public void save(MyUser user){
        userRepository.save(user);
    }
    @Transactional
    public void saveUsers(MyUser... users){
        for(MyUser user : users){
            logger.info("saving user: "+user.getEmail());
            userRepository.save(user);
        }
    }


    private void sendActivationEmail(MyUser user) {

    }
}
