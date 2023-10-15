package com.example.newsapp.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsapp.data.remote.NewsApi
import com.example.newsapp.data.remote.NewsPagingSource
import com.example.newsapp.data.remote.SearchNewsPagingSource
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.utils.Constants.PAGE_SIZE
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> =
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE
            ),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi,
                    sources.joinToString()
                )
            }
        ).flow

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> =
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE
            ),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    newsApi,
                    sources.joinToString(),
                    searchQuery
                )
            }
        ).flow
}