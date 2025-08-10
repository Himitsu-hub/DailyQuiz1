import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.alemak.core.ui.R

@Composable
fun StatusBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Blue400),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "12:31",
            modifier = Modifier
                .padding(start = 20.dp),
            style = interRegular,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            color = White
        )
        Row (
            horizontalArrangement = Arrangement.spacedBy(1.dp),
            modifier = Modifier.padding(end = 20.dp)
        ){
            Icon(
                painter = painterResource(R.drawable.wifi),
                contentDescription = "Clock",
                modifier = Modifier
                    .size(15.dp),
                tint = White
            )
            Icon(
                painter = painterResource(R.drawable.network),
                contentDescription = "Clock",
                modifier = Modifier
                    .size(15.dp),
                tint = White
            )
            Icon(
                painter = painterResource(R.drawable.power),
                contentDescription = "Clock",
                modifier = Modifier
                    .size(15.dp),
                tint = White
            )
        }
    }
}