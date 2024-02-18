package com.avito.AvitoDemo.service;

import com.avito.AvitoDemo.enums.EnumsRole;
import com.avito.AvitoDemo.module.User;
import com.avito.AvitoDemo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) return false;
        user.setActive(true);
        user.getRoles().add(EnumsRole.ROLE_USER);
        log.info("Saving new user with email {}",user.getEmail());
        return true;
    }
}
