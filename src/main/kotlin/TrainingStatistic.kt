import java.util.Date

data class TrainingStatistic(
    val id: Long = 0L,
    val results: MutableList<TrainingResult>,
) {
    fun getStatisticByDate(date: Date) =
        results.filter {
            it.trainingDate.year == date.year && it.trainingDate.month == date.month && it.trainingDate.day == date.day
        }
    fun addResult(trainingResult: TrainingResult){
        results.add(trainingResult)
    }

    fun getLastMistakes() = results.last().mistakes.map { it.toUserWord() }
}