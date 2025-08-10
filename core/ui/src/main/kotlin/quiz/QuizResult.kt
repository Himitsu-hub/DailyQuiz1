package quiz

import Black
import Blue400
import Gray100
import White
import Yellow
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.alemak.core.ui.R
import interBlack
import interBold
import interRegular


@Preview(showBackground = false)
@Composable
fun QuizResultPreview() {
    QuizResult(0) {}
}

@Composable
fun QuizResult(rating: Int, onButtonClick: () -> Unit) {
    var starsCount = rating
    if (rating !in 0..5) starsCount = 0

    val title = when (starsCount) {
        1 -> "Сложный вопрос?"
        2 -> "Есть над чем поработать"
        3 -> "Хороший результат!"
        4 -> "Почти идеально!"
        5 -> "Идеально!"
        else -> "Бывает и так!"
    }
    val text = when (starsCount) {
        1 -> "1/5 — иногда просто не ваш день. \nСледующая попытка будет лучше!"
        2 -> "2/5 — не расстраивайтесь, \nпопробуйте ещё раз!"
        3 -> "3/5 — вы на верном пути. \nПродолжайте тренироваться!"
        4 -> "4/5 — очень близко \nк совершенству. Ещё один шаг!"
        5 -> "5/5 — вы ответили на всё правильно. \nЭто блестящий результат!"
        else -> "0/5 — не отчаивайтесь. \nНачните заново и удивите себя!"
    }
    Box(
        modifier = Modifier
            .width(320.dp)
            .height(342.dp)
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
            StarRating(starsCount, size = 46.dp, starSpacer = 4.dp)
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = "$starsCount из 5",
                style = interBold,
                fontWeight = FontWeight.W700,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Yellow
            )

            Spacer(modifier = Modifier.size(24.dp))

            Text(
                text = title,
                style = interBold,
                textAlign = TextAlign.Center,
                color = Black
            )

            Spacer(modifier = Modifier.size(12.dp))

            Text(
                text = text,
                style = interRegular,
                fontSize = 14.sp,
                lineHeight = 18.sp,
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
                    text = "НАЧАТЬ ЗАНОВО",
                    style = interBlack,
                    color = White
                )
            }
        }
    }
}

@Composable
fun StarRating(rating: Int, size:Dp, starSpacer:Dp) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(starSpacer),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
    ) {
        repeat(5) { index ->
            var starColor = if (index < rating) R.drawable.star_active else R.drawable.star_gray

            if (rating !in 0..5) starColor = R.drawable.star_gray
            Image(
                painter = painterResource(id = starColor),
                contentDescription = null,
                modifier = Modifier.size(size)
            )
        }
    }
}
