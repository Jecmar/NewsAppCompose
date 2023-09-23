package com.example.newsapp.data.event

sealed class OnBoardingEvent {
    object SaveAppEntry : OnBoardingEvent()
}