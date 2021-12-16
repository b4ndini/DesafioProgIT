package com.example.testeprogittecnologia.api

import com.example.testeprogittecnologia.model.PrizeResponseData
import retrofit2.Response
import retrofit2.http.GET

interface ProgItApi {

    @GET("premio/BuscarPremiosUltimoSorteio")
    suspend fun getPrizes(
    ): Response<PrizeResponseData>


}