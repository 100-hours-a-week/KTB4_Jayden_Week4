package com.example.spring_rest_api;

import com.example.spring_rest_api.article.entity.Article;
import com.example.spring_rest_api.article.repository.ArticleMemoryRepository;
import com.example.spring_rest_api.comment.entity.Comment;
import com.example.spring_rest_api.comment.repository.CommentCountMemoryRepository;
import com.example.spring_rest_api.comment.repository.CommentMemoryRepository;
import com.example.spring_rest_api.user.entity.User;
import com.example.spring_rest_api.user.repository.UserMemoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 게시판 무한스크롤, 댓글 무한스크롤 API 응답 확인을 위한 데이터 초기화 클래스
 */
@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final ArticleMemoryRepository articleMemoryRepository;
    private final UserMemoryRepository userMemoryRepository;
    private final CommentMemoryRepository commentMemoryRepository;
    private final CommentCountMemoryRepository commentCountMemoryRepository;

    @PostConstruct
    public void initialize() {
        for (Long i = 100L; i < 120L; i++) {
            articleMemoryRepository.save(Article.create(
                    i,
                    "title" + i,
                    "content" + i,
                    i,
                    List.of(String.valueOf(i))
            ));

            userMemoryRepository.create(User.create(
                    i,
                    "abc" + i + "@abc.com",
                    "Abc1234!",
                    "nickname" + i,
                    "profileImage" + i
            ));

            commentCountMemoryRepository.increase(100L);
            commentMemoryRepository.save(Comment.create(
                    i,
                    100L,
                    i,
                    userMemoryRepository.findById(i).getProfileImage(),
                    "comment text" + i,
                    null
            ));
        }
    }
}
