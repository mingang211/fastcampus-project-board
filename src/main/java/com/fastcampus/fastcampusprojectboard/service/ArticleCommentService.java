package com.fastcampus.fastcampusprojectboard.service;

import com.fastcampus.fastcampusprojectboard.dto.ArticleCommentDto;
import com.fastcampus.fastcampusprojectboard.repository.ArticleCommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ArticleCommentService {

    private final ArticleCommentRepository articleCommentRepository;

    public ArticleCommentService(ArticleCommentRepository articleCommentRepository) {
        this.articleCommentRepository = articleCommentRepository;
    }

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComments(long articleId) {
        return List.of();
    }

    public void saveArticleComment(ArticleCommentDto dto) {
    }

    public void updateArticleComment(ArticleCommentDto dto) {
    }

    public void deleteArticleComment(Long articleCommentId) {
    }
}
