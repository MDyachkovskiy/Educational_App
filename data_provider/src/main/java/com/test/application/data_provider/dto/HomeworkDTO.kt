package com.test.application.data_provider.dto

import java.util.Calendar

data class HomeworkDTO(
    val className: String,
    val description: String,
    val dueTime: Calendar
)
