package gb.com.educational_app.model.repository

import gb.com.educational_app.model.datasource.Classes
import gb.com.educational_app.model.datasource.ClassesMockData

class ClassesRepositoryImpl: ClassesRepository {

    override fun getClasses(): List<Classes> {
        return ClassesMockData.classesList
    }
}