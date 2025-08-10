package quiz.model

import api.TriviaResponse

interface QuizRepository {
    suspend fun fetchQuizQuestions(): TriviaResponse
    suspend fun saveQuizResult(result: String)
}