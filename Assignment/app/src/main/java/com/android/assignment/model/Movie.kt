package com.android.assignment.model

import com.google.gson.annotations.SerializedName


data class ResultsItem(val overview: String = "",
                       @SerializedName("original_language")
                       val originalLanguage: String = "",
                       @SerializedName("original_title")
                       val originalTitle: String = "",
                       val video: Boolean = false,
                       val title: String = "",
                       @SerializedName("genre_ids")
                       val genreIds: List<Integer>?,
                       @SerializedName("poster_path")
                       val poster_path: String = "",
                       @SerializedName("backdrop_path")
                       val backdropPath: String = "",
                       @SerializedName("release_date")
                       val releaseDate: String = "",
                       @SerializedName("vote_average")
                       val voteAverage: Double = 0.0,
                       val popularity: Double = 0.0,
                       val id: Int = 0,
                       val adult: Boolean = false,
                       @SerializedName("vote_count")
                       val voteCount: Int = 0)


data class Movie(val page: Int = 0,
             @SerializedName("total_pages")
             val totalPages: Int = 0,
             val results: List<ResultsItem>?,
             @SerializedName("total_results")
             val totalResults: Int = 0)


