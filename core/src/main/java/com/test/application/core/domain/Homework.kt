package com.test.application.core.domain

import java.util.Calendar

data class Homework (
    val className: String,
    val description: String,
    val dueTime: Calendar
    )