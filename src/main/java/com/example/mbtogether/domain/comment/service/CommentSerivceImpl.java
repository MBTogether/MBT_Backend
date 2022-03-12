package com.example.mbtogether.domain.comment.service;

import com.example.mbtogether.domain.comment.dto.request.CommentDto;
import com.example.mbtogether.domain.comment.dto.response.CommentList;
import com.example.mbtogether.domain.comment.entity.Comment;
import com.example.mbtogether.domain.comment.repository.CommentRepository;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.post.repository.PostRepository;
import com.example.mbtogether.domain.report.entity.CommentReport;
import com.example.mbtogether.domain.report.repository.ReportRepository;
import com.example.mbtogether.domain.report.request.ReportDto;
import com.example.mbtogether.global.error.ErrorCode;
import com.example.mbtogether.global.error.Exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentSerivceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final ReportRepository reportRepository;

    @Override
    public void chatDel(@PathVariable int Id){
        Comment comment = commentRepository.findById(Id).orElseThrow(() -> new CustomException(ErrorCode.OTHER_SERVER_NOT_FOUND));
        commentRepository.delete(comment);
    }

    @Override
    public void reportChat(ReportDto reportDto){
        CommentReport commentReport = new CommentReport(reportDto.getCommentId(), reportDto.getContent());
        reportRepository.save(commentReport);
    }

    @Override
    public List<CommentList> chatList(@PathVariable int postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new CustomException(ErrorCode.OTHER_SERVER_NOT_FOUND));
        List<Comment> comments = commentRepository.findAll();
        List<CommentList> commentLists = new ArrayList<>();

        for(Comment comment : comments){
            if(post.getId().equals(postId)){

                CommentList commentList = CommentList.builder()
                        .id(comment.getId())
                        .date(comment.getPost().getDate())
                        .comment(comment.getComment())
                        .userName(comment.getUser().getNickname())
                        .userMbti(comment.getUser().getMbti())
                        .build();
                commentLists.add(commentList);
            }
        }
        return commentLists;
    }

    @Override
    public void createChat(@PathVariable int postId, CommentDto commentDto){
        Post post = postRepository.findById(postId).orElseThrow(() -> new CustomException(ErrorCode.OTHER_SERVER_BAD_REQUEST));
        Comment comment = new Comment(commentDto.getComment(), post.getId());
        commentRepository.save(comment);
    }
}
