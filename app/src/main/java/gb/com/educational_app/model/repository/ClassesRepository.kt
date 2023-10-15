package gb.com.educational_app.model.repository

import gb.com.educational_app.model.datasource.Classes

interface ClassesRepository {
    fun getClasses(): List<Classes>
}