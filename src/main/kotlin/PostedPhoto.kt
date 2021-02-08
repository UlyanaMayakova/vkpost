 class PostedPhoto (
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo604: String
) : Attachment(type = "postedPhoto") {
//     override fun secondProp(attachment: Attachment) {
//         super.secondProp(attachment as PostedPhoto)
//     }
}