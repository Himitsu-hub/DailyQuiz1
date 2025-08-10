import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.alemak.core.ui.R

val interRegular = TextStyle(
    fontFamily = FontFamily(Font(R.font.inter_regular)),
    fontWeight = FontWeight.Normal,
    fontStyle = FontStyle.Normal,
    fontSize = 14.sp,
    lineHeight = 14.sp,
    letterSpacing = 0.sp
)

val interBlack = TextStyle(
    fontFamily = FontFamily(Font(R.font.inter_black)),
    fontWeight = FontWeight.W900,
    fontStyle = FontStyle.Normal,
    fontSize = 16.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.sp
)

val interBold = TextStyle(
    fontFamily = FontFamily(Font(R.font.inter_bold)),
    fontWeight = FontWeight.W700,
    fontStyle = FontStyle.Normal,
    fontSize = 24.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.sp
)

val interMedium = TextStyle(
    fontFamily = FontFamily(Font(R.font.inter_medium)),
    fontWeight = FontWeight.W500,
    fontStyle = FontStyle.Normal,
    fontSize = 16.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.sp
)
