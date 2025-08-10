package buttons

import Black
import Blue400
import Blue800
import Gray400
import White
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import interBlack


@Preview(showBackground = false)
@Composable
fun DefaultNextButtonPreview() {
    DefaultNextButton {}
}

@Composable
fun DefaultNextButton(onButtonClick: () -> Unit) {
    Button(
        onClick = onButtonClick,
        enabled = false,
        colors = ButtonColors(
            containerColor = Gray400,
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
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                text = "ДАЛЕЕ",
                style = interBlack,
                color = White
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun BlueNextButtonPreview() {
    BlueNextButton (){}
}

@Composable
fun BlueNextButton(onButtonClick: () -> Unit) {
    Button(
        onClick = onButtonClick,
        colors = ButtonColors(
            containerColor = Blue400,
            contentColor = Black,
            disabledContentColor = Black,
            disabledContainerColor = Black
        ),
        modifier = Modifier
            .width(272.dp)
            .heightIn(min = 52.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                text = "ДАЛЕЕ",
                style = interBlack,
                color = White
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun WhiteNextButtonPreview() {
    WhiteNextButton {}
}

@Composable
fun WhiteNextButton(onButtonClick: () -> Unit) {
    Button(
        onClick = onButtonClick,
        colors = ButtonColors(
            containerColor = White,
            contentColor = Black,
            disabledContentColor = Black,
            disabledContainerColor = Black
        ),
        modifier = Modifier
            .width(272.dp)
            .heightIn(min = 52.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                text = "ДАЛЕЕ",
                style = interBlack,
                color = Blue800
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun BlueFinishButtonPreview() {
    BlueFinishButton() {}
}

@Composable
fun BlueFinishButton(onButtonClick: () -> Unit) {
    Button(
        onClick =  onButtonClick,
        colors = ButtonColors(
            containerColor = Blue400,
            contentColor = Black,
            disabledContentColor = Black,
            disabledContainerColor = Black
        ),
        modifier = Modifier
            .width(272.dp)
            .heightIn(min = 52.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                text = "ЗАВЕРШИТЬ",
                style = interBlack,
                color = White
            )
        }
    }
}