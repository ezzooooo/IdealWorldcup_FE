package com.yjy.idw.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PageViewModel : ViewModel() {

    val _index = MutableLiveData<Int>()
    val maintext: LiveData<String> = Transformations.map(_index) {
        ""
    }
    val subtext: LiveData<String> = Transformations.map(_index) {
        ""
    }

    fun setIndex(index: Int) {
        _index.value = index
    }
}