import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.R
import com.example.pmdm.Components.DataProfileComponent
import com.example.pmdm.Components.FavColumnDisplay
import com.example.pmdm.Components.PreviewFieldConfig
import com.example.pmdm.Components.ProfileCard
import com.example.pmdm.model.CardConfig


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
fun ProfilePage(
    profileData: List<PreviewFieldConfig>,
    favorites: List<CardConfig>,
    canEdit: Boolean,
    navController: NavController,
) {
    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.login_page),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )

        LazyColumn {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Profile card
                    ProfileCard(
                        cardConfig = CardConfig(
                            id = 1,
                            imageId = R.drawable.crocs,
                            imageDesc = "crocs",
                            title = profileData.firstOrNull()?.value ?: "Usuario",
                            synopsis = "",
                            info = ""
                        )
                    )

                    // Datos del usuario
                    DataProfileComponent(
                        title = "DATOS USUARIO",
                        items = profileData,
                        borderColor = Color.White
                    )

                    // Favoritos
                    FavColumnDisplay(
                        favorites = favorites,
                        navController = navController
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
@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    val sampleProfile = listOf(
        PreviewFieldConfig("USER:", "NicoDev"),
        PreviewFieldConfig("EMAIL:", "nico@example.com"),
        PreviewFieldConfig("PASS:", "********"),
        PreviewFieldConfig("ROLE:", "Premium")
    )

    val sampleFav = listOf(
        CardConfig(1, R.drawable.naruto, "Naruto", "Naruto", "", ""),
        CardConfig(2, R.drawable.onepiece, "One Piece", "One Piece", "", "")
    )

    ProfilePage(
        profileData = sampleProfile,
        favorites = sampleFav,
        canEdit = true,
        navController = rememberNavController()
    )
}
