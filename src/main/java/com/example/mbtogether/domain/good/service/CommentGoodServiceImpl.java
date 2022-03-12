package com.example.mbtogether.domain.good.service;

import com.example.mbtogether.domain.comment.entity.Comment;
import com.example.mbtogether.domain.comment.repository.CommentRepository;
import com.example.mbtogether.domain.good.entity.Good;
import com.example.mbtogether.domain.good.entity.GoodId;
import com.example.mbtogether.domain.good.repository.GoodRepository;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.post.repository.PostRepository;
import com.example.mbtogether.domain.user.entity.User;
import com.example.mbtogether.domain.user.repository.UserRepository;
import com.example.mbtogether.global.error.ErrorCode;
import com.example.mbtogether.global.error.Exception.CustomException;
import com.example.mbtogether.global.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentGoodServiceImpl implements CommentGoodService{

    private final PostRepository postRepository;
    private final GoodRepository goodRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public void insertGood(int commentId) {
        Post post = postRepository.findById(commentId).orElseThrow(() -> new CustomException(ErrorCode.OTHER_SERVER_NOT_FOUND));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new CustomException(ErrorCode.OTHER_SERVER_NOT_FOUND));
        User user = userRepository.findById(authenticationFacade.getUserId()).orElseThrow(() -> new CustomException(ErrorCode.OTHER_SERVER_NOT_FOUND));

        Good good = new Good(post, user);

        if (goodRepository.findByCommentAndUser(comment, user).isEmpty()) {
            goodRepository.save(good);
        } else {
            throw new RuntimeException("error");
        }
    }

    @Override
    public void deleteGood(String commentId, int userId) {
        String userid = Integer.toString(userId);
        GoodId id = new GoodId(commentId, userid);
        Good good = goodRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.OTHER_SERVER_NOT_FOUND));
        goodRepository.delete(good);
    }
}
