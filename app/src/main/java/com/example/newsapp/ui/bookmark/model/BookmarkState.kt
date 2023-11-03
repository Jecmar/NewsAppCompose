package com.example.newsapp.ui.bookmark.model

import com.example.newsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)