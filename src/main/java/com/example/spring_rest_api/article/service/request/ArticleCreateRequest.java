package com.example.spring_rest_api.article.service.request;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ArticleCreateRequest {
    private String title;
    private String content;
    private Long userId;
    private List<String> contentImages;
}
