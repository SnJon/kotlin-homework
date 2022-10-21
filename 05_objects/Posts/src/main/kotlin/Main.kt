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

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun likeById(id: Int) {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(likes = post.likes + 1)
            }
        }
    }

    fun printPosts() {
        println(posts.contentToString())
    }
}

fun main() {
    val firstPost = Post(1, 11, "First post", likes = 0)
    val secondPost = Post(2, 22, "Second post", likes = 0)

    WallService.add(firstPost)
    WallService.add(secondPost)
    WallService.likeById(1)
    WallService.printPosts()
}
