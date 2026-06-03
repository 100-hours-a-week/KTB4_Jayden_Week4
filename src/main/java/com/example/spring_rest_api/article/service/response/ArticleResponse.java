package com.example.spring_rest_api.article.service.response;

import com.example.spring_rest_api.article.entity.Article;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
public class ArticleResponse {
    private Long articleId;
    private String title;
    private String content;
    private String previousContent;
    private Long userId;
    private List<String> contentImages;
    private List<String> previousContentImages;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private boolean isArticleDeleted;
    private boolean isArticleEdited;

    public static ArticleResponse from(Article article) {
        ArticleResponse response = new ArticleResponse();
        response.articleId = article.getArticleId();
        response.title = article.getTitle();
        response.content = article.getContent();
        response.previousContent = article.getPreviousContent();
        response.userId = article.getUserId();
        response.contentImages = article.getContentImages();
        response.previousContentImages = article.getPreviousContentImages();
        response.createdAt = article.getCreatedAt();
        response.updatedAt = article.getUpdatedAt();
        response.deletedAt = article.getDeletedAt();
        response.isArticleDeleted = article.isArticleDeleted();
        response.isArticleEdited = article.isArticleEdited();
        return response;
    }
}
