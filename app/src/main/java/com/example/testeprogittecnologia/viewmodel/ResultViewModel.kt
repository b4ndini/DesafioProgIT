package com.example.testeprogittecnologia.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testeprogittecnologia.api.ResponseApi
import com.example.testeprogittecnologia.model.PrizeResponseData
import com.example.testeprogittecnologia.repository.ResultRepository
import kotlinx.coroutines.launch

class ResultViewModel : ViewModel() {

    var errorLiveData: MutableLiveData<String> = MutableLiveData()
    var prizesLiveData: MutableLiveData<PrizeResponseData> = MutableLiveData()
    private val repository: ResultRepository = ResultRepository()

    fun getPrizes() {
        viewModelScope.launch {
            when (val response = repository.getPrizes()) {
                is ResponseApi.Success -> {
                    prizesLiveData.postValue(response.data as PrizeResponseData)
                }
                is ResponseApi.Error -> {
                    errorLiveData.postValue(response.msg)
                }
            }
        }
    }

}