package com.example.spring_rest_api.like.controller;

import com.example.spring_rest_api.like.service.ArticleLikeService;
import com.example.spring_rest_api.like.service.response.ArticleLikeCountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ArticleLikeController {
    private final ArticleLikeService likeService;

    @PostMapping("/likes/articles/{articleId}/users/{userId}")
    public ArticleLikeCountResponse like(@PathVariable Long articleId, @PathVariable Long userId) {
        return likeService.like(articleId, userId);
    }

    @DeleteMapping("/likes/articles/{articleId}/users/{userId}")
    public ArticleLikeCountResponse unlike(@PathVariable Long articleId, @PathVariable Long userId) {
        return likeService.unlike(articleId, userId);
    }

    @GetMapping("/likes/articles/{articleId}/count")
    public ArticleLikeCountResponse countLike(@PathVariable Long articleId) {
        return likeService.readCount(articleId);
    }
}
