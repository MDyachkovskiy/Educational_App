package gb.com.educational_app.utils

import gb.com.educational_app.R

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