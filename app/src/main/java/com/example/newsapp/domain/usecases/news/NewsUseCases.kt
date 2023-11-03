package com.example.newsapp.domain.usecases.news

data class NewsUseCases(
    val getNews: GetNews,
    val getArticles: GetArticles,
    val searchNews: SearchNews,
    val insertArticle: InsertArticle,
    val deleteArticle: DeleteArticle
)
