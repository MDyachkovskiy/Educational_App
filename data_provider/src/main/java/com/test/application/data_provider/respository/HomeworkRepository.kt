package com.test.application.data_provider.respository


interface HomeworkRepository<T> {
    fun getHomeworks(): List<T>
}