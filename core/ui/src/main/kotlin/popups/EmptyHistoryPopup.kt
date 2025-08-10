package popups

import Black
import Blue400
import Gray100
import Gray400
import White
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import interBlack
import interRegular


@Preview(showBackground = false)
@Composable
fun EmptyHistoryPopupPreview() {
    EmptyHistoryPopup {}
}

@Composable
fun EmptyHistoryPopup(onButtonClick: () -> Unit) {
    var showPopup by remember { mutableStateOf(true) }

    if (showPopup) {
        Popup {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Gray400),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier
                        .width(320.dp)
                        .height(186.dp)
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
                            text = "Вы еще не проходили \nни одной викторины!",
                            style = interRegular,
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            textAlign = TextAlign.Center,
                            color = Black
                        )

                        Spacer(modifier = Modifier.size(40.dp))

                        Button(
                            onClick = onButtonClick,
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
        }
    }
}