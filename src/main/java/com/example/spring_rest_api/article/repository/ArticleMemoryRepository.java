package com.example.spring_rest_api.article.repository;

import com.example.spring_rest_api.article.entity.Article;
import com.example.spring_rest_api.article.service.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class ArticleMemoryRepository {
    private final Map<Long, Article> articleStorage = new ConcurrentHashMap<>();
    private Long sequence = 0L;

    public Article save(Article article) {
        articleStorage.put(article.getArticleId(), article);
        return articleStorage.get(article.getArticleId());
    }

    public Article findById(Long articleId) {

    }


}
