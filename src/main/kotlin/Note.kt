data class Note (
    val id: Int,
    val ownerId: Int = 1,
    val title: String,
    val text: String,
    val date: Int,
    val comments: Int = 0,
    val readComments: Int? = null,
    val viewUrl: String? = null
)