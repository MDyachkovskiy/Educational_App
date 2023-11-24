package com.test.application.classes.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.application.core.domain.Classes
import com.test.application.core.interactor.ClassesScreenInteractor
import kotlinx.coroutines.launch

class ClassesViewModel(
    private val interactor: ClassesScreenInteractor
) : ViewModel() {

    private val _classes = MutableLiveData<List<Classes>>()
    val classes: LiveData<List<Classes>> get() = _classes

    fun loadClasses() {
        viewModelScope.launch {
            _classes.postValue(interactor.getClasses())
        }
    }
}