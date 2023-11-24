package com.test.application.data_provider.datasource

import com.test.application.data_provider.dto.ClassesDTO


object ClassesMockData {
    val classesList = listOf(
        ClassesDTO(
            "History",
            "8.00-8.45",
            "Mrs. Thomas", null, true
        ),
        ClassesDTO(
            "Literature",
            "9.00-9.45",
            "Mrs. Barros", null, false
        ),
        ClassesDTO(
            "Physical Education",
            "10.00-11.35",
            "Mr. Barros",
            "Intense preparation for The Junior World Championship in Los Angeles",
            false, isFacultative = true
        ),
        ClassesDTO(
            "Chemistry",
            "12.00-12.45",
            "Mrs. Curie",
            "Students, I kindly request that you prepare thoroughly " +
                    "for the new topic in the lesson - Radioactivity",
            false
        ),
        ClassesDTO(
            "Physics",
            "13.00-13.45",
            "Mr. Einstein",
            "Today's lecture theme hint: It's all relative",
            true, isFacultative = true
        ),
        ClassesDTO(
            "Math",
            "14.00-14.45",
            "Mr. Fon Neyman",
            "Bring a calculator",
            true
        )
    )
}