package gb.com.educational_app.model.datasource

data class Classes(
    val className: String,
    val classTime: String,
    val teacher: String,
    val comments: String?,
    val isOnline: Boolean = false
)