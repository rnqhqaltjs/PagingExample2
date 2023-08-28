package com.example.pagingexample2.new_network

import com.example.pagingexample2.new_data.GithubResponse
import retrofit2.http.GET
import retrofit2.http.Query

// https://api.github.com/search/repositories?q=android$page=1&per_page=90

interface GithubApi {

    @GET("search/repositories")
    suspend fun getData(
        @Query("q") query : String,
        @Query("page") page : Int,
        @Query("per_page") per_page : Int
    ) : GithubResponse

}