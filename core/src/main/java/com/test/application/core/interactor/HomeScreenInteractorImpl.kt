package com.test.application.core.interactor

import com.test.application.core.domain.Classes
import com.test.application.core.domain.ExamTime
import com.test.application.core.domain.Homework
import com.test.application.data_provider.respository.ClassesRepository
import com.test.application.data_provider.respository.ExamRepository
import com.test.application.data_provider.respository.HomeworkRepository

class HomeScreenInteractorImpl(
    private val examRepository: ExamRepository<ExamTime>,
    private val classesRepository: ClassesRepository<Classes>,
    private val homeworkRepository: HomeworkRepository<Homework>
) : HomeScreenInteractor {
    override fun getExamTime(): ExamTime = examRepository.getExamTime()

    override fun getClasses(): List<Classes> = classesRepository.getClasses()

    override fun getHomeworks(): List<Homework> = homeworkRepository.getHomeworks()
}