data class Words(
    val id:Long = 0L,
    val name:String,
    val userWords:List<UserWord>,
    val trainingStatistic: TrainingStatistic,
    val learningLanguage: LearningLanguage,
    val createdBy: User
)