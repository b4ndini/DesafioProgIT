package com.example.testeprogittecnologia.repository

import com.example.testeprogittecnologia.api.ApiService
import com.example.testeprogittecnologia.api.ResponseApi
import java.lang.Exception

class ResultRepository {

    suspend fun getPrizes(): ResponseApi {
        return try{
            val response = ApiService.progItApi.getPrizes()

            if(response.isSuccessful){
                ResponseApi.Success(response.body())
            }
            else{
                ResponseApi.Error(response.code().toString())
            }
        }catch (exception: Exception){
            ResponseApi.Error(exception.message ?: "Exception")
        }

    }
}