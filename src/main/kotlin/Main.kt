val firstPost = Post(
    id = 1,
    ownerId = 123,
    fromId = 321,
    date = 1611307716,
    text = "Это первая запись",
    comments = Comments(count = 1, canClose = false, canOpen = false),
    copyright = Copyright(id = 234, "link.com", "That Group", "post"),
    likes = Likes(count = 12, userLike = false, canLike = true),
    reposts = Reposts(count = 3),
    views = Views(count = 100),
    postType = PostType.POST,
    canPin = false,
    canDelete = false,
    canEdit = false,
    isFavourite = true,
    donut = Donut(isDonut = true, paidDuration = 1234567890, editMode = EditMode.DURATION)
)

fun main() {
    WallService.add(firstPost)
    print(firstPost)
}