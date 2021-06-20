package com.example.superdemo.condition

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel(): ViewModel() {
    private var _isLogin = MutableLiveData<Boolean>(false)
    val isLogin: LiveData<Boolean> = _isLogin
    fun setLogin(){
        _isLogin.value = true
    }
}