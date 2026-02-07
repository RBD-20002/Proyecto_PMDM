package com.example.pmdm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Clase de aplicación principal que habilita la inyección de dependencias con Hilt.
 * Esta clase debe ser referenciada en el archivo AndroidManifest.xml.
 *
 * @see HiltAndroidApp
 */
@HiltAndroidApp
class MyApp : Application()