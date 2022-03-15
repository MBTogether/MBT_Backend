package com.example.mbtogether.domain.post.service;

import com.example.mbtogether.domain.post.controller.request.PostDto;
import com.example.mbtogether.domain.post.controller.request.UpdateDto;
import com.example.mbtogether.domain.post.controller.response.DetailDto;
import com.example.mbtogether.domain.post.controller.response.ListDto;
import com.example.mbtogether.domain.post.entity.Post;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PostService {
    Post post(PostDto dto);
    Post update(UpdateDto dto);
    void delete(int id);
    DetailDto detail(int id);
    List<ListDto> mbtiList(String mbti);
    List<ListDto> popularList();
    List<ListDto> latestList();
    List<ListDto> search(String searchWord);
    String uploadImage(MultipartFile image) throws IOException;
    void uploadImageList(List<MultipartFile> image) throws IOException;
}
