package com.test.application.core.interactor

import com.test.application.core.domain.Classes
import com.test.application.core.domain.ExamTime
import com.test.application.core.domain.Homework

interface HomeScreenInteractor {
    fun getExamTime(): ExamTime
    fun getClasses(): List<Classes>
    fun getHomeworks(): List<Homework>
}