package quiz.repository

import quiz.model.QuizRepository
import api.TriviaApiService
import api.TriviaResponse
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(private val apiService: TriviaApiService) :
    QuizRepository {
    override suspend fun fetchQuizQuestions(): TriviaResponse {
        return apiService.getQuestions()
    }

    override suspend fun saveQuizResult(result: String) {

    }
}