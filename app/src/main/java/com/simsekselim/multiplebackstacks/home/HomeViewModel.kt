package com.simsekselim.multiplebackstacks.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * @Author: Selim Simsek
 * @Date: 16.10.2023
 */
class HomeViewModel: ViewModel() {
    var items: MutableStateFlow<MutableList<Int>> = MutableStateFlow(mutableListOf())

    init {
        getData()
    }

    private fun getData(){
        for (i in 0 until 100){
            items.value.add(i)
        }
    }
}