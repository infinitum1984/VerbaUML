import TrainingType.*
import java.util.*

class Training(
    val words: Words,
    val trainingType: TrainingType,
    val user: User,
) {
    fun startTraining(endTrainingCallback: EndTrainingCallback) {
        var iterableWords = words.userWords
        val lisMistake = mutableListOf<Mistake>()

        if (trainingType == LAST_MISTAKES || trainingType == LAST_MISTAKES_REVERS)
            iterableWords = words.trainingStatistic.getLastMistakes()

        for (word in iterableWords) {
            val idealTranslate =
                when (trainingType) {
                    LAST_MISTAKES -> word.translate
                    LAST_MISTAKES_REVERS -> word.translate
                    else -> word.word
                }
            val printedWord = when (trainingType) {
                LAST_MISTAKES -> word.word
                LAST_MISTAKES_REVERS -> word.word
                else -> word.translate
            }
            println("translate word: printedWord")
            val inputStr = readln()
            if (inputStr != idealTranslate) {
                lisMistake.add(word.toMistake(inputStr))
            }
        }
        val trainingResult = TrainingResult(
                0,
                countPercentage(iterableWords.size, lisMistake.size),
                lisMistake,
                Date()
            )
        words.trainingStatistic.addResult(trainingResult)
        endTrainingCallback.end(trainingResult)
    }

    private fun countPercentage(words: Int, mistakes: Int) =
        100 - (mistakes.toDouble() * 100 / words.toDouble()).toInt()
}

interface EndTrainingCallback {
    fun end(result: TrainingResult)
}
