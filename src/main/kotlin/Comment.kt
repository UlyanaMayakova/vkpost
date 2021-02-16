data class Comment (
    val id: Int,
    val fromId: Int = 2,
    val ownerId: Int = 1,
    val postId: Int,
    val date: Int,
    val text: String,
    val donut: Donut? = null,
    val replyToUser: Int? = null,
    val replyToComment: Int? = null,
    val attachment: Array<Attachment> = emptyArray(),
    val parentsStack: Array<Int> = emptyArray(),
    val thread: Thread? = null
)