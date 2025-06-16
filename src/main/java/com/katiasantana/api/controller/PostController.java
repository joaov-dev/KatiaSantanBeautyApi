package com.katiasantana.api.controller;

import com.katiasantana.api.model.Post;
import com.katiasantana.api.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> list() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody CreateRequest body) {
        Post saved = service.create(body.getContent());
        return ResponseEntity.status(201).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // DTO interno
    public static class CreateRequest {
        private String content;
        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }
    }
}