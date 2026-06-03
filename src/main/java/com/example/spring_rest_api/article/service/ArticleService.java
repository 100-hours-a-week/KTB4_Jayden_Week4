package com.example.spring_rest_api.article.service;

import com.example.spring_rest_api.article.entity.Article;
import com.example.spring_rest_api.article.repository.ArticleMemoryRepository;
import com.example.spring_rest_api.article.service.request.ArticleCreateRequest;
import com.example.spring_rest_api.article.service.request.ArticleUpdateRequest;
import com.example.spring_rest_api.article.service.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleMemoryRepository articleMemoryRepository;
    private Long sequence = 0L;

    public ArticleResponse create(ArticleCreateRequest request) {
        Article article = articleMemoryRepository.save(Article.create(
                sequence++,
                request.getTitle(),
                request.getContent(),
                request.getUserId(),
                request.getContentImages()
        ));
        return ArticleResponse.from(article);
    }

    public ArticleResponse update(Long articleId, ArticleUpdateRequest request) {
        return null;
    }

    public ArticleResponse saveTempArticle(Long userId, ArticleUpdateRequest request) {
        return null;
    }

    public ArticleResponse readTempArticle(Long userId) {
        return null;
    }

    public ArticleResponse delete(Long articleId) {
        return null;
    }

    public ArticleResponse read(Long articleId) {
        return null;
    }

    public List<ArticleResponse> readInfiniteScroll(Long pageSize, Long lastArticleId) {
        return null;
    }

    public void report(Long articleId, Long userId) {

    }
}
