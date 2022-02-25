package com.example.mbtogether.global.security;

import com.example.mbtogether.domain.repository.UserRepository;
import com.example.mbtogether.global.security.detail.AuthUserDetail;
import com.example.mbtogether.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

            User user = userRepository.findById(id).get();

            Optional<User> opt = Optional.ofNullable(user);

            opt.orElseThrow(() -> {throw new UsernameNotFoundException(id);});

             return new AuthUserDetail(user);

        //Optional<User> opt = Optional.ofNullable(userRepository.findById(id).get());
    }
}
