package com.test.application.home.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gb.com.educational_app.model.datasource.Classes
import gb.com.educational_app.model.datasource.ExamTime
import gb.com.educational_app.model.datasource.Homework
import gb.com.educational_app.model.repository.ClassesRepository
import gb.com.educational_app.model.repository.ExamRepository
import gb.com.educational_app.model.repository.HomeworkRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val examRepository: ExamRepository,
    private val classesRepository: ClassesRepository,
    private val homeworkRepository: HomeworkRepository
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
            _examTime.postValue(examRepository.getExamTime())
        }
    }

    private fun loadClasses() {
        viewModelScope.launch {
            _classes.postValue(classesRepository.getClasses())
        }
    }

    private fun loadHomework() {
        viewModelScope.launch {
            _homework.postValue(homeworkRepository.getHomeworks())
        }
    }
}