package com.example.reddit.service;

import com.example.reddit.domain.MyUser;
import com.example.reddit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final RoleService roleService;
    private final UserRepository userRepository;

    public UserService(RoleService roleService, UserRepository userRepository) {
        this.roleService = roleService;
        this.userRepository = userRepository;
    }

    public MyUser register(MyUser user) {
        return user;
    }
    public MyUser save(MyUser user){
        return userRepository.save(user);
    }
    @Transactional
    public void saveUsers(MyUser... users){
        for(MyUser user : users){
            logger.info("saving user: "+user.getEmail());
            userRepository.save(user);
        }
    }
}
