package com.example.mbtogether.domain.post.service;

import com.example.mbtogether.domain.post.controller.request.PostDto;
import com.example.mbtogether.domain.post.controller.request.UpdateDto;
import com.example.mbtogether.domain.post.controller.response.DetailDto;
import com.example.mbtogether.domain.post.controller.response.ListDto;

import java.util.List;

public interface PostService {
    public void post(PostDto dto);
    public void update(UpdateDto dto);
    public void delete(int id);
    public DetailDto detail(int id);
    public List<ListDto> mbtiList(String mbti);
    public List<ListDto> popularList();
    public List<ListDto> latestList();
    public List<ListDto> search(String searchWord);
}
