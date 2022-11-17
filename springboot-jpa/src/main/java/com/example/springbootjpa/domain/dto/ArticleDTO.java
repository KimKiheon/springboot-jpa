package com.example.springbootjpa.domain.dto;

import com.example.springbootjpa.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleDTO {
    private Long id;
    private String title;
    private String content;
    public Article toEntity(){
        return new Article(this.id, this.title, this.content);
    }
}
