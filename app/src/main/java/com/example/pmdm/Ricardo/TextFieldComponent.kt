import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm.Ricardo.TextComponent

@Composable
fun MyTextField(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    placeholder: (@Composable () -> Unit)? = null, //<- texto que se pone en caso que este vacio
    shape: Shape = TextFieldDefaults.shape
){
    TextField(
        state = state,
        modifier = modifier,
        placeholder = placeholder,
        shape = RoundedCornerShape(20.dp)
    )
}

@Preview
@Composable
fun previewTextField(){
    val state = remember { TextFieldState() }
    MyTextField(
        state = state,
        placeholder = {
            TextComponent("USUARIO O CORREO ELECTRONICO",15.sp, Color.LightGray)
        },
        modifier = Modifier
            .width(2000.dp)
    )
}
