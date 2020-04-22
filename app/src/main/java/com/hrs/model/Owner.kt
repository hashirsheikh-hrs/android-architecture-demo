package com.hrs.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Owner(
    @Json(name = "id") val own_id: Long,
    val login: String,
    @ColumnInfo(name = "avatar_url") @Json(name = "avatar_url") val avatarUrl: String,
    @ColumnInfo(name="avatar_html_url") @Json(name = "html_url") val htmlUrl: String
)