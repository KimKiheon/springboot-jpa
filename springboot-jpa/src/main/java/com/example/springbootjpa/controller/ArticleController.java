package com.example.springbootjpa.controller;

import com.example.springbootjpa.domain.entity.Article;
import com.example.springbootjpa.domain.repository.ArticleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(value = "/{id}")
    public String Select(@PathVariable Long id, Model model) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (optionalArticle.isEmpty()) return "articles/error";
        model.addAttribute("article",optionalArticle.get());
        return "articles/show";
    }
}
