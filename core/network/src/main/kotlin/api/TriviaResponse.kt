package api

import model.Question

data class TriviaResponse(
    val response_code: Int,
    val results: List<Question>
)