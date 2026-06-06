package com.example.spring_rest_api.like.service.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ArticleLikeCountResponse {
    private Long articleId;
    private Long articleLikeCount;

    public static ArticleLikeCountResponse from(Long articleId, Long articleLikeCount) {
        ArticleLikeCountResponse response = new ArticleLikeCountResponse();
        response.articleId = articleId;
        response.articleLikeCount = articleLikeCount;
        return response;
    }
}
