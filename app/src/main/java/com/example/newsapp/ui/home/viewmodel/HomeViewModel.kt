package com.example.newsapp.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    newsUseCases: NewsUseCases
) : ViewModel() {
    private val sources = listOf("bbc-news", "abc-news", "al-jazeera-english")

    val news = newsUseCases.getNews(sources = sources).cachedIn(viewModelScope)
}