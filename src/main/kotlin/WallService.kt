object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        post.id = posts.indexOf(post)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val postId = post.id
        try {
            if (post.id == posts[postId].id) {
                val previousPost = posts[postId]
                val newPost = post.copy(ownerId = previousPost.ownerId, date = previousPost.date)
                posts[postId] = newPost
                return true
            }
        } catch (e: ArrayIndexOutOfBoundsException) {

        }
        return false
    }
}