package com.example.mbtogether.domain.post.service;

import com.example.mbtogether.domain.post.controller.request.PostDto;
import com.example.mbtogether.domain.post.controller.request.UpdateDto;
import com.example.mbtogether.domain.post.controller.response.DetailDto;
import com.example.mbtogether.domain.post.controller.response.ListDto;
import com.example.mbtogether.domain.post.entity.Image;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.post.repository.ImageRepository;
import com.example.mbtogether.domain.post.repository.PostRepository;
import com.example.mbtogether.global.error.ErrorCode;
import com.example.mbtogether.global.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ImageRepository imageRepository;

    @Override
    public void post(PostDto dto) {
        Post post = new Post(dto.getTitle(), dto.getContent(), dto.getCoverUrl());
        postRepository.save(post);
    }

    @Override
    public void update(UpdateDto dto) {
        Post post = postRepository.findById(dto.getId()).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));
        post.update(dto.getTitle(), dto.getContent(), dto.getCoverUrl());
    }

    @Override
    public void delete(int id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));
        postRepository.delete(post);
    }

    @Override
    public DetailDto detail(int id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));
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

    @Override
    public String uploadImage(MultipartFile image) {
        UUID uuid = UUID.randomUUID();
        String imageName = uuid + "-" + image.getOriginalFilename();

        Image saveImage = new Image(imageName);

        imageRepository.save(saveImage);
        return imageName;
    }

    @Override
    public void uploadImageList(List<MultipartFile> image) {

        for(MultipartFile multipartFile : image){
            UUID uuid = UUID.randomUUID();
            String imageName = uuid + "-" + multipartFile.getOriginalFilename();

            Image saveImage = new Image(imageName);

            imageRepository.save(saveImage);
        }
    }
}
