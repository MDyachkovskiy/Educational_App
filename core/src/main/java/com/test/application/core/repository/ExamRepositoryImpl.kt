package com.test.application.core.repository

import com.test.application.core.domain.ExamTime
import com.test.application.data_provider.respository.ExamRepository

class ExamRepositoryImpl: ExamRepository<ExamTime> {
    override fun getExamTime(): ExamTime {
        return ExamTime.createExamTime()
    }
}