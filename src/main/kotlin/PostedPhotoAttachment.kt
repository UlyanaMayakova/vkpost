class PostedPhotoAttachment (
    override val type: String = "postedPhoto",
    val postedPhoto: PostedPhoto
) : Attachment