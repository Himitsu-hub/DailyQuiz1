import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow

@Preview(showBackground = false)
@Composable
fun LoaderScreenPreview() {
    val state= remember {  mutableStateOf(true) }
    LoaderScreen(state) {}
}

@Composable
fun LoaderScreen(isLoadingState: State<Boolean>, goToQuizScreen: () -> Unit) {
    if(!isLoadingState.value) goToQuizScreen()
    Scaffold(
        topBar = {
            StatusBar()
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
                    Spacer(modifier = Modifier.size(178.dp))
                    Logo(280.dp, 63.dp)
                    Spacer(modifier = Modifier.size(112.dp))
                    CircularProgressIndicator(
                        modifier = Modifier.width(56.dp),
                        color = White,
                        trackColor = Gray400,
                        strokeWidth = 4.dp
                    )

                }
            }
        })
}
