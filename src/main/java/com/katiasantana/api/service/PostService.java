package com.katiasantana.api.service;

import com.katiasantana.api.model.Post;
import com.katiasantana.api.repository.PostRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository repo;

    public PostService(PostRepository repo) {
        this.repo = repo;
    }

    public List<Post> findAll() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "publishedAt"));
    }

    public Post create(String content) {
        Post p = new Post(content);
        return repo.save(p);
    }

    public void delete(Long id) {
        // opcional: checar existência antes de apagar
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
    }
}