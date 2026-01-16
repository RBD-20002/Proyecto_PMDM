package com.example.pmdm.model

import com.example.pmdm.R
import com.example.pmdm.model.Anime

object DataProvider {

    val favoriteAnime = mutableSetOf<Int>()

    fun filterFavorite(animeId: Int){
        if(favoriteAnime.contains(animeId)){
            favoriteAnime.remove(animeId)
        }else{
            favoriteAnime.add(animeId)
        }
    }

    fun isFavorite(animeId: Int): Boolean{
        return favoriteAnime.contains(animeId)
    }

    fun getListFavoriteAnime(): List<CardConfig> {
        return animeList.filter { favoriteAnime.contains(it.id) }
    }

    val animeList = listOf(
        CardConfig(
            id = 1,
            imageId = R.drawable.naruto,
            imageDesc = "Naruto Uzumaki",
            title = "NARUTO",
            synopsis = "Naruto sigue a un joven ninja marginado, Naruto Uzumaki, que sueña con convertirse en Hokage, el líder de su aldea, para ganar reconocimiento. Lleva dentro al demonio Zorro de Nueve Colas, lo que lo hace temido por muchos. La historia muestra su crecimiento, sus amistades y sus batallas por proteger lo que ama.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Super Poderes, Shounen, Artes Marciales, Comedia, Accion\n\n" +
                    "Studios:\n" +
                    "Pierrot\n\n" +
                    "Temporada:\n" +
                    "Otoño 2002\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "220\n\n" +
                    "Duracion:\n" +
                    "23 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Jueves, 03 de Octubre de 2002",
            enlace1 = "https://www3.animeflv.net/anime/naruto",
            enlace2 = "https://jkanime.net/naruto"
        ),
        CardConfig(
            id = 2,
            imageId = R.drawable.bleach,
            imageDesc = "Ichigo Kurosaki",
            title = "BLEACH",
            synopsis = "Bleach cuenta la historia de Ichigo Kurosaki, un adolescente que obtiene los poderes de una Shinigami, Rukia Kuchiki. Con ellos, debe proteger a los vivos de los espíritus malignos llamados Hollows y guiar almas al más allá. A medida que avanza, descubre conspiraciones y enfrenta enemigos cada vez más poderosos en el mundo espiritual.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Sobrenatural, Super Poderes, Shounen, Comedia, Accion\n\n" +
                    "Studios:\n" +
                    "Pierrot\n\n" +
                    "Temporada:\n" +
                    "Otoño 2004\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "366\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Martes, 05 de Octubre de 2004",
            enlace1 = "https://www3.animeflv.net/anime/bleach-tv",
            enlace2 = "https://jkanime.net/bleach"
        ),
        CardConfig(
            id = 3,
            imageId = R.drawable.dragonball,
            imageDesc = "Goku",
            title = "DRAGON BALL Z",
            synopsis = "Dragon Ball Z narra las batallas de Goku y sus amigos para proteger la Tierra de poderosos enemigos. A lo largo de la serie enfrentan amenazas como los Saiyajin, Freezer, Cell y Majin Buu, mientras Goku alcanza nuevas formas de poder como el Super Saiyajin. Es una historia de superación, amistad y lucha constante por la paz.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Comedia, Fantasia, Artes Marciales, Shounen, Super Poderes\n\n" +
                    "Categoria:\n" +
                    "Latino\n\n" +
                    "Studios:\n" +
                    "Toei Animation\n\n" +
                    "Temporada:\n" +
                    "Invierno 1986\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Latino , Español Latino\n\n" +
                    "Episodios:\n" +
                    "153\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Miercoles, 26 de Febrero de 1986",
            enlace1 = "https://www3.animeflv.net/anime/dragon-ball-z",
            enlace2 = "https://jkanime.net/dragon-ball-z/"
        ),
        CardConfig(
            id = 4,
            imageId = R.drawable.onepiece,
            imageDesc = "Luffy",
            title = "ONE PIECE",
            synopsis = "One Piece sigue a Monkey D. Luffy, un joven pirata que busca el legendario tesoro “One Piece” para convertirse en el Rey de los Piratas. Con su tripulación, los Sombrero de Paja, navega por mares peligrosos enfrentando enemigos, gobiernos corruptos y misterios del mundo, todo guiado por la libertad y los sueños.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Aventura, Comedia, Fantasia, Shounen, Super Poderes\n\n" +
                    "Studios:\n" +
                    "Toei Animation\n\n" +
                    "Temporada:\n" +
                    "Otoño 1999\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "0\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Miercoles, 20 de Octubre de 1999",
            enlace1 = "https://www3.animeflv.net/anime/one-piece-tv",
            enlace2 = "https://jkanime.net/one-piece/"
        ),
        CardConfig(
            id = 5,
            imageId = R.drawable.evangelion,
            imageDesc = "Evangelion",
            title = "EVANGELION",
            synopsis = "Neon Genesis Evangelion sigue a Shinji Ikari, un adolescente reclutado para pilotar un mecha llamado EVA y defender a la humanidad de criaturas llamadas Ángeles. Mientras lucha, enfrenta conflictos psicológicos, traumas y el peso de un mundo al borde del colapso. La serie explora identidad, soledad y el sentido de la existencia.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Psicologico, Sci-Fi, Mecha, Drama, Dementia, Accion\n\n" +
                    "Studios:\n" +
                    "Gainax\n\n" +
                    "Temporada:\n" +
                    "Otoño 1995\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "26\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Martes, 03 de Octubre de 1995",
            enlace1 = "https://www3.animeflv.net/anime/neon-genesis-evangelion",
            enlace2 = "https://jkanime.net/evangelion/"
        ),
        CardConfig(
            id = 6,
            imageId = R.drawable.code_geas,
            imageDesc = "Code Geass",
            title = "CODE GEASS",
            synopsis = "Code Geass sigue a Lelouch Lamperouge, un ex príncipe del Imperio de Britannia que obtiene el poder del “Geass”, capaz de controlar la voluntad de los demás. Con él lidera una rebelión bajo la identidad de Zero para liberar a Japón del dominio imperial. La serie mezcla estrategia, política y dilemas morales sobre poder y justicia.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Militar, Super Poderes, Colegial, Mecha, Accion\n\n" +
                    "Studios:\n" +
                    "Sunrise\n\n" +
                    "Temporada:\n" +
                    "Otoño 2006\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "25\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Viernes, 06 de Octubre de 2006",
            enlace1 = "https://www3.animeflv.net/anime/code-geass",
            enlace2 = "https://jkanime.net/code-geass-hangyaku-no-lelouch/"
        ),
        CardConfig(
            id = 7,
            imageId = R.drawable.hajime_no_ippo,
            imageDesc = "Hajime no Ippo",
            title = "HAJIME NO IPPO",
            synopsis = "Hajime no Ippo sigue a Ippo Makunouchi, un estudiante tímido que descubre su talento para el boxeo tras ser ayudado por un campeón. A través del entrenamiento y la competencia, Ippo aprende sobre fuerza, respeto y perseverancia, enfrentando duros rivales para convertirse en un verdadero boxeador profesional.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Comedia, Drama, Shounen, Deportes\n\n" +
                    "Studios:\n" +
                    "Madhouse\n\n" +
                    "Temporada:\n" +
                    "Otoño 2000\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "75\n\n" +
                    "Duracion:\n" +
                    "23 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Miercoles, 04 de Octubre de 2000",
            enlace1 = "https://www3.animeflv.net/anime/hajime-no-ippo",
            enlace2 = "https://jkanime.net/hajime-no-ippo/"
        ),
        CardConfig(
            id = 8,
            imageId = R.drawable.hellsing,
            imageDesc = "Hellsing",
            title = "HELLSING",
            synopsis = "Hellsing sigue a Alucard, un vampiro inmortal que trabaja para la organización Hellsing, encargada de eliminar amenazas sobrenaturales en Inglaterra. Junto a Integra Hellsing y Seras Victoria, combate monstruos, cultos y una milicia nazi que busca desatar el caos. Es una historia oscura sobre poder, fe y la naturaleza del mal.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Misterio, Terror, Super Poderes, Vampiros, Seinen\n\n" +
                    "Studios:\n" +
                    "Gonzo\n\n" +
                    "Temporada:\n" +
                    "Otoño 2001\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "13\n\n" +
                    "Duracion:\n" +
                    "23 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Jueves, 11 de Octubre de 2001",
            enlace1 = "https://www3.animeflv.net/anime/hellsing",
            enlace2 = "https://jkanime.net/hellsing/"
        ),
        CardConfig(
            id = 9,
            imageId = R.drawable.gachiakuta,
            imageDesc = "Gachiakuta",
            title = "GACHIAKUTA",
            synopsis = "Gachiakuta sigue a Rudo, un joven marginado que vive en un mundo donde los “impuros” y la basura son arrojados al Abismo. Tras ser acusado falsamente de asesinato, cae al fondo y descubre una sociedad olvidada que transforma desechos en armas llamadas Jinki. Busca justicia, venganza y la verdad sobre su mundo corrupto.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Fantasia\n\n" +
                    "Studios:\n" +
                    "Bones Film\n\n" +
                    "Temporada:\n" +
                    "Verano 2025\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "24\n\n" +
                    "Duracion:\n" +
                    "24 min.\n\n" +
                    "Emitido:\n" +
                    "Domingo, 06 de Julio de 2025",
            enlace1 = "https://www3.animeflv.net/anime/gachiakuta",
            enlace2 = "https://jkanime.net/gachiakuta/"
        ),
        CardConfig(
            id = 10,
            imageId = R.drawable.tokyo_revengers,
            imageDesc = "Tokyo Revengers",
            title = "TOKYO REVENGERS",
            synopsis = "Tokyo Revengers sigue a Takemichi Hanagaki, un joven fracasado que descubre que puede viajar al pasado tras la muerte de su exnovia. Decide usar esa habilidad para cambiar el rumbo de su vida y evitar tragedias, infiltrándose en pandillas juveniles. La historia combina acción, redención y segundas oportunidades.",
            info = "Tipo:\n" +
                    "Serie\n" +
                    "Generos:\n" +
                    "Sobrenatural, Shounen, Drama, Accion\n\n" +
                    "Studios:\n" +
                    "LIDENFILMS\n\n" +
                    "Temporada:\n" +
                    "Otoño 2023\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "13\n\n" +
                    "Duracion:\n" +
                    "24 min.\n\n" +
                    "Emitido:\n" +
                    "Miercoles, 04 de Octubre de 2023",
            enlace1 = "https://www3.animeflv.net/anime/tokyo-revengers",
            enlace2 = "https://jkanime.net/tokyo-revengers/"
        ),
        CardConfig(
            id = 11,
            imageId = R.drawable.mob_psycho,
            imageDesc = "Mob Psycho 100",
            title = "MOB PSYCHO 100",
            synopsis = "Mob Psycho 100 sigue a Shigeo “Mob” Kageyama, un estudiante con poderes psíquicos inmensos que intenta llevar una vida normal y controlar sus emociones. Trabaja para un supuesto exorcista sin poderes mientras enfrenta espíritus, enemigos psíquicos y su propio crecimiento personal. La historia combina acción y reflexión sobre identidad y autocontrol.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Sobrenatural, Cosas de la vida, Shounen, Comedia, Accion\n\n" +
                    "Studios:\n" +
                    "Bones\n\n" +
                    "Temporada:\n" +
                    "Verano 2016\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "12\n\n" +
                    "Duracion:\n" +
                    "24 min por episodio.\n\n" +
                    "Emitido:\n" +
                    "Lunes, 11 de Julio de 2016",
            enlace1 = "https://www3.animeflv.net/anime/mob-psycho-100",
            enlace2 = "https://jkanime.net/mob-psycho-100/"
        ),
        CardConfig(
            id = 12,
            imageId = R.drawable.kaijuu_8gou,
            imageDesc = "Kaijuu 8-gou",
            title = "KAIJUU 8-GOU",
            synopsis = "Kaijuu 8-gou sigue a Kafka Hibino, un hombre de 32 años que trabaja limpiando los restos de monstruos gigantes que atacan Japón. Tras un encuentro inesperado, obtiene la habilidad de transformarse en un kaijuu. Decide usar este poder para cumplir su sueño de unirse a las Fuerzas de Defensa y luchar contra las criaturas que antes solo podía observar.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Ciencia Ficcion, Monstruos, Shounen\n\n" +
                    "Studios:\n" +
                    "Production I.G\n\n" +
                    "Temporada:\n" +
                    "Primavera 2024\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "12\n\n" +
                    "Duracion:\n" +
                    "23 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Sabado, 13 de Abril de 2024",
            enlace1 = "https://www3.animeflv.net/anime/kaijuu-8gou",
            enlace2 = "https://jkanime.net/kaijuu-8-gou/"
        ),
        CardConfig(
            id = 13,
            imageId = R.drawable.shingeki_no_kyojin,
            imageDesc = "Shingeki no Kyojin",
            title = "SHINGEKI NO KYOJIN",
            synopsis = "Shingeki no Kyojin sigue a Eren Jaeger, un joven que vive en un mundo asediado por titanes, gigantes que devoran humanos. Tras la destrucción de su hogar y la muerte de su madre, jura exterminarlos. La historia revela oscuros secretos sobre la humanidad, los titanes y la verdadera naturaleza del mundo en una narrativa intensa y trágica.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Drama, Fantasia, Misterio, Militar, Shounen\n\n" +
                    "Studios:\n" +
                    "Wit Studio, MAPPA\n\n" +
                    "Temporada:\n" +
                    "Primavera 2013\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "75 + Final\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Domingo, 07 de Abril de 2013",
            enlace1 = "https://www3.animeflv.net/anime/shingeki-no-kyojin",
            enlace2 ="https://jkanime.net/shingeki-no-kyojin/"
        ),
        CardConfig(
            id = 14,
            imageId = R.drawable.tokyo_ghoul,
            imageDesc = "Tokyo Ghoul",
            title = "TOKYO GHOUL",
            synopsis = "Tokyo Ghoul sigue a Ken Kaneki, un estudiante universitario que tras un accidente recibe los órganos de un ghoul, una criatura que se alimenta de carne humana. Convertido en mitad humano, mitad ghoul, debe aprender a sobrevivir entre ambos mundos mientras lucha por mantener su humanidad en una sociedad dividida y violenta.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Misterio, Terror, Psicologico, Drama, Seinen\n\n" +
                    "Studios:\n" +
                    "Pierrot\n\n" +
                    "Temporada:\n" +
                    "Verano 2014\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "12\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Jueves, 04 de Julio de 2014",
            enlace1 = "https://www3.animeflv.net/anime/tokyo-ghoul",
            enlace2 = "https://jkanime.net/tokyo-ghoul/"
        ),
        CardConfig(
            id = 15,
            imageId = R.drawable.death_note,
            imageDesc = "Death Note",
            title = "DEATH NOTE",
            synopsis = "Death Note sigue a Light Yagami, un estudiante prodigio que encuentra un cuaderno con el poder de matar a cualquiera cuyo nombre se escriba en él. Bajo el alias de Kira, busca crear un mundo libre de criminales, pero su justicia retorcida lo enfrenta a L, un enigmático detective decidido a detenerlo.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Misterio, Psicologico, Sobrenatural, Thriller, Shounen\n\n" +
                    "Studios:\n" +
                    "Madhouse\n\n" +
                    "Temporada:\n" +
                    "Otoño 2006\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "37\n\n" +
                    "Duracion:\n" +
                    "23 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Martes, 03 de Octubre de 2006",
            enlace1 = "https://www3.animeflv.net/anime/death-note",
            enlace2 = "https://jkanime.net/death-note/"
        ),
        CardConfig(
            id = 16,
            imageId = R.drawable.monster,
            imageDesc = "Monster",
            title = "MONSTER",
            synopsis = "Monster sigue al neurocirujano Kenzo Tenma, quien salva la vida de un niño herido que luego se convierte en un asesino en serie. Años después, Tenma se ve envuelto en una oscura conspiración mientras busca detener al monstruo que él mismo salvó. La historia explora la moralidad, la culpa y la naturaleza del mal.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Misterio, Psicologico, Drama, Crimen, Thriller, Seinen\n\n" +
                    "Studios:\n" +
                    "Madhouse\n\n" +
                    "Temporada:\n" +
                    "Primavera 2004\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "74\n\n" +
                    "Duracion:\n" +
                    "23 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Martes, 06 de Abril de 2004",
            enlace1 = "https://www3.animeflv.net/anime/monster",
            enlace2 = "https://jkanime.net/monster/"
        ),
        CardConfig(
            id = 17,
            imageId = R.drawable.berserk,
            imageDesc = "Berserk",
            title = "BERSERK",
            synopsis = "Berserk sigue a Guts, un guerrero solitario que viaja por un mundo medieval brutal dominado por demonios y corrupción. Tras ser traicionado por su antiguo camarada Griffith, jura venganza mientras lucha contra monstruos y su propio destino marcado por una maldición. Es una historia de violencia, ambición y supervivencia.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Aventura, Fantasia, Drama, Horror, Seinen\n\n" +
                    "Studios:\n" +
                    "OLM\n\n" +
                    "Temporada:\n" +
                    "Invierno 1997\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "25\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Miercoles, 08 de Octubre de 1997",
            enlace1 = "https://www3.animeflv.net/anime/berserk",
            enlace2 = "https://jkanime.net/berserk/"
        ),
        CardConfig(
            id = 18,
            imageId = R.drawable.another,
            imageDesc = "Another",
            title = "ANOTHER",
            synopsis = "Another sigue a Koichi Sakakibara, un estudiante que se transfiere a una escuela donde una clase está maldita. Un misterioso fenómeno causa muertes horribles entre los alumnos y sus familias. Junto a su compañera Mei Misaki, intenta descubrir el origen de la maldición y detenerla antes de que todos mueran.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Terror, Misterio, Sobrenatural, Thriller, Escolar\n\n" +
                    "Studios:\n" +
                    "P.A. Works\n\n" +
                    "Temporada:\n" +
                    "Invierno 2012\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "12\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Martes, 10 de Enero de 2012",
            enlace1 = "https://www3.animeflv.net/anime/another",
            enlace2 = "https://jkanime.net/another/"
        ),
        CardConfig(
            id = 19,
            imageId = R.drawable.grappler_baki,
            imageDesc = "Grappler Baki",
            title = "GRAPPLER BAKI",
            synopsis = "Grappler Baki sigue a Baki Hanma, un joven luchador decidido a superar a su padre, Yujiro Hanma, el ser más fuerte del mundo. A través de combates brutales y entrenamientos extremos, Baki se enfrenta a poderosos rivales en torneos subterráneos, demostrando su crecimiento físico y mental en la búsqueda de la fuerza absoluta.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Artes Marciales, Deportes, Shounen\n\n" +
                    "Studios:\n" +
                    "Group TAC\n\n" +
                    "Temporada:\n" +
                    "Primavera 2001\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "24\n\n" +
                    "Duracion:\n" +
                    "23 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Martes, 08 de Enero de 2001",
            enlace1 = "https://www3.animeflv.net/anime/drappler-baki",
            enlace2 = "https://jkanime.net/grappler-baki-tv/"
        ),
        CardConfig(
            id = 20,
            imageId = R.drawable.the_god_of_high_school,
            imageDesc = "The God of High School",
            title = "THE GOD OF HIGH SCHOOL",
            synopsis = "The God of High School sigue a Jin Mori, un adolescente que participa en un torneo de artes marciales donde los concursantes luchan usando habilidades sobrenaturales. A medida que avanza la competencia, descubre conspiraciones que amenazan al mundo, y debe enfrentarse a enemigos cada vez más poderosos mientras descubre la verdad sobre su propio pasado.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Artes Marciales, Sobrenatural, Fantasia, Shounen\n\n" +
                    "Studios:\n" +
                    "MAPPA\n\n" +
                    "Temporada:\n" +
                    "Verano 2020\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "13\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Viernes, 06 de Julio de 2020",
            enlace1 = "no disponible",
            enlace2 = "https://jkanime.net/the-god-of-high-school/"
        ),
        CardConfig(
            id = 21,
            imageId = R.drawable.megalo_box,
            imageDesc = "Megalo Box",
            title = "MEGALO BOX",
            synopsis = "Megalo Box sigue a Joe, un boxeador que lucha en combates ilegales usando exoesqueletos mecánicos para mejorar su fuerza. Deseando enfrentar a los mejores sin depender de la tecnología, adopta la identidad de 'Gearless Joe'. La serie explora la lucha por la dignidad, la superación personal y el espíritu del boxeo puro.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Deportes, Drama, Shounen\n\n" +
                    "Studios:\n" +
                    "TMS Entertainment\n\n" +
                    "Temporada:\n" +
                    "Primavera 2018\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "13\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Viernes, 06 de Abril de 2018",
            enlace1 = "https://www3.animeflv.net/anime/megalo-box",
            enlace2 = "https://jkanime.net/megalo-box/"
        ),
        CardConfig(
            id = 22,
            imageId = R.drawable.dororo,
            imageDesc = "Dororo",
            title = "DORORO",
            synopsis = "Dororo sigue a Hyakkimaru, un joven despojado de sus órganos al nacer por un pacto de su padre con demonios, y a Dororo, un niño ladrón que lo acompaña. Juntos viajan enfrentando monstruos y demonios para recuperar las partes perdidas de Hyakkimaru, explorando temas de venganza, humanidad y redención en un Japón feudal oscuro.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Aventura, Fantasia, Historico, Shounen, Sobrenatural\n\n" +
                    "Studios:\n" +
                    "Mappa, Tezuka Productions\n\n" +
                    "Temporada:\n" +
                    "Invierno 2019\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "24\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Domingo, 07 de Enero de 2019",
            enlace1 = "https://www3.animeflv.net/anime/dororo",
            enlace2 = "https://jkanime.net/dororo/"
        ),
        CardConfig(
            id = 23,
            imageId = R.drawable.kimetsu_no_yaiba,
            imageDesc = "Kimetsu no Yaiba",
            title = "KIMETSU NO YAIBA",
            synopsis = "Kimetsu no Yaiba sigue a Tanjiro Kamado, un joven que busca vengar a su familia asesinada por demonios y salvar a su hermana Nezuko, convertida en demonio. Se une al Cuerpo de Exterminio de Demonios y enfrenta enemigos poderosos mientras aprende técnicas de espada y desarrolla su fuerza física y espiritual.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Fantasia, Sobrenatural, Historico, Shounen, Demonios\n\n" +
                    "Studios:\n" +
                    "Ufotable\n\n" +
                    "Temporada:\n" +
                    "Primavera 2019\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "26\n\n" +
                    "Duracion:\n" +
                    "23 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Domingo, 06 de Abril de 2019",
            enlace1 = "https://www3.animeflv.net/anime/kimetsu-no-yaiba",
            enlace2 = "https://jkanime.net/kimetsu-no-yaiba/"
        ),
        CardConfig(
            id = 24,
            imageId = R.drawable.noragami,
            imageDesc = "Noragami",
            title = "NORAGAMI",
            synopsis = "Noragami sigue a Yato, un dios menor que realiza trabajos menores por cinco yen, y a Hiyori Iki, una chica que se convierte en medio espíritu tras un accidente. Juntos enfrentan problemas del mundo espiritual y combaten espíritus maliciosos mientras Yato busca ganar reconocimiento y seguidores para alcanzar su verdadero potencial.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Comedia, Sobrenatural, Fantasia, Shounen\n\n" +
                    "Studios:\n" +
                    "Bones\n\n" +
                    "Temporada:\n" +
                    "Invierno 2014\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "12\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Viernes, 05 de Enero de 2014",
            enlace1 = "https://www3.animeflv.net/anime/noragami",
            enlace2 = "https://jkanime.net/noragami/"
        ),
        CardConfig(
            id = 25,
            imageId = R.drawable.fullmetal_alchemist,
            imageDesc = "Fullmetal Alchemist",
            title = "FULLMETAL ALCHEMIST",
            synopsis = "Fullmetal Alchemist sigue a los hermanos Edward y Alphonse Elric, quienes tras un fallido experimento de alquimia buscan la Piedra Filosofal para recuperar sus cuerpos perdidos. La serie explora temas de sacrificio, ética, guerra y el precio del poder mientras los hermanos enfrentan enemigos y conspiraciones ocultas.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Aventura, Fantasia, Sobrenatural, Shounen, Drama\n\n" +
                    "Studios:\n" +
                    "Bones\n\n" +
                    "Temporada:\n" +
                    "Otoño 2003\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "51\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Sábado, 04 de Octubre de 2003",
            enlace1 = "https://www3.animeflv.net/anime/fullmetal-alchemist-brotherhood",
            enlace2 = "https://jkanime.net/fullmetal-alchemist/"
        ),
        CardConfig(
            id = 26,
            imageId = R.drawable.black_clover,
            imageDesc = "Black Clover",
            title = "BLACK CLOVER",
            synopsis = "Black Clover sigue a Asta, un joven sin poderes mágicos en un mundo donde la magia lo es todo, y a Yuno, su amigo y rival prodigio. Ambos buscan convertirse en el Rey Mago. La serie combina acción, aventuras y desarrollo de habilidades mientras enfrentan enemigos poderosos y desafíos mágicos.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Aventura, Fantasia, Magia, Shounen\n\n" +
                    "Studios:\n" +
                    "Studio Pierrot\n\n" +
                    "Temporada:\n" +
                    "Otoño 2017\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "170+\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Martes, 03 de Octubre de 2017",
            enlace1 = "https://www3.animeflv.net/anime/black-clover-tv",
            enlace2 = "https://jkanime.net/black-clover-tv/"
        ),

        CardConfig(
            id = 27,
            imageId = R.drawable.boku_dake_ga_inai_machi,
            imageDesc = "Boku dake ga Inai Machi",
            title = "BOKU DAKE GA INAI MACHI",
            synopsis = "Boku dake ga Inai Machi sigue a Satoru Fujinuma, un hombre que posee la habilidad de retroceder en el tiempo momentos antes de que ocurra un desastre. Cuando su madre es asesinada, Satoru es enviado al pasado, a su infancia, para prevenir un secuestro que desencadenó una serie de tragedias, enfrentando misterios y peligros mientras intenta cambiar el destino.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Misterio, Sobrenatural, Drama, Thriller, Escolar\n\n" +
                    "Studios:\n" +
                    "A-1 Pictures\n\n" +
                    "Temporada:\n" +
                    "Invierno 2016\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "12\n\n" +
                    "Duracion:\n" +
                    "23 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Viernes, 08 de Enero de 2016",
            enlace1 = "https://www3.animeflv.net/anime/boku-dake-ga-inai-machi",
            enlace2 = "https://jkanime.net/boku-dake-ga-inai-machi/"
        ),
        CardConfig(
            id = 28,
            imageId = R.drawable.charlotte,
            imageDesc = "Charlotte",
            title = "CHARLOTTE",
            synopsis = "Charlotte sigue a Yuu Otosaka, un adolescente que descubre que tiene la habilidad de poseer temporalmente el cuerpo de otros. Reclutado por Nao Tomori, se une a una escuela especial para jóvenes con poderes. La serie mezcla comedia, drama y acción mientras los personajes enfrentan las consecuencias de sus habilidades y buscan proteger a otros con poderes similares.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Sobrenatural, Comedia, Drama, Escolar, Shounen\n\n" +
                    "Studios:\n" +
                    "P.A. Works\n\n" +
                    "Temporada:\n" +
                    "Verano 2015\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "13\n\n" +
                    "Duracion:\n" +
                    "23 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Viernes, 05 de Julio de 2015",
            enlace1 = "https://www3.animeflv.net/anime/charlotte",
            enlace2 = "https://jkanime.net/charlotte-/"
        ),
        CardConfig(
            id = 29,
            imageId = R.drawable.angel_beats,
            imageDesc = "Angel Beats!",
            title = "ANGEL BEATS!",
            synopsis = "Angel Beats! sigue a Otonashi, un joven que despierta en una vida después de la muerte sin recuerdos de su vida pasada. Se une a la SSS, un grupo de estudiantes que luchan contra Angel, una misteriosa chica que controla la escuela, mientras enfrentan traumas y buscan cumplir sus deseos pendientes antes de descansar en paz.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Comedia, Drama, Escolar, Sobrenatural\n\n" +
                    "Studios:\n" +
                    "P.A. Works\n\n" +
                    "Temporada:\n" +
                    "Primavera 2010\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "13\n\n" +
                    "Duracion:\n" +
                    "23 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Viernes, 03 de Abril de 2010",
            enlace1 = "https://www3.animeflv.net/anime/angel-beats",
            enlace2 = "https://jkanime.net/angel-beats/"
        ),
        CardConfig(
            id = 30,
            imageId = R.drawable.death_parade,
            imageDesc = "Death Parade",
            title = "DEATH PARADE",
            synopsis = "Death Parade sigue a Decim, un árbitro en un bar donde las almas recién fallecidas deben competir en juegos para decidir su destino: reencarnación o vacío. La serie explora la naturaleza humana, la moral y las emociones a través de las historias de quienes llegan al bar, revelando secretos y conflictos internos de cada persona.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Drama, Misterio, Psicologico, Sobrenatural, Thriller\n\n" +
                    "Studios:\n" +
                    "Madhouse\n\n" +
                    "Temporada:\n" +
                    "Invierno 2015\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "12\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Viernes, 09 de Enero de 2015",
            enlace1 = "https://www3.animeflv.net/anime/death-parade",
            enlace2 = "https://jkanime.net/death-parade/"
        ),
        CardConfig(
            id = 31,
            imageId = R.drawable.psycho_pass,
            imageDesc = "Psycho-Pass",
            title = "PSYCHO-PASS",
            synopsis = "Psycho-Pass sigue a Akane Tsunemori, una oficial novata en la unidad de crimen del sistema Sybil, que controla la sociedad mediante la medición de la probabilidad de que alguien cometa un crimen. La serie explora justicia, moralidad y control social mientras Akane enfrenta casos complejos y criminales con diferentes motivaciones.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Psicologico, Sci-Fi, Thriller, Seinen\n\n" +
                    "Studios:\n" +
                    "Production I.G\n\n" +
                    "Temporada:\n" +
                    "Otoño 2012\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "22\n\n" +
                    "Duracion:\n" +
                    "23 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Viernes, 12 de Octubre de 2012",
            enlace1 = "https://www3.animeflv.net/anime/psycho-pass",
            enlace2 = "https://jkanime.net/psycho-pass/"
        )
    )
}