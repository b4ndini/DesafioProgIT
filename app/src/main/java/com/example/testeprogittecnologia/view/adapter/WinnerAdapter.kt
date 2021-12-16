package com.example.testeprogittecnologia.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testeprogittecnologia.databinding.WinnerListItemBinding
import com.example.testeprogittecnologia.model.Contemplado

class WinnerAdapter  (
    private val winnersList: List<Contemplado>,
) : RecyclerView.Adapter<WinnerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = WinnerListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(winnersList[position])
    }

    override fun getItemCount(): Int {
        return winnersList.size
    }

    class ViewHolder(private val binding: WinnerListItemBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(winner: Contemplado) = with(itemView) {

            val titleNumber = "Nº: ${winner.NumeroTitulo}"
            val seller = "Vendedor: ${winner.Vendedor}"

            binding.apply{
                tvTitleNumber.text = titleNumber
                tvName.text = winner.Nome
                tvAddress.text = winner.Endereco
                tvSeller.text = seller
            }


        }

    }

}
