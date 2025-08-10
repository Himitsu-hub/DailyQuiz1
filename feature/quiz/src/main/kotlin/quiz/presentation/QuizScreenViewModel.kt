package quiz.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import model.Question
import quiz.model.QuizRepository
import javax.inject.Inject

@HiltViewModel
class QuizScreenViewModel @Inject constructor(private val quizRepository: QuizRepository) :
    ViewModel() {
    private val questions = MutableStateFlow<List<Question>>(emptyList())

    private val selectedVariants = MutableStateFlow<MutableMap<Question, String>>(mutableMapOf())

    private val _currentSelectedVariant = MutableStateFlow("")
    val currentSelectedVariant: StateFlow<String> = _currentSelectedVariant.asStateFlow()

    private val _currentQuestionIndex = MutableStateFlow(0)
    val currentQuestionIndex: StateFlow<Int> = _currentQuestionIndex.asStateFlow()

    private val _currentQuestionTitle = MutableStateFlow("")
    val currentQuestionTitle: StateFlow<String> = _currentQuestionTitle.asStateFlow()

    private val _currentQuestionVariants = MutableStateFlow(mapOf("" to false))
    val currentQuestionVariants: StateFlow<Map<String, Boolean>> =
        _currentQuestionVariants.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _isFinished = MutableStateFlow(false)
    val isFinished: StateFlow<Boolean> = _isFinished

    private val _rating = MutableStateFlow(0)
    val rating: StateFlow<Int> = _rating.asStateFlow()

    init {
        fetchQuestions()
    }

    fun fetchQuestions() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    quizRepository.fetchQuizQuestions()
                }
                questions.value = response.results

                clearSelectedVariants()
                setDefaultCurrentIndex()
                setDefaultCurrentSelectedVariant()
                _isFinished.value = false
                _rating.value = 0

                updateCurrentQuestionTitle()
                updateCurrentQuestionVariants()

                delay(2000)
                _isLoading.value = false
            } catch (e: Exception) {
                Log.d("QUIZVIEWMODEL", e.message!!)
                _isLoading.value = false
            }
        }
    }

    fun nextQuestion() {
        if (_currentQuestionIndex.value < questions.value.size - 1) {
            updateCurrentIndex()
            updateCurrentQuestionTitle()
            updateCurrentQuestionVariants()
            setDefaultCurrentSelectedVariant()
        }
        if (selectedVariants.value.count() == questions.value.size) finishQuiz()
    }

    private fun setDefaultCurrentSelectedVariant() {
        _currentSelectedVariant.value = ""
    }

    fun updateSelectedVariants(selectedVariant: String) {
        _currentSelectedVariant.value = selectedVariant
        selectedVariants.value += questions.value[currentQuestionIndex.value] to selectedVariant
    }

    private fun clearSelectedVariants() {
        selectedVariants.value = mutableMapOf()
    }

    private fun setDefaultCurrentIndex() {
        _currentQuestionIndex.value = 0
    }

    private fun updateCurrentIndex() = _currentQuestionIndex.value++

    private fun updateCurrentQuestionTitle() {
        _currentQuestionTitle.value = questions.value[currentQuestionIndex.value].question
    }

    private fun updateCurrentQuestionVariants() {
        val currentQuestion: Question = questions.value[currentQuestionIndex.value]
         val answers = mapOf(
            currentQuestion.correct_answer to true,
            *currentQuestion.incorrect_answers.map { it to false }.toTypedArray()
        )
        _currentQuestionVariants.value = answers.entries.shuffled().associate { it.toPair() }
    }

    private fun calculateRating() {
        var rating = 0
        selectedVariants.value.forEach {
            val rightAnswer = it.key.correct_answer
            val selectedAnswer = it.value
            if (selectedAnswer == rightAnswer) rating++
        }
        _rating.value = rating
    }

    private fun finishQuiz() {
        calculateRating()
        _isFinished.value = true
        Log.d("QUIZVIEWMODEL", selectedVariants.value.toString())
    }
}