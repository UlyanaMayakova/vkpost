data class Page (
    val id: Int,
    val groupId: Int,
    val creatorId: Int,
    val title: String,
    val currentUserCanEdit: Boolean,
    val currentUserCanEditAccess: Boolean,
    val whoCanView: Int,
    val whoCanEdit: Int,
    val edited: Int,
    val created: Int,
    val editorId: Int,
    val views: Int,
    val parent: String? = null,
    val parent2: String? = null,
    val source: String? = null,
    val html: String? = null,
    val viewUrl: String
)