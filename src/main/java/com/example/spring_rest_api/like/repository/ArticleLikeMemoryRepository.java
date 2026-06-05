package com.example.spring_rest_api.like.repository;

import com.example.spring_rest_api.like.entity.ArticleLike;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class ArticleLikeMemoryRepository {
    // <userId, ArticleLike>
    private final Map<Long, ArticleLike> articleLikeStorage =  new ConcurrentHashMap<>();

    public ArticleLike findByArticleIdAndUserId(Long articleId, Long userId) {
        return articleLikeStorage.entrySet().stream()
                .filter(entry -> entry.getKey().equals(articleId))
                .filter(entry -> entry.getValue().getUserId().equals(userId))
                .findAny()
                .map(Map.Entry::getValue)
                .orElseThrow();
    }

    public void save(Long articleId, Long userId) {
        articleLikeStorage.put(userId, ArticleLike.create(articleId, userId));
    }

    public void delete(Long articleId, Long userId) {
        articleLikeStorage.entrySet().stream()
                .filter(entry -> entry.getKey().equals(articleId))
                .filter(entry -> entry.getValue().getUserId().equals(userId))
                .findAny()
                .map(entry -> entry.getValue().delete())
                .map(articleLike -> articleLikeStorage.put(articleId, articleLike))
                .orElseThrow();
    }
}
