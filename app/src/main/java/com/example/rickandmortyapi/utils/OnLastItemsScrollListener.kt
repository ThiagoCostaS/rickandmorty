package com.example.rickandmortyapi.utils

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class OnLastItemsScrollListener(private val onLastItemsVisible: () -> Unit): RecyclerView.OnScrollListener() {

    private var isLoading = false

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val layoutManager = recyclerView.layoutManager as GridLayoutManager
        val totalItemCount = layoutManager.itemCount
        val lastVisibleItem = layoutManager.findLastVisibleItemPosition()

        if(!isLoading && totalItemCount <= lastVisibleItem + ITEM_QUANTITY_INVISIBLE){
            onLastItemsVisible()
            isLoading = true
        }
    }

    fun setLoaded(){
        isLoading = false
    }

    companion object{
        private const val ITEM_QUANTITY_INVISIBLE = 2
    }
}