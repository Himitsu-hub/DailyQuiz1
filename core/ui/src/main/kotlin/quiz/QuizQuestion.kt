package quiz

import Black
import Blue100
import DefaultAnswerOption
import SelectedAnswerOption
import White
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import buttons.BlueFinishButton
import buttons.BlueNextButton
import buttons.DefaultNextButton
import interBold
import interRegular


@Preview(showBackground = false)
@Composable
fun QuizQuestionPreview() {
    QuizQuestion(
        1, "Как переводится слово «apple»?",
        mapOf("test" to true, "test2" to true, "test3" to true, "test4" to true),
        "test2",
        onVariantSelectedClick = {},
        onNextButtonClick = {}
    )
}

@Composable
fun QuizQuestion(
    questionNumber: Int,
    title: String,
    variants: Map<String, Boolean>,
    selectedVariant:String,
    onVariantSelectedClick:(String) -> Unit,
    onNextButtonClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(320.dp)
            .heightIn(min = 548.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(White),
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Вопрос $questionNumber из 5",
                style = interBold,
                fontSize = 16.sp,
                fontWeight = FontWeight.W700,
                color = Blue100
            )
            Spacer(modifier = Modifier.size(24.dp))
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
                if (selectedVariant == variantText)
                    SelectedAnswerOption(variantText) {}
                else
                    DefaultAnswerOption(variantText) { onVariantSelectedClick(variantText) }
                Spacer(modifier = Modifier.size(16.dp))
            }
            Spacer(modifier = Modifier.size(51.dp))
            if (selectedVariant.isEmpty())
                DefaultNextButton {}
            else {
                if (questionNumber == 5)
                    BlueFinishButton(onNextButtonClick)
                else
                    BlueNextButton(onNextButtonClick)
            }
        }
    }
}

