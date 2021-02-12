val firstPost = Post(
    id = 0,
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

val secondPost = Post(
    id = 1,
    ownerId = 123456,
    fromId = 654321,
    date = 16113077165689,
    text = "Это вторая запись",
    comments = Comments(count = 3, canClose = true, canOpen = false),
    copyright = Copyright(id = 18234, "link23.com", "Another Group", "superPost"),
    likes = Likes(count = 45, userLike = true, canLike = false),
    reposts = Reposts(count = 18),
    views = Views(count = 1111),
    postType = PostType.REPLY,
    canPin = true,
    canDelete = false,
    canEdit = true,
    isFavourite = true,
    donut = Donut(isDonut = false)
)
val thirdPost = firstPost.copy(id = 4)

val newComment = Comment(
    id = 123,
    ownerId = 987,
    fromId = 984,
    postId = 4,
    date = 123456789,
    text = "Cool post"
)

fun main() {
    val wallService = WallService()
    wallService.add(firstPost)
    wallService.add(secondPost)
    wallService.add(thirdPost)

    println(firstPost)

    var result = wallService.update(secondPost)
    println(result)

    result = wallService.update(thirdPost)
    println(result)

    wallService.createComment(newComment)
}