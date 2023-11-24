package com.test.application.data_provider.respository

interface ClassesRepository<T> {
    fun getClasses(): List<T>
}