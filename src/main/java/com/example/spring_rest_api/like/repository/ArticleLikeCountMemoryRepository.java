package com.example.spring_rest_api.like.repository;

import com.example.spring_rest_api.like.entity.ArticleLikeCount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class ArticleLikeCountMemoryRepository {
    // <articleId, ArticleLikeCount>
    private final Map<Long, ArticleLikeCount> articleLikeCountStorage =  new ConcurrentHashMap<>();

    public Long read(Long articleId) {
        return articleLikeCountStorage.get(articleId).getLikeCount();
    }

    public void increase(Long articleId) {
        articleLikeCountStorage.put(articleId, articleLikeCountStorage.get(articleId).increase());
    }

    public void decrease(Long articleId) {
        articleLikeCountStorage.put(articleId, articleLikeCountStorage.get(articleId).decrease());
    }
}
