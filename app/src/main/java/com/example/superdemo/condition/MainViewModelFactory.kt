package com.example.superdemo.condition

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner

class MainViewModelFactory(private val size: Int, owner: SavedStateRegistryOwner, bundle: Bundle):
    AbstractSavedStateViewModelFactory(owner, bundle) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return MainViewModel(size, handle) as T
    }

}