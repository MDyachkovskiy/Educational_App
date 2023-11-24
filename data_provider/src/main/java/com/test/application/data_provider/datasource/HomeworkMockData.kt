package com.test.application.data_provider.datasource

import com.test.application.data_provider.dto.HomeworkDTO
import java.util.Calendar

object HomeworkMockData {
    val homeworkList = listOf(
        HomeworkDTO("Literature",
            "Read scenes 1.1-1.12 of The Master and Margarita",
            Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, 2) }
        ),
        HomeworkDTO("Physics",
            "Calculate the work done by a force of 10 N moving an object over a distance of 5 m",
            Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, 3) }
        ),
        HomeworkDTO("Chemistry",
            "Describe the process of electrolysis of water and write the chemical " +
                    "equations associated with it.",
            Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, 2) }
        ),
        HomeworkDTO("History",
            "Write a brief essay about the impact of World War I on the " +
                    "geopolitical structure of Europe.",
            Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, 4) }
        ),
        HomeworkDTO("Math",
            "Solve the quadratic equations from paragraph 5.6 and graph its solutions on the number line.",
            Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, 5) }
        )
    )
}