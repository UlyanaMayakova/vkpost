class WallService {
    var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun add(post: Post): Post {
        val newId = if (posts.isEmpty()) 0 else posts.last().id + 1
        posts += post.copy(id = newId)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, thisPost) in posts.withIndex()) {
            if (thisPost.id == post.id) {
                val thisDate = thisPost.date
                val thisOwnerId = thisPost.ownerId
                posts[index] = post.copy(ownerId = thisOwnerId, date = thisDate)
                return true
            }
        }
        return false
    }

    fun createComment(comment: Comment) {
        var postExists = false
        posts.forEach {
            if (comment.postId == it.id) {
                postExists = true
                comments += comment
            }
        }

        if (!postExists) throw PostNotFoundException("Post is not found!")
    }
}