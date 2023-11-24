package com.test.application.core.interactor

import com.test.application.core.domain.Classes

interface ClassesScreenInteractor {
    fun getClasses(): List<Classes>
}