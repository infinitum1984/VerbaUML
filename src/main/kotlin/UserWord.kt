data class UserWord(
    val id: Long = 0L,
    val word: String,
    val translate: String) {
    fun toMistake(mistake: String) =
        Mistake(0L, word, translate, mistake)
}
