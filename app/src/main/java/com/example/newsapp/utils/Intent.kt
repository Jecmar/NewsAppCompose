package com.example.newsapp.utils

import android.content.Context
import android.content.Intent

fun Intent.safeStartActivity(context: Context){
    if(this.resolveActivity(context.packageManager) != null){
        context.startActivity(this)
    }
}