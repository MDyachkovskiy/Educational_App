package com.test.application.core.domain

data class Classes(
    val className: String,
    val classTime: String,
    val teacher: String,
    val comments: String?,
    val isOnline: Boolean = false,
    val isFacultative: Boolean = false
)