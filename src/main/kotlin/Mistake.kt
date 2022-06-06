data class Mistake(
    val id: Long = 0L,
    val word: String,
    val translate: String,
    val mistakeInput: String
) {
    fun toUserWord() = UserWord(word = word, translate = translate)
}
