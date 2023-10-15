package gb.com.educational_app.model.repository

import gb.com.educational_app.model.datasource.ExamTime

class ExamRepositoryImpl: ExamRepository {
    override fun getExamTime(): ExamTime {
        return ExamTime.createExamTime()
    }
}