package com.example.pmdm.data.network

object ApiConfig {

    //private const val BASE_URL = "http://192.168.1.147:5131/"  // Ricardo
    // private const val BASE_URL = "http://10.0.2.2:5131/"   //Funciona en solo con el emulador

    // Para usar API con el cable  ejecutara API con comando       dotnet run --urls "http://0.0.0.0:5131"
    // y modificar network_security_config.xml y Dataprovider agregando el ip propio a los permisos

    const val BASE_URL = "http://10.0.2.2:5131/" //modificar ip de pc
}
