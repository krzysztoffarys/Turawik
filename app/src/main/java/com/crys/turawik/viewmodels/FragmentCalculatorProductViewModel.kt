package com.crys.turawik.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentCalculatorProductViewModel : ViewModel() {

    val currentPrice: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}