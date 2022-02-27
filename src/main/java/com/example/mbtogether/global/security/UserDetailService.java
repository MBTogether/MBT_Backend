package com.example.mbtogether.global.security;

import com.example.mbtogether.domain.user.repository.UserRepository;
import com.example.mbtogether.global.security.detail.AuthUserDetail;
import com.example.mbtogether.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = userRepository.findById(Integer.valueOf(id)).orElseThrow(() -> new UsernameNotFoundException(id));
        return new AuthUserDetail(user);
    }

}
