import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.pmdm.R
import com.example.pmdm.RicardoComponent.CardConfig
import com.example.pmdm.nicolasComponent.DataProfileComponent
import com.example.pmdm.nicolasComponent.PreviewFieldConfig
import com.example.pmdm.nicolasComponent.ProfileCard


@Composable
fun ProfilePage() {
    Box(Modifier.fillMaxSize()) {


        Image(
            painter = painterResource(R.drawable.login_page),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 26.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileCard(
                cardConfig = CardConfig(
                    id = 1,
                    imageId = R.drawable.crocs,
                    imageDesc = "crocs",
                    title = "Nombre Usuario",
                    synopsis = "",
                    info = ""
                )
            )

            Spacer(Modifier.padding(top = 8.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 43.dp)
                    .clickable(onClick = { Log.i("TEST", "click en boton") }),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically

                ) {
                Text(
                    text = "Configurar",
                    modifier = Modifier.padding(),
                    color = Color.White
                )
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Configuración",
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(start = 10.dp, bottom = 10.dp)
                )
            }

                var previewItems = listOf(
                    PreviewFieldConfig("USER:", "NicoDev"),
                    PreviewFieldConfig("EMAIL:", "nico@example.com"),
                    PreviewFieldConfig("PASS:", "********"),
                    PreviewFieldConfig("ROLE:", "Premium")
                )
                DataProfileComponent(
                    title = "DATOS USUARIO",
                    items = previewItems,
                    borderColor = Color.White
                )


        }
    }
}


@Preview
@Composable
fun Preview() {
    ProfilePage()
}