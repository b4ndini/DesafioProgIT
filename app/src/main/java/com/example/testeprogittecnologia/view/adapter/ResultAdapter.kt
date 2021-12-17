package com.example.testeprogittecnologia.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testeprogittecnologia.databinding.PrizeListItemBinding
import com.example.testeprogittecnologia.model.Premio

class ResultAdapter  (
    private val prizesList: List<Premio>,
) : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PrizeListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(prizesList[position])
    }

    override fun getItemCount(): Int {
        return prizesList.size
    }

    class ViewHolder(private val binding: PrizeListItemBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(prize: Premio) = with(itemView) {

            val titleNumber = "${prize.OrdemExibicao}º Prêmio"
            binding.tvPrizeNumber.text = titleNumber
            binding.tvPrizeDescription.text = prize.Descricao

            if(prize.Contemplados.isNotEmpty()){
                binding.rvWinners.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                    adapter = WinnerAdapter(prize.Contemplados)
                }
            }

        }

    }

}
