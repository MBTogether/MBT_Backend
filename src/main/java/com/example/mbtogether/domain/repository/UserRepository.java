package com.example.mbtogether.domain.repository;

import com.example.mbtogether.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
}
