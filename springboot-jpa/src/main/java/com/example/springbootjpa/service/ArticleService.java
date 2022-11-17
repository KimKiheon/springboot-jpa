package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.dto.ArticleResponse;
import com.example.springbootjpa.domain.entity.Article;
import com.example.springbootjpa.domain.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    public ArticleResponse getArticle(Long id){
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if(optionalArticle.isPresent()){
            Article article = optionalArticle.get();
            return Article.of(article);
        }
        return null;
    }
}
