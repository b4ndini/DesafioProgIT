package com.example.testeprogittecnologia.repository

import com.example.testeprogittecnologia.api.ApiService
import com.example.testeprogittecnologia.api.ResponseApi
import com.example.testeprogittecnologia.model.Premio
import java.lang.Exception

class ResultRepository {


    suspend fun getPrizes(): ResponseApi {
        return try{
            val response = ApiService.progItApi.getPrizes()

            if(response.isSuccessful){
                val filteredList = mutableListOf<Premio>()
                val responseBody = response.body()

                responseBody?.Data?.Premios?.forEach { prize ->
                       if(prize.Destaque){
                           /**remove o primeiro caractere(atributo "endereco" da API esta
                           retornando espaco em branco na primeira posicao da String)*/
                           prize.Contemplados.forEach { winner ->
                               winner.Endereco = winner.Endereco.drop(1)
                           }
                           /****************************************/
                           filteredList.add(prize)
                       }
                }
                responseBody?.Data?.Premios = filteredList
                ResponseApi.Success(responseBody)
            }
            else{
                ResponseApi.Error(response.code().toString())
            }
        }catch (exception: Exception){
            ResponseApi.Error(exception.message ?: "Exception")
        }

    }
}