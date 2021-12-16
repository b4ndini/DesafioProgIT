package com.example.testeprogittecnologia.api

import com.example.testeprogittecnologia.util.Constants.PROG_IT_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    val progItApi = getProgItApiClient().create(ProgItApi::class.java)

    private fun getProgItApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(PROG_IT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}