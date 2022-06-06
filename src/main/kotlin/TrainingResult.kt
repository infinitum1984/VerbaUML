import java.util.*

data class TrainingResult(
    val id : Long = 0L,
    val successPercentage: Int,
    val mistakes:List<Mistake>,
    val trainingDate: Date,
    )