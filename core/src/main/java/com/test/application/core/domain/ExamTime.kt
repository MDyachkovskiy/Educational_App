package com.test.application.core.domain

import java.util.Calendar

data class ExamTime(
    val targetTime: Calendar
) {
    companion object {
        fun createExamTime(): ExamTime {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, 3)
            calendar.set(Calendar.HOUR_OF_DAY, 9)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            return ExamTime(calendar)
        }
    }
}