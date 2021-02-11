import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun createCommentWorking() {
        val service = WallService()

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
            donut = Donut(isDonut = true, paidDuration = 1234567890, editMode = EditMode.DURATION))

        val newComment = Comment(
            id = 123,
            ownerId = 987,
            fromId = 984,
            postId = 0,
            date = 123456789,
            text = "Cool post"
        )

        service.add(firstPost)
        service.createComment(newComment)
    }

    @Test (expected = PostNotFoundException::class)
    fun createCommentThrowing() {
        val service = WallService()

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
            donut = Donut(isDonut = true, paidDuration = 1234567890, editMode = EditMode.DURATION))

        val newComment = Comment(
            id = 123,
            ownerId = 987,
            fromId = 984,
            postId = 2,
            date = 123456789,
            text = "Cool post"
        )

        service.add(firstPost)
        service.createComment(newComment)
    }

    @Test
    fun add() {
        val service = WallService()

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

        val post = service.add(firstPost)
        val result = post.id
        assertNotEquals(-1, result)
    }

    @Test
    fun updateExisting() {
        val service = WallService()

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
            id = 0,
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

        service.add(firstPost)
        val result = service.update(secondPost)

        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        val service = WallService()

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
            id = 4,
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

        service.add(firstPost)
        val result = service.update(secondPost)

        assertFalse(result)
    }
}