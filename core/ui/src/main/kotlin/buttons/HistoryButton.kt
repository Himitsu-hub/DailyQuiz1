package buttons

import Blue400
import White
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.alemak.core.ui.R
import interRegular


@Preview(showBackground = false)
@Composable
fun HistoryButtonPreview() {
    HistoryButton {}
}

@Composable
fun HistoryButton(onButtonClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable(onClick = onButtonClick)
            .clip(RoundedCornerShape(40.dp))
            .background(White)
            .width(103.dp)
            .height(40.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "История",
                style = interRegular,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Blue400
            )
            Spacer(modifier = Modifier.size(12.dp))
            Icon(
                painter = painterResource(id = R.drawable.history_icon),
                modifier = Modifier
                    .size(16.dp),
                tint = Blue400,
                contentDescription = "History",
            )
        }
    }
}