package com.fastcampus.fastcampusprojectboard.service;

import com.fastcampus.fastcampusprojectboard.domain.Article;
import com.fastcampus.fastcampusprojectboard.domain.type.SearchType;
import com.fastcampus.fastcampusprojectboard.dto.ArticleDto;
import com.fastcampus.fastcampusprojectboard.dto.ArticleUpdateDto;
import com.fastcampus.fastcampusprojectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService sut;

    @Mock
    private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하여 게시글 리스트를 반환한다.")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnArticleList() {
        //given

        //when
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword");

        //then
        assertThat(articles).isNotNull();

    }
    @DisplayName("게시글을 조회하면 게시글을 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticles_thenReturnArticle() {
        //given

        //when
        ArticleDto articles = sut.searchArticle(1L);

        //then
        assertThat(articles).isNotNull();

    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 생선한다.")
    @Test
    void giveArticleInfo_whenSavingArticle_thenSaveArticle() {
        //give
        given(articleRepository.save(any(Article.class))).willReturn(null);

        //when
        sut.saveArticle(ArticleDto.of(LocalDateTime.now(), "who", "title", "content", "#java"));

        //then
        then(articleRepository).should().save(any(Article.class));

    }
    @DisplayName("게시글 수정 정보를 입력하면, 게시글을 수정한다.")
    @Test
    void giveArticleIdAndModifiedInfo_whenUpdatingArticle_thenUpdateArticle() {
        //give
        given(articleRepository.save(any(Article.class))).willReturn(null);

        //when
        sut.updateArticle(1L, ArticleUpdateDto.of( "title", "content", "#java"));

        //then
        then(articleRepository).should().save(any(Article.class));

    }
    @DisplayName("게시글 ID를 입력하면, 게시글을 삭제한다.")
    @Test
    void giveArticleId_whenDeletingArticle_thenDeleteArticle() {
        //give
        willDoNothing().given(articleRepository).delete(any(Article.class));

        //when
        sut.deleteArticle(1L);

        //then
        then(articleRepository).should().delete(any(Article.class));

    }
}
