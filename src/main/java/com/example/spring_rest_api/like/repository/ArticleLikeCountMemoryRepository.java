package com.example.spring_rest_api.like.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class ArticleLikeCountMemoryRepository {
    // <articleId, articleLikeCount>
    private final Map<Long, Long> articleLikeCountStorage =  new ConcurrentHashMap<>();

    public Long read(Long articleId) {
        return articleLikeCountStorage.getOrDefault(articleId, 0L);
    }

    public void increase(Long articleId) {
        if (articleLikeCountStorage.containsKey(articleId)) {
            articleLikeCountStorage.put(articleId, articleLikeCountStorage.get(articleId) + 1L);
        } else {
            articleLikeCountStorage.put(articleId, 1L);
        }
    }

    public void decrease(Long articleId) {
        if (articleLikeCountStorage.containsKey(articleId) && articleLikeCountStorage.get(articleId) > 0L) {
                articleLikeCountStorage.put(articleId, articleLikeCountStorage.get(articleId) - 1L);
        } else {
            articleLikeCountStorage.put(articleId, 0L);
        }
    }
}
