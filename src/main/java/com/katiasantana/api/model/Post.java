package com.katiasantana.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // since Katia is always the author, we can hard-code these fields
    private String authorName;
    private String authorRole;
    private String authorAvatarUrl;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime publishedAt;

    public Post() {}

    public Post(String content) {
        this.authorName = "Katia Santana";
        this.authorRole = "Esteticista & Empreendedora";
        this.authorAvatarUrl = "/assets/katia.png";
        this.content = content;
        this.publishedAt = LocalDateTime.now();
    }

    // -- getters & setters --

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public String getAuthorRole() { return authorRole; }
    public void setAuthorRole(String authorRole) { this.authorRole = authorRole; }

    public String getAuthorAvatarUrl() { return authorAvatarUrl; }
    public void setAuthorAvatarUrl(String authorAvatarUrl) { this.authorAvatarUrl = authorAvatarUrl; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getPublishedAt() { return publishedAt; }
    public void setPublishedAt(LocalDateTime publishedAt) { this.publishedAt = publishedAt; }
}