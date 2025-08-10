import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import buttons.HistoryButton

@Preview(showBackground = false)
@Composable
fun HomeScreenPreview() {
    HomeScreen{}
}

@Composable
fun HomeScreen(onStartQuizClick:()->Unit) {
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
                    Spacer(modifier = Modifier.size(52.dp))
                    HistoryButton { }
                    Spacer(modifier = Modifier.size(116.dp))
                    Logo(280.dp,63.dp)
                    Spacer(modifier = Modifier.size(40.dp))
                    StartQuiz {onStartQuizClick()}
                }
            }
        })
}

@Composable
fun StartQuiz(onButtonClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(320.dp)
            .height(206.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(Gray100),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .padding(top = 24.dp, bottom = 24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Добро пожаловать в DailyQuiz!",
                style = interBold,
                fontSize = 28.sp,
                fontWeight = FontWeight.W700,
                textAlign = TextAlign.Center,
                color = Black
            )

            Spacer(modifier = Modifier.size(40.dp))

            Button(
                onClick = {
                    onButtonClick()
                },
                colors = ButtonColors(
                    containerColor = Blue400,
                    contentColor = Black,
                    disabledContentColor = Black,
                    disabledContainerColor = Black
                ),
                modifier = Modifier
                    .width(260.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Text(
                    text = "НАЧАТЬ ВИКТОРИНУ",
                    style = interBlack,
                    color = White
                )
            }
        }
    }
}

