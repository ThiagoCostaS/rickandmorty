package com.example.rickandmortyapi.ui.listcharacters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.rickandmortyapi.databinding.ItemCharacterBinding
import com.example.rickandmortyapi.domain.model.CharacterDomain
import com.example.rickandmortyapi.domain.model.ResultDomain
import com.example.rickandmortyapi.extensions.loadImageWithShimmer
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.material.card.MaterialCardView

class ListCharacterAdapter(
    private val onClickListener: (ResultDomain) -> Unit
) :
    RecyclerView.Adapter<ListCharacterAdapter.ListCharacterAdapterViewHolder>() {

        private val listCharacters: MutableList<ResultDomain> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListCharacterAdapterViewHolder {
        val binding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListCharacterAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int = listCharacters.size

    override fun onBindViewHolder(holder: ListCharacterAdapterViewHolder, position: Int) {
        holder.bind(listCharacters[position])
    }

    fun setList(list: List<ResultDomain>){
        this.listCharacters.clear()
        this.listCharacters.addAll(list)
        notifyDataSetChanged()
    }

    fun addList(list: List<ResultDomain>){
        this.listCharacters.addAll(list)
        notifyDataSetChanged()
    }

    inner class ListCharacterAdapterViewHolder(itemView: ItemCharacterBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        private val characterImg: ImageView = itemView.characterImg
        private val shimmer: ShimmerFrameLayout = itemView.shimmer
        private val characterName: TextView = itemView.txtNameCharacter
        private val characterStatus: TextView = itemView.txtStatus
        private val characterItem: MaterialCardView = itemView.characterItem

        fun bind(character: ResultDomain) {
            characterImg.loadImageWithShimmer(character.image, shimmer)
            characterName.text = character.name
            characterStatus.text = character.status

            characterItem.setOnClickListener {
                onClickListener(character)
            }
        }
    }
}
