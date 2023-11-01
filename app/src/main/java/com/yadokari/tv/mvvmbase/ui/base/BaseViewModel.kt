package com.yadokari.tv.mvvmbase.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    private val _failure = MutableLiveData<Throwable>()
    val failure: LiveData<Throwable> = _failure

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    protected fun handleFailure(failure: Throwable) {
        this._failure.postValue(failure)
    }

    protected fun startLoading(onStart: () -> Unit) {
        if (_isLoading.value) return

        viewModelScope.launch {
            _isLoading.value = true
            onStart()
        }
    }

    protected fun stopLoading() {
        _isLoading.value = false
    }
}