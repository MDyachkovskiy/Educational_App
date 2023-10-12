package gb.com.educational_app.model.repository

import gb.com.educational_app.model.datasource.Homework
import gb.com.educational_app.model.datasource.HomeworkMockData

class HomeworkRepositoryImpl : HomeworkRepository {
    override fun getHomeworks(): List<Homework> {
        return HomeworkMockData.homeworkList
    }
}