package com.example.pagingexample2.new_data

data class GithubResponse (
    val total_count : Int,
    val incomplete_results : Boolean,
    val items : List<NewItems>
)