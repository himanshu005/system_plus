package com.android.assignment.model.network

import com.android.assignment.model.Credits
import com.android.assignment.model.Movie
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RequestInterface {

    @GET("search/movie")
    fun getMovies(@Query("api_key") api_key:String,
                  @Query("query") query:String) : Observable<Movie>

     @GET("movie/{id}/credits")
     fun getCredits( @Path("id") id:String,
                 @Query("api_key") api_key:String
                ) : Observable<Credits>
}