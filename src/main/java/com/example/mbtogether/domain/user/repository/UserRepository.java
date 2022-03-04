package com.example.mbtogether.domain.user.repository;

import com.example.mbtogether.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
}
