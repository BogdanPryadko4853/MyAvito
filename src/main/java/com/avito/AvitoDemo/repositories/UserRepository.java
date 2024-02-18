package com.avito.AvitoDemo.repositories;

import com.avito.AvitoDemo.module.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
User findByEmail(String email);
}
