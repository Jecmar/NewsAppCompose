package com.example.newsapp.ui.search.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsapp.data.event.SearchEvent
import com.example.newsapp.domain.usecases.news.NewsUseCases
import com.example.newsapp.ui.search.model.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {
    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    private val sources = listOf("bbc-news", "abc-news", "al-jazeera-english")

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.SearchNews -> {
                searchNews()
            }

            is SearchEvent.UpdateSearchQuery -> {
                _state.value = state.value.copy(searchQuery = event.searchQuery)
            }
        }
    }

    private fun searchNews() {
        val articles =
            newsUseCases.searchNews(state.value.searchQuery, sources).cachedIn(viewModelScope)
        _state.value = state.value.copy(articles = articles)
    }
}