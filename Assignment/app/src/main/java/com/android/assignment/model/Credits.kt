package com.android.assignment.model
import com.google.gson.annotations.SerializedName

data class Credits(val cast: List<CastItem>?,
                   val id: Int = 0,
                   val crew: List<CrewItem>?)


data class CrewItem(val gender: Int = 0,
                    @SerializedName("credit_id")
                    val creditId: String = "",
                    val name: String = "",
                    @SerializedName("profile_path")
                    val profile_path: String = "",
                    val id: Int = 0,
                    val department: String = "",
                    val job: String = "")


data class CastItem(@SerializedName("cast_id")
                    val castId: Int = 0,
                    val character: String = "",
                    val gender: Int = 0,
                    @SerializedName("credit_id")
                    val creditId: String = "",
                    val name: String = "",
                    @SerializedName("profile_path")
                    val profile_path: String = "",
                    val id: Int = 0,
                    val order: Int = 0)


