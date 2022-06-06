import java.util.*

fun main() {
    val learningLanguage = LearningLanguage(name = "English")
    val nativeLanguage = NativeLanguage(name = "Ukrainian")
    val user = User(userName = "vasyl", name = "Vasyl", password = "12345", nativeLanguages = listOf(nativeLanguage))
    val listUserWords = listOf(
        UserWord(0, "test", "test"),
        UserWord(0, "apple", "apple"),
        UserWord(0, "table", "table")
    )
    val words = Words(0, "lesson 1", listUserWords, TrainingStatistic(0, mutableListOf()), learningLanguage, user)
    val wordsSets = WordsSets(listOf(words))
    val englishSet = wordsSets.getSetsByLanguage(learningLanguage)
    val training = Training(englishSet.first(), TrainingType.BASIC, user)
    println(user)
    println(wordsSets)
    println("Test training")
    training.startTraining(object : EndTrainingCallback {
        override fun end(result: TrainingResult) {
            println("$result")
        }
    })
    println(words.trainingStatistic)
    println(words.trainingStatistic.getStatisticByDate(Date()))
}