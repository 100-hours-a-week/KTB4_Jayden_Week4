package com.example.spring_rest_api.like.service;

import com.example.spring_rest_api.like.repository.ArticleLikeCountMemoryRepository;
import com.example.spring_rest_api.like.repository.ArticleLikeMemoryRepository;
import com.example.spring_rest_api.like.service.response.ArticleLikeCountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleLikeService {
    private final ArticleLikeMemoryRepository articleLikeMemoryRepository;
    private final ArticleLikeCountMemoryRepository articleLikeCountMemoryRepository;


    public ArticleLikeCountResponse like(Long articleId, Long userId) {
        articleLikeMemoryRepository.save(articleId, userId);
        articleLikeCountMemoryRepository.increase(articleId);
        return ArticleLikeCountResponse.from(
                articleId,
                articleLikeCountMemoryRepository.read(articleId)
        );
    }

    public ArticleLikeCountResponse unlike(Long articleId, Long userId) {
        articleLikeMemoryRepository.delete(articleId, userId);
        articleLikeCountMemoryRepository.decrease(articleId);
        return ArticleLikeCountResponse.from(
                articleId,
                articleLikeCountMemoryRepository.read(articleId)
        );
    }

    public ArticleLikeCountResponse readCount(Long articleId) {
        return ArticleLikeCountResponse.from(
                articleId,
                articleLikeCountMemoryRepository.read(articleId)
        );
    }
}
