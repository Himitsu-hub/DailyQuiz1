package quiz

import Black
import Blue800
import Gray100
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import interBold
import interRegular


@Preview(showBackground = false)
@Composable
fun QuizHistoryTryPreview() {
    QuizHistoryTry(5,1, "11 мая", "12:03") {}
}

@Composable
fun QuizHistoryTry(rating: Int,quizNumber:Int, stringDate:String, stringTime:String, onButtonClick: () -> Unit) {
    var starsCount = rating
    if (rating !in 0..5) starsCount = 0

    Box(
        modifier = Modifier
            .width(320.dp)
            .height(104.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(Gray100)
            .clickable { onButtonClick() },
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (modifier = Modifier
                .height(29.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Text(modifier = Modifier
                    .weight(1f),
                    text = "Quiz $quizNumber",
                    style = interBold,
                    fontWeight = FontWeight.W700,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start,
                    color = Blue800
                )
                StarRating(starsCount,size = 16.dp, starSpacer = 8.dp)
            }

            Spacer(modifier = Modifier.size(12.dp))
            Row (modifier = Modifier
                .height(29.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .weight(1f),
                    text = stringDate,
                    style = interRegular,
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    color = Black
                )
                Text(
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .weight(1f),
                    text = stringTime,
                    style = interRegular,
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp,
                    textAlign = TextAlign.End,
                    color = Black
                )
            }
        }
    }
}
