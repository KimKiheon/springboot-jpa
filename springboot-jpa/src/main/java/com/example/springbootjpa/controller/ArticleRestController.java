package com.example.springbootjpa.controller;

import com.example.springbootjpa.domain.dto.ArticleResponse;
import com.example.springbootjpa.domain.repository.ArticleRepository;
import com.example.springbootjpa.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {
    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> get(@PathVariable Long id) {
        ArticleResponse articleResponse = articleService.getArticle(id);
        return ResponseEntity.ok().body(articleResponse);
    }
}
