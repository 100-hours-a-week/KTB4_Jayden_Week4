package com.example.spring_rest_api.like.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleLikeCount {
    private Long articleId;
    private Long likeCount;

    public static ArticleLikeCount init(Long articleId, Long likeCount) {
        ArticleLikeCount articleLikeCount = new ArticleLikeCount();
        articleLikeCount.articleId = articleId;
        articleLikeCount.likeCount = likeCount;
        return articleLikeCount;
    }

    public ArticleLikeCount increase() {
        this.likeCount++;
        return this;
    }

    public ArticleLikeCount decrease() {
        this.likeCount--;
        return this;
    }
}
