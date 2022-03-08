package com.example.mbtogether.domain.comment.service;

import com.example.mbtogether.domain.comment.dto.request.CommentDto;
import com.example.mbtogether.domain.comment.dto.response.CommentList;
import com.example.mbtogether.domain.comment.entity.Comment;
import com.example.mbtogether.domain.comment.entity.CommentLike;
import com.example.mbtogether.domain.comment.repository.CommentLikeRepositroy;
import com.example.mbtogether.domain.comment.repository.CommentRepository;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.post.repository.PostRepository;
import com.example.mbtogether.domain.report.entity.CommentReport;
import com.example.mbtogether.domain.report.repository.ReportRepository;
import com.example.mbtogether.domain.report.request.ReportDto;
import com.example.mbtogether.domain.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentLikeRepositroy commentLikeRepositroy;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final ReportRepository reportRepository;

    @Override
    public void chatGood(@PathVariable int commentId){
        Comment comment = commentRepository.findById(commentId).get();
        User user = new User();
        Optional<CommentLike> byCommentUser = commentLikeRepositroy.findByCommentAndUser(comment,user);

        byCommentUser.ifPresentOrElse(

                // 좋아요가 있을 경우 삭제
                commentLike -> {
                    commentLikeRepositroy.delete(commentLike);
                    comment.discountLike(commentLike);
                },
                // 좋아요가 없을 경우 좋아요 추가
                () ->{
                    CommentLike commentLike = CommentLike.builder().build();

                    commentLike.mappingComment(comment);
                    commentLike.mappingUser(user);
                    comment.updateLikeCount();

                    commentLikeRepositroy.save(commentLike);
                }
        );
    }

    @Override
    public void chatDel(@PathVariable int Id){
        Comment comment = commentRepository.findById(Id).get();
        commentRepository.delete(comment);
    }

    @Override
    public void reportChat(ReportDto reportDto){
        CommentReport commentReport = new CommentReport(reportDto.getCommentId(), reportDto.getContent());
        reportRepository.save(commentReport);
    }

    @Override
    public List<CommentList> chatList(@PathVariable int postId){
        Post post = postRepository.findById(postId).get();
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
        Post post = postRepository.findById(postId).get();
        Comment comment = new Comment(commentDto.getComment(), post.getId());
        commentRepository.save(comment);
    }
}
