package gb.com.educational_app.model.repository

import gb.com.educational_app.model.datasource.ExamTime

interface ExamRepository {
    fun getExamTime(): ExamTime
}