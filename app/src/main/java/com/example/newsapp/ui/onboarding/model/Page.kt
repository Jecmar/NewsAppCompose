package com.example.newsapp.ui.onboarding.model

import androidx.annotation.DrawableRes
import com.example.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val imageId: Int
)

val pages = listOf(
    Page(
        "Lorem Ipsum is simply dummy",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        R.drawable.onboarding1
    ),
    Page(
        "Lorem Ipsum is simply dummy",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        R.drawable.onboarding2
    ),
    Page(
        "Lorem Ipsum is simply dummy",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        R.drawable.onboarding3
    )
)
