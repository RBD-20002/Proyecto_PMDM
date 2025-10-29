import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm.Ricardo.TextComponent

@Composable
fun TextFieldComponent(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    placeholder: (@Composable () -> Unit)? = null, //<- texto que se pone en caso que este vacio
    shape: Shape = TextFieldDefaults.shape
){
    val focusManager = LocalFocusManager.current

    Box() {
        TextField(
            state = state,
            modifier = modifier.padding(1.dp),
            placeholder = placeholder,
            shape = RoundedCornerShape(20.dp)

            /*
            //Evita salto de línea
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done // cambia "Enter" por "Done"
            ),

            //Cierra teclado al presionar "Done"
            keyboardActions = androidx.compose.foundation.text.KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
            */
        )
    }
}


@Preview
@Composable
fun previewTextField(){
    val state = remember { TextFieldState() }
    TextFieldComponent(
        state = state,
        placeholder = {
            TextComponent("USUARIO O CORREO ELECTRONICO",15.sp, Color.White)
        },
        modifier = Modifier
            .width(2000.dp)
    )
}
