package com.test.application.core.utils

import android.content.Intent
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.test.application.core.R
import com.test.application.core.domain.Classes

import java.util.Calendar

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
    val currentTime = Calendar.getInstance()
    var nextClassIndex = -1
    for((index, classes) in classesList.withIndex()){
        val(startTimeStr, endTimeStr) = classes.classTime.split("-")

        val startTime = parseTime(startTimeStr)
        val endTime = parseTime(endTimeStr)

        if (currentTime.after(startTime) && currentTime.before(endTime)) {
            return index
        } else if (currentTime.before(startTime) && nextClassIndex == -1) {
            nextClassIndex = index
        }
    }
    return nextClassIndex
}

fun parseTime(timeStr: String): Calendar {
    val parts = timeStr.trim().split(".")
    val hours = parts[0].toInt()
    val minutes = parts[1].toInt()

    return Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, hours)
        set(Calendar.MINUTE, minutes)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }
}

fun openSkype(binding: ViewBinding) {
    val skypePackageName = "com.skype.raider"

    val skypeIntent = Intent(Intent.ACTION_MAIN).apply {
        addCategory(Intent.CATEGORY_LAUNCHER)
        setPackage(skypePackageName)
    }

    val context = binding.root.context

    if(skypeIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(skypeIntent)
    } else {
        Toast.makeText(context,
            "Skype is not installed", Toast.LENGTH_SHORT).show()
    }
}