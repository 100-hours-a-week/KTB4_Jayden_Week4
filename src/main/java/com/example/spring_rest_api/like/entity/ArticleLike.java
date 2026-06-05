package com.example.spring_rest_api.like.entity;

import lombok.*;

@Getter
@ToString
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleLike {
    private Long userId;
    private Long articleId;
    private boolean liked;

    public static ArticleLike create(Long articleId, Long userId) {
        ArticleLike articleLike = new ArticleLike();
        articleLike.userId = userId;
        articleLike.articleId = articleId;
        articleLike.liked = true;
        return articleLike;
    }

    public ArticleLike delete() {
        this.liked = false;
        return this;
    }
}
