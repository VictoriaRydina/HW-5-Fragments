package com.example.hw_5_fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel(){
    val dataId: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}