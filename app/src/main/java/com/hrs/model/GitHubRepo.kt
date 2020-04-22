package com.hrs.model

import androidx.room.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "repository")
@JsonClass(generateAdapter = true)
data class GitHubRepo(
    @PrimaryKey val id: Long,
    val name: String,
    @ColumnInfo(name="full_name") @Json(name = "full_name") val fullName: String,
    val description: String,
    @ColumnInfo(name = "html_url") @Json(name = "html_url") val htmlUrl: String,
    @Embedded var owner: Owner
)