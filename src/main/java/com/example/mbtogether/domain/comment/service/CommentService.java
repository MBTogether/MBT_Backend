package com.example.mbtogether.domain.comment.service;

import com.example.mbtogether.domain.comment.dto.request.CommentDto;
import com.example.mbtogether.domain.comment.dto.response.CommentList;
import com.example.mbtogether.domain.report.request.ReportDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CommentService {
    void chatDel(@PathVariable int id);

    void chatGood(@PathVariable int commentId);

    void reportChat(ReportDto reportDto);

    List<CommentList> chatList(@PathVariable int postId);

    void createChat(@PathVariable int postId, CommentDto commentDto);
}
