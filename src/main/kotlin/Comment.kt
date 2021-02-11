data class Comment (
    val id: Int,
    val fromId: Int,
    val ownerId: Int,
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