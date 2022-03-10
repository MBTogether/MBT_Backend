package com.example.mbtogether.domain.comment.controller;

import com.example.mbtogether.domain.comment.dto.request.CommentDto;
import com.example.mbtogether.domain.comment.dto.response.CommentList;
import com.example.mbtogether.domain.comment.service.CommentService;
import com.example.mbtogether.domain.report.request.ReportDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @DeleteMapping("/{id}")
    public void charDel(@PathVariable int id){
        commentService.chatDel(id);
    }

    @PostMapping("/reports")
    public void reportChat(ReportDto reportDto){
        commentService.reportChat(reportDto);
    }

    @PostMapping("/{postId}")
    public void createChat(@PathVariable int postId, CommentDto commentDto){
        commentService.createChat(postId,commentDto);
    }

    @PostMapping("/likes/{commentId}")
    public void chatLike(@PathVariable int commentId){
        commentService.chatGood(commentId);
    }

    @DeleteMapping("/likes/{commentId}")
    public void chatUnLike(@PathVariable int commentId) {
        commentService.chatGood(commentId);
    }

    @GetMapping("chat-list/{postId}")
    public List<CommentList> chatList(@PathVariable int postId){
        return commentService.chatList(postId);
    }
}
