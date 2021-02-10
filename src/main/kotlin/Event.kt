data class Event (
    val id: Int,
    val time: Int,
    val memberStatus: Int,
    val isFavourite: Boolean,
    val address: String,
    val text: String,
    val buttonText: String,
    val friends: IntArray
)