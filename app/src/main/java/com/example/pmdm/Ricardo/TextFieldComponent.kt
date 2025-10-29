import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldComponent(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    placeholder: (@Composable () -> Unit)? = null, //<- texto que se pone en caso que este vacio
    shape: Shape = TextFieldDefaults.shape
){
    TextField(
        state = state,
        modifier = modifier.padding(1.dp),
        placeholder = placeholder,
        shape = RoundedCornerShape(20.dp)
    )
}

/*
@Preview
@Composable
fun previewTextField(){
    val state = remember { TextFieldState() }
    TextFieldComponent(
        state = state,
        placeholder = {
            TextComponent("USUARIO O CORREO ELECTRONICO",15.sp, Color.LightGray)
        },
        modifier = Modifier
            .width(2000.dp)
    )
}
*/