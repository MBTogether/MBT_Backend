package com.example.mbtogether.domain.user.service;

import com.example.mbtogether.domain.post.dto.response.PostListResponse;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.post.repository.PostRepository;
import com.example.mbtogether.domain.user.dto.Response.UserResponse;
import com.example.mbtogether.domain.user.dto.Request.UserIntroduceRequest;
import com.example.mbtogether.domain.user.dto.Request.UserNameRequest;
import com.example.mbtogether.domain.user.entity.User;
import com.example.mbtogether.domain.user.repository.UserRepository;
import com.example.mbtogether.global.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public UserResponse userInformation() {
        User user = userRepository.findById(authenticationFacade.getUserId()).get();
        return new UserResponse(user);
    }

    @Override
    public void nameChange(UserNameRequest req) {
        User user = userRepository.findById(authenticationFacade.getUserId()).get();
        user.nameChange(req);
    }

    @Override
    public void introducesChange(UserIntroduceRequest req) {
        User user = userRepository.findById(authenticationFacade.getUserId()).get();
        user.introducesChange(req);
    }

    @Override
    public void delUser() {
        User user = userRepository.findById(authenticationFacade.getUserId()).get();
        userRepository.delete(user);
    }

    @Override
    public List<PostListResponse> myPost() {
        User user = userRepository.findById(authenticationFacade.getUserId()).get();
        int id = user.getId();
        List<Post> posts = postRepository.findAll();
        List<PostListResponse> postListResponse = new ArrayList<>();

        for (Post post : posts) {
            if (user.getId().equals(id)) {
                PostListResponse rep = PostListResponse.builder()
                        .title(post.getTitle())
                        .coverUrl(post.getCoverUrl())
                        .date(post.getDate())
                        .id(post.getId())
                        .build();
                postListResponse.add(rep);
            }
        }
        return postListResponse;
    }

    @Override
    public List<PostListResponse> goodPost() {
        Sort sort = Sort.by(Sort.Direction.ASC, "goods");
        List<Post> posts = postRepository.findAll(sort);
        List<PostListResponse> postListResponse = new ArrayList<>();

        for (Post post : posts) {
            PostListResponse rep = PostListResponse.builder()
                    .title(post.getTitle())
                    .coverUrl(post.getCoverUrl())
                    .date(post.getDate())
                    .id(post.getId())
                    .build();
            postListResponse.add(rep);
        }
        return postListResponse;
    }
}
