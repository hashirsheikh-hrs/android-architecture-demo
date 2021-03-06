package com.hrs.data.remote

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader

object NULL_TO_DEFAULT_ADAPTER {
    @FromJson
    fun fromJson(reader: JsonReader): String {
        if (reader.peek() != JsonReader.Token.NULL) {
            return reader.nextString()
        }
        reader.nextNull<Unit>()
        return ""
    }
}