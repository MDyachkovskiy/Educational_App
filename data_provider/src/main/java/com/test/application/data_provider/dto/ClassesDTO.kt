package com.test.application.data_provider.dto

data class ClassesDTO(
    val className: String,
    val classTime: String,
    val teacher: String,
    val comments: String?,
    val isOnline: Boolean = false,
    val isFacultative: Boolean = false
)
