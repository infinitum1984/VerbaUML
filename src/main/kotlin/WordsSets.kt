data class WordsSets(
    val wordsSets: List<Words>
){
    fun getSetsByLanguage(language: Language) =
        wordsSets.filter { language.languageName == it.learningLanguage.languageName }
}