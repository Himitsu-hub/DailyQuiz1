import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import buttons.DefaultRadioButton
import buttons.RightRadioButton
import buttons.SelectedRadioButton
import buttons.WrongRadioButton


@Preview(showBackground = false)
@Composable
fun DefaultAnswerOptionPreview() {
    DefaultAnswerOption("Text") {}
}

@Composable
fun DefaultAnswerOption(text: String, onButtonClick: () -> Unit) {
    Button(
        onClick = { onButtonClick() },
        colors = ButtonColors(
            containerColor = Gray100,
            contentColor = Black,
            disabledContentColor = Gray400,
            disabledContainerColor = Gray400
        ),
        modifier = Modifier
            .width(272.dp)
            .heightIn(min = 52.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            DefaultRadioButton()
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = text,
                style = interRegular,
                color = Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectedAnswerOptionPreview() {
    SelectedAnswerOption("Text") {}
}

@Composable
fun SelectedAnswerOption(text: String, onButtonClick: () -> Unit) {
    Button(
        onClick = onButtonClick,
        colors = ButtonColors(
            containerColor = Color.Transparent,
            contentColor = Blue800,
            disabledContentColor = Gray400,
            disabledContainerColor = Gray400
        ),
        modifier = Modifier
            .width(272.dp)
            .heightIn(min = 52.dp),
        border = BorderStroke(2.dp, Blue800),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            SelectedRadioButton()
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = text,
                style = interRegular
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RightAnswerOptionPreview() {
    RightAnswerOption("Text") {}
}

@Composable
fun RightAnswerOption(text: String, onButtonClick: () -> Unit) {
    Button(
        onClick = onButtonClick,
        colors = ButtonColors(
            containerColor = Color.Transparent,
            contentColor = Green,
            disabledContentColor = Gray400,
            disabledContainerColor = Gray400
        ),
        modifier = Modifier
            .width(272.dp)
            .heightIn(min = 52.dp),
        border = BorderStroke(2.dp, Green),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            RightRadioButton()
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = text,
                style = interRegular
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WrongAnswerOptionPreview() {
    WrongAnswerOption("Text") {}
}

@Composable
fun WrongAnswerOption(text: String, onButtonClick: () -> Unit) {
    Button(
        onClick = onButtonClick,
        colors = ButtonColors(
            containerColor = Color.Transparent,
            contentColor = Red,
            disabledContentColor = Gray400,
            disabledContainerColor = Gray400
        ),
        modifier = Modifier
            .width(272.dp)
            .heightIn(min = 52.dp),
        border = BorderStroke(2.dp, Red),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            WrongRadioButton()
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = text,
                style = interRegular
            )
        }
    }
}
