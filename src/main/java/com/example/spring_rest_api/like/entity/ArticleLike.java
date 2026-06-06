package com.example.spring_rest_api.like.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleLike {
    private Long  articleLikeId;
    private Long userId;
    private Long articleId;
    private LocalDateTime createdAt;

    public static ArticleLike create(Long articleLikeId, Long articleId, Long userId) {
        ArticleLike articleLike = new ArticleLike();
        articleLike.articleLikeId = articleLikeId;
        articleLike.userId = userId;
        articleLike.articleId = articleId;
        articleLike.createdAt = LocalDateTime.now();
        return articleLike;
    }
}
