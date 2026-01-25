package com.example.pmdm.model

import com.example.pmdm.R

object DataProvider {

    val favoriteAnime = mutableSetOf<Int>()

    fun filterFavorite(animeId: Int) {
        if (favoriteAnime.contains(animeId)) {
            favoriteAnime.remove(animeId)
        } else {
            favoriteAnime.add(animeId)
        }
    }

    fun isFavorite(animeId: Int): Boolean {
        return favoriteAnime.contains(animeId)
    }

    fun getListFavoriteAnime(): List<Anime> {
        return animeList.filter { favoriteAnime.contains(it.id) }
    }

    val animeList = listOf(
        Anime(
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
        Anime(
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
        Anime(
            id = 3,
            imageId = R.drawable.dragon_ball,
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
        Anime(
            id = 4,
            imageId = R.drawable.one_piece,
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
            enlace2 = "https://jkanime.net/shingeki-no-kyojin/"
        ),
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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

        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        Anime(
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
        ),
        Anime(
            id = 32,
            imageId = R.drawable.rurouni_kenshin,
            imageDesc = "Rurouni Kenshin",
            title = "RUROUNI KENSHIN",
            synopsis = "Rurouni Kenshin sigue a Himura Kenshin, un espadachín que juró nunca volver a matar después de la guerra. Viaja por Japón ayudando a personas necesitadas mientras enfrenta enemigos de su pasado, combinando acción, romance y drama histórico en la era Meiji.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Aventura, Drama, Romance, Shounen\n\n" +
                    "Studios:\n" +
                    "Studio Deen\n\n" +
                    "Temporada:\n" +
                    "Primavera 1996\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "94\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Lunes, 10 de Enero de 1996",
            enlace1 = "https://www3.animeflv.net/anime/rurouni-kenshin",
            enlace2 = "https://jkanime.net/rurouni-kenshin/"
        ),
        Anime(
            id = 33,
            imageId = R.drawable.blade_of_the_immortal,
            imageDesc = "Blade of the Immortal",
            title = "BLADE OF THE IMMORTAL",
            synopsis = "Blade of the Immortal sigue a Manji, un samurái maldito con inmortalidad, quien busca redimirse asesinando a 1000 hombres malvados para expiar sus pecados. La serie combina acción sangrienta, drama y un intenso viaje de venganza y redención en el Japón feudal.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Samurais, Drama, Seinen\n\n" +
                    "Studios:\n" +
                    "Madhouse\n\n" +
                    "Temporada:\n" +
                    "Otoño 2008\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "13\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Viernes, 13 de Octubre de 2008",
            enlace1 = "https://www3.animeflv.net/anime/mugen-no-juunin-immortal",
            enlace2 = "https://jkanime.net/blade-of-the-immortal"
        ),
        Anime(
            id = 34,
            imageId = R.drawable.gintama,
            imageDesc = "Gintama",
            title = "GINTAMA",
            synopsis = "Gintama sigue a Gintoki Sakata, un samurái perezoso en un Japón alternativo invadido por extraterrestres, que realiza trabajos extraños para pagar sus deudas. La serie mezcla comedia absurda, acción, parodia de otros animes y momentos dramáticos, con un elenco variado y extravagante.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Comedia, Parodia, Samurai, Shounen\n\n" +
                    "Studios:\n" +
                    "Sunrise\n\n" +
                    "Temporada:\n" +
                    "Invierno 2006\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "201+ (varias temporadas)\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Jueves, 04 de Abril de 2006",
            enlace1 = "https://www3.animeflv.net/anime/gintama",
            enlace2 = "https://jkanime.net/gintama"
        ),
        Anime(
            id = 35,
            imageId = R.drawable.pokemon,
            imageDesc = "Ash Ketchum",
            title = "POKÉMON",
            synopsis = "Pokémon sigue a Ash Ketchum y su compañero Pikachu en su viaje para convertirse en Maestro Pokémon. Viajan por diferentes regiones capturando criaturas llamadas Pokémon, compitiendo en batallas y enfrentándose a villanos mientras aprenden sobre amistad, valentía y crecimiento personal.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Aventura, Comedia, Fantasia, Infantil, Shounen\n\n" +
                    "Studios:\n" +
                    "OLM, Inc.\n\n" +
                    "Temporada:\n" +
                    "Primavera 1997\n\n" +
                    "Demografia:\n" +
                    "Kodomo\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "1000+\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Miércoles, 01 de Abril de 1997",
            enlace1 = "https://www3.animeflv.net/anime/pokemon",
            enlace2 = "https://jkanime.net/pokemon"
        ),
        Anime(
            id = 36,
            imageId = R.drawable.mononoke_hime,
            imageDesc = "San",
            title = "MONONOKE HIME",
            synopsis = "Mononoke Hime sigue a Ashitaka, un joven príncipe que se ve envuelto en un conflicto entre los humanos y los espíritus del bosque. La historia explora la relación entre la naturaleza y la humanidad, con combates épicos y dilemas morales en un mundo lleno de criaturas místicas.",
            info = "Tipo:\n" +
                    "Película\n\n" +
                    "Generos:\n" +
                    "Accion, Aventura, Fantasia, Drama\n\n" +
                    "Studios:\n" +
                    "Studio Ghibli\n\n" +
                    "Temporada:\n" +
                    "1997\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Duracion:\n" +
                    "133 min.\n\n" +
                    "Emitido:\n" +
                    "Viernes, 12 de Julio de 1997",
            enlace1 = "https://www3.animeflv.net/anime/mononoke-hime",
            enlace2 = "https://jkanime.net/mononoke-hime"
        ),
        Anime(
            id = 37,
            imageId = R.drawable.enen_no_shouboutai,
            imageDesc = "Shinra Kusakabe",
            title = "ENEN NO SHOUBOUTAI",
            synopsis = "Enen no Shouboutai sigue a Shinra Kusakabe, un pirocinético con la habilidad de encender sus pies a voluntad, quien se une a la Compañía 8 de la Fuerza Especial de Fuego para combatir a los \"Infernales\", humanos que se convierten en criaturas de fuego, y descubrir la verdad detrás de un misterioso incendio que marcó su pasado.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Acción, Ciencia Ficción, Shounen\n\n" +
                    "Studios:\n" +
                    "David Production\n\n" +
                    "Temporada:\n" +
                    "Verano 2019\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "24 (T1)\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "viernes, 05 de Julio de 2019",
            enlace1 = "https://www3.animeflv.net/anime/enen-no-shouboutai",
            enlace2 = "https://jkanime.net/enen-no-shouboutai"
        ),
        Anime(
            id = 38,
            imageId = R.drawable.log_horizon,
            imageDesc = "Shiroe",
            title = "LOG HORIZON",
            synopsis = "Log Horizon sigue a Shiroe y otros jugadores atrapados dentro de un MMORPG llamado Elder Tale. Deben adaptarse a este nuevo mundo, crear estrategias de supervivencia y alianzas, mientras enfrentan desafíos tanto dentro como fuera del juego en un entorno que mezcla acción, estrategia y comedia.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Aventura, Fantasia, Juegos, Shounen\n\n" +
                    "Studios:\n" +
                    "Satelight, Studio Deen\n\n" +
                    "Temporada:\n" +
                    "Otoño 2013\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "25 (T1) + 25 (T2) + 12 (T3)\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Lunes, 05 de Octubre de 2013",
            enlace1 = "https://www3.animeflv.net/anime/log-horizon",
            enlace2 = "https://jkanime.net/log-horizon"
        ),
        Anime(
            id = 39,
            imageId = R.drawable.overlord,
            imageDesc = "Ainz Ooal Gown",
            title = "OVERLORD",
            synopsis = "Overlord sigue a Momonga, un jugador atrapado dentro del juego de realidad virtual Yggdrasil cuando este se cierra. Adoptando el rol de su personaje esquelético, Ainz Ooal Gown, busca dominar este nuevo mundo mientras explora su poder, estrategia y la lealtad de sus subordinados en un reino fantástico.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Aventura, Fantasia, Sobrenatural, Seinen\n\n" +
                    "Studios:\n" +
                    "Madhouse\n\n" +
                    "Temporada:\n" +
                    "Invierno 2015\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "13 (T1) + 13 (T2) + 13 (T3)\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Lunes, 07 de Julio de 2015",
            enlace1 = "https://www3.animeflv.net/anime/overlord",
            enlace2 = "https://jkanime.net/overlord"
        ),
        Anime(
            id = 40,
            imageId = R.drawable.drifters,
            imageDesc = "Shimazu Toyohisa",
            title = "DRIFTERS",
            synopsis = "Drifters sigue a guerreros históricos que son transportados a un mundo alternativo lleno de conflictos. Liderados por Shimazu Toyohisa, deben enfrentarse a enemigos poderosos y desconocidos mientras buscan sobrevivir y cumplir sus objetivos en este mundo lleno de fantasía, estrategia y batallas sangrientas.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Aventura, Fantasia, Historico, Seinen\n\n" +
                    "Studios:\n" +
                    "Hoods Entertainment\n\n" +
                    "Temporada:\n" +
                    "Otoño 2016\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "12\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Viernes, 07 de Octubre de 2016",
            enlace1 = "https://www3.animeflv.net/anime/drifters",
            enlace2 = "https://jkanime.net/drifters"
        ),
        Anime(
            id = 41,
            imageId = R.drawable.nakitai_watashi_wa_neko_wo_kaburu,
            imageDesc = "Miko Tsukimi",
            title = "NAKITAI WATASHI WA NEKO WO KABURU",
            synopsis = "Nakitai Watashi wa Neko wo Kaburu sigue a Miko Tsukimi, una chica que encuentra una máscara mágica que le permite transformarse en un gato. La historia mezcla comedia, romance y drama mientras Miko explora sentimientos, secretos y las conexiones con las personas a su alrededor a través de su nueva forma felina.",
            info = "Tipo:\n" +
                    "Película\n\n" +
                    "Generos:\n" +
                    "Romance, Comedia, Fantasia, Escolar, Drama\n\n" +
                    "Studios:\n" +
                    "Shin-Ei Animation\n\n" +
                    "Temporada:\n" +
                    "2020\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Duracion:\n" +
                    "102 min.\n\n" +
                    "Emitido:\n" +
                    "Viernes, 05 de Junio de 2020",
            enlace1 = "https://www3.animeflv.net/",
            enlace2 = "https://jkanime.net/nakitai-watashi-wa-neko-wo-kaburu"
        ),
        Anime(
            id = 42,
            imageId = R.drawable.koe_no_katachi,
            imageDesc = "Shouya Ishida",
            title = "KOE NO KATACHI",
            synopsis = "Koe no Katachi sigue a Shouya Ishida, un joven que acosó a una compañera sorda, Shouko Nishimiya, durante la infancia. Años después busca redimirse y enmendar sus errores mientras enfrenta remordimientos, relaciones humanas y el poder del perdón en un emotivo drama escolar.",
            info = "Tipo:\n" +
                    "Película\n\n" +
                    "Generos:\n" +
                    "Drama, Escolar, Romance, Slice of Life\n\n" +
                    "Studios:\n" +
                    "Kyoto Animation\n\n" +
                    "Temporada:\n" +
                    "2016\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Duracion:\n" +
                    "129 min.\n\n" +
                    "Emitido:\n" +
                    "Viernes, 17 de Septiembre de 2016",
            enlace1 = "https://www3.animeflv.net/anime/koe-no-katachi",
            enlace2 = "https://jkanime.net/koe-no-katachi"
        ),
        Anime(
            id = 43,
            imageId = R.drawable.dead_mount_death_play,
            imageDesc = "Polka",
            title = "DEAD MOUNT DEATH PLAY",
            synopsis = "Dead Mount Death Play sigue a un legendario asesino reencarnado en un mundo moderno como Polka, un detective con habilidades sobrenaturales. La historia combina acción, misterio y elementos sobrenaturales mientras el protagonista investiga crímenes y enfrenta enemigos con poderes extraordinarios.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Sobrenatural, Misterio, Drama, Seinen\n\n" +
                    "Studios:\n" +
                    "Mappa\n\n" +
                    "Temporada:\n" +
                    "Verano 2023\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "12+\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Lunes, 04 de Julio de 2023",
            enlace1 = "https://www3.animeflv.net/anime/dead-mount-death-play",
            enlace2 = "https://jkanime.net/dead-mount-death-play"
        ),
        Anime(
            id = 44,
            imageId = R.drawable.kaminaki_sekai_no_kamisama_katsudou,
            imageDesc = "Natsume",
            title = "KAMINAKI SEKAI NO KAMISAMA KATSUDOU",
            synopsis = "Kaminaki Sekai no Kamisama Katsudou sigue a Natsume, un joven que se encuentra en un mundo donde los dioses y espíritus influyen en la vida cotidiana. La historia combina aventura, fantasía y comedia mientras Natsume aprende a convivir y resolver conflictos divinos en un entorno desconocido y mágico.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Aventura, Fantasia, Comedia, Sobrenatural, Shounen\n\n" +
                    "Studios:\n" +
                    "Studio Deen\n\n" +
                    "Temporada:\n" +
                    "Primavera 2024\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "12+\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Lunes, 01 de Abril de 2024",
            enlace1 = "https://www3.animeflv.net/anime/kaminaki-sekai-no-kamisama-katsudou",
            enlace2 = "https://jkanime.net/kaminaki-sekai-no-kamisama-katsudou"
        ),
        Anime(
            id = 45,
            imageId = R.drawable.leadale_no_daichi_nite,
            imageDesc = "Leila",
            title = "LEADALE NO DAICHI NITE",
            synopsis = "Leadale no Daichi nite sigue a Keina Kagami, quien tras un accidente queda atrapada en el mundo de su juego de realidad virtual como su personaje, Leila. La historia combina fantasía, aventura y comedia mientras Keina explora este mundo, haciendo amigos y enfrentando desafíos para reconstruir su nueva vida.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Aventura, Fantasia, Comedia, Vida, Isekai\n\n" +
                    "Studios:\n" +
                    "Maho Film\n\n" +
                    "Temporada:\n" +
                    "Invierno 2022\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "12\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Viernes, 09 de Enero de 2022",
            enlace1 = "https://www3.animeflv.net/anime/leadale-no-daichi-nite",
            enlace2 = "https://jkanime.net/leadale-no-daichi-nite"
        ),
        Anime(
            id = 46,
            imageId = R.drawable.jitsu_wa_ore_saikyou_deshita,
            imageDesc = "Orato",
            title = "JITSU WA ORE, SAIKYOU DESHITA?",
            synopsis = "Jitsu wa Ore, Saikyou deshita? sigue a Orato, un joven aparentemente normal que esconde un pasado como héroe invencible. Ahora vive tranquilamente hasta que su identidad y habilidades comienzan a atraer problemas y aventuras, mezclando comedia, acción y romance en un mundo moderno con toques sobrenaturales.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Comedia, Romance, Sobrenatural, Isekai\n\n" +
                    "Studios:\n" +
                    "FelixFilm\n\n" +
                    "Temporada:\n" +
                    "Verano 2023\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés , Español Latino\n\n" +
                    "Episodios:\n" +
                    "12+\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Martes, 04 de Julio de 2023",
            enlace1 = "https://www3.animeflv.net/anime/jitsu-wa-ore-saikyou-deshita",
            enlace2 = "https://jkanime.net/jitsu-wa-ore-saikyou-deshita"
        ),
        Anime(
            id = 47,
            imageId = R.drawable.darwins_game,
            imageDesc = "Darwins Game",
            title = "DARWIN’S GAME",
            synopsis = "Darwin’s Game sigue a Kaname Sudō, un estudiante normal que recibe una invitación para probar una aplicación de juego móvil. Pronto descubre que el juego es mortal y obliga a los participantes a luchar entre sí a vida o muerte usando habilidades llamadas Sigils.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Suspenso, Ciencia Ficcion\n\n" +
                    "Studios:\n" +
                    "Nexus\n\n" +
                    "Temporada:\n" +
                    "Invierno 2020\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español Latino\n\n" +
                    "Episodios:\n" +
                    "12\n\n" +
                    "Duracion:\n" +
                    "23 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "3 de Enero de 2020",
            enlace1 = "https://www3.animeflv.net/anime/darwins-game",
            enlace2 = "https://jkanime.net/darwins-game"
        ),
        Anime(
            id = 48,
            imageId = R.drawable.eighty_six,
            imageDesc = "86 Eighty Six",
            title = "86 - EIGHTY SIX",
            synopsis = "En la República de San Magnolia, una guerra sin ‘víctimas’ es propaganda; los soldados reales, etiquetados como ‘86’, luchan y mueren pilotando drones. La historia sigue a Shinei Nouzen y la Handler Vladilena Milize mientras enfrentan la brutal realidad de la guerra y la discriminación.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Drama, Ciencia Ficcion, Mecha, Militar\n\n" +
                    "Studios:\n" +
                    "A-1 Pictures\n\n" +
                    "Temporada:\n" +
                    "Primavera 2021\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español Latino\n\n" +
                    "Episodios:\n" +
                    "11+\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "11 de Abril de 2021",
            enlace1 = "https://www3.animeflv.net/anime/86-eighty-six",
            enlace2 = "https://jkanime.net/86-eighty-six"
        ),
        Anime(
            id = 49,
            imageId = R.drawable.ninety_one_days,
            imageDesc = "91 Days",
            title = "91 DAYS",
            synopsis = "Ambientado en la era de la Ley Seca en Estados Unidos, Angelo Lagusa adopta el alias Avilio Bruno tras la muerte de su familia por la mafia. Siete años después regresa a Lawless para infiltrarse en la familia Vanetti y buscar venganza en un mundo de crimen y traición.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Drama, Thriller, Historico\n\n" +
                    "Studios:\n" +
                    "Shuka\n\n" +
                    "Temporada:\n" +
                    "Verano 2016\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español Latino\n\n" +
                    "Episodios:\n" +
                    "12\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "9 de Julio de 2016",
            enlace1 = "https://www3.animeflv.net/anime/91-days",
            enlace2 = "https://jkanime.net/91-days"
        ),
        Anime(
            id = 50,
            imageId = R.drawable.spy_kyoushitsu,
            imageDesc = "Spy Kyoshitsu",
            title = "SPY KYOSHITSU",
            synopsis = "Tras una guerra devastadora, los gobiernos recurren a estrategias encubiertas: en una academia de élite, estudiantes entrenan como espías para enfrentar conflictos futuros. La serie mezcla intriga, acción y drama en un mundo donde cada movimiento puede ser mortal.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Misterio, Thriller\n\n" +
                    "Studios:\n" +
                    "Desconocido\n\n" +
                    "Temporada:\n" +
                    "Desconocida\n\n" +
                    "Demografia:\n" +
                    "Shounen/Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español Latino\n\n" +
                    "Episodios:\n" +
                    "Desconocido\n\n" +
                    "Duracion:\n" +
                    "24 min. aprox.\n\n" +
                    "Emitido:\n" +
                    "Desconocido",
            enlace1 = "https://www3.animeflv.net/anime/spy-kyoushitsu",
            enlace2 = "https://jkanime.net/spy-kyoushitsu/"
        ),
        Anime(
            id = 51,
            imageId = R.drawable.cestvs_the_roman_fighter,
            imageDesc = "Cestvs Roman Fighter",
            title = "CESTVS: THE ROMAN FIGHTER",
            synopsis = "Ambientada en el año 54 D.C., la historia sigue a Cestus, un joven esclavo entrenado como boxeador en una academia romana. Enfrentando brutales combates y su propio destino, lucha para ganar libertad y respeto en un mundo despiadado de gladiadores.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Historico, Deportes\n\n" +
                    "Studios:\n" +
                    "Desconocido\n\n" +
                    "Temporada:\n" +
                    "Primavera 2021\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español Latino\n\n" +
                    "Episodios:\n" +
                    "11\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "2021",
            enlace1 = "https://www3.animeflv.net/anime/cestvs-the-roman-fighter",
            enlace2 = "https://jkanime.net/cestvs-the-roman-fighter"
        ),
        Anime(
            id = 52,
            imageId = R.drawable.sai_dokushin_chuuken_boukensha_no_nichijou,
            imageDesc = "29‑sai Dokushin Chuuken Boukensha no Nichijou",
            title = "29‑SAI DOKUSHIN CHUUKEN BOUKENSHA NO NICHIJOU",
            synopsis = "Un aventurero de 29 años que nunca ha tenido novia lleva una vida común en una ciudad tranquila hasta que pequeñas misiones y encuentros inesperados empiezan a complicar su vida diaria con humor y acción.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Aventura, Comedia\n\n" +
                    "Studios:\n" +
                    "Desconocido\n\n" +
                    "Temporada:\n" +
                    "2026\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español Latino\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2026",
            enlace1 = "https://www3.animeflv.net/anime/29sai-dokushin-chuuken-boukensha-no-nichijou",
            enlace2 = "https://jkanime.net/29-sai-dokushin-chuuken-boukensha-no-nichijou/"
        ),
        Anime(
            id = 53,
            imageId = R.drawable.toujima_tanzaburou_wa_kamen_rider_ni_naritai,
            imageDesc = "Toujima Tanzaburou wa Kamen Rider ni Naritai",
            title = "TOUJIMA TANZABUROU WA KAMEN RIDER NI NARITAI",
            synopsis = "Tras un accidente misterioso, un hombre común despierta con la determinación de convertirse en un héroe estilo Kamen Rider y proteger a los demás en una ciudad plagada de peligros sobrenaturales.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Drama, Sobrenatural\n\n" +
                    "Studios:\n" +
                    "Desconocido\n\n" +
                    "Temporada:\n" +
                    "2026\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español Latino\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2026",
            enlace1 = "https://www3.animeflv.net/anime/toujima-tanzaburou-wa-kamen-rider-ni-naritai",
            enlace2 = "https://jkanime.net/toujima-tanzaburou-wa-kamen-rider-ni-naritai"
        ),
        Anime(
            id = 54,
            imageId = R.drawable.yuusha_no_kuzu,
            imageDesc = "Yuusha no Kuzu",
            title = "YUUSHA NO KUZU",
            synopsis = "Después de derrotar al Rey Demonio, un héroe fracasado y sus compañeros viven aventuras absurdas y caóticas mientras intentan adaptarse a la vida civil en un mundo fantasioso lleno de problemas ridículos.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Comedia, Fantasia, Aventura\n\n" +
                    "Studios:\n" +
                    "Desconocido\n\n" +
                    "Temporada:\n" +
                    "2026\n\n" +
                    "Demografia:\n" +
                    "Shounen/Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español Latino\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2026",
            enlace1 = "https://www3.animeflv.net/anime/yuusha-no-kuzu",
            enlace2 = "https://jkanime.net/yuusha-no-kuzu"
        ),
        Anime(
            id = 55,
            imageId = R.drawable.mayonaka_heart_tune,
            imageDesc = "Mayonaka Heart Tune",
            title = "MAYONAKA HEART TUNE",
            synopsis = "Una serie centrada en músicos callejeros que buscan éxito y reconocimiento mientras enfrentan desafíos personales y del mundo del espectáculo en un ambiente urbano vibrante.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Musica, Drama, Slice of Life\n\n" +
                    "Studios:\n" +
                    "Desconocido\n\n" +
                    "Temporada:\n" +
                    "2026\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español Latino\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2026",
            enlace1 = "https://www3.animeflv.net/anime/mayonaka-heart-tune",
            enlace2 = "https://jkanime.net/mayonaka-heart-tune"
        ),
        Anime(
            id = 56,
            imageId = R.drawable.mugen_gacha,
            imageDesc = "Mugen Gacha",
            title = "MUGEN GACHA",
            synopsis = "En un mundo dominado por objetos místicos llamados Gachas que otorgan poderes extremos, un joven intenta dominar sus misterios mientras se enfrenta a peligros mortales y otros usuarios sin escrúpulos.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Fantasia, Aventura\n\n" +
                    "Studios:\n" +
                    "Desconocido\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Shounen/Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español Latino\n\n" +
                    "Episodios:\n" +
                    "10+\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/mugen-gacha",
            enlace2 = "https://jkanime.net/shinjiteita-nakama-tachi-ni-dungeon-okuchi-de-korosarekaketa-ga-gift-mugen-gacha-de-level-9999-no-nakama-tachi-wo-te-ni-irete-moto-party-member-to-sekai-ni-fukushuu-zamaa-shimasu/"
        ),
        Anime(
            id = 57,
            imageId = R.drawable.sanda,
            imageDesc = "Sanda",
            title = "SANDA",
            synopsis = "Una historia de supervivencia en un mundo post‑apocalíptico donde un guerrero solitario debe enfrentarse a bárbaros, criaturas mutantes y su propio pasado para encontrar un lugar seguro.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Supervivencia, Misterio\n\n" +
                    "Studios:\n" +
                    "Desconocido\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español Latino\n\n" +
                    "Episodios:\n" +
                    "1+\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/sanda",
            enlace2 = "https://jkanime.net/sanda"
        ),
        Anime(
            id = 58,
            imageId = R.drawable.blue_lock,
            imageDesc = "Blue Lock",
            title = "BLUE LOCK",
            synopsis = "Tras una derrota devastadora en la Copa Mundial, Japón lanza el proyecto Blue Lock: un programa brutal para crear al mejor delantero egoísta del mundo. Los participantes compiten sin piedad entre sí por un solo lugar.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Deportes, Accion, Psicológico\n\n" +
                    "Studios:\n" +
                    "8bit\n\n" +
                    "Temporada:\n" +
                    "2022\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "24+\n\n" +
                    "Duracion:\n" +
                    "24 min por episodio\n\n" +
                    "Emitido:\n" +
                    "Octubre 2022",
            enlace1 = "https://www3.animeflv.net/anime/blue-lock",
            enlace2 = "https://jkanime.net/blue-lock"
        ),
        Anime(
            id = 59,
            imageId = R.drawable.the_new_gate,
            imageDesc = "The New Gate",
            title = "THE NEW GATE",
            synopsis = "Después de triunfar en un juego mortal de realidad virtual, Shin es transportado a un nuevo mundo donde los peligros son reales y viejos enemigos reaparecen mientras intenta sobrevivir y encontrar respuestas.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Aventura, Isekai\n\n" +
                    "Studios:\n" +
                    "Arvo Animation\n\n" +
                    "Temporada:\n" +
                    "2022\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "12\n\n" +
                    "Duracion:\n" +
                    "24 min por episodio\n\n" +
                    "Emitido:\n" +
                    "Abril 2022",
            enlace1 = "https://www3.animeflv.net/anime/the-new-gate",
            enlace2 = "https://jkanime.net/the-new-gate"
        ),
        Anime(
            id = 60,
            imageId = R.drawable.mushoku_no_eyuu,
            imageDesc = "Mushoku no Eiyuu",
            title = "MUSHOKU NO EIYUU: BETSU NI SKILL NANKA IRANAKATTA N DA GA",
            synopsis = "Un hombre reencarna en un mundo de fantasía tras una vida de fracasos, decidido a empezar de cero. Sin habilidades destacadas, su ingenio y perseverancia lo llevarán por caminos insospechados.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Fantasia, Aventura\n\n" +
                    "Studios:\n" +
                    "Studio ???\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min por episodio\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/mushoku-no-eiyuu-betsu-ni-skill-nanka-iranakatta-n-da-ga",
            enlace2 = "https://jkanime.net/mushoku-no-eiyuu-betsu-ni-skill-nanka-iranakatta-n-da-ga/"
        ),
        Anime(
            id = 61,
            imageId = R.drawable.tougen_anki,
            imageDesc = "Togen Anki",
            title = "TOGEN ANKI",
            synopsis = "En un mundo donde monstruos amenazan la paz, Anki Togen despierta con un poder misterioso que puede salvar o destruirlo todo. Debe dominarlo mientras enfrenta amenazas mortales y descubre oscuros secretos.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Sobrenatural, Fantasia\n\n" +
                    "Studios:\n" +
                    "???\n\n" +
                    "Temporada:\n" +
                    "2024–2025\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min por episodio\n\n" +
                    "Emitido:\n" +
                    "2024",
            enlace1 = "https://www3.animeflv.net/anime/tougen-anki",
            enlace2 = "https://jkanime.net/tougen-anki/"
        ),
        Anime(
            id = 62,
            imageId = R.drawable.si_vis_sound_of_heroes,
            imageDesc = "SI‑VIS The Sound of Heroes",
            title = "SI‑VIS: THE SOUND OF HEROES",
            synopsis = "Un grupo de jóvenes con habilidades únicas es reclutado en una academia especial para entrenar y proteger al mundo de amenazas desconocidas, aprendiendo a dominar su poder en combates intensos.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Fantasia, Supernatural\n\n" +
                    "Studios:\n" +
                    "???\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/sivis-the-sound-of-heroes",
            enlace2 = "https://jkanime.net/si-vis-the-sound-of-heroes/"
        ),
        Anime(
            id = 63,
            imageId = R.drawable.unnamed_memory,
            imageDesc = "Unnamed Memory",
            title = "UNNAMED MEMORY",
            synopsis = "Un joven sin recuerdos lucha por sobrevivir en un mundo devastado mientras descubre fragmentos de su pasado que podrían cambiar el destino de todo lo que conoce.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Drama, Sobrenatural\n\n" +
                    "Studios:\n" +
                    "???\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/unnamed-memory",
            enlace2 = "https://jkanime.net/unnamed-memory"
        ),
        Anime(
            id = 64,
            imageId = R.drawable.sokushi_cheat_ga_saikyou,
            imageDesc = "Sokushi Cheat ga Saikyou",
            title = "SOKUSHI CHEAT GA SAIKYOU",
            synopsis = "Tras ser transportado a otro mundo, un estudiante obtiene un poder letal llamado ‘Death Cheat’. Con él debe aprender a dominarlo para protegerse de monstruos y otros aventureros sin escrúpulos.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Isekai, Aventura\n\n" +
                    "Studios:\n" +
                    "???\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/sokushi-cheat-ga-saikyou-sugite-isekai-no-yatsura-ga-marude-aite-ni-naranai-n-desu-ga",
            enlace2 = "https://jkanime.net/sokushi-cheat-ga-saikyou-sugite-isekai-no-yatsura-ga-marude-aite-ni-naranai-n-desu-ga/"
        ),
        Anime(
            id = 65,
            imageId = R.drawable.ramen_akaneko,
            imageDesc = "Ramen Akaneko",
            title = "RAMEN AKANEKO",
            synopsis = "Un chef solitario con un pasado misterioso abre un pequeño puesto de ramen. Cada episodio combina acciones cotidianas con decisiones de vida, mostrando cómo la comida puede transformar destinos y relaciones.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Slice of Life, Comedia, Gourmet\n\n" +
                    "Studios:\n" +
                    "???\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/ramen-akaneko",
            enlace2 = "https://jkanime.net/ramen-akaneko"
        ),
        Anime(
            id = 66,
            imageId = R.drawable.ninja_to_gokudou,
            imageDesc = "Ninja to Gokudou",
            title = "NINJA TO GOKUDOU",
            synopsis = "Shinoha, un ninja tradicional, colisiona con Kiwami, un gánster moderno, y ambos terminan aliados forzados mientras enfrentan caos, traición y peligros fuera de la ley en un Japón más rudo de lo que imaginaban.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Comedia, Crimen\n\n" +
                    "Studios:\n" +
                    "–\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/ninja-to-gokudou",
            enlace2 = "https://jkanime.net/ninja-to-gokudou"
        ),
        Anime(
            id = 67,
            imageId = R.drawable.kikaijikake_no_marie,
            imageDesc = "Kikaijikake no Marie",
            title = "KIKAijikake NO MARIE",
            synopsis = "Marie es una chica con habilidades mecánicas extraordinarias que decide crear inventos que la ayudan a resolver crímenes y misterios en una ciudad futurista, enfrentándose a rivales robóticos cada vez más peligrosos.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Sci‑Fi, Aventura\n\n" +
                    "Studios:\n" +
                    "–\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Shounen/Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/kikaijikake-no-marie",
            enlace2 = "https://jkanime.net/kikaijikake-no-marie"
        ),
        Anime(
            id = 68,
            imageId = R.drawable.digimon_beatbreak,
            imageDesc = "Digimon Beatbreak",
            title = "DIGIMON BEATBREAK",
            synopsis = "En un nuevo mundo digital, varios DigiDestinados emergen para enfrentar amenazas misteriosas con sus Digimon compañeros, descubriendo secretos que podrían cambiar ambos mundos para siempre.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Aventura, Fantasia\n\n" +
                    "Studios:\n" +
                    "–\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/digimon-beatbreak",
            enlace2 = "https://jkanime.net/digimon-beatbreak"
        ),
        Anime(
            id = 69,
            imageId = R.drawable.watari_kun_no_xx_ga_houkai_sunzen,
            imageDesc = "Watari-kun no xx ga Houkai Sunzen",
            title = "WATARI‑KUN NO XX GA HOUKAI SUNZEN",
            synopsis = "La vida de un estudiante cambia radicalmente cuando su relación con una compañera se vuelve impredecible y peligrosa, forzándolo a tomar decisiones extremas mientras intenta mantener su mundo intacto.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Drama, Suspenso\n\n" +
                    "Studios:\n" +
                    "–\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/watarikun-no-xx-ga-houkai-sunzen",
            enlace2 = "https://jkanime.net/watari-kun-no-xx-ga-houkai-sunzen"
        ),
        Anime(
            id = 70,
            imageId = R.drawable.saikyou_no_shienshoku,
            imageDesc = "Saikyou no Shienshoku",
            title = "SAIKYOU NO SHIENSHOKU \"WAJUTSUSHI\" DE ARU ORE WA SEKAI SAIKYOU CLAN WO SHITAGAERU",
            synopsis = "Noel, el más débil de su clase, usa su ingenio para volverse el más fuerte y protegerlo todo, desafiando sistemas de poder y subestimaciones en un mundo lleno de magia y combates.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Fantasia, Aventura\n\n" +
                    "Studios:\n" +
                    "–\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/saikyou-no-shienshoku-wajutsushi-de-aru-ore-wa-sekai-saikyou-clan-wo-shitagaeru",
            enlace2 = "https://jkanime.net/saikyou-no-shienshoku-wajutsushi-de-aru-ore-wa-sekai-saikyou-clan-wo-shitagaeru/"
        ),
        Anime(
            id = 71,
            imageId = R.drawable.botsuraku_yotei_no_kizoku,
            imageDesc = "Botsuraku Yotei no Kizoku",
            title = "BOTSU RAKU YOTEI NO KIZOKU DAKEDO, HIMA DATTA KARA MAHOU WO KIWAMETEMITA",
            synopsis = "Un noble desocupado decide dominar la magia en un mundo de fantasía, pero sus métodos poco convencionales y su actitud despreocupada lo llevan a situaciones caóticas y divertidas.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Comedia, Fantasia, Aventura\n\n" +
                    "Studios:\n" +
                    "–\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/botsuraku-yotei-no-kizoku-dakedo-hima-datta-kara-mahou-wo-kiwametemita",
            enlace2 = "https://jkanime.net/botsuraku-yotei-no-kizoku-dakedo-hima-datta-kara-mahou-wo-kiwametemita"
        ),
        Anime(
            id = 72,
            imageId = R.drawable.alma_chan_wa_kazoku_ni_naritai,
            imageDesc = "Alma‑chan wa Kazoku ni Naritai",
            title = "ALMA‑CHAN WA KAZOKU NI NARITAI",
            synopsis = "Un robot autónomo quiere convertirse en parte de una familia humana y enfrenta desafíos sociales y emocionales mientras descubre qué significa pertenecer y ser amado.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Comedia, Sci‑Fi, Slice of Life\n\n" +
                    "Studios:\n" +
                    "–\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/almachan-wa-kazoku-ni-naritai",
            enlace2 = "https://jkanime.net/alma-chan-wa-kazoku-ni-naritai"
        ),
        Anime(
            id = 73,
            imageId = R.drawable.shabake,
            imageDesc = "Shabake",
            title = "SHABAKE",
            synopsis = "En una ciudad moderna plagada de monstruos sobrenaturales conocidos como youkai, varios cazadores jóvenes se unen para proteger a los ciudadanos y desentrañar antiguos misterios.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Sobrenatural\n\n" +
                    "Studios:\n" +
                    "–\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/shabake",
            enlace2 = "https://jkanime.net/shabake/"
        ),
        Anime(
            id = 74,
            imageId = R.drawable.shuumatsu_train_doko_e_iku,
            imageDesc = "Shuumatsu Train Doko e Iku?",
            title = "SHUUMATSU TRAIN DOKO E IKU?",
            synopsis = "Un tren misterioso recorre un mundo post‑apocalíptico lleno de peligros y criaturas extrañas; los pocos pasajeros restantes deben unirse para enfrentar el destino incierto de la humanidad.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Misterio, Aventura\n\n" +
                    "Studios:\n" +
                    "–\n\n" +
                    "Temporada:\n" +
                    "2025\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "En emisión\n\n" +
                    "Duracion:\n" +
                    "24 min aprox.\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/shuumatsu-train-doko-e-iku",
            enlace2 = "https://jkanime.net/shuumatsu-train-doko-e-iku"
        ),
        Anime(
            id = 75,
            imageId = R.drawable.tate_no_yuusha_no_nariagari,
            imageDesc = "Tate no Yuusha no Nariagari",
            title = "TATE NO YUUSHA NO NARIAGARI",
            synopsis = "Naofumi es convocado a otro mundo como el Héroe del Escudo. Traicionado y menospreciado, debe sobrevivir y proteger el reino mientras crece en poder y aprende a confiar en aliados inesperados.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Fantasia, Isekai\n\n" +
                    "Studios:\n" +
                    "Kinema Citrus\n\n" +
                    "Temporada:\n" +
                    "Primavera 2019\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "25+\n\n" +
                    "Duracion:\n" +
                    "24 min por episodio\n\n" +
                    "Emitido:\n" +
                    "2019",
            enlace1 = "https://www3.animeflv.net/anime/tate-no-yuusha-no-nariagari",
            enlace2 = "https://jkanime.net/tate-no-yuusha-no-nariagari"
        ),
        Anime(
            id = 76,
            imageId = R.drawable.tengen_toppa_gurren_lagann,
            imageDesc = "Tengen Toppa Gurren Lagann",
            title = "TENGEN ROPPA GURREN LAGANN",
            synopsis = "Simon y Kamina viven bajo tierra hasta que descubren la superficie y luchan contra fuerzas opresoras. Su determinación y espíritu guerrero los lleva a pilotar mechas y desafiar el destino del universo.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Mecha, Aventura\n\n" +
                    "Studios:\n" +
                    "Gainax\n\n" +
                    "Temporada:\n" +
                    "2007\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "27\n\n" +
                    "Duracion:\n" +
                    "24 min por episodio\n\n" +
                    "Emitido:\n" +
                    "2007",
            enlace1 = "https://www3.animeflv.net/anime/tengen-toppa",
            enlace2 = "https://jkanime.net/tengen-toppa/"
        ),
        Anime(
            id = 77,
            imageId = R.drawable.dr_stone,
            imageDesc = "Dr. Stone",
            title = "DR. STONE",
            synopsis = "Tras un misterioso fenómeno que petrificó a la humanidad, Senku despierta miles de años después con el objetivo de reconstruir la civilización mediante la ciencia, enfrentando desafíos y enemigos humanos.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Ciencia Ficcion, Aventura\n\n" +
                    "Studios:\n" +
                    "TMS Entertainment\n\n" +
                    "Temporada:\n" +
                    "Verano 2019\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "24+\n\n" +
                    "Duracion:\n" +
                    "24 min por episodio\n\n" +
                    "Emitido:\n" +
                    "2019",
            enlace1 = "https://www3.animeflv.net/anime/dr-stone",
            enlace2 = "https://jkanime.net/dr-stone"
        ),
        Anime(
            id = 78,
            imageId = R.drawable.one_punch_man,
            imageDesc = "One Punch Man",
            title = "ONE PUNCH MAN",
            synopsis = "Saitama entrena hasta volverse increíblemente poderoso, derrotando enemigos con un solo golpe. Mientras busca emoción en la vida de héroe, descubre desafíos que ponen a prueba su aburrimiento y su fuerza.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Comedia, Superpoderes\n\n" +
                    "Studios:\n" +
                    "Madhouse / J.C.Staff\n\n" +
                    "Temporada:\n" +
                    "Otoño 2015\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "12+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2015",
            enlace1 = "https://www3.animeflv.net/anime/one-punch-man",
            enlace2 = "https://jkanime.net/one-punch-man"
        ),
        Anime(
            id = 79,
            imageId = R.drawable.boku_no_hero,
            imageDesc = "Boku no Hero Academia",
            title = "BUKO NO HERO ACADEMIA",
            synopsis = "Izuku Midoriya nace sin poderes en un mundo donde casi todos los tienen. Sueña con ser héroe y recibe la habilidad de All Might, enfrentando villanos y superando retos para convertirse en el mayor héroe.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Superpoderes, Escolar\n\n" +
                    "Studios:\n" +
                    "Bones\n\n" +
                    "Temporada:\n" +
                    "Primavera 2016\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "88+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2016",
            enlace1 = "https://www3.animeflv.net/anime/boku-no-hero-academia-2016",
            enlace2 = "https://jkanime.net/boku-no-hero-academia/"
        ),
        Anime(
            id = 80,
            imageId = R.drawable.dark_moon,
            imageDesc = "Dark Moon: Tsuki no Saidan",
            title = "DARK MOON: TSUKI NO SAIDAN",
            synopsis = "Un grupo de investigadores se enfrenta a misteriosas fuerzas sobrenaturales en un mundo donde la luna oculta secretos oscuros que podrían cambiar la realidad.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Misterio, Sobrenatural\n\n" +
                    "Studios:\n" +
                    "Studio Deen\n\n" +
                    "Temporada:\n" +
                    "Otoño 2025\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "12+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2025",
            enlace1 = "https://www3.animeflv.net/anime/dark-moon-tsuki-no-saidan",
            enlace2 = "https://jkanime.net/dark-moon-tsuki-no-saidan/"
        ),
        Anime(
            id = 81,
            imageId = R.drawable.dorohedoro,
            imageDesc = "Dorohedoro",
            title = "DOROHEDORO",
            synopsis = "En una ciudad oscura y caótica llamada Hole, un hombre reptil busca recuperar su memoria y descubrir quién lo transformó, enfrentando magos y criminales en un mundo brutal.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Comedia Negra, Sobrenatural\n\n" +
                    "Studios:\n" +
                    "MAPPA\n\n" +
                    "Temporada:\n" +
                    "Primavera 2020\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "12+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2020",
            enlace1 = "https://www3.animeflv.net/anime/dorohedoro",
            enlace2 = "https://jkanime.net/dorohedoro/"
        ),
        Anime(
            id = 82,
            imageId = R.drawable.mushoku_tensei,
            imageDesc = "Mushoku Tensei",
            title = "MUSHOKU TENSEI",
            synopsis = "Un hombre reencarna en un mundo de magia como Rudeus Greyrat y busca aprovechar su nueva vida para superar sus errores pasados y convertirse en un gran mago.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Fantasia, Aventura, Magia\n\n" +
                    "Studios:\n" +
                    "Studio Bind\n\n" +
                    "Temporada:\n" +
                    "Invierno 2021\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "23+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2021",
            enlace1 = "https://www3.animeflv.net/anime/mushoku-tensei-isekai-ittara-honki-dasu",
            enlace2 = "https://jkanime.net/mushoku-tensei-isekai-ittara-honki-dasu/"
        ),
        Anime(
            id = 83,
            imageId = R.drawable.kono_subarashii,
            imageDesc = "Kono Subarashii Sekai ni Shukufuku wo!",
            title = "KONO SUBARASHII SEKAI NI SHUKUFUKU WO!",
            synopsis = "Kazuma Satou muere de manera ridícula y es transportado a un mundo de fantasía, formando un grupo con la diosa Aqua y otros compañeros inusuales en hilarantes aventuras.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Comedia, Fantasia, Aventura\n\n" +
                    "Studios:\n" +
                    "Studio Deen\n\n" +
                    "Temporada:\n" +
                    "Enero 2016\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "10+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2016",
            enlace1 = "https://www3.animeflv.net/anime/kono-subarashii-sekai-ni-shukufuku-wo",
            enlace2 = "https://jkanime.net/kono-subarashii-sekai-ni-shukufuku-wo/"
        ),
        Anime(
            id = 84,
            imageId = R.drawable.no_game_no_life,
            imageDesc = "No Game No Life",
            title = "NO GAME NO LIFE",
            synopsis = "Los hermanos Sora y Shiro, expertos jugadores, son transportados a un mundo donde todo se decide mediante juegos, y deben enfrentarse al dios de los juegos para salvar ese mundo.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Fantasia, Comedia, Aventura\n\n" +
                    "Studios:\n" +
                    "Madhouse\n\n" +
                    "Temporada:\n" +
                    "Primavera 2014\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "12+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2014",
            enlace1 = "https://www3.animeflv.net/anime/no-game-no-life",
            enlace2 = "https://jkanime.net/no-game-no-life/"
        ),
        Anime(
            id = 85,
            imageId = R.drawable.eromanga_sensei,
            imageDesc = "Eromanga Sensei",
            title = "EROMANGA SENSEI",
            synopsis = "Masamune Izumi, escritor de novelas ligeras, descubre que su ilustradora misteriosa y talentosa es su propia hermana menor, enfrentando situaciones cómicas y desafíos creativos.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Comedia, Escolar, Drama\n\n" +
                    "Studios:\n" +
                    "A-1 Pictures\n\n" +
                    "Temporada:\n" +
                    "Primavera 2017\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "12+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2017",
            enlace1 = "https://www3.animeflv.net/anime/eromangasensei",
            enlace2 = "https://jkanime.net/eromanga-sensei/"
        ),
        Anime(
            id = 86,
            imageId = R.drawable.sword_art_online,
            imageDesc = "Sword Art Online",
            title = "SWORD ART ONLINE",
            synopsis = "Kirito queda atrapado junto a miles de jugadores en un MMORPG de realidad virtual donde morir en el juego significa morir en la vida real, luchando por sobrevivir y escapar.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Fantasia, Aventura, Romance\n\n" +
                    "Studios:\n" +
                    "A-1 Pictures\n\n" +
                    "Temporada:\n" +
                    "Verano 2012\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "25+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2012",
            enlace1 = "https://www3.animeflv.net/anime/sword-art-online",
            enlace2 = "https://jkanime.net/sword-art-online/"
        ),
        Anime(
            id = 87,
            imageId = R.drawable.hunter_x_hunter,
            imageDesc = "Hunter x Hunter",
            title = "HUNTER X HUNTER",
            synopsis = "Gon Freecss busca convertirse en un Hunter como su padre, enfrentando peligrosos desafíos, pruebas y enemigos mientras forma amistades que marcarán su camino.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Aventura, Fantasia\n\n" +
                    "Studios:\n" +
                    "Madhouse\n\n" +
                    "Temporada:\n" +
                    "Otoño 2011\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "148+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2011",
            enlace1 = "https://www3.animeflv.net/anime/hunter-x-hunter",
            enlace2 = "https://jkanime.net/hunter-x-hunter/"
        ),
        Anime(
            id = 88,
            imageId = R.drawable.beastars,
            imageDesc = "Beastars",
            title = "BEASTARS",
            synopsis = "En una sociedad de animales antropomórficos, Legoshi, un lobo tímido, navega por conflictos de poder, emociones y relaciones mientras descubre su identidad y deseos.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Drama, Escolar, Misterio, Vida Cotidiana\n\n" +
                    "Studios:\n" +
                    "Orange\n\n" +
                    "Temporada:\n" +
                    "Otoño 2019\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "12+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2019",
            enlace1 = "https://www3.animeflv.net/anime/beastars",
            enlace2 = "https://jkanime.net/beastars/"
        ),
        Anime(
            id = 89,
            imageId = R.drawable.kekkai_sensen,
            imageDesc = "Kekkai Sensen",
            title = "KEKKAI SENSEN",
            synopsis = "Leonardo Watch, un joven con ojos especiales, se une a Libra, un grupo que protege a la ciudad de Nueva York mezclada con dimensiones sobrenaturales y criaturas extrañas.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Sobrenatural, Comedia, Fantasia\n\n" +
                    "Studios:\n" +
                    "Bones\n\n" +
                    "Temporada:\n" +
                    "Primavera 2015\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "12+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2015",
            enlace1 = "https://www3.animeflv.net/anime/kekkai-sensen",
            enlace2 = "https://jkanime.net/kekkai-sensen/"
        ),
        Anime(
            id = 90,
            imageId = R.drawable.saenai_heroine_no_sodatekata,
            imageDesc = "Saenai Heroine no Sodatekata",
            title = "SAENAI HEROINE NO SODATEKATA",
            synopsis = "Tomoya Aki, un otaku decidido, intenta crear un juego visual novel exitoso junto a un grupo de talentosas chicas, enfrentando desafíos creativos y cómicas situaciones románticas.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Comedia, Escolar, Drama\n\n" +
                    "Studios:\n" +
                    "A-1 Pictures\n\n" +
                    "Temporada:\n" +
                    "Primavera 2015\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "12+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2015",
            enlace1 = "https://www3.animeflv.net/anime/saenai-heroine-no-sodatekata",
            enlace2 = "https://jkanime.net/saenai-heroine-no-sodatekata/"
        ),
        Anime(
            id = 91,
            imageId = R.drawable.kino_no_tabi,
            imageDesc = "Kino no Tabi: The Beautiful World",
            title = "KINO NO TABI: THE BEAUTIFUL WORLD",
            synopsis = "Kino viaja de país en país con su motocicleta parlante, Hermès, explorando distintas culturas y filosofías mientras reflexiona sobre la naturaleza humana y la vida.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Aventura, Filosofico, Drama\n\n" +
                    "Studios:\n" +
                    "Studio Deen\n\n" +
                    "Temporada:\n" +
                    "Primavera 2003\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "13+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2003",
            enlace1 = "https://www3.animeflv.net/anime/kino-no-tabi-the-beautiful-world-the-animated-series",
            enlace2 = "https://jkanime.net/kino-no-tabi-the-beautiful-world/"
        ),
        Anime(
            id = 92,
            imageId = R.drawable.akame_ga_kill,
            imageDesc = "Akame ga Kill!",
            title = "AKAME GA KILL!",
            synopsis = "Tatsumi se une a Night Raid, un grupo de asesinos, para luchar contra la corrupción del Imperio, enfrentando enemigos poderosos y dilemas morales en un mundo violento.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Fantasia, Aventura\n\n" +
                    "Studios:\n" +
                    "White Fox\n\n" +
                    "Temporada:\n" +
                    "Verano 2014\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "24+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2014",
            enlace1 = "https://www3.animeflv.net/anime/akame-ga-kill",
            enlace2 = "https://jkanime.net/akame-ga-kill/"
        ),
        Anime(
            id = 93,
            imageId = R.drawable.mahouka_koukou_no_rettousei,
            imageDesc = "Mahouka Koukou no Rettousei",
            title = "MAHOUKA KOUKOU NO RETTOUSEI",
            synopsis = "Tatsuya Shiba y su hermana Miyuki asisten a la Primera Escuela de Magia, donde Tatsuya oculta habilidades extraordinarias mientras enfrenta conflictos sociales y rivalidades mágicas.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Fantasia, Escolar, Magia\n\n" +
                    "Studios:\n" +
                    "Madhouse\n\n" +
                    "Temporada:\n" +
                    "Primavera 2014\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "26+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2014",
            enlace1 = "https://www3.animeflv.net/anime/mahouka-koukou-no-rettousei",
            enlace2 = "https://jkanime.net/mahouka-koukou-no-rettousei/"
        ),
        Anime(
            id = 94,
            imageId = R.drawable.magi,
            imageDesc = "Magi: The Labyrinth of Magic",
            title = "MAGI: THE LABYRINTH OF MAGIC",
            synopsis = "Alibaba y Aladdin exploran mazmorras misteriosas llenas de tesoros y peligros, mientras se enfrentan a reinos corruptos y descubren secretos del mundo mágico.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Aventura, Fantasia, Accion\n\n" +
                    "Studios:\n" +
                    "A-1 Pictures\n\n" +
                    "Temporada:\n" +
                    "Otoño 2012\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "25+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2012",
            enlace1 = "https://www3.animeflv.net/anime/magi",
            enlace2 = "https://jkanime.net/magi/"
        ),
        Anime(
            id = 95,
            imageId = R.drawable.tensei_shitara_slime_datta_ken,
            imageDesc = "Tensei Shitara Slime Datta Ken",
            title = "TENSEI SHITARA SLIME DATTA KEN",
            synopsis = "Satoru Mikami reencarna como un slime en un mundo de fantasía, usando habilidades únicas para formar alianzas, expandir su reino y enfrentar poderosos enemigos.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Fantasia, Aventura, Comedia\n\n" +
                    "Studios:\n" +
                    "8bit\n\n" +
                    "Temporada:\n" +
                    "Otoño 2018\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "24+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2018",
            enlace1 = "https://www3.animeflv.net/anime/tensei-shitara-slime-datta-ken",
            enlace2 = "https://jkanime.net/tensei-shitara-slime-datta-ken/"
        ),
        Anime(
            id = 96,
            imageId = R.drawable.shokugeki_no_souma,
            imageDesc = "Shokugeki no Souma",
            title = "SHOKUGEKI NO SOUMA",
            synopsis = "Souma Yukihira entra a la Academia Tootsuki, una escuela culinaria de élite, donde participa en intensos duelos de cocina para superar desafíos y demostrar su talento.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Comedia, Escolar, Vida Cotidiana, Gastronomia\n\n" +
                    "Studios:\n" +
                    "J.C. Staff\n\n" +
                    "Temporada:\n" +
                    "Primavera 2015\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "24+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2015",
            enlace1 = "https://www3.animeflv.net/anime/shokugeki-no-souma",
            enlace2 = "https://jkanime.net/shokugeki-no-souma/"
        ),
        Anime(
            id = 97,
            imageId = R.drawable.horimiya,
            imageDesc = "Horimiya",
            title = "HORIMIYA",
            synopsis = "Kyoko Hori y Izumi Miyamura descubren lados ocultos de sus personalidades y desarrollan una relación inesperada mientras enfrentan los altibajos de la vida escolar.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Comedia, Escolar, Romance, Vida Cotidiana\n\n" +
                    "Studios:\n" +
                    "CloverWorks\n\n" +
                    "Temporada:\n" +
                    "Invierno 2021\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "13+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2021",
            enlace1 = "https://www3.animeflv.net/anime/horimiya",
            enlace2 = "https://jkanime.net/horimiya/"
        ),
        Anime(
            id = 98,
            imageId = R.drawable.gangsta,
            imageDesc = "Gangsta",
            title = "GANGSTA",
            synopsis = "En la ciudad de Ergastulum, dos mercenarios realizan trabajos peligrosos para criminales y policías mientras se enfrentan a mafias, corrupción y el peligro constante de la violencia.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Accion, Drama, Crimen, Seinen\n\n" +
                    "Studios:\n" +
                    "Manglobe\n\n" +
                    "Temporada:\n" +
                    "Verano 2015\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "12+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2015",
            enlace1 = "https://www3.animeflv.net/anime/gangsta",
            enlace2 = "https://jkanime.net/gangsta-/"
        ),
        Anime(
            id = 99,
            imageId = R.drawable.made_in_abyss,
            imageDesc = "Made in Abyss",
            title = "MADE IN ABYSS",
            synopsis = "Riko, una niña exploradora, desciende al Abismo en busca de su madre, enfrentando criaturas mortales, misterios y secretos de un mundo subterráneo lleno de maravillas y peligros.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Aventura, Fantasia, Misterio, Drama\n\n" +
                    "Studios:\n" +
                    "Kinema Citrus\n\n" +
                    "Temporada:\n" +
                    "Verano 2017\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "13+\n\n" +
                    "Duracion:\n" +
                    "24 min\n\n" +
                    "Emitido:\n" +
                    "2017",
            enlace1 = "https://www3.animeflv.net/anime/made-in-abyss",
            enlace2 = "https://jkanime.net/made-in-abyss/"
        ),
        Anime(
            id = 100,
            imageId = R.drawable.oshi_no_ko,
            imageDesc = "Aqua y Ruby Hoshino",
            title = "OSHI NO KO",
            synopsis = "Oshi no Ko sigue a Gorou Amamiya, un ginecólogo que renace como Aquamarine Hoshino, hijo de la idol Ai Hoshino, junto a su hermana gemela Ruby. A medida que crecen en la industria del entretenimiento japonés, enfrentan sus ambiciones, traiciones y el lado oscuro del mundo del espectáculo mientras buscan respuestas sobre su pasado y su identidad.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Drama, Sobrenatural, Seinen\n\n" +
                    "Studios:\n" +
                    "Doga Kobo\n\n" +
                    "Temporada:\n" +
                    "Primera: Primavera 2023, Segunda: Verano 2024, Tercera: Invierno 2026\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "11 (T1) + 13 (T2) + en emisión (T3)\n\n" +
                    "Duracion:\n" +
                    "24 min. aprox. por episodio\n\n" +
                    "Emitido:\n" +
                    "Desde 12 de Abril de 2023",
            enlace1 = "https://www3.animeflv.net/anime/oshi-no-ko",
            enlace2 = "https://jkanime.net/oshi-no-ko"
        ),
        Anime(
            id = 101,
            imageId = R.drawable.jujutsu_kaisen,
            imageDesc = "Yuji Itadori",
            title = "JUJUTSU KAISEN",
            synopsis = "Jujutsu Kaisen sigue a Yuji Itadori, un estudiante de secundaria que ingiere un dedo maldito para salvar a sus compañeros, convirtiéndose en el recipiente del poderoso espíritu Ryomen Sukuna. Ahora se une a los hechiceros de jujutsu para combatir maldiciones, proteger a la humanidad y enfrentarse a amenazas que desafían la lógica y el poder humano.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Acción, Aventura, Fantasía Oscura, Sobrenatural\n\n" +
                    "Studios:\n" +
                    "MAPPA\n\n" +
                    "Temporada:\n" +
                    "Otoño 2020 (T1), Verano 2023 (T2), Invierno 2026 (T3)\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "24 (T1) + 23 (T2) + en emisión (T3)\n\n" +
                    "Duracion:\n" +
                    "23–24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Desde 3 de Octubre de 2020",
            enlace1 = "https://www3.animeflv.net/anime/jujutsu-kaisen-tv",
            enlace2 = "https://jkanime.net/jujutsu-kaisen-tv/"
        ),
        Anime(
            id = 102,
            imageId = R.drawable.sakamoto_days,
            imageDesc = "Taro Sakamoto",
            title = "SAKAMOTO DAYS",
            synopsis = "Sakamoto Days sigue a Taro Sakamoto, un antiguo asesino legendario retirado que vive una vida tranquila como dueño de una tienda de conveniencia con su familia. Cuando antiguos enemigos y colegas del mundo criminal vuelven para buscarlo, Sakamoto debe utilizar sus habilidades letales para proteger a sus seres queridos mientras mantiene su fachada de hombre común.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Acción, Comedia, Vida Cotidiana, Shounen\n\n" +
                    "Studios:\n" +
                    "TMS Entertainment\n\n" +
                    "Temporada:\n" +
                    "Primavera 2025 (Parte 1) y Verano 2025 (Parte 2)\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "22 (Temporada 1 – 2 cours)\n\n" +
                    "Duracion:\n" +
                    "≈24–25 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "11 de Enero de 2025 – 23 de Septiembre de 2025",
            enlace1 = "https://www3.animeflv.net/anime/sakamoto-days",
            enlace2 = "https://jkanime.net/sakamoto-days"
        ),
        Anime(
            id = 103,
            imageId = R.drawable.yakusoku_no_neverland,
            imageDesc = "Emma",
            title = "YAKUSOKU NO NEVERLAND",
            synopsis = "Yakusoku no Neverland sigue a Emma, Norman y Ray, niños que viven en el Orfanato Grace Field, descubriendo que están siendo criados como alimento para demonios. Los protagonistas idean un plan para escapar y salvar a sus compañeros mientras enfrentan peligros, engaños y la implacable inteligencia de sus guardianes demoníacos.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Suspenso, Misterio, Psicologico, Shounen\n\n" +
                    "Studios:\n" +
                    "CloverWorks\n\n" +
                    "Temporada:\n" +
                    "Invierno 2019 (T1), Verano 2021 (T2)\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "12 (T1) + 11 (T2)\n\n" +
                    "Duracion:\n" +
                    "23 min. aprox. por episodio\n\n" +
                    "Emitido:\n" +
                    "Desde 11 de Enero de 2019",
            enlace1 = "https://www3.animeflv.net/anime/yakusoku-no-neverland",
            enlace2 = "https://jkanime.net/yakusoku-no-neverland"
        ),
        Anime(
            id = 104,
            imageId = R.drawable.parasyte,
            imageDesc = "Shinichi Izumi",
            title = "PARASYTE -THE MAXIM-",
            synopsis = "Parasyte sigue a Shinichi Izumi, un estudiante de secundaria cuya mano derecha es infectada por un parásito alienígena llamado Migi. Mientras otros parásitos atacan y consumen humanos, Shinichi y Migi deben coexistir y luchar para sobrevivir, enfrentando dilemas morales y la amenaza constante de criaturas que buscan dominar a la humanidad.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Acción, Ciencia Ficción, Horror, Sobrenatural, Psicologico\n\n" +
                    "Studios:\n" +
                    "Madhouse\n\n" +
                    "Temporada:\n" +
                    "Otoño 2014\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "24\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Desde 9 de Octubre de 2014",
            enlace1 = "https://www3.animeflv.net/anime/kiseijuu-sei-no-kakuritsu",
            enlace2 = "https://jkanime.net/kiseijuu-sei-no-kakuritsu/"
        ),
        Anime(
            id = 105,
            imageId = R.drawable.akira,
            imageDesc = "Kaneda y Tetsuo",
            title = "AKIRA",
            synopsis = "Akira es un clásico del anime que sigue a Kaneda y Tetsuo, amigos en un Neo-Tokio post-apocalíptico. Tras un accidente que despierta poderes psíquicos en Tetsuo, se desencadena una serie de eventos catastróficos que amenazan con destruir la ciudad. La película combina acción, ciencia ficción y un análisis oscuro del poder y la corrupción.",
            info = "Tipo:\n" +
                    "Película\n\n" +
                    "Generos:\n" +
                    "Ciencia Ficción, Acción, Cyberpunk, Psicologico\n\n" +
                    "Studios:\n" +
                    "Tokyo Movie Shinsha (TMS)\n\n" +
                    "Temporada:\n" +
                    "1988\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "1 Película\n\n" +
                    "Duracion:\n" +
                    "124 min.\n\n" +
                    "Emitido:\n" +
                    "16 de Julio de 1988",
            enlace1 = "https://www3.animeflv.net/anime/akira",
            enlace2 = "https://jkanime.net/akira"
        ),
        Anime(
            id = 106,
            imageId = R.drawable.ushio_to_tora,
            imageDesc = "Ushio Aotsuki y Tora",
            title = "USHIO TO TORA",
            synopsis = "Ushio to Tora sigue a Ushio Aotsuki, un joven que libera accidentalmente a Tora, un demonio atrapado por siglos. A pesar de su inicial enemistad, Ushio y Tora se ven obligados a unir fuerzas para enfrentar otras criaturas sobrenaturales que amenazan a la humanidad, mientras Ushio descubre secretos sobre su familia y su propio poder.",
            info = "Tipo:\n" +
                    "Serie\n\n" +
                    "Generos:\n" +
                    "Acción, Aventura, Sobrenatural, Comedia, Shounen\n\n" +
                    "Studios:\n" +
                    "MAPPA, Studio VOLN\n\n" +
                    "Temporada:\n" +
                    "Primera: Julio 2015 – Segunda: Marzo 2016\n\n" +
                    "Demografia:\n" +
                    "Shounen\n\n" +
                    "Idiomas:\n" +
                    "Japonés\n\n" +
                    "Episodios:\n" +
                    "26 (T1) + 39 (T2)\n\n" +
                    "Duracion:\n" +
                    "24 min. por episodio\n\n" +
                    "Emitido:\n" +
                    "Desde 3 de Julio de 2015",
            enlace1 = "https://www3.animeflv.net/anime/ushio-to-tora",
            enlace2 = "https://jkanime.net/ushio-to-tora-tv/"
        ),
        Anime(
            id = 107,
            imageId = R.drawable.howl_no_ugoku_shiro,
            imageDesc = "Sophie y Howl",
            title = "HOWL NO UGOKU SHIRO",
            synopsis = "Howl no Ugoku Shiro sigue a Sophie, una joven transformada en anciana por una maldición, quien se encuentra con Howl, un mago excéntrico que habita un castillo mágico ambulante. Juntos enfrentan peligros, misterios y desarrollan una relación mientras descubren secretos sobre la guerra y la magia que rodea sus vidas.",
            info = "Tipo:\n" +
                    "Película\n\n" +
                    "Generos:\n" +
                    "Fantasía, Aventura, Romance, Magia\n\n" +
                    "Studios:\n" +
                    "Studio Ghibli\n\n" +
                    "Temporada:\n" +
                    "2004\n\n" +
                    "Demografia:\n" +
                    "Seinen\n\n" +
                    "Idiomas:\n" +
                    "Japonés, Español\n\n" +
                    "Episodios:\n" +
                    "1 Película\n\n" +
                    "Duracion:\n" +
                    "119 min.\n\n" +
                    "Emitido:\n" +
                    "20 de Noviembre de 2004",
            enlace1 = "https://www3.animeflv.net/anime/howl-no-ugoku-shiro",
            enlace2 = "https://jkanime.net/howl-no-ugoku-shiro"
        )
    )
}