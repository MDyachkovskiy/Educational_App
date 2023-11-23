package com.test.application.core.mapper

import com.test.application.core.domain.Classes
import com.test.application.core.domain.Homework
import com.test.application.data_provider.dto.ClassesDTO
import com.test.application.data_provider.dto.HomeworkDTO
import java.util.Calendar

fun ClassesDTO.toDomain(): Classes {
    return Classes(
        className = this.className,
        classTime = this.classTime,
        teacher = this.teacher,
        comments = this.comments,
        isOnline = this.isOnline,
        isFacultative = this.isFacultative
    )
}

fun HomeworkDTO.toDomain(): Homework{
    return Homework(
        className = this.className,
        description = this.description,
        dueTime = this.dueTime
    )
}