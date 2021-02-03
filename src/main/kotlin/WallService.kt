class WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        val newId = if (posts.isEmpty()) 0 else posts.last().id
        posts += post.copy(id = newId)
        post.id = posts.indexOf(post)
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
}