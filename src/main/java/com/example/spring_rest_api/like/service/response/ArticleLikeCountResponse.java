package com.example.spring_rest_api.like.service.response;

public class ArticleLikeCountResponse {
    private Long articleId;
    private Long likeCount;

    public static ArticleLikeCountResponse from(Long articleId, Long likeCount) {
        ArticleLikeCountResponse response = new ArticleLikeCountResponse();
        response.articleId = articleId;
        response.likeCount = likeCount;
        return response;
    }
}
