package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.ArticleDTO;
import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.domain.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {
    // Spring이 ArticleRepository 구현체(ArticleDao)를 DI (인터페이스 아님)
    // 인터페이스지만 실제 기능이 들어가있음 findAll(), findById(), save() ...
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "articles/list";
    }

    @GetMapping("")
    public String index() {
        return "redirect:/articles/list";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id, ArticleDTO articleDto, Model model) {
        Article article = articleRepository.save(articleDto.toEntity());
        model.addAttribute("article", article);
        return String.format("redirect:/articles/%d", article.getId());
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        articleRepository.deleteById(id);
        return "redirect:/articles";
    }

    @GetMapping(value = "/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @GetMapping(value = "/{id}")
    public String selectSingle(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);
        if (optArticle.isEmpty()) {
            return "articles/error";
        }
        model.addAttribute("article", optArticle.get());
        return "articles/show";

    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Article> optionalArticle = articleRepository.findById(id);

        if (optionalArticle.isEmpty()) {
            model.addAttribute("message", String.format("%d가 없습니다.", id));
            return "articles/error";
        }
        model.addAttribute("article", optionalArticle.get());
        return "articles/edit";
    }

    @PostMapping(value = "/posts")
    public String creatArticle(ArticleDTO form) {
        Article savedArticle = articleRepository.save(form.toEntity());
        return String.format("redirect:/articles/%d", savedArticle.getId());
    }
}