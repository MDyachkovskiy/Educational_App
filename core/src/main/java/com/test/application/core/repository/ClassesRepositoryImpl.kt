package com.test.application.core.repository

import com.test.application.core.domain.Classes
import com.test.application.core.mapper.toDomain
import com.test.application.data_provider.datasource.ClassesMockData
import com.test.application.data_provider.respository.ClassesRepository

class ClassesRepositoryImpl: ClassesRepository<Classes> {
    override fun getClasses(): List<Classes> {
        return ClassesMockData.classesList.map { dto ->
            dto.toDomain()
        }
    }
}