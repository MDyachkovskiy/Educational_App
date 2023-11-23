package com.test.application.core.repository

import com.test.application.core.domain.Homework
import com.test.application.core.mapper.toDomain
import com.test.application.data_provider.datasource.HomeworkMockData
import com.test.application.data_provider.respository.HomeworkRepository

class HomeworkRepositoryImpl : HomeworkRepository<Homework> {
    override fun getHomeworks(): List<Homework> {
        return HomeworkMockData.homeworkList.map { dto ->
            dto.toDomain()
        }
    }
}