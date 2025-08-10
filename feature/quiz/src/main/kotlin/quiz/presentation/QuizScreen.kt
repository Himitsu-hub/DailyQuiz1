package quiz.presentation

import Blue400
import BottomBar
import Logo
import StatusBar
import White
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import dev.alemak.core.ui.R
import interRegular
import quiz.QuizQuestion
import quiz.QuizResult


@Composable
fun QuizScreen(
    navController: NavHostController,
    quizViewModel: QuizScreenViewModel
) {
    val questionNumber by quizViewModel.currentQuestionIndex.collectAsState()
    val title by quizViewModel.currentQuestionTitle.collectAsState()
    val variants by quizViewModel.currentQuestionVariants.collectAsState()
    val selectedVariant by quizViewModel.currentSelectedVariant.collectAsState()
    val finished by quizViewModel.isFinished.collectAsState()

    Scaffold(
        topBar = {
            StatusBar()
        },
        bottomBar = {
            BottomBar()
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Blue400)
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Box {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .height(40.dp)
                                .fillMaxWidth()
                        ) {
                            Logo(180.dp, 40.dp)
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier
                                .height(40.dp)
                                .fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.arrow_back_icon),
                                contentDescription = "Arrow back",
                                modifier = Modifier
                                    .padding(start = 20.dp)
                                    .clickable {
                                        navController.navigate("home")
                                        quizViewModel.fetchQuestions()
                                    }
                                    .size(24.dp),
                                tint = White
                            )
                        }
                    }
                    Spacer(modifier = Modifier.size(112.dp))
                    if(finished){
                        val rating by quizViewModel.rating.collectAsState()
                        QuizResult(rating) {
                            navController.navigate("home")
                            quizViewModel.fetchQuestions()
                        }
                    }else {
                        QuizQuestion(
                            questionNumber = questionNumber + 1,
                            title = title,
                            variants = variants,
                            selectedVariant = selectedVariant,
                            onNextButtonClick = { quizViewModel.nextQuestion() },
                            onVariantSelectedClick = { selected ->
                                quizViewModel.updateSelectedVariants(
                                    selected
                                )
                            }
                        )
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(
                        text = "Вернуться к предыдущим вопросам нельзя",
                        style = interRegular,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.W400,
                        color = White
                    )
                }
            }
        })
}