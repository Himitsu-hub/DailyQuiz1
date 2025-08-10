import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.alemak.core.ui.R

@Preview(showBackground = false)
@Composable
fun LogoPreview() {
    Logo(280.dp,63.dp)
}

@Composable
fun Logo(width:Dp, height:Dp) { //280x63
    Box(
        modifier = Modifier
            .width(width)
            .height(height),
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Daily Quiz",
        )
    }
}