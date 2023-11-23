package com.test.application.home.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.application.core.domain.Classes
import com.test.application.core.domain.ExamTime
import com.test.application.core.domain.Homework
import com.test.application.core.interactor.HomeScreenInteractor
import kotlinx.coroutines.launch

class HomeViewModel(
    private val interactor: HomeScreenInteractor,
) : ViewModel() {

    private val _examTime = MutableLiveData<ExamTime>()
    val examTime: LiveData<ExamTime> = _examTime

    private val _classes = MutableLiveData<List<Classes>>()
    val classes: LiveData<List<Classes>> get() = _classes

    private val _homework = MutableLiveData<List<Homework>>()
    val homework: LiveData<List<Homework>> get() = _homework

    fun loadData() = viewModelScope.launch {
        launch { getExamTime() }
        launch { loadClasses() }
        launch { loadHomework() }
    }

    private fun getExamTime() {
        viewModelScope.launch {
            _examTime.postValue(interactor.getExamTime())
        }
    }

    private fun loadClasses() {
        viewModelScope.launch {
            _classes.postValue(interactor.getClasses())
        }
    }

    private fun loadHomework() {
        viewModelScope.launch {
            _homework.postValue(interactor.getHomeworks())
        }
    }
}