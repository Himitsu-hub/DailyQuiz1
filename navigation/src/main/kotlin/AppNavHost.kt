import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import quiz.presentation.QuizScreen
import quiz.presentation.QuizScreenViewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    val quizViewModel: QuizScreenViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onStartQuizClick = {
                navController.navigate("loader") {}
            })
        }
        composable("loader") {
            LoaderScreen(quizViewModel.isLoading.collectAsState()) {
                navController.navigate("quiz")
            }
        }
        composable("quiz") { QuizScreen(navController, quizViewModel) }
    }
}