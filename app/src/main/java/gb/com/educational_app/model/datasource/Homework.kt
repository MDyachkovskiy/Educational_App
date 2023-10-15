package gb.com.educational_app.model.datasource

import java.util.Calendar

data class Homework (
    val className: String,
    val description: String,
    val dueTime: Calendar
    )