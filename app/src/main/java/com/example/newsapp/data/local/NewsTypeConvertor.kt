package com.example.newsapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.newsapp.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConvertor {
    @TypeConverter
    fun sourceToString(source: Source): String =
        "${source.id}, ${source.name}"

    @TypeConverter
    fun stringToSource(source: String): Source =
        source.split(",").let { sourceArray -> Source(sourceArray[0], sourceArray[1]) }
}