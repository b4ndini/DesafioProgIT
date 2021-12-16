package com.example.testeprogittecnologia.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testeprogittecnologia.databinding.ActivityResultBinding
import com.example.testeprogittecnologia.view.adapter.ResultAdapter
import com.example.testeprogittecnologia.viewmodel.ResultViewModel

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var viewModel: ResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[ResultViewModel::class.java]
        setObservers()
        viewModel.getPrizes()

    }

    private fun setObservers() {
        viewModel.prizesLiveData.observe(this, { prizes ->
            prizes.let {
                val prizeDate = "Sorteio ${it.Data.DataSorteio}"
                binding.tvPrizeDrawDate.text = prizeDate
                binding.rvPrizes.apply {
                    layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = ResultAdapter(it.Data.Premios)
                }
            }

        })

        viewModel.errorLiveData.observe(this, { errorMsg ->
            Toast.makeText(this, "Ocorreu um erro ao carregar:\n $errorMsg", Toast.LENGTH_LONG)
                .show()
        })
    }


}