data class Post(
    var id: Int,
    val createdBy: Int,
    val text: String,
    val postType: String = "post",
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val markedAsAds: Boolean = false,
    val likes: Int
)

object WallService {

    private var posts = emptyArray<Post>()
    private var postId = 0

    fun add(post: Post): Post {
        post.id = postId + 1
        postId += 1
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val changePost = Post(0, 33, "change post", likes = 0)
        for (iter in posts) {
            if (post.id == iter.id) {
                iter.createdBy == changePost.createdBy
                return true
            }
        }
        return false
    }

    fun printPosts() {
        println(posts.contentToString())
    }
}

fun main() {
    val firstPost = Post(0, 11, "First post", likes = 0)
    val secondPost = Post(0, 22, "Second post", likes = 0)

    WallService.add(firstPost)
    WallService.add(secondPost)

    WallService.printPosts()
    WallService.update(firstPost)
}
