package com.example.mbtogether.domain.commentgood.service;

import com.example.mbtogether.domain.comment.entity.Comment;
import com.example.mbtogether.domain.comment.repository.CommentRepository;
import com.example.mbtogether.domain.commentgood.entity.CommentGood;
import com.example.mbtogether.domain.commentgood.entity.CommentGoodId;
import com.example.mbtogether.domain.commentgood.repository.CommentGoodRepository;
import com.example.mbtogether.domain.user.entity.User;
import com.example.mbtogether.domain.user.repository.UserRepository;
import com.example.mbtogether.global.error.ErrorCode;
import com.example.mbtogether.global.error.exception.CustomException;
import com.example.mbtogether.global.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentGoodServiceImpl implements CommentGoodService{

    private final CommentGoodRepository commentGoodRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public void insertGood(int commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new CustomException(ErrorCode.OTHER_SERVER_NOT_FOUND));
        User user = userRepository.findById(authenticationFacade.getUserId()).orElseThrow(() -> new CustomException(ErrorCode.OTHER_SERVER_NOT_FOUND));

        CommentGood commentGood = new CommentGood(comment, user);

        if (commentGoodRepository.findByCommentAndUser(comment, user).isEmpty()) {
            commentGoodRepository.save(commentGood);
        } else {
            throw new RuntimeException("error");
        }
    }

    @Override
    public void deleteGood(String commentId, int userId) {
        String userid = Integer.toString(userId);
        CommentGoodId id = new CommentGoodId(commentId, userid);
        CommentGood commentGood = commentGoodRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.OTHER_SERVER_NOT_FOUND));
        commentGoodRepository.delete(commentGood);
    }
}
