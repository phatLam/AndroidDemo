package com.example.superdemo.condition

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel( val size: Int , val state: SavedStateHandle): ViewModel() {
    val _getList = MutableLiveData<Int>()
    val getList: LiveData<Int> = _getList
    init {
        val size = state.get<Int>("B")
        _getList.value = size
        Log.i("Phat", "size = " + size)
    }


}