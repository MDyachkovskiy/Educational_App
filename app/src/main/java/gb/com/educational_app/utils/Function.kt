package gb.com.educational_app.utils

import gb.com.educational_app.R
import gb.com.educational_app.model.datasource.Classes
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun getIconBasedOnClassName(className: String): Int {
    return when(className) {
        "Math" -> R.drawable.ic_math_class
        "Physics" -> R.drawable.ic_physic_class
        "Chemistry" -> R.drawable.ic_chemistry_class
        "History" -> R.drawable.ic_history_class
        "Literature" -> R.drawable.ic_literature_class
        "Physical Education" -> R.drawable.ic_physical_education_class
        else -> R.drawable.ic_math_class
    }
}

fun findCurrentClassPosition(classesList: List<Classes>): Int {
    val currentTime = LocalTime.now()
    var nextClassIndex = -1
    for((index, classes) in classesList.withIndex()){
        val(startTimeStr, endTimeStr) = classes.classTime.split("-")
        val timeFormat = DateTimeFormatter.ofPattern("H.mm")
        val startTime = LocalTime.parse(startTimeStr.trim(), timeFormat)
        val endTime = LocalTime.parse(endTimeStr.trim(), timeFormat)

        if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
            return index
        } else if (currentTime.isBefore(startTime) && nextClassIndex == -1) {
            nextClassIndex = index
        }
    }
    return nextClassIndex
}