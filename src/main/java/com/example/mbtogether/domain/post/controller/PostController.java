package com.example.mbtogether.domain.post.controller;

import com.example.mbtogether.domain.post.controller.request.PostDto;
import com.example.mbtogether.domain.post.controller.request.UpdateDto;
import com.example.mbtogether.domain.post.controller.response.DetailDto;
import com.example.mbtogether.domain.post.controller.response.ListDto;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/board")
    public void post(@RequestBody PostDto dto){
        postService.post(dto);
    }

    @PatchMapping("/board")
    public void update(@RequestBody UpdateDto dto){
        postService.update(dto);
    }

    @DeleteMapping("/board/{id}")
    public void delete(@PathVariable int id){
        postService.delete(id);
    }

    @GetMapping("/board/{id}")
    public DetailDto detail(@PathVariable int id){
        return postService.detail(id);
    }

    @GetMapping("/board/mbti-list")
    public List<ListDto> mbtiList(@RequestParam("value") String mbti){
        return postService.mbtiList(mbti);
    }

    @GetMapping("/board/popular-list")
    public List<ListDto> popularList(){
        return postService.popularList();
    }

    @GetMapping("/board/latest-list")
    public List<ListDto> latestList(){
        return postService.latestList();
    }

    @GetMapping("/board")
    public List<ListDto> search(@RequestParam("word") String searchWord){
        return postService.search(searchWord);
    }
}
