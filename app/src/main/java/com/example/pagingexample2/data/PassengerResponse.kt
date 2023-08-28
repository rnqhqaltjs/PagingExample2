package com.example.pagingexample2.data

data class PassengerResponse(
    val `data`: List<Data>,
    val totalPages: Int,
    val totalPassengers: Int

)
