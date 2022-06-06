data class User(
    val id: Long = 0L,
    val userName: String,
    val name: String,
    val password: String,
    val nativeLanguages: List<NativeLanguage>
)