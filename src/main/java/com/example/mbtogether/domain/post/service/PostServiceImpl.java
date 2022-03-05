package com.example.mbtogether.domain.post.service;

import com.example.mbtogether.domain.post.controller.request.PostDto;
import com.example.mbtogether.domain.post.controller.request.UpdateDto;
import com.example.mbtogether.domain.post.controller.response.DetailDto;
import com.example.mbtogether.domain.post.controller.response.ListDto;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.post.repository.PostRepository;
import com.example.mbtogether.global.error.ErrorCode;
import com.example.mbtogether.global.error.Exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public void post(PostDto dto) {
        Post post = new Post(dto.getTitle(), dto.getContent(), dto.getCoverUrl());
        postRepository.save(post);
    }

    @Override
    public void update(UpdateDto dto) {
        Post post = postRepository.findById(dto.getId()).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND, ErrorCode.NOT_FOUND.getMessage()));
        post.update(dto.getTitle(), dto.getContent(), dto.getCoverUrl());
    }

    @Override
    public void delete(int id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND, ErrorCode.NOT_FOUND.getMessage()));
        postRepository.delete(post);
    }

    @Override
    public DetailDto detail(int id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND, ErrorCode.NOT_FOUND.getMessage()));
        return new DetailDto(post);
    }

    @Override
    public List<ListDto> mbtiList(String mbti) {
        List<Post> posts = postRepository.findAll();
        List<ListDto> mbtiListDto = new ArrayList<>();

        for(Post post : posts){
            if(post.getUser().getMbti().equals(mbti)) {
                ListDto dto = ListDto.builder()
                        .title(post.getTitle())
                        .coverUrl(post.getCoverUrl())
                        .date(post.getDate())
                        .id(post.getId())
                        .build();

                mbtiListDto.add(dto);
            }
        }
        return mbtiListDto;
    }

    @Override
    public List<ListDto> popularList() {
        Sort sort = Sort.by(Sort.Direction.ASC, "goods");
        List<Post> posts = postRepository.findAll(sort);
        List<ListDto> popularListDto = new ArrayList<>();

        for(Post post : posts){
            ListDto dto = ListDto.builder()
                    .title(post.getTitle())
                    .coverUrl(post.getCoverUrl())
                    .date(post.getDate())
                    .id(post.getId())
                    .build();
            popularListDto.add(dto);
        }
        return popularListDto;
    }

    @Override
    public List<ListDto> latestList() {
        Sort sort = Sort.by(Sort.Direction.ASC, "date");
        List<Post> posts = postRepository.findAll(sort);
        List<ListDto> latestListDto = new ArrayList<>();

        for(Post post : posts){
            ListDto dto = ListDto.builder()
                    .title(post.getTitle())
                    .coverUrl(post.getCoverUrl())
                    .date(post.getDate())
                    .id(post.getId())
                    .build();
            latestListDto.add(dto);
        }
        return latestListDto;
    }

    @Override
    public List<ListDto> search(String searchWord) {
        List<Post> posts = postRepository.findAll();
        List<ListDto> mbtiListDto = new ArrayList<>();

        for(Post post : posts){
            if(post.getTitle().equals(searchWord)) {
                ListDto dto = ListDto.builder()
                        .title(post.getTitle())
                        .coverUrl(post.getCoverUrl())
                        .date(post.getDate())
                        .id(post.getId())
                        .build();

                mbtiListDto.add(dto);
            }
        }
        return mbtiListDto;
    }
}
