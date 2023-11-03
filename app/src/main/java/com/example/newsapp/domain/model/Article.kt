package com.example.newsapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class Article(
    @PrimaryKey val id: String = generateRandomId(),
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
) {
    companion object {
        private fun generateRandomId(): String = UUID.randomUUID().toString()

    }
}