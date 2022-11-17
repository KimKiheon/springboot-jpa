package com.example.springbootjpa.domain.repository;

import com.example.springbootjpa.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
