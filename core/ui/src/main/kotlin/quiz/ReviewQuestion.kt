package quiz

import Black
import DefaultAnswerOption
import Gray400
import RightAnswerOption
import White
import WrongAnswerOption
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.alemak.core.ui.R
import interBold
import interRegular


@Preview(showBackground = false)
@Composable
fun ReviewQuestionPreview() {
    ReviewQuestion(
        1, "Как переводится слово «apple»?",
        mapOf("test" to true, "test2" to true, "test3" to true, "test4" to true),
        "test"
    )
}

@Composable
fun ReviewQuestion(
    questionNumber: Int,
    title: String,
    variants: Map<String, Boolean>,
    selectedVariant: String
) {
    Box(
        modifier = Modifier
            .width(320.dp)
            .height(408.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(White),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .align(Alignment.Start)) {
                Text(
                    text = "Вопрос $questionNumber из 5",
                    style = interBold,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    textAlign = TextAlign.Start,
                    color = Gray400
                )
                Spacer(modifier = Modifier.size(145.dp))
                val painter =  if(variants[selectedVariant]==true)
                    painterResource(id = R.drawable.radio_btn_right)
                else
                    painterResource(id = R.drawable.radio_btn_wrong)

                Image(
                    painter = painter,
                    modifier = Modifier.size(20.dp),
                    contentDescription = "Answer is right",
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = title,
                style = interRegular,
                fontSize = 18.sp,
                fontWeight = FontWeight.W600,
                textAlign = TextAlign.Center,
                color = Black
            )
            Spacer(modifier = Modifier.size(24.dp))
            repeat(4) { index ->
                val variant = variants.entries.elementAt(index)
                val variantText = variant.key
                val variantResult = variant.value
                if (variantText == selectedVariant) {
                    if (variantResult)
                        RightAnswerOption(variantText) { }
                    else
                        WrongAnswerOption(variantText) { }
                } else DefaultAnswerOption(variantText) { }
                Spacer(modifier = Modifier.size(16.dp))

            }
        }
    }
}

