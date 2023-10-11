package gb.com.educational_app.model.datasource

object ClassesMockData {
    val classesList = listOf(
        Classes(
            "History",
            "8.00-8.45",
            "Mrs. Thomas", null, true),
        Classes(
            "Literature",
            "9.00-9.45",
            "Mrs. Barros", null, false),
        Classes(
            "Physical Education",
            "10.00-11.35",
            "Mr. Barros",
            "Intense preparation for The Junior World Championship in Los Angeles",
            false),
        Classes(
            "Chemistry",
        "12.00-12.45",
            "Mrs. Curie",
        "Students, I kindly request that you prepare thoroughly " +
                "for the new topic in the lesson - Radioactivity",
            false
        ),
        Classes(
            "Physics",
            "13.00-13.45",
            "Mr. Einstein",
            "Today's lecture theme hint: It's all relative",
            true
        ),
        Classes(
            "Math",
            "14.00-14.45",
            "Mr. Fon Neyman",
            "Bring a calculator",
            true
        )
    )
}