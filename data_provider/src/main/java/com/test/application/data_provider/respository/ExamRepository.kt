package com.test.application.data_provider.respository


interface ExamRepository<T> {
    fun getExamTime(): T
}