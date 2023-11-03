package com.example.newsapp.data.event

sealed class DetailsEvent {
    object SaveArticle : DetailsEvent()
}