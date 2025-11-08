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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.R
import com.example.pmdm.RicardoComponent.CardConfig
import com.example.pmdm.model.DataProvider
import com.example.pmdm.nicolasComponent.DataProfileComponent
import com.example.pmdm.nicolasComponent.FavColumnDisplay
import com.example.pmdm.nicolasComponent.PreviewFieldConfig
import com.example.pmdm.nicolasComponent.ProfileCard

/**
 * Pantalla de perfil del usuario.
 *
 * Este componente compone la vista completa del perfil, incluyendo:
 * - Imagen de fondo difuminada.
 * - Tarjeta superior con la foto y nombre del usuario ([ProfileCard]).
 * - Botón de configuración con icono y texto clicable.
 * - Bloque de datos personales ([DataProfileComponent]) mostrando
 *   información básica del usuario.
 *
 * ### Estructura visual:
 * ```
 * ┌──────────────────────────────┐
 * │     Imagen de fondo          │
 * │ ┌──────────────────────────┐ │
 * │ │ ProfileCard              │ │
 * │ └──────────────────────────┘ │
 * │ Configurar ⚙️                │
 * │ ┌──────────────────────────┐ │
 * │ │ DataProfileComponent     │ │
 * │ └──────────────────────────┘ │
 * └──────────────────────────────┘
 * ```
 *
 * ### Características:
 * - Usa un fondo de imagen (`login_page`) con contenido superpuesto.
 * - Incluye un botón de "Configurar" con log en consola al hacer clic.
 * - Los datos del usuario se generan a partir de una lista de [PreviewFieldConfig].
 *
 * @see ProfileCard
 * @see DataProfileComponent
 */
@Composable
fun ProfilePage() {
    Box(Modifier.fillMaxSize()) {
        // Imagen de fondo a pantalla completa
        Image(
            painter = painterResource(R.drawable.login_page),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
        LazyColumn {
            item {
                // Contenido principal
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
                        Text(text = "Configurar", color = Color.White)
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Configuración",
                            tint = Color.White,
                            modifier = Modifier
                                .size(30.dp)
                                .padding(start = 10.dp, bottom = 10.dp)
                        )
                    }

                    val previewItems = listOf(
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

                    Spacer(Modifier.padding(top = 8.dp))

                    FavColumnDisplay(
                        title = "Tus Favoritos",
                        favorites = DataProvider.animeList.take(15) //TODO: cambiar a los favoritos cuando se sepamos como
                    )
                }
            }
        }


    }
}

/**
 * Vista previa del componente [ProfilePage].
 *
 * Muestra la pantalla de perfil completa en modo de diseño,
 * incluyendo la tarjeta del usuario, el botón de configuración
 * y el bloque de datos personales.
 */
@Preview
@Composable
fun Preview() {
    ProfilePage()
}
