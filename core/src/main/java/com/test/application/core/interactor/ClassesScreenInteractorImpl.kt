package com.test.application.core.interactor

import com.test.application.core.domain.Classes
import com.test.application.data_provider.respository.ClassesRepository

class ClassesScreenInteractorImpl(
    private val classesRepository: ClassesRepository<Classes>
) : ClassesScreenInteractor{
    override fun getClasses(): List<Classes> {
        return classesRepository.getClasses()
    }
}