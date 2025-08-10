package buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.alemak.core.ui.R


@Preview(showBackground = true)
@Composable
fun DefaultRadioButtonPreview() {
    DefaultRadioButton()
}

@Composable
fun DefaultRadioButton() {
    Box(
        modifier = Modifier
            .size(20.dp)
            .clickable(onClick = {}), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.radio_btn_default),
            contentDescription = "Answer selected",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SelectedRadioButtonPreview() {
    SelectedRadioButton()
}

@Composable
fun SelectedRadioButton() {
    Box(
        modifier = Modifier
            .size(20.dp)
            .clickable(onClick = {}), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.radio_btn_selected),
            contentDescription = "Answer selected",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RightRadioButtonPreview() {
    RightRadioButton()
}

@Composable
fun RightRadioButton() {
    Box(
        modifier = Modifier
            .size(20.dp)
            .clickable(onClick = {}), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.radio_btn_right),
            contentDescription = "Answer selected",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WrongRadioButtonPreview() {
    WrongRadioButton()
}

@Composable
fun WrongRadioButton() {
    Box(
        modifier = Modifier
            .size(20.dp)
            .clickable(onClick = {}), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.radio_btn_wrong),
            contentDescription = "Answer selected",
        )
    }
}



