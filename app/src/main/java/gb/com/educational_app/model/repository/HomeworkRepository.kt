package gb.com.educational_app.model.repository

import gb.com.educational_app.model.datasource.Homework

interface HomeworkRepository {
    fun getHomeworks(): List<Homework>
}